package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbLoadBalancerV2;
import org.openstack4j.model.network.ext.builder.LbLoadBalancerV2Builder;
import org.openstack4j.openstack.common.IdResourceEntity;
import org.openstack4j.openstack.common.ListResult;

import java.util.List;

/**
 * Created by zhangbohan on 16/2/17.
 */
@JsonRootName("loadbalancer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbLoadBalancerV2 implements LbLoadBalancerV2 {

    private static final long serialVersionUID = 1L;


    @JsonProperty("health_monitors")
    private List<IdResourceEntity> healthMonitors;
    private String id;
    @JsonProperty("tenant_id")
    private String tenantId;
    @JsonProperty("vip_address")
    private String vipAddress ;
    @JsonProperty("vip_subnet_id")
    private String vipSubnetId;
    private String name;
    private String description;
    private String provider;

    private List<IdResourceEntity> members;
    private List<IdResourceEntity> listeners;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;
    @JsonProperty("operating_status")
    private String operatingStatus;
    @JsonProperty("provisioning_status")
    private String provisioningStatus;
    /**
     * {@inheritDoc}
     */
    @Override
    public LbLoadBalancerV2Builder toBuilder() {
        return new LbLoadBalancerContreteV2Builder(this);
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getTenantId() {
        return tenantId;
    }

    @Override
    public String getVipAddress() {
        return vipAddress;
    }

    @Override
    public String getVipSubnetId() {
        return vipSubnetId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public List<IdResourceEntity> getMembers() {
        return members;
    }

    @Override
    public List<IdResourceEntity> getHealthMonitors() {
        return healthMonitors;
    }

    @Override
    public List<IdResourceEntity> getListeners() {
        return listeners;
    }

    @Override
    public boolean isAdminStateUp() {
        return false;
    }

    @Override
    public String getProvisioningStatus() {
        return provisioningStatus;
    }

    @Override
    public String getOperatingStatus() {
        return operatingStatus;
    }

    @Override
    public String getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("adminStateUp", adminStateUp)
                .add("description", description)
                .add("healthMonitors", healthMonitors)
                .add("members", members)
                .add("name", name)
                .add("provider", provider)
                .add("listeners", listeners)
                .add("operatingStatus", operatingStatus)
                .add("provisioningStatus", provisioningStatus)
                .add("tenantId", tenantId)
                .add("vipAddress", vipAddress)
                .add("vipSubnetId", vipSubnetId)
                .toString();
    }

    public static class LbLoadBalancerContreteV2Builder implements LbLoadBalancerV2Builder {

        private NeutronLbLoadBalancerV2 m;
        @Override
        public LbLoadBalancerV2 build() {
            return m;
        }
        public LbLoadBalancerContreteV2Builder(){
            this(new NeutronLbLoadBalancerV2());
        }
        public LbLoadBalancerContreteV2Builder(NeutronLbLoadBalancerV2 m){
            this.m = m;
        }

        @Override
        public LbLoadBalancerV2Builder from(LbLoadBalancerV2 in) {
            m = (NeutronLbLoadBalancerV2) in;
            return this;
        }

        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2Builder tenantId(String tenantId) {
            m.tenantId = tenantId;
            return this;
        }

        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2Builder name(String name) {
            m.name = name;
            return this;
        }

        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2Builder description(String description) {
            m.description = description;
            return this;
        }

        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2Builder vipSubnetId(String subnentId){
            m.vipSubnetId = subnentId;
            return this;
        }
        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2Builder vipAddress(String address){
            m.vipAddress = address;
            return this;
        }

        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2Builder provider(String provider) {
            m.provider = provider;
            return this;
        }

        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2Builder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }


    }

    public static class LbLoadBalancerV2s extends ListResult<NeutronLbLoadBalancerV2> {

        private static final long serialVersionUID = 1L;
        @JsonProperty("loadbalancers")
        List<NeutronLbLoadBalancerV2> loadbalancers;
        /**
         * {@inheritDoc}
         */
        @Override
        public List<NeutronLbLoadBalancerV2> value() {
            return loadbalancers;
        }
        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("loadbalancers", loadbalancers)
                    .toString();
        }

    }


    public static LbLoadBalancerV2Builder builder(){
        return new LbLoadBalancerContreteV2Builder();
    }
}
