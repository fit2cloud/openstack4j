package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbMemberV2;
import org.openstack4j.model.network.ext.LbPoolV2;
import org.openstack4j.model.network.ext.builder.LbMemberV2Builder;
import org.openstack4j.model.network.ext.builder.LbPoolV2Builder;
import org.openstack4j.openstack.common.ListResult;

import java.util.List;

/**
 * Created by zhangbohan on 16/2/17.
 */
@JsonRootName("member")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbMemberV2 implements LbMemberV2 {

    private static final long serialVersionUID = 1L;


    private String id;
    @JsonProperty("tenant_id")
    private String tenantId;
    @JsonProperty("pool_id")
    private String poolId;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;
    private String address ;
    private String status;
    @JsonProperty("protocol_port")
    private Integer protocolPort;
    private Integer weight;
    @JsonProperty("subnet_id")
    private String subnetId;
    @JsonProperty("floating_network_id")
    private String floatingNetworkId;
    @JsonProperty("port_id")
    private String portId;


    /**
     * {@inheritDoc}
     */
    @Override
    public LbMemberV2Builder toBuilder() {
        return new LbMemberV2ContreteBuilder(this);
    }



    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("id", id)
                .add("adminStateUp", adminStateUp)
                .add("poolId", poolId)
                .add("address", address)
                .add("tenantId", tenantId)
                .add("protocolPort", protocolPort)
                .add("status", status)
                .add("weight", weight)
                .add("subnetId", subnetId)
                .add("floatingNetworkId",floatingNetworkId)
                .add("portId",portId)
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
    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public String getPoolId() {
        return poolId;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public Integer getProtocolPort() {
        return protocolPort;
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public String getSubnetId() {
        return subnetId;
    }

    @Override
    public String getFloatingNetworkId() {
        return floatingNetworkId;
    }

    @Override
    public String getPortId() {
        return portId;
    }


    public static class LbMemberV2ContreteBuilder implements LbMemberV2Builder {

        private NeutronLbMemberV2 m;
        @Override
        public LbMemberV2 build() {
            return m;
        }

        @Override
        public LbMemberV2Builder from(LbMemberV2 in) {
            return this;
        }

        public LbMemberV2ContreteBuilder(){
            this(new NeutronLbMemberV2());
        }
        public LbMemberV2ContreteBuilder(NeutronLbMemberV2 m){
            this.m = m;
        }


        @Override
        public LbMemberV2Builder tenantId(String tenantId) {
            m.tenantId = tenantId;
            return this;
        }

        @Override
        public LbMemberV2Builder poolId(String poolId) {
            m.poolId = poolId;
            return this;
        }

        @Override
        public LbMemberV2Builder address(String address) {
            m.address = address;
            return this;
        }

        @Override
        public LbMemberV2Builder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }

        @Override
        public LbMemberV2Builder protocolPort(Integer protocolPort) {
            m.protocolPort = protocolPort;
            return this;
        }

        @Override
        public LbMemberV2Builder weight(Integer weight) {
            m.protocolPort = weight;
            return this;
        }

        @Override
        public LbMemberV2Builder subnetId(String subnetId) {
            m.subnetId = subnetId;
            return this;
        }

        @Override
        public LbMemberV2Builder floatingNetworkId(String floatingNetworkId) {
            m.floatingNetworkId = floatingNetworkId;
            return this;
        }

        @Override
        public LbMemberV2Builder portId(String portId) {
            m.portId = portId;
            return this;
        }
    }

    public static class LbMemberV2s extends ListResult<NeutronLbMemberV2> {

        private static final long serialVersionUID = 1L;
        @JsonProperty("members")
        List<NeutronLbMemberV2> members;
        /**
         * {@inheritDoc}
         */
        @Override
        public List<NeutronLbMemberV2> value() {
            return members;
        }
        @Override
        public String toString() {
            return Objects.toStringHelper(this)
                    .add("members", members)
                    .toString();
        }

    }


    public static LbMemberV2Builder builder(){
        return new LbMemberV2ContreteBuilder();
    }
}
