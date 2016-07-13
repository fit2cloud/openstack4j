package org.openstack4j.api.networking.ext;

import org.openstack4j.common.RestService;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.LbMemberV2;
import org.openstack4j.model.network.ext.LbMemberV2Update;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangbohan on 16/2/19.
 */
public interface LbMemberV2Service extends RestService {
    /**
     * List all lb members
     *
     * @return list of all lb members
     */
    List<? extends LbMemberV2> list(String poolId);

    /**
     * Returns list of lb members filtered by parameters.
     *
     * @param filteringParams
     *            map (name, value) of filtering parameters
     * @return List
     */
    List<? extends LbMemberV2> list(String poolId,Map<String, String> filteringParams);

    /**
     * Get the specified lb member by ID
     *
     * @param poolId
     *            the lb pool identifier
     * @param lbMemberId
     *            the lb member identifier
     * @return the lbMember or null if not found
     */
    LbMemberV2 get(String poolId,String lbMemberId);

    /**
     * Delete the specified lb Pool by ID
     *
     *
     * @param poolId
     *            the lb pool identifier
     * @param lbMemberId
     *            the lb member identifier
     * @return the action response
     */
    ActionResponse delete(String poolId,String lbMemberId);

    /**
     * Create a lb Pool
     *
     * @param poolId
     *            the lb pool identifier
     * @param lbMember
     *            LbMemberV2
     * @return Member
     */
    LbMemberV2 create(String poolId,LbMemberV2 lbMember);

    /**
     * Update a lb member
     *
     * @param poolId
     *            the lb pool identifier
     * @param lbMemberId
     *            the lb member identifier
     * @param lbMember
     *            LbMemberV2Update
     * @return LbMemberV2
     */
    LbMemberV2 update(String poolId,String lbMemberId, LbMemberV2Update lbMember);


}
