package com.chemcool.school.lesson.configuration;

import com.chemcool.school.lesson.configuration.properties.KafkaProperties;
import com.chemcool.school.lesson.domain.fixedanswer.ChemFixedAnswerTaskEvent;
import com.chemcool.school.lesson.domain.matches.ChemMatchingTaskEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaChemMatchesConsumerConfiguration {
    private final KafkaProperties kafkaProperties;

    private final String TRUSTED_PACKAGES = "com.chemcool.school.lesson.domain.matches";


    public Map<String, Object> consumerConfig() {
        Map<String, Object> properties = new HashMap<>();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, this.kafkaProperties.getServer());
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaJsonDeserializer.class);
        properties.put(JsonDeserializer.TRUSTED_PACKAGES, TRUSTED_PACKAGES);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, this.kafkaProperties.getChemMatchesGroupId());
        return properties;
    }

    @Bean
    public KafkaListenerContainerFactory chemMatchesKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, ChemMatchingTaskEvent> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());

        return factory;
    }

    public ConsumerFactory<String, ChemMatchingTaskEvent> consumerFactory(){
        return new DefaultKafkaConsumerFactory<>(consumerConfig(), new StringDeserializer(),
                new KafkaJsonDeserializer<ChemMatchingTaskEvent>(ChemMatchingTaskEvent.class));
    }

}
