package com.ogawalucas.springexamples.infra.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerConfig {

    @GetMapping
    public String redirect() {
        return "redirect:swagger-ui.html";
    }
}
