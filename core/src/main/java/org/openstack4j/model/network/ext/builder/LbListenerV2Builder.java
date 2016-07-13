package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbListenerV2;

import java.util.List;

/**
 * A Builder to create a loadbalancer listener
 * 
 * @author zhangbohan
 *
 */
public interface LbListenerV2Builder extends Builder<LbListenerV2Builder, LbListenerV2> {

	/**
	 * 
	 * @param tenantId
	 *            Owner of the listener. Only an administrative user can specify a
	 *            tenant ID other than its own.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder tenantId(String tenantId);

	/**
	 * 
	 * @param name
	 *            Pool name. Does not have to be unique.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder name(String name);

	/**
	 * 
	 * @param description
	 *            Description for the pool.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder description(String description);


	/**
	 *
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder adminStateUp(boolean adminStateUp);

	/**
	 *
	 * @param defaultPoolId
	 *            The UUID of default pool.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder defaultPoolId(String defaultPoolId);

	/**
	 *
	 * @param connectionLimit
	 *            The maximum number of connections permitted for this load balancer.
	 * 			  Default is -1, which indicates an infinite limit.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder connectionLimit(Integer connectionLimit);

	/**
	 *
	 * @param protocol
	 *            The protocol to load balance.
	 *            A valid value is HTTP, HTTPS, TCP, or TERMINATED_HTTPS.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder protocol(String protocol);

	/**
	 *
	 * @param protocolPort
	 *            The TCP or UDP port on which to listen.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder protocolPort(Integer protocolPort);

	/**
	 *
	 * @param loadbalancerId
	 *            The UUID of the load balancer.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder loadbalancerId(String loadbalancerId);

	/**
	 *
	 * @param defaultTlsContainerRef
	 *            A reference to a container of TLS secrets.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder defaultTlsContainerRef(String defaultTlsContainerRef);

	/**
	 *
	 * @param sniContainerRefs
	 *            A list of references to TLS secrets.
	 * @return LbListenerV2Builder
	 */
	public LbListenerV2Builder sniContainerRefs(List<String> sniContainerRefs);
}
