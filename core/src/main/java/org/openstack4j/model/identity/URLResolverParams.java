package org.openstack4j.model.identity;

import org.openstack4j.api.types.Facing;
import org.openstack4j.api.types.ServiceType;
import org.openstack4j.model.common.resolvers.ServiceVersionResolver;
import org.openstack4j.model.common.resolvers.StableServiceVersionResolver;
import org.openstack4j.openstack.identity.domain.v3.AccessWrapper;

/**
 * Dynamic parameters used for URL resolution with Endpoints
 * 
 * @author Jeremy Unruh
 */
public class URLResolverParams {

	public final Access access;
	public final AccessWrapper accessv3;
	public final ServiceType type;
	public String region;
	public Facing perspective;
	private ServiceVersionResolver resolver;
	private AuthVersion version;
	
	private URLResolverParams(Access access, ServiceType type) {
		this.access = access;
		this.accessv3 = null;
		this.type = (type == null) ? ServiceType.IDENTITY : type;
		this.version = AuthVersion.V2;
	}

	private URLResolverParams(AccessWrapper accessv3, ServiceType type) {
		this.access = null;
		this.accessv3 = accessv3;
		this.type = (type == null) ? ServiceType.IDENTITY : type;
		this.version = AuthVersion.V3;
	}
	
	public static URLResolverParams create(Access access, ServiceType type) {
		return new URLResolverParams(access, type);
	}

	public static URLResolverParams create(AccessWrapper accessv3, ServiceType type) {
		return new URLResolverParams(accessv3, type);
	}
	
	public URLResolverParams region(String region) {
		this.region = region;
		return this;
	}
	
	public URLResolverParams perspective(Facing perspective) {
		this.perspective = perspective;
		return this;
	}
	
	public URLResolverParams resolver(ServiceVersionResolver resolver) {
	    this.resolver = resolver;
	    return this;
	}

	public URLResolverParams version(AuthVersion version){
		this.version = version;
		return this;
	}

	public AuthVersion getVersion(){
		return (version != null) ? version : AuthVersion.V2;
 	}
	
	public ServiceVersionResolver getV2Resolver() {
	    return (resolver != null) ? resolver : StableServiceVersionResolver.INSTANCE;
	}
	
}
