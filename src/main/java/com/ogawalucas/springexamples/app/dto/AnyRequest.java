package com.ogawalucas.springexamples.app.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AnyRequest {

    private UUID id;

    private String anyField;
}