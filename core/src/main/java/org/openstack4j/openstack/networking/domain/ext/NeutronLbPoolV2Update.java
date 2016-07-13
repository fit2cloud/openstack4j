package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbPoolV2Update;
import org.openstack4j.model.network.ext.builder.LbPoolV2UpdateBuilder;

/**
 * Created by zhangbohan on 16/2/18.
 */
@JsonRootName("pool")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbPoolV2Update implements LbPoolV2Update {

    private static final long serialVersionUID = 1L;
    private String name;
    private String description;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;
    @JsonProperty("lb_algorithm")
    private String lbAlgorithm;
    @JsonProperty("session_persistence")
    private String sessionPersistence;


    public String toString() {
        return Objects.toStringHelper(this)
                .add("adminStateUp", adminStateUp)
                .add("description", description)
                .add("lbAlgorithm", lbAlgorithm)
                .add("sessionPersistence", sessionPersistence)
                .add("name", name)
                .toString();
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
    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    @Override
    public String getLbAlgorithm() {
        return lbAlgorithm;
    }

    @Override
    public String getSessionPersistence() {
        return sessionPersistence;
    }

    @Override
    public LbPoolV2UpdateBuilder toBuilder() {
        return new LbPoolContreteV2UpdateBuilder(this);
    }

    public static class LbPoolContreteV2UpdateBuilder implements LbPoolV2UpdateBuilder {

        private NeutronLbPoolV2Update m;
        public LbPoolContreteV2UpdateBuilder(){
            this(new NeutronLbPoolV2Update());
        }
        public LbPoolContreteV2UpdateBuilder(NeutronLbPoolV2Update m){
            this.m = m;
        }
        @Override
        public LbPoolV2Update build() {

            return m;
        }

        @Override
        public LbPoolV2UpdateBuilder from(LbPoolV2Update in) {
            m = (NeutronLbPoolV2Update)in;
            return this;
        }


        @Override
        public LbPoolV2UpdateBuilder name(String name) {
            m.name = name;
            return this;
        }

        @Override
        public LbPoolV2UpdateBuilder description(String description) {
            m.description = description;
            return this;
        }

        @Override
        public LbPoolV2UpdateBuilder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }

        @Override
        public LbPoolV2UpdateBuilder lbAlgorithm(String lbAlgorithm) {
            m.lbAlgorithm = lbAlgorithm;
            return this;
        }

        @Override
        public LbPoolV2UpdateBuilder sessionPersistence(String sessionPersistence) {
            m.sessionPersistence = sessionPersistence;
            return this;
        }
    }
    public static LbPoolV2UpdateBuilder builder(){
        return new LbPoolContreteV2UpdateBuilder();
    }
}
