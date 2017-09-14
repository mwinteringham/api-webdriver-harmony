package http.payloads;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BugPayload {

    @JsonProperty
    private String product;
    @JsonProperty
    private String description;
    @JsonProperty
    private String component;
    @JsonProperty
    private String summary;
    @JsonProperty
    private String version;
    @JsonProperty
    private String op_sys;
    @JsonProperty
    private String rep_platform;

    public BugPayload(String product, String component, String summary, String version, String op_sys, String rep_platform, String description) {
        this.product = product;
        this.description = description;
        this.component = component;
        this.summary = summary;
        this.version = version;
        this.op_sys = op_sys;
        this.rep_platform = rep_platform;
    }

    public String getProduct() {
        return product;
    }

    public String getDescription() {
        return description;
    }

    public String getComponent() {
        return component;
    }

    public String getSummary() {
        return summary;
    }

    public String getVersion() {
        return version;
    }

    public String getOp_sys() {
        return op_sys;
    }

    public String getRep_platform() {
        return rep_platform;
    }
}
