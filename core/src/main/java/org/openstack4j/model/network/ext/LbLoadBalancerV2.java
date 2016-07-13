package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbLoadBalancerV2Builder;
import org.openstack4j.openstack.common.IdResourceEntity;

import java.util.List;

/**
 * A loadbanlancer
 * @author zhangbohan
 *
 */
public interface LbLoadBalancerV2 extends ModelEntity, Buildable<LbLoadBalancerV2Builder> {

	/**
	 * 
	 * @return id. The unique ID for the loadbanlancer.
	 */
	public String getId();
	/**
	 * 
	 * @return tenantId.
	 * Owner of the loadbanlancer. Only an administrative user can specify a tenant ID other than its own.
	 */
	public String getTenantId();
	/**
	 * 
	 * @return vip address.
	 */
	public String getVipAddress();
	/**
	 *
	 * @return subnetId The ID of the subnet on which to allocate the VIP address.
	 */
	public String getVipSubnetId();
	/**
	 * 
	 * @return loadbalancer name. Does not have to be unique.
	 */
	public String getName();
	/**
	 * 
	 * @return Description for the pool.
	 */
	public String getDescription();


	/**
	 * 
	 * @return List of members that belong to the pool.
	 */
	public List<IdResourceEntity> getMembers();
	
	/**
	 * 
	 * @return List of health monitors that associated to the pool.
	 */
	public List<IdResourceEntity> getHealthMonitors();
	/**
	 *
	 * @return List of listeners that associated to the pool.
	 */
	public List<IdResourceEntity> getListeners();

	/**
	 * 
	 * @return The administrative state of the lb pool, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();
	/**
	 * 
	 * @return The provisioning status of the load balancer.
	 *
	 */
	public String getProvisioningStatus();
	/**
	 *
	 * @return The operating status of the load balancer.
	 *  This value is ONLINE or OFFLINE.
	 */
	public String getOperatingStatus();

	/**
	 *
	 * @return The provider  of the load balancer.
	 */
	public String getProvider();


}
