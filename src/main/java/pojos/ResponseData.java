package pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ResponseData {
    private Map<String, String> args;
    private Map<String, String> form;
    private Headers headers;
    private Map<String, String> json;
    private String url;
}
