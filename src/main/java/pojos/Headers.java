package pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class Headers{
    @JsonProperty("x-forwarded-proto")
    private String xForwardedProto;
    @JsonProperty("x-forwarded-port")
    private String xForwardedPort;
    private String host;
    @JsonProperty("x-amzn-trace-id")
    private String xAmznTraceId;
    @JsonProperty("content-length")
    private Integer contentLength;
    private String accept;
    @JsonProperty("content-type")
    private String contentType;
    @JsonProperty("user-agent")
    private String userAgent;
    @JsonProperty("accept-encoding")
    private String acceptEncoding;

}
