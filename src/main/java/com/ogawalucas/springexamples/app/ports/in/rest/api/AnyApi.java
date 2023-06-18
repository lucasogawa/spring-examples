package com.ogawalucas.springexamples.app.ports.in.rest.api;

import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.app.dto.AnyResponse;
import org.springframework.web.bind.annotation.GetMapping;

public interface AnyApi {

    @GetMapping("publish")
    AnyResponse pubish(AnyRequest anyRequest);
}
