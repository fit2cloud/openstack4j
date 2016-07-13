package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbMemberV2Update;
import org.openstack4j.model.network.ext.LbPoolV2Update;

/**
 * A Builder to create a loadbalancer pool
 * 
 * @author zhangbohan
 *
 */
public interface LbMemberV2UpdateBuilder extends Builder<LbMemberV2UpdateBuilder, LbMemberV2Update> {


	/**
	 * 
	 * @param weight
	 *            The weight of a member determines the portion of requests or connections
	 *            it services compared to the other members of the pool.
	 * @return LbMemberV2UpdateBuilder
	 */
	public LbMemberV2UpdateBuilder weight(Integer weight);



	/**
	 *
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbMemberV2UpdateBuilder
	 */
	public LbMemberV2UpdateBuilder adminStateUp(boolean adminStateUp);




}
