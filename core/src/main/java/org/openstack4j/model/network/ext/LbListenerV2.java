package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbListenerV2Builder;
import org.openstack4j.openstack.common.IdResourceEntity;

import java.util.List;

/**
 * A lb listener
 * @author zhangbohan
 *
 */
public interface LbListenerV2 extends ModelEntity, Buildable<LbListenerV2Builder> {

	/**
	 * 
	 * @return id. The unique ID for the listener.
	 */
	public String getId();
	/**
	 * 
	 * @return tenantId.
	 * Owner of the listener. Only an administrative user can specify a tenant ID other than its own.
	 */
	public String getTenantId();
	/**
	 * 
	 * @return listener name. Does not have to be unique.
	 */
	public String getName();
	/**
	 * 
	 * @return Description for the listener.
	 */
	public String getDescription();


	/**
	 * 
	 * @return The UUID of default pool.
	 */
	public String getDefaultPoolId ();
	
	/**
	 * 
	 * @return The maximum number of connections permitted for this load balancer.
	 * Default is -1, which indicates an infinite limit.
	 */
	public Integer getConnectionLimit ();
	/**
	 *
	 * @return The protocol to load balance.
	 * A valid value is HTTP, HTTPS, TCP, or TERMINATED_HTTPS.
	 */
	public String getProtocol();

	/**
	 *
	 * @return The TCP or UDP port on which to listen.
	 */
	public Integer getProtocolPort();

	/**
	 * 
	 * @return The administrative state of the lb pool, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();
	/**
	 * 
	 * @return The UUID of the load balancer.
	 *
	 */
	public String getLoadbalancerId();

	/**
	 *
	 * @return The list of the load balancers related with listener.
	 *
	 */
	public List<IdResourceEntity> getLoadbalancers();
	/**
	 *
	 * @return A reference to a container of TLS secrets.
	 */
	public String getDefaultTlsContainerRef ();
	/**
	 *
	 * @return A list of references to TLS secrets..
	 */
	public List<String> getSniContainerRefs ();


}
