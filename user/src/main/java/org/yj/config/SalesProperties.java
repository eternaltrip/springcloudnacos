package org.yj.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sales")
public class SalesProperties {
    private boolean enable;
    private  String desc;
}
