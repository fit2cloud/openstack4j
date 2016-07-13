package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbMemberV2Update;
import org.openstack4j.model.network.ext.builder.LbMemberV2UpdateBuilder;

/**
 * Created by zhangbohan on 16/2/18.
 */
@JsonRootName("member")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbMemberV2Update implements LbMemberV2Update {

    private static final long serialVersionUID = 1L;
    private Integer weight;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;


    public String toString() {
        return Objects.toStringHelper(this)
                .add("adminStateUp", adminStateUp)
                .add("weight", weight)
                .toString();
    }


    @Override
    public LbMemberV2UpdateBuilder toBuilder() {
        return new LbMemberV2ContreteUpdateBuilder(this);
    }

    @Override
    public Integer getWeight() {
        return weight;
    }

    @Override
    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    public static class LbMemberV2ContreteUpdateBuilder implements LbMemberV2UpdateBuilder {

        private NeutronLbMemberV2Update m;
        public LbMemberV2ContreteUpdateBuilder(){
            this(new NeutronLbMemberV2Update());
        }
        public LbMemberV2ContreteUpdateBuilder(NeutronLbMemberV2Update m){
            this.m = m;
        }
        @Override
        public LbMemberV2Update build() {

            return m;
        }

        @Override
        public LbMemberV2UpdateBuilder from(LbMemberV2Update in) {
            m = (NeutronLbMemberV2Update)in;
            return this;
        }


        @Override
        public LbMemberV2UpdateBuilder weight(Integer weight) {
            m.weight = weight;
            return this;
        }

        @Override
        public LbMemberV2UpdateBuilder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }
    }
    public static LbMemberV2UpdateBuilder builder(){
        return new LbMemberV2ContreteUpdateBuilder();
    }
}
