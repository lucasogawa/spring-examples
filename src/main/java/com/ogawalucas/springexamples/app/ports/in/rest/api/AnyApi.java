package com.ogawalucas.springexamples.app.ports.in.rest.api;

import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.app.dto.AnyResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AnyApi {

    @PostMapping("publish")
    AnyResponse pubish(@RequestBody @Valid AnyRequest anyRequest);

    @GetMapping("log")
    void log();
}
