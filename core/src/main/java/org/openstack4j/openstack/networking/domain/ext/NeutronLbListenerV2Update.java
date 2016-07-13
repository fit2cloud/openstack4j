package org.openstack4j.openstack.networking.domain.ext;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.google.common.base.Objects;
import org.openstack4j.model.network.ext.LbListenerV2Update;
import org.openstack4j.model.network.ext.builder.LbListenerV2UpdateBuilder;

import java.util.List;

/**
 * Created by zhangbohan on 16/2/18.
 */
@JsonRootName("listener")
@JsonIgnoreProperties(ignoreUnknown = true)
public class NeutronLbListenerV2Update implements LbListenerV2Update {

    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    @JsonProperty("admin_state_up")
    private boolean adminStateUp;
    @JsonProperty("connection_limit")
    private Integer connectionLimit ;
    @JsonProperty("default_tls_container_ref")
    private String defaultTlsContainerRef;
    @JsonProperty("sni_container_refs")
    private List<String> sniContainerRefs;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Integer getConnectionLimit() {
        return connectionLimit;
    }

    @Override
    public boolean isAdminStateUp() {
        return adminStateUp;
    }

    @Override
    public String getDefaultTlsContainerRef() {
        return defaultTlsContainerRef;
    }

    @Override
    public List<String> getSniContainerRefs() {
        return sniContainerRefs;
    }

    @Override
    public LbListenerV2UpdateBuilder toBuilder() {
        return new LbListenerContreteV2UpdateBuilder(this);
    }
    @Override
    public String toString() {
        return Objects.toStringHelper(this).omitNullValues()
                .add("adminStateUp", adminStateUp)
                .add("description", description)
                .add("name", name)
                .add("connectionLimit", connectionLimit)
                .add("defaultTlsContainerRef", defaultTlsContainerRef)
                .add("sniContainerRefs", sniContainerRefs)
                .toString();
    }


    public static class LbListenerContreteV2UpdateBuilder implements LbListenerV2UpdateBuilder {

        private NeutronLbListenerV2Update m;
        public LbListenerContreteV2UpdateBuilder(){
            this(new NeutronLbListenerV2Update());
        }
        public LbListenerContreteV2UpdateBuilder(NeutronLbListenerV2Update m){
            this.m = m;
        }
        @Override
        public LbListenerV2Update build() {

            return m;
        }

        @Override
        public LbListenerV2UpdateBuilder from(LbListenerV2Update in) {
            m = (NeutronLbListenerV2Update)in;
            return this;
        }


        @Override
        public LbListenerV2UpdateBuilder name(String name) {
            m.name = name;
            return this;
        }

        @Override
        public LbListenerV2UpdateBuilder description(String description) {
            m.description = description;
            return this;
        }

        @Override
        public LbListenerV2UpdateBuilder adminStateUp(boolean adminStateUp) {
            m.adminStateUp = adminStateUp;
            return this;
        }

        @Override
        public LbListenerV2UpdateBuilder connectionLimit(Integer connectionLimit) {
            m.connectionLimit = connectionLimit;
            return this;
        }

        @Override
        public LbListenerV2UpdateBuilder defaultTlsContainerRef(String defaultTlsContainerRef) {
            m.defaultTlsContainerRef = defaultTlsContainerRef;
            return this;
        }

        @Override
        public LbListenerV2UpdateBuilder sniContainerRefs(List<String> sniContainerRefs) {
            m.sniContainerRefs = sniContainerRefs;
            return this;
        }
    }
    public static LbListenerV2UpdateBuilder builder(){
        return new LbListenerContreteV2UpdateBuilder();
    }
}
