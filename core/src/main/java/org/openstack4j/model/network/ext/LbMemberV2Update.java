package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbLoadBalancerV2UpdateBuilder;
import org.openstack4j.model.network.ext.builder.LbMemberV2UpdateBuilder;

/**
 * A loadbanlancer
 * @author zhangbohan
 *
 */
public interface LbMemberV2Update extends ModelEntity, Buildable<LbMemberV2UpdateBuilder> {

	/**
	 * 
	 * @return The weight of a member determines the portion of requests or connections it services compared to the other members of the pool.
	 * A value of 0 means the member does not participate in load-balancing but still accepts persistent connections.
	 * A valid value is from 0 to 256.
	 */
	public Integer getWeight();


	/**
	 * 
	 * @return The administrative state of the lb member, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();


}
