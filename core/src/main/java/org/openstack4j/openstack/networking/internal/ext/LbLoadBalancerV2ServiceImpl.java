package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.networking.ext.*;
import org.openstack4j.model.compute.ActionResponse;
import org.openstack4j.model.network.ext.LbLoadBalancerV2;
import org.openstack4j.model.network.ext.LbLoadBalancerV2Update;
import org.openstack4j.openstack.compute.functions.ToActionResponseFunction;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbLoadBalancerV2.LbLoadBalancerV2s;
import org.openstack4j.openstack.networking.domain.ext.NeutronLbLoadBalancerV2;
import org.openstack4j.openstack.networking.internal.BaseNetworkingServices;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * LBaaS Service Implementation
 */
public class LbLoadBalancerV2ServiceImpl extends BaseNetworkingServices implements LbLoadBalancerV2Service {


    @Override
    public List<? extends LbLoadBalancerV2> list() {
        return get(LbLoadBalancerV2s.class, uri("/lbaas/loadbalancers")).execute().getList();
    }

    @Override
    public List<? extends LbLoadBalancerV2> list(Map<String, String> filteringParams) {
        Invocation<LbLoadBalancerV2s> req = get(LbLoadBalancerV2s.class, uri("/lbaas/loadbalancers"));
        if (filteringParams != null) {
            for (Map.Entry<String, String> entry : filteringParams.entrySet()) {
                req = req.param(entry.getKey(), entry.getValue());
            }
        }
        return req.execute().getList();
    }

    @Override
    public LbLoadBalancerV2 get(String loadBalancerId) {
        checkNotNull(loadBalancerId);
        return get(NeutronLbLoadBalancerV2.class, uri("/lbaas/loadbalancers/%s",loadBalancerId)).execute();
    }

    @Override
    public ActionResponse delete(String loadBalancerId) {
        checkNotNull(loadBalancerId);
        return ToActionResponseFunction.INSTANCE.apply(delete(void.class,
                uri("/lbaas/loadbalancers/%s", loadBalancerId)).executeWithResponse());
    }

    @Override
    public LbLoadBalancerV2 create(LbLoadBalancerV2 lbLoadBalancerV2) {
        checkNotNull(lbLoadBalancerV2);
        return post(NeutronLbLoadBalancerV2.class,uri("/lbaas/loadbalancers")).entity(lbLoadBalancerV2).execute();
    }

    @Override
    public LbLoadBalancerV2 update(String loadBalancerId, LbLoadBalancerV2Update lbLoadBalancerV2Update) {
        checkNotNull(loadBalancerId);
        checkNotNull(lbLoadBalancerV2Update);
        return put(NeutronLbLoadBalancerV2.class, uri("/lbaas/loadbalancers/%s", loadBalancerId)).entity(
                lbLoadBalancerV2Update).execute();
    }
}
