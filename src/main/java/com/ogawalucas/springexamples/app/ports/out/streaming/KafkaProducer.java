package com.ogawalucas.springexamples.app.ports.out.streaming;

import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.core.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {

    @Value(value = "${kafka.topics.any-topic}")
    private String anyTopic;

    @Qualifier("kafkaTemplate")
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final JsonUtils jsonUtils;

    public void sendToAnyTopic(AnyRequest request) {
        var payload = jsonUtils.toJson(request);

        log.info("Kafka Producer -> Sending for {} with {}", anyTopic, payload);

        kafkaTemplate.send(anyTopic, payload);
    }
}
