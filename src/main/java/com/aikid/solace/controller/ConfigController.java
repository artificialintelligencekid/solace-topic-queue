package com.aikid.solace.controller;

import com.aikid.solace.config.SolaceConfigProperties;
import com.aikid.solace.config.QueueConfig;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@Getter
@Setter
@RequiredArgsConstructor
@RequestMapping("/config")
public class ConfigController {

    private final SolaceConfigProperties solaceConfigProperties;


    @GetMapping("/queues")
    public List<QueueConfig> getQueues() {
        SolaceConfigProperties solaceProperties = new SolaceConfigProperties();
        solaceProperties.setHost("defaultHost");
        solaceProperties.setUsername("defaultUsername");
        solaceProperties.setPassword("defaultPassword");
        solaceProperties.setVpnName("defaultVpn");
        return Optional.ofNullable(solaceConfigProperties)
                .map(SolaceConfigProperties::getQueues)
                .orElse(Collections.singletonList(new QueueConfig()));


    }
}
