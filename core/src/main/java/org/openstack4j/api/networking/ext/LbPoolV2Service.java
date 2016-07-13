package org.openstack4j.api.networking.ext;

import org.openstack4j.common.RestService;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.LbPoolV2Update;
import org.openstack4j.model.network.ext.LbPoolV2;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangbohan on 16/2/19.
 */
public interface LbPoolV2Service extends RestService {
    /**
     * List all lb pools that the current tenant has access to
     *
     * @return list of all lb pools
     */
    List<? extends LbPoolV2> list();

    /**
     * Returns list of lb pools filtered by parameters.
     *
     * @param filteringParams
     *            map (name, value) of filtering parameters
     * @return List
     */
    List<? extends LbPoolV2> list(Map<String, String> filteringParams);

    /**
     * Get the specified lb pool by ID
     *
     * @param lbPoolId
     *            the lb pool identifier
     * @return the lbPool or null if not found
     */
    LbPoolV2 get(String lbPoolId);

    /**
     * Delete the specified lb Pool by ID
     *
     * @param lbPoolId
     *            the lb pool identifier
     * @return the action response
     */
    ActionResponse delete(String lbPoolId);

    /**
     * Create a lb Pool
     *
     * @param lbPool
     *            LbPoolV2
     * @return Member
     */
    LbPoolV2 create(LbPoolV2 lbPool);

    /**
     * Update a lb pool
     *
     * @param lbPoolId
     *            the lb pool identifier
     * @param lbPool
     *            LbPoolV2Update
     * @return LbPoolV2
     */
    LbPoolV2 update(String lbPoolId, LbPoolV2Update lbPool);


}
