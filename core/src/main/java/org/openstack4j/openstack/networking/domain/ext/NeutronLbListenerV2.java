package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbListenerV2;
import org.openstack4j.model.network.ext.LbLoadBalancerV2;
import org.openstack4j.model.network.ext.builder.LbListenerV2Builder;
import org.openstack4j.openstack.common.IdResourceEntity;
import org.openstack4j.openstack.common.ListResult;

import java.util.List;

/**
 * Created by zhangbohan on 16/2/17.
 */
@JsonRootName("listener")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbListenerV2 implements LbListenerV2 {

    private static final long serialVersionUID = 1L;


    private String id;
    @JsonProperty("tenant_id")
    private String tenantId;
    private String name;
    private String description;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;
    @JsonProperty("default_pool_id")
    private String defaultPoolId;
    @JsonProperty("connection_limit")
    private Integer connectionLimit ;
    private String protocol ;
    @JsonProperty("protocol_port")
    private Integer protocolPort ;
    @JsonProperty("loadbalancer_id")
    private String loadbalancerId;
    @JsonProperty("default_tls_container_ref")
    private String defaultTlsContainerRef;
    @JsonProperty("sni_container_refs")
    private List<String> sniContainerRefs;
    private List<IdResourceEntity> loadbalancers;


    /**
     * {@inheritDoc}
     */
    @Override
    public LbListenerV2Builder toBuilder() {
        return new LbListenerContreteV2Builder(this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getDefaultPoolId() {
        return defaultPoolId;
    }

    @Override
    public Integer getConnectionLimit() {
        return connectionLimit;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public Integer getProtocolPort() {
        return protocolPort;
    }

    @Override
    public String getLoadbalancerId() {
        return loadbalancerId;
    }

    @Override
    public List<IdResourceEntity> getLoadbalancers() {
        return loadbalancers;
    }

    public String getDefaultTlsContainerRef() {
        return defaultTlsContainerRef;
    }

    @Override
    public List<String> getSniContainerRefs() {
        return sniContainerRefs;
    }

    @Override
    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("adminStateUp", adminStateUp)
                .add("description", description)
                .add("name", name)
                .add("tenantId", tenantId)
                .add("defaultPoolId", defaultPoolId)
                .add("connectionLimit", connectionLimit)
                .add("loadbalancerId", loadbalancerId)
                .add("protocol", protocol)
                .add("protocolPort", protocolPort)
                .add("defaultTlsContainerRef", defaultTlsContainerRef)
                .add("sniContainerRefs", sniContainerRefs)
                .add("loadbalancers", loadbalancers)
                .toString();
    }

    public static class LbListenerContreteV2Builder implements LbListenerV2Builder {

        private NeutronLbListenerV2 m;
        @Override
        public LbListenerV2 build() {
            return m;
        }
        public LbListenerContreteV2Builder(){
            this(new NeutronLbListenerV2());
        }
        public LbListenerContreteV2Builder(NeutronLbListenerV2 m){
            this.m = m;
        }

        @Override
        public LbListenerV2Builder from(LbListenerV2 in) {
            m = (NeutronLbListenerV2) in;
            return this;
        }


        @Override
        public LbListenerV2Builder tenantId(String tenantId) {
            m.tenantId = tenantId;
            return this;
        }

        @Override
        public LbListenerV2Builder name(String name) {
            m.name = name;
            return this;
        }

        @Override
        public LbListenerV2Builder description(String description) {
            m.description = description;
            return this;
        }

        @Override
        public LbListenerV2Builder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }

        @Override
        public LbListenerV2Builder defaultPoolId(String defaultPoolId) {
            m.defaultPoolId = defaultPoolId;
            return this;
        }

        @Override
        public LbListenerV2Builder connectionLimit(Integer connectionLimit) {
            m.connectionLimit = connectionLimit;
            return this;
        }

        @Override
        public LbListenerV2Builder protocol(String protocol) {
            m.protocol = protocol;
            return this;
        }

        @Override
        public LbListenerV2Builder protocolPort(Integer protocolPort) {
            m.protocolPort = protocolPort;
            return this;
        }

        @Override
        public LbListenerV2Builder loadbalancerId(String loadbalancerId) {
            m.loadbalancerId = loadbalancerId;
            return this;
        }

        @Override
        public LbListenerV2Builder defaultTlsContainerRef(String defaultTlsContainerRef) {
            m.defaultTlsContainerRef = defaultTlsContainerRef;
            return this;
        }

        @Override
        public LbListenerV2Builder sniContainerRefs(List<String> sniContainerRefs) {
            m.sniContainerRefs = sniContainerRefs;
            return this;
        }
    }

    public static class LbListenerV2s extends ListResult<NeutronLbListenerV2> {

        private static final long serialVersionUID = 1L;
        @JsonProperty("listeners")
        List<NeutronLbListenerV2> listeners;
        /**
         * {@inheritDoc}
         */
        @Override
        public List<NeutronLbListenerV2> value() {
            return listeners;
        }
        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("listeners", listeners)
                    .toString();
        }

    }


    public static LbListenerV2Builder builder(){
        return new LbListenerContreteV2Builder();
    }
}
