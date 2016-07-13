package org.openstack4j.openstack.networking.internal.ext;

import org.openstack4j.api.Apis;
import org.openstack4j.api.networking.ext.*;

/**
 * LBaaS Service Implementation
 */
public class LBaaSServiceImpl implements LBaaSService {

    /**
     * {@inheritDoc}
     */
    @Override
    public MemberService member(){
        return Apis.get(MemberService.class);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public VipService vip() {
        return Apis.get(VipService.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HealthMonitorService healthMonitor() {
        return Apis.get(HealthMonitorService.class);
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public LbPoolV2Service lbPool() {
        return Apis.get(LbPoolV2Service.class);
    }

    @Override
    public LbMemberV2Service lbMember() {
        return Apis.get(LbMemberV2Service.class);
    }

    @Override
    public LbLoadBalancerV2Service loadbalancer() {
        return Apis.get(LbLoadBalancerV2Service.class);
    }

    @Override
    public LbListenerV2Service listener() {
        return Apis.get(LbListenerV2Service.class);
    }


}
