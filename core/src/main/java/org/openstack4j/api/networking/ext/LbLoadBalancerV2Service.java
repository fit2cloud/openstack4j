package org.openstack4j.api.networking.ext;

import org.openstack4j.common.RestService;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.LbLoadBalancerV2;
import org.openstack4j.model.network.ext.LbLoadBalancerV2Update;

import java.util.List;
import java.util.Map;

/**
 * Networking (Neutron) Lbaas member Extension API
 * @author liujunpeng
 *
 */
public interface LbLoadBalancerV2Service extends RestService {
    /**
     * List all loadBalancers  that the current tenant has access to
     *
     * @return list of all loadBalancers
     */
    List<? extends LbLoadBalancerV2> list();

    /**
     * Returns list of loadBalancer filtered by parameters.
     * 
     * @param filteringParams map (name, value) of filtering parameters
     * @return 
     */
    List<? extends LbLoadBalancerV2> list(Map<String, String> filteringParams);


    /**
     * Get the specified loadBalancer by ID
     *
     * @param loadBalancerId the loadBalancer identifier
     * @return the member or null if not found
     */
    LbLoadBalancerV2 get(String loadBalancerId);
    
    /**
     * Delete the specified member by ID
     * @param loadBalancerId the loadBalancer identifier
     * @return the action response
     */
    ActionResponse delete(String loadBalancerId);
    /**
     * Create a loadBalancer
     * @param loadBalancer LbLoadBalancerV2
     * @return Member
     */
    LbLoadBalancerV2 create(LbLoadBalancerV2 loadBalancer);
    /**
     * Update a loadBalancer
     * @param loadBalancerId the loadBalancer identifier
     * @param member MemberUpdate
     * @return Member
     */
    LbLoadBalancerV2 update(String loadBalancerId, LbLoadBalancerV2Update member);
}
