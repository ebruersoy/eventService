package com.myway.configuration;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ebru Göksal
 */
@Configuration
public class KafkaTopicConfig {
    private EmployeeEventConfiguration configuration;
    private ApplicationConfiguration applicationConfiguration;

    public KafkaTopicConfig(EmployeeEventConfiguration configuration, ApplicationConfiguration applicationConfiguration) {
        this.configuration = configuration;
        this.applicationConfiguration = applicationConfiguration;
    }

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, configuration.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic(applicationConfiguration.getTopicName(), 1, (short) 1);
    }
}
