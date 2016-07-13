package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbLoadBalancerV2UpdateBuilder;

/**
 * A loadbanlancer
 * @author zhangbohan
 *
 */
public interface LbLoadBalancerV2Update extends ModelEntity, Buildable<LbLoadBalancerV2UpdateBuilder> {

	/**
	 * 
	 * @return loadbalancer name. Does not have to be unique.
	 */
	public String getName();
	/**
	 * 
	 * @return Description for the loadbalancer.
	 */
	public String getDescription();


	/**
	 * 
	 * @return The administrative state of the lb loadbalancer, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();


}
