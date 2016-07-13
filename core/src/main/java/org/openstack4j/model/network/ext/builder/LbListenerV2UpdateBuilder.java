package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbListenerV2Update;

import java.util.List;

/**
 * A Builder to create a loadBalancer
 * 
 * @author zhangbohan
 *
 */
public interface LbListenerV2UpdateBuilder extends Builder<LbListenerV2UpdateBuilder, LbListenerV2Update> {


	/**
	 * 
	 * @param name
	 *            Pool name. Does not have to be unique.
	 * @return LbPoolBuilder
	 */
	public LbListenerV2UpdateBuilder name(String name);

	/**
	 * 
	 * @param description
	 *            Description for the pool.
	 * @return LbPoolBuilder
	 */
	public LbListenerV2UpdateBuilder description(String description);



	/**
	 * 
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbPoolBuilder
	 */
	public LbListenerV2UpdateBuilder adminStateUp(boolean adminStateUp);

	/**
	 *
	 * @param connectionLimit
	 *            The maximum number of connections permitted for this load balancer.
	 * 			  Default is -1, which indicates an infinite limit.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2UpdateBuilder connectionLimit(Integer connectionLimit);

	/**
	 *
	 * @param defaultTlsContainerRef
	 *            A reference to a container of TLS secrets.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2UpdateBuilder defaultTlsContainerRef(String defaultTlsContainerRef);

	/**
	 *
	 * @param sniContainerRefs
	 *            A list of references to TLS secrets.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2UpdateBuilder sniContainerRefs(List<String> sniContainerRefs);
}
