package org.openstack4j.api.networking.ext;

import org.openstack4j.common.RestService;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.LbListenerV2;
import org.openstack4j.model.network.ext.LbListenerV2Update;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangbohan on 16/2/18.
 */
public interface LbListenerV2Service extends RestService {
    /**
     * List all listeners  that the current tenant has access to
     *
     * @return list of all listeners
     */
    List<? extends LbListenerV2> list();

    /**
     * Returns list of listener filtered by parameters.
     *
     * @param filteringParams map (name, value) of filtering parameters
     * @return
     */
    List<? extends LbListenerV2> list(Map<String, String> filteringParams);


    /**
     * Get the specified listener by ID
     *
     * @param listenerId the listener identifier
     * @return the member or null if not found
     */
    LbListenerV2 get(String listenerId);

    /**
     * Delete the specified member by ID
     * @param listenerId the listener identifier
     * @return the action response
     */
    ActionResponse delete(String listenerId);
    /**
     * Create a listener
     * @param listener LbListenerV2
     * @return Member
     */
    LbListenerV2 create(LbListenerV2 listener);
    /**
     * Update a listener
     * @param listenerId the listener identifier
     * @param member MemberUpdate
     * @return Member
     */
    LbListenerV2 update(String listenerId, LbListenerV2Update member);
}
