package org.openstack4j.openstack.internal;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import org.openstack4j.api.Apis;
import org.openstack4j.api.EndpointTokenProvider;
import org.openstack4j.api.OSClient;
import org.openstack4j.api.client.CloudProvider;
import org.openstack4j.api.compute.ComputeService;
import org.openstack4j.api.heat.HeatService;
import org.openstack4j.api.identity.EndpointURLResolver;
import org.openstack4j.api.identity.IdentityService;
import org.openstack4j.api.image.ImageService;
import org.openstack4j.api.networking.NetworkingService;
import org.openstack4j.api.sahara.SaharaService;
import org.openstack4j.api.storage.BlockStorageService;
import org.openstack4j.api.storage.ObjectStorageService;
import org.openstack4j.api.telemetry.TelemetryService;
import org.openstack4j.api.types.Facing;
import org.openstack4j.api.types.ServiceType;
import org.openstack4j.core.transport.Config;
import org.openstack4j.model.identity.Access;
import org.openstack4j.model.identity.AuthVersion;
import org.openstack4j.model.identity.Token;
import org.openstack4j.model.identity.URLResolverParams;
import org.openstack4j.openstack.identity.domain.v3.AccessWrapper;
import org.openstack4j.openstack.identity.domain.v3.KeystoneToken;
import org.openstack4j.openstack.identity.functions.ServiceToServiceType;
import org.openstack4j.openstack.identity.internal.DefaultEndpointURLResolver;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;

/**
 * A client which has been identified.  Any calls spawned from this session will automatically utilize the original authentication that was
 * successfully validated and authorized
 * 
 * @author Jeremy Unruh
 */
public class OSClientSession implements OSClient, EndpointTokenProvider {

    private static final ThreadLocal<OSClientSession> sessions = new ThreadLocal<OSClientSession>();

    EndpointURLResolver epr = new DefaultEndpointURLResolver();
    Config config;
    Access access;
    AccessWrapper accessv3;
    Facing perspective;
    String region;
    Set<ServiceType> supports;
    CloudProvider provider;
    AuthVersion version;

    private OSClientSession(Access access, String endpoint, Facing perspective, CloudProvider provider, Config config)
    {
        this.access = access;
        this.accessv3 = null;
        this.config = config;
        this.perspective = perspective;
        this.provider = provider;
        this.version = AuthVersion.V2;
        sessions.set(this);
    }

    private OSClientSession(AccessWrapper accessv3, String endpoint, Facing perspective, CloudProvider provider, Config config)
    {
        this.access = null;
        this.accessv3 = accessv3;
        this.config = config;
        this.perspective = perspective;
        this.provider = provider;
        this.version = AuthVersion.V3;
        sessions.set(this);
    }

    private OSClientSession(OSClientSession parent, String region)
    {
        this.access = parent.access;
        this.accessv3 = parent.accessv3;
        this.perspective = parent.perspective;
        this.version = parent.version;
        this.region = region;
    }

    public static OSClientSession createSession(Access access) {
        return new OSClientSession(access, access.getEndpoint(), null, null, null);
    }

    public static OSClientSession createSession(Access access, Facing perspective, CloudProvider provider, Config config) {
        return new OSClientSession(access, access.getEndpoint(), perspective, provider, config);
    }

    public static OSClientSession createSession(AccessWrapper accessv3, Facing perspective, CloudProvider provider, Config config) {
        return new OSClientSession(accessv3, accessv3.getEndpoint(), perspective, provider, config);
    }


    
    public static OSClientSession getCurrent() {
        return sessions.get();
    }
    
    @VisibleForTesting
    public OSClientSession useConfig(Config config) {
        this.config = config;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OSClient useRegion(String region) {
        this.region = region;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OSClient removeRegion() {
        return useRegion(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<ServiceType> getSupportedServices() {
        if (supports == null)
            supports = Sets.immutableEnumSet(Iterables.transform(access.getServiceCatalog(), new ServiceToServiceType()));
        return supports;
    }

    /**
     * @return the current perspective
     */
    public Facing getPerspective() {
        return perspective;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsCompute() {
        return getSupportedServices().contains(ServiceType.COMPUTE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsIdentity() {
        return getSupportedServices().contains(ServiceType.IDENTITY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsNetwork() {
        return getSupportedServices().contains(ServiceType.NETWORK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsImage() {
        return getSupportedServices().contains(ServiceType.IMAGE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsHeat() {
        return getSupportedServices().contains(ServiceType.ORCHESTRATION);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsBlockStorage() {
        return getSupportedServices().contains(ServiceType.BLOCK_STORAGE);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsObjectStorage() {
        return getSupportedServices().contains(ServiceType.OBJECT_STORAGE);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean supportsTelemetry() {
        return getSupportedServices().contains(ServiceType.TELEMETRY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Token getToken() {
        return access.getToken();
    }

    @Override
    public org.openstack4j.model.identity.v3.Token getTokenV3() {
        return accessv3.getToken();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEndpoint() {
        if(access!=null){
            return access.getEndpoint();
        }else {
            return accessv3.getEndpoint();
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getEndpoint(ServiceType service) {
        if(access!=null) {
            return addNATIfApplicable(epr.findURL(URLResolverParams.create(access, service)
                    .resolver(config != null ? config.getV2Resolver() : null)
                    .perspective(perspective)
                    .region(region)));
        }else{
            return addNATIfApplicable(epr.findURL(URLResolverParams.create(accessv3, service)
                    .resolver(config != null ? config.getV2Resolver() : null)
                    .perspective(perspective)
                    .region(region)));
        }

    }
    
    private String addNATIfApplicable(String url) {
        if (config != null && config.isBehindNAT()) {
            try {
                URI uri = new URI(url);
                return url.replace(uri.getHost(), config.getEndpointNATResolution());
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return url;
    }
    
    /**
     * @return the original client configuration associated with this session
     */
    public Config getConfig()
    {
        return config;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getTokenId() {
        if(version.equals(AuthVersion.V2)){
            return getToken().getId();
        }else {
            return accessv3.getId();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IdentityService identity() {
        return Apis.getIdentityServices();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ComputeService compute() {
        return Apis.getComputeServices();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NetworkingService networking() {
        return Apis.getNetworkingServices();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImageService images() {
        return Apis.getImageService();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Access getAccess() {
        return access;
    }

    @Override
    public AccessWrapper getAccessV3() {
        return accessv3;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public BlockStorageService blockStorage() {
        return Apis.get(BlockStorageService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public TelemetryService telemetry() {
        return Apis.get(TelemetryService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HeatService heat() {
        return Apis.getHeatServices();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ObjectStorageService objectStorage() {
        return Apis.get(ObjectStorageService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SaharaService sahara() {
        return Apis.getSaharaServices();
    }

    @Override
    public AuthVersion getVersion() {
        return this.version;
    }

    @Override
    public OSClient perspective(Facing perspective) {
        this.perspective = perspective;
        return this;
    }
    
    public CloudProvider getProvider() {
        return (provider == null) ? CloudProvider.UNKNOWN : provider;
    }
	
}