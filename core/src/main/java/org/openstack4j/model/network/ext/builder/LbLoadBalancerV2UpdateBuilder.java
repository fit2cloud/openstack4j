package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbLoadBalancerV2Update;

/**
 * A Builder to create a loadBalancer
 * 
 * @author zhangbohan
 *
 */
public interface LbLoadBalancerV2UpdateBuilder extends Builder<LbLoadBalancerV2UpdateBuilder, LbLoadBalancerV2Update> {


	/**
	 * 
	 * @param name
	 *            Loadbalancer name. Does not have to be unique.
	 * @return LbLoadBalancerV2UpdateBuilder
	 */
	public LbLoadBalancerV2UpdateBuilder name(String name);

	/**
	 * 
	 * @param description
	 *            Description for the loadbalancer.
	 * @return LbLoadBalancerV2UpdateBuilder
	 */
	public LbLoadBalancerV2UpdateBuilder description(String description);



	/**
	 * 
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbLoadBalancerV2UpdateBuilder
	 */
	public LbLoadBalancerV2UpdateBuilder adminStateUp(boolean adminStateUp);
}
