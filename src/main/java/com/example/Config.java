package com.example;

import io.smallrye.config.ConfigMapping;

@ConfigMapping(prefix = "twilio")
public interface Config {
    String accountSid();
    String authToken();
    String phoneNumber();
}
