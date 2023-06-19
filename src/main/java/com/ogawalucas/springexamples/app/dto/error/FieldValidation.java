package com.ogawalucas.springexamples.app.dto.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FieldValidation {

    private String field;

    private String error;
}
