package com.chemcool.school.lesson.tasks.chemsingleselect.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("kafka")
public class KafkaProperties {
    private String server;
    private String groupId;
}
