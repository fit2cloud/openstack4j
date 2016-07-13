package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbPoolV2UpdateBuilder;

/**
 * A lb pool
 * @author zhangbohan
 *
 */
public interface LbPoolV2Update extends ModelEntity, Buildable<LbPoolV2UpdateBuilder> {

	/**
	 * 
	 * @return pool name. Does not have to be unique.
	 */
	public String getName();
	/**
	 * 
	 * @return Description for the pool.
	 */
	public String getDescription();


	/**
	 * 
	 * @return The administrative state of the lb pool, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();



	/**
	 *
	 * @return The load-balancer algorithm,
	 * which is round-robin (ROUND_ROBIN),
	 * least-connections (LEAST_CONNECTIONS), source IP (SOURCE_IP),
	 * and so on, that is used to distribute traffic to the pool members.
	 * This value, which must be supported,
	 * is dependent on the load-balancer provider.
	 * The round-robin algorithm must be supported.
	 */
	public String getLbAlgorithm();


	/**
	 *
	 * @return The session persistence algorithm. This algorithm is a dictionary with type and cookie_name keys.
	 */
	public String getSessionPersistence();


}
