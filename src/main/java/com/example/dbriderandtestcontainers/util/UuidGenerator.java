package com.example.dbriderandtestcontainers.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidGenerator {

    public UUID generateUuid() {
        return UUID.randomUUID();
    }
}
