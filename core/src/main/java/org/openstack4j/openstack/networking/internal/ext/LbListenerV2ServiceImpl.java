package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.networking.ext.LbListenerV2Service;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.LbListenerV2;
import org.openstack4j.model.network.ext.LbListenerV2Update;
import org.openstack4j.openstack.compute.functions.ToActionResponseFunction;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbListenerV2;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbListenerV2.LbListenerV2s;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by zhangbohan on 16/2/19.
 */
public class LbListenerV2ServiceImpl extends BaseNetworkingServices implements LbListenerV2Service {
    @Override
    public List<? extends LbListenerV2> list() {
        return get(LbListenerV2s.class, uri("/lbaas/listeners")).execute().getList();
    }

    @Override
    public List<? extends LbListenerV2> list(Map<String, String> filteringParams) {
        Invocation<LbListenerV2s> req = get(LbListenerV2s.class, uri("/lbaas/listeners"));
        if (filteringParams != null) {
            for (Map.Entry<String, String> entry : filteringParams.entrySet()) {
                req = req.param(entry.getKey(), entry.getValue());
            }
        }
        return req.execute().getList();
    }

    @Override
    public LbListenerV2 get(String listenerId) {
        checkNotNull(listenerId);
        return get(NeutronLbListenerV2.class, uri("/lbaas/listeners/%s",listenerId)).execute();
    }

    @Override
    public ActionResponse delete(String listenerId) {
        checkNotNull(listenerId);
        return ToActionResponseFunction.INSTANCE.apply(delete(void.class,
                uri("/lbaas/listeners/%s", listenerId)).executeWithResponse());
    }

    @Override
    public LbListenerV2 create(LbListenerV2 listener) {
        checkNotNull(listener);
        return post(NeutronLbListenerV2.class,uri("/lbaas/listeners")).entity(listener).execute();
    }

    @Override
    public LbListenerV2 update(String listenerId, LbListenerV2Update listenerUpdate) {
        checkNotNull(listenerId);
        checkNotNull(listenerUpdate);
        return put(NeutronLbListenerV2.class, uri("/lbaas/listeners/%s", listenerId)).entity(
                listenerUpdate).execute();
    }
}
