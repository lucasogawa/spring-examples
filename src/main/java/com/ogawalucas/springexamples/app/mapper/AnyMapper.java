package com.ogawalucas.springexamples.app.mapper;

import com.ogawalucas.springexamples.app.dto.AnyRequest;
import com.ogawalucas.springexamples.app.dto.AnyResponse;
import com.ogawalucas.springexamples.core.entity.AnyEntity;
import org.springframework.beans.BeanUtils;

public class AnyMapper {

    public static AnyRequest toRequest(AnyEntity anyEntity) {
        var anyRequest = new AnyRequest();

        BeanUtils.copyProperties(anyEntity, anyRequest);

        return anyRequest;
    }

    public static AnyEntity toEntity(AnyRequest anyRequest) {
        var anyEntity = new AnyEntity();

        BeanUtils.copyProperties(anyRequest, anyEntity);

        return anyEntity;
    }

    public static AnyResponse toResponse(AnyEntity anyEntity) {
        var anyResponse = new AnyResponse();

        BeanUtils.copyProperties(anyEntity, anyResponse);

        return anyResponse;
    }
}
