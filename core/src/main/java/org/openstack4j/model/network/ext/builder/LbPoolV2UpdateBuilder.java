package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbPoolV2Update;

/**
 * A Builder to create a loadbalancer pool
 * 
 * @author zhangbohan
 *
 */
public interface LbPoolV2UpdateBuilder extends Builder<LbPoolV2UpdateBuilder, LbPoolV2Update> {


	/**
	 * 
	 * @param name
	 *            Pool name. Does not have to be unique.
	 * @return LbPoolV2UpdateBuilder
	 */
	public LbPoolV2UpdateBuilder name(String name);

	/**
	 * 
	 * @param description
	 *            Description for the pool.
	 * @return LbPoolV2UpdateBuilder
	 */
	public LbPoolV2UpdateBuilder description(String description);


	/**
	 *
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbPoolV2UpdateBuilder
	 */
	public LbPoolV2UpdateBuilder adminStateUp(boolean adminStateUp);


	/**
	 *
	 * @param lbAlgorithm
	 *            The load-balancer algorithm.
	 * @return LbPoolV2UpdateBuilder
	 */
	public LbPoolV2UpdateBuilder lbAlgorithm(String lbAlgorithm);



	/**
	 *
	 * @param sessionPersistence
	 *            The TCP or UDP port on which to listen.
	 * @return LbPoolV2UpdateBuilder
	 */
	public LbPoolV2UpdateBuilder sessionPersistence(String sessionPersistence);


}
