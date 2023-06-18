package com.ogawalucas.springexamples.app.ports.in.rest.controller;

import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.app.dto.AnyResponse;
import com.ogawalucas.springexamples.app.mapper.AnyMapper;
import com.ogawalucas.springexamples.app.ports.in.rest.api.AnyApi;
import com.ogawalucas.springexamples.core.port.AnyServicePort;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/any")
public class AnyController implements AnyApi {

    private final AnyServicePort service;

    @Override
    public AnyResponse pubish(AnyRequest anyRequest) {
        return AnyMapper.toResponse(service.publish(AnyMapper.toEntity(anyRequest)));
    }
}
