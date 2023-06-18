package com.ogawalucas.springexamples.app.ports.in.streaming;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
@ConditionalOnProperty(name = "kafka.enabled", havingValue = "true")
public class KafkaConsumer {

    @Value(value = "${kafka.topics.any-topic}")
    private String anyTopic;

    @KafkaListener(
        topics = "${kafka.topics.any-topic}",
        groupId = "${kafka.consumer.group-id}",
        containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    public void consumeAnyTopic(String payload) {
        log.info("Kafka Consumer -> Receiving from {} with {}", anyTopic, payload);
    }
}
