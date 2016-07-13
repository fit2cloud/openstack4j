
package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.networking.ext.LbMemberV2Service;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.*;
import org.openstack4j.openstack.compute.functions.ToActionResponseFunction;
import org.openstack4j.openstack.networking.domain.ext.NeutronHealthMonitor;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbMemberV2.LbMemberV2s;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbMemberV2;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 *  OpenStack (Neutron) Lbaas pool based Operations
 * @author liujunpeng
 *
 */
public class LbMemberV2ServiceImpl extends BaseNetworkingServices implements
        LbMemberV2Service {

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends LbMemberV2> list(String poolId) {
        return get(LbMemberV2s.class, uri("/lbaas/pools/%s/members",poolId)).execute().getList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<? extends LbMemberV2> list(String poolId,Map<String, String> filteringParams) {
        Invocation<LbMemberV2s> req = get(LbMemberV2s.class, uri("/lbaas/pools/%s/members",poolId));
        if (filteringParams != null) {
            for (Map.Entry<String, String> entry : filteringParams.entrySet()) {
                req = req.param(entry.getKey(), entry.getValue());
            }
        }
        return req.execute().getList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LbMemberV2 get(String poolId,String lbMemberId) {
        checkNotNull(lbMemberId);
        return get(NeutronLbMemberV2.class, uri("/lbaas/pools/%s/members/%s",poolId,lbMemberId)).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ActionResponse delete(String poolId,String lbMemberId) {
        checkNotNull(lbMemberId);
        return ToActionResponseFunction.INSTANCE.apply(delete(void.class,
                uri("/lbaas/pools/%s/members/%s",poolId,lbMemberId)).executeWithResponse());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LbMemberV2 create(String poolId,LbMemberV2 lbPool) {
        checkNotNull(lbPool);
        return post(NeutronLbMemberV2.class,uri("/lbaas/pools/%s/members",poolId)).entity(lbPool).execute();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LbMemberV2 update(String poolId,String lbMemberId, LbMemberV2Update lbPool) {
        checkNotNull(lbMemberId);
        checkNotNull(lbPool);
        return put(NeutronLbMemberV2.class, uri("/lbaas/pools/%s/members/%s",poolId, lbMemberId)).entity(
                lbPool).execute();
    }

}
