package org.openstack4j.model.network.ext;

import org.openstack4j.common.Buildable;
import org.openstack4j.model.ModelEntity;
import org.openstack4j.model.network.ext.builder.LbListenerV2UpdateBuilder;

import java.util.List;

/**
 * A lb listener update
 * @author zhangbohan
 *
 */
public interface LbListenerV2Update extends ModelEntity, Buildable<LbListenerV2UpdateBuilder> {

	/**
	 *
	 * @return listener name. Does not have to be unique.
	 */
	public String getName();
	/**
	 *
	 * @return Description for the listener.
	 */
	public String getDescription();

	/**
	 *
	 * @return The maximum number of connections permitted for this load balancer.
	 * Default is -1, which indicates an infinite limit.
	 */
	public Integer getConnectionLimit ();

	/**
	 *
	 * @return The administrative state of the lb pool, which is up (true) or
	 *         down (false).
	 */
	public boolean isAdminStateUp();
	/**
	 *
	 * @return A reference to a container of TLS secrets.
	 */
	public String getDefaultTlsContainerRef ();
	/**
	 *
	 * @return A list of references to TLS secrets..
	 */
	public List<String> getSniContainerRefs ();


}
