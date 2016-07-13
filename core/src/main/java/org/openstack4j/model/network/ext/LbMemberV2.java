package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbMemberV2Builder;
import org.openstack4j.model.network.ext.builder.LbPoolV2Builder;

import java.util.List;

/**
 * A lb pool
 * @author zhangbohan
 *
 */
public interface LbMemberV2 extends ModelEntity, Buildable<LbMemberV2Builder> {

	/**
	 * 
	 * @return id. The unique ID for the member.
	 */
	public String getId();
	/**
	 * 
	 * @return tenantId.
	 * Owner of the member. Only an administrative user can specify a tenant ID other than its own.
	 */
	public String getTenantId();



	/**
	 * 
	 * @return The administrative state of the lb pool, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();

	/**
	 *
	 * @return The status of the pool. Indicates whether the pool is operational.
	 */
	public String getStatus();



	/**
	 *
	 * @return The UUID of the pool to which the member belongs.
	 */
	public String getPoolId();

	/**
	 *
	 * @return The IP address of the member.
	 */
	public String getAddress();

	/**
	 *
	 * @return The port where the application is hosted.
	 */
	public Integer getProtocolPort();

	/**
	 *
	 * @return The UUID of the health monitor.
	 */
	public Integer getWeight();

	/**
	 *
	 * @return The UUID of the subnet.
	 */
	public String getSubnetId();

	/**
	 *
	 * @return custome for xiangcloud.
	 */
	public String getFloatingNetworkId();

	/**
	 *
	 * @return custome for xiangcloud.
	 */
	public String getPortId();

}
