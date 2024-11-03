package dev.danwys.kafka_example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    public NewTopic funds() {
        return TopicBuilder.name("funds").build();
    }
}
