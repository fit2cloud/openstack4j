package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbLoadBalancerV2;

/**
 * A Builder to create a loadBalancer
 * 
 * @author zhangbohan
 *
 */
public interface LbLoadBalancerV2Builder extends Builder<LbLoadBalancerV2Builder, LbLoadBalancerV2> {

	/**
	 * 
	 * @param tenantId
	 *            Owner of the loadbalancer. Only an administrative user can specify a
	 *            tenant ID other than its own.
	 * @return LbLoadBalancerV2Builder
	 */
	public LbLoadBalancerV2Builder tenantId(String tenantId);

	/**
	 * 
	 * @param name
	 *            Loadbalancer name. Does not have to be unique.
	 * @return LbLoadBalancerV2Builder
	 */
	public LbLoadBalancerV2Builder name(String name);

	/**
	 * 
	 * @param description
	 *            Description for the loadbalancer.
	 * @return LbLoadBalancerV2Builder
	 */
	public LbLoadBalancerV2Builder description(String description);

	/**
	 * 
	 * @param subnentId
	 *            The ID of the subnet on which to allocate the VIP address.
	 * @return LbLoadBalancerV2Builder
	 */
	public LbLoadBalancerV2Builder vipSubnetId(String subnentId);

	/**
	 *
	 * @param address
	 *            The address allocate the VIP .
	 * @return LbLoadBalancerV2Builder
	 */
	public LbLoadBalancerV2Builder vipAddress(String address);

	/**
	 *
	 * @param provider
	 *            Loadbalance provider which openstack supports,such as haproxy
	 * @return LbLoadBalancerV2Builder
	 */
	public LbLoadBalancerV2Builder provider(String provider);


	/**
	 * 
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbLoadBalancerV2Builder
	 */
	public LbLoadBalancerV2Builder adminStateUp(boolean adminStateUp);
}
