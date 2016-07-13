package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbLoadBalancerV2Update;
import org.openstack4j.model.network.ext.builder.LbLoadBalancerV2UpdateBuilder;

/**
 * Created by zhangbohan on 16/2/18.
 */
@JsonRootName("loadbalancer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbLoadBalancerV2Update implements LbLoadBalancerV2Update {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    @Override
    public LbLoadBalancerV2UpdateBuilder toBuilder() {
        return null;
    }
    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("adminStateUp", adminStateUp)
                .add("description", description)
                .add("name", name)
                .toString();
    }
    public static class LbLoadBalancerContreteV2UpdateBuilder implements LbLoadBalancerV2UpdateBuilder {

        private NeutronLbLoadBalancerV2Update m;
        public LbLoadBalancerContreteV2UpdateBuilder(){
            this(new NeutronLbLoadBalancerV2Update());
        }
        public LbLoadBalancerContreteV2UpdateBuilder(NeutronLbLoadBalancerV2Update m){
            this.m = m;
        }
        @Override
        public LbLoadBalancerV2Update build() {

            return m;
        }

        @Override
        public LbLoadBalancerV2UpdateBuilder from(LbLoadBalancerV2Update in) {
            m = (NeutronLbLoadBalancerV2Update)in;
            return this;
        }


        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2UpdateBuilder name(String name) {
            m.name = name;
            return this;
        }
        /**
         *
         * {@inheritDoc}
         */
        @Override
        public LbLoadBalancerV2UpdateBuilder description(String description) {
            m.description = description;
            return this;
        }
        @Override
        public LbLoadBalancerV2UpdateBuilder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }
    }
    public static LbLoadBalancerV2UpdateBuilder builder(){
        return new LbLoadBalancerContreteV2UpdateBuilder();
    }
}
