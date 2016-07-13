package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.networking.ext.LbPoolV2Service;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.LbPoolV2;
import org.openstack4j.model.network.ext.LbPoolV2Update;
import org.openstack4j.openstack.compute.functions.ToActionResponseFunction;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbPoolV2;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbPoolV2.LbPoolV2s;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by zhangbohan on 16/2/19.
 */
public class LbPoolV2ServiceImpl extends BaseNetworkingServices implements LbPoolV2Service{
    @Override
    public List<? extends LbPoolV2> list() {
        return get(LbPoolV2s.class, uri("/lbaas/pools")).execute().getList();
    }

    @Override
    public List<? extends LbPoolV2> list(Map<String, String> filteringParams) {
        Invocation<LbPoolV2s> req = get(LbPoolV2s.class, uri("/lbaas/pools"));
        if (filteringParams != null) {
            for (Map.Entry<String, String> entry : filteringParams.entrySet()) {
                req = req.param(entry.getKey(), entry.getValue());
            }
        }
        return req.execute().getList();
    }

    @Override
    public LbPoolV2 get(String lbPoolId) {
        checkNotNull(lbPoolId);
        return get(NeutronLbPoolV2.class, uri("/lbaas/pools/%s",lbPoolId)).execute();
    }

    @Override
    public ActionResponse delete(String lbPoolId) {
        checkNotNull(lbPoolId);
        return ToActionResponseFunction.INSTANCE.apply(delete(void.class,
                uri("/lbaas/pools/%s", lbPoolId)).executeWithResponse());
    }

    @Override
    public LbPoolV2 create(LbPoolV2 lbPool) {
        checkNotNull(lbPool);
        return post(NeutronLbPoolV2.class,uri("/lbaas/pools")).entity(lbPool).execute();
    }

    @Override
    public LbPoolV2 update(String lbPoolId, LbPoolV2Update lbPool) {
        checkNotNull(lbPoolId);
        checkNotNull(lbPool);
        return put(NeutronLbPoolV2.class, uri("/lbaas/pools/%s", lbPoolId)).entity(
                lbPool).execute();
    }
}
