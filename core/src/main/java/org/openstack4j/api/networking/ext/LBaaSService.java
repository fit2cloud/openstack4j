package org.openstack4j.api.networking.ext;

/**
 * Created by zhangbohan on 16/2/17.
 */
public interface LBaaSService {
    /**
     *
     * @return the Lbaas member Service API
     */
    MemberService member();

    /**
     * @return the Lbaas vip Service API
     */
    VipService vip();

    /**
     * @return the Lbaas healthmonitor Service API
     */
    HealthMonitorService healthMonitor();


    /**
     * @return the lbaas loadbalancer v2  Service API
     */
    LbLoadBalancerV2Service loadbalancer();

    /**
     * @return the lbaas listener v2 Service API
     */
    LbListenerV2Service listener();

    /**
     * @return the lbaas pool v2 Service API
     */
    LbPoolV2Service lbPool();

    /**
     * @return the lbaas member v2 Service API
     */
    LbMemberV2Service lbMember();
}
