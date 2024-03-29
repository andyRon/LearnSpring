package com.andyron.andyronspringbootstarterautoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author andyron
 **/
@ConfigurationProperties(prefix = "andyron.hello")
public class HelloProperties {
    private String prefix;
    private String suffix;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
