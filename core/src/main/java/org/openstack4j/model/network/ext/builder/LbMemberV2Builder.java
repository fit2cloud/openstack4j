package org.openstack4j.model.network.ext.builder;

import org.openstack4j.common.Buildable.Builder;
import org.openstack4j.model.network.ext.LbMemberV2;
import org.openstack4j.model.network.ext.LbPoolV2;

/**
 * A Builder to create a loadbalancer pool
 * 
 * @author zhangbohan
 *
 */
public interface LbMemberV2Builder extends Builder<LbMemberV2Builder, LbMemberV2> {

	/**
	 * 
	 * @param tenantId
	 *            Owner of the member. Only an administrative user can specify a
	 *            tenant ID other than its own.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder tenantId(String tenantId);

	/**
	 * 
	 * @param poolId
	 *            The UUID of the pool to which the member belongs.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder poolId(String poolId);

	/**
	 * 
	 * @param address
	 *            The IP address of the member.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder address(String address);


	/**
	 *
	 * @param adminStateUp
	 *            The administrative state of the lb pool, which is up (true) or
	 *            down (false).
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder adminStateUp(boolean adminStateUp);

	/**
	 *
	 * @param protocolPort
	 *            TThe port where the application is hosted.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder protocolPort(Integer protocolPort);

	/**
	 *
	 * @param weight
	 *            The load-balancer algorithm.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder weight(Integer weight);

	/**
	 *
	 * @param subnetId
	 *            The UUID of the subnet.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder subnetId(String subnetId);

	/**
	 *
	 * @param floatingNetworkId
	 *            The UUID of the floatingNetwork.custom for xiangcloud.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder floatingNetworkId(String floatingNetworkId);

	/**
	 *
	 * @param portId
	 *            The UUID of the port.custom for xiangcloud.
	 * @return LbMemberV2Builder
	 */
	public LbMemberV2Builder portId(String portId);

}
