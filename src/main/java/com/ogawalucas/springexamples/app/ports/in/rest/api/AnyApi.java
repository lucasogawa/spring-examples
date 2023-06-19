package com.ogawalucas.springexamples.app.ports.in.rest.api;

import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.app.dto.AnyResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public interface AnyApi {

    @PostMapping("publish")
    AnyResponse pubish(AnyRequest anyRequest);

    @GetMapping("log")
    void log();
}
