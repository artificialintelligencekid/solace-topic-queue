package com.aikid.solace.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "queues")
@ToString
@Configuration
public class QueueConfig {

    private String name;
    private List<String> topics;
}
