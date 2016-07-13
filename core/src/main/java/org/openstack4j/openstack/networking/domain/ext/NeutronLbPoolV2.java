package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbListenerV2;
import org.openstack4j.model.network.ext.LbLoadBalancerV2;
import org.openstack4j.model.network.ext.LbPoolV2;
import org.openstack4j.model.network.ext.builder.LbListenerV2Builder;
import org.openstack4j.model.network.ext.builder.LbPoolV2Builder;
import org.openstack4j.openstack.common.IdResourceEntity;
import org.openstack4j.openstack.common.ListResult;

import java.util.List;

/**
 * Created by zhangbohan on 16/2/17.
 */
@JsonRootName("pool")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbPoolV2 implements LbPoolV2 {

    private static final long serialVersionUID = 1L;


    private String id;
    @JsonProperty("tenant_id")
    private String tenantId;
    private String name;
    private String description;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;
    private String protocol ;
    private String status;
    private List<IdResourceEntity> members;
    private List<IdResourceEntity> listeners;
    @JsonProperty("lb_algorithm")
    private String lbAlgorithm;
    @JsonProperty("session_persistence")
    private String sessionPersistence;
    @JsonProperty("health_monitors")
    private List<IdResourceEntity> healthMonitors;
    @JsonProperty("healthmonitor_id")
    private String healthmonitorId;
    @JsonProperty("subnet_id")
    private String subnetId;
    @JsonProperty("vip_id")
    private String vipId;
    @JsonProperty("health_monitors_status")
    private String healthMonitorsStatus;
    @JsonProperty("listener_id")
    private String listenerId;

    /**
     * {@inheritDoc}
     */
    @Override
    public LbPoolV2Builder toBuilder() {
        return new LbPoolContreteV2Builder(this);
    }



    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("adminStateUp", adminStateUp)
                .add("description", description)
                .add("name", name)
                .add("tenantId", tenantId)
                .add("protocol", protocol)
                .add("status", status)
                .add("members", members)
                .add("listeners", listeners)
                .add("lbAlgorithm", lbAlgorithm)
                .add("sessionPersistence", sessionPersistence)
                .add("healthMonitors", healthMonitors)
                .add("healthmonitorId", healthmonitorId)
                .add("subnetId", subnetId)
                .add("vipId", vipId)
                .add("healthMonitorsStatus", healthMonitorsStatus)
                .add("listenerId",listenerId)
                .toString();
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
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public List<IdResourceEntity> getMembers() {
        return members;
    }

    @Override
    public String getListenerId() {
        return listenerId;
    }

    @Override
    public List<IdResourceEntity> getListeners() {
        return listeners;
    }

    @Override
    public String getLbAlgorithm() {
        return lbAlgorithm;
    }

    @Override
    public String getHealthmonitorId() {
        return healthmonitorId;
    }

    @Override
    public List<IdResourceEntity> getHealthMonitors() {
        return healthMonitors;
    }

    @Override
    public String getSessionPersistence() {
        return sessionPersistence;
    }

    @Override
    public String getSubnetId() {
        return subnetId;
    }

    @Override
    public String getVipId() {
        return vipId;
    }

    @Override
    public String getHealthMonitorsStatus() {
        return healthMonitorsStatus;
    }

    public static class LbPoolContreteV2Builder implements LbPoolV2Builder {

        private NeutronLbPoolV2 m;
        @Override
        public LbPoolV2 build() {
            return m;
        }
        public LbPoolContreteV2Builder(){
            this(new NeutronLbPoolV2());
        }
        public LbPoolContreteV2Builder(NeutronLbPoolV2 m){
            this.m = m;
        }

        @Override
        public LbPoolV2Builder from(LbPoolV2 in) {
            m = (NeutronLbPoolV2) in;
            return this;
        }


        @Override
        public LbPoolV2Builder tenantId(String tenantId) {
            m.tenantId = tenantId;
            return this;
        }

        @Override
        public LbPoolV2Builder name(String name) {
            m.name = name;
            return this;
        }

        @Override
        public LbPoolV2Builder description(String description) {
            m.description = description;
            return this;
        }

        @Override
        public LbPoolV2Builder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }

        @Override
        public LbPoolV2Builder protocol(String protocol) {
            m.protocol = protocol;
            return this;
        }

        @Override
        public LbPoolV2Builder lbAlgorithm(String lbAlgorithm) {
            m.lbAlgorithm = lbAlgorithm;
            return this;
        }

        @Override
        public LbPoolV2Builder listenerId(String listenerId) {
            m.listenerId = listenerId;
            return this;
        }

        @Override
        public LbPoolV2Builder sessionPersistence(String sessionPersistence) {
            m.sessionPersistence = sessionPersistence;
            return this;
        }

        @Override
        public LbPoolV2Builder subnetId(String subnetId) {
            m.subnetId = subnetId;
            return this;
        }
    }

    public static class LbPoolV2s extends ListResult<NeutronLbPoolV2> {

        private static final long serialVersionUID = 1L;
        @JsonProperty("pools")
        List<NeutronLbPoolV2> pools;
        /**
         * {@inheritDoc}
         */
        @Override
        public List<NeutronLbPoolV2> value() {
            return pools;
        }
        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("pools", pools)
                    .toString();
        }

    }


    public static LbPoolV2Builder builder(){
        return new LbPoolContreteV2Builder();
    }
}
