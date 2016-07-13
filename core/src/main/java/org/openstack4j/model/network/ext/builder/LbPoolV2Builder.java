package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbListenerV2;
import org.openstack4j.model.network.ext.LbPoolV2;

import java.util.List;

/**
 * A Builder to create a loadbalancer pool
 * 
 * @author zhangbohan
 *
 */
public interface LbPoolV2Builder extends Builder<LbPoolV2Builder, LbPoolV2> {

	/**
	 * 
	 * @param tenantId
	 *            Owner of the pool. Only an administrative user can specify a
	 *            tenant ID other than its own.
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder tenantId(String tenantId);

	/**
	 * 
	 * @param name
	 *            Pool name. Does not have to be unique.
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder name(String name);

	/**
	 * 
	 * @param description
	 *            Description for the pool.
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder description(String description);


	/**
	 *
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder adminStateUp(boolean adminStateUp);

	/**
	 *
	 * @param protocol
	 *            The protocol to load balance.
	 *            A valid value is HTTP, HTTPS, TCP, or TERMINATED_HTTPS.
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder protocol(String protocol);

	/**
	 *
	 * @param lbAlgorithm
	 *            The load-balancer algorithm.
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder lbAlgorithm(String lbAlgorithm);

	/**
	 *
	 * @param listenerId
	 *            The UUID of the listener in which this pool becomes the default pool
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder listenerId(String listenerId);


	/**
	 *
	 * @param sessionPersistence
	 *            The TCP or UDP port on which to listen.
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder sessionPersistence(String sessionPersistence);

	/**
	 *
	 * @param subnetId
	 *            The UUID of the subnet on which to allocate the virtual IP (VIP) address..
	 * @return LbPoolV2Builder
	 */
	public LbPoolV2Builder subnetId(String subnetId);

}
