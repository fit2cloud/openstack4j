package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbListenerV2Builder;
import org.openstack4j.model.network.ext.builder.LbPoolV2Builder;
import org.openstack4j.openstack.common.IdResourceEntity;

import java.util.List;

/**
 * A lb pool
 * @author zhangbohan
 *
 */
public interface LbPoolV2 extends ModelEntity, Buildable<LbPoolV2Builder> {

	/**
	 * 
	 * @return id. The unique ID for the pool.
	 */
	public String getId();
	/**
	 * 
	 * @return tenantId.
	 * Owner of the pool. Only an administrative user can specify a tenant ID other than its own.
	 */
	public String getTenantId();
	/**
	 * 
	 * @return pool name. Does not have to be unique.
	 */
	public String getName();
	/**
	 * 
	 * @return Description for the pool.
	 */
	public String getDescription();

	/**
	 *
	 * @return The protocol of the pool, which is TCP, HTTP, or HTTPS.
	 */
	public String getProtocol();


	/**
	 * 
	 * @return The administrative state of the lb pool, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();

	/**
	 *
	 * @return The status of the pool. Indicates whether the pool is operational.
	 */
	public String getStatus();

	/**
	 *
	 * @return The list of members that belong to the pool.
	 */
	public List<IdResourceEntity> getMembers();

	/**
	 *
	 * @return The UUID of listener .
	 */
	public String getListenerId();

	/**
	 *
	 * @return The list of listeners that belong to the pool.
	 */
	public List<IdResourceEntity> getListeners();

	/**
	 *
	 * @return The load-balancer algorithm,
	 * which is round-robin (ROUND_ROBIN),
	 * least-connections (LEAST_CONNECTIONS), source IP (SOURCE_IP),
	 * and so on, that is used to distribute traffic to the pool members.
	 * This value, which must be supported,
	 * is dependent on the load-balancer provider.
	 * The round-robin algorithm must be supported.
	 */
	public String getLbAlgorithm();

	/**
	 *
	 * @return The UUID of the health monitor.
	 */
	public String getHealthmonitorId();

	/**
	 *
	 * @return The list of health monitors that belong to the pool.
	 */
	public List<IdResourceEntity> getHealthMonitors();


	/**
	 *
	 * @return The session persistence algorithm. This algorithm is a dictionary with type and cookie_name keys.
	 */
	public String getSessionPersistence();

	/**
	 *
	 * @return The UUID of the subnet.
	 */
	public String getSubnetId();

	/**
	 *
	 * @return The UUID of the virtual IP (VIP) address.
	 */
	public String getVipId();

	/**
	 *
	 * @return The statuses of the health monitors that are associated with the pool.
	 */
	public String getHealthMonitorsStatus();

}
