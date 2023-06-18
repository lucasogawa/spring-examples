package com.ogawalucas.springexamples.core.service;

import com.ogawalucas.springexamples.app.mapper.AnyMapper;
import com.ogawalucas.springexamples.app.ports.out.streaming.KafkaProducer;
import com.ogawalucas.springexamples.core.entity.AnyEntity;
import com.ogawalucas.springexamples.core.port.AnyServicePort;
import com.ogawalucas.springexamples.core.repository.AnyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AnyService implements AnyServicePort {

    private final AnyRepository repository;

    private final KafkaProducer kafkaProducer;

    @Override
    public AnyEntity publish(AnyEntity anyEntity) {
        anyEntity = repository.save(anyEntity);

        kafkaProducer.sendToAnyTopic(AnyMapper.toRequest(anyEntity));

        return anyEntity;
    }
}
