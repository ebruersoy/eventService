package com.myway.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Ebru Göksal
 */
@Component
@ConfigurationProperties(prefix = "tpd")
public class ApplicationConfiguration {
    private String topicName;

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }
}
