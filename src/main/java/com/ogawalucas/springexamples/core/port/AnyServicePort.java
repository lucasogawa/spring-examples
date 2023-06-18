package com.ogawalucas.springexamples.core.port;

import com.ogawalucas.springexamples.core.entity.AnyEntity;

public interface AnyServicePort {

    AnyEntity publish(AnyEntity anyEntity);

    void log();
}
