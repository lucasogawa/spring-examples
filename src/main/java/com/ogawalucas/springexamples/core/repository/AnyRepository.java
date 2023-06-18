package com.ogawalucas.springexamples.core.repository;

import com.ogawalucas.springexamples.core.entity.AnyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnyRepository extends JpaRepository<AnyEntity, UUID> {
}
