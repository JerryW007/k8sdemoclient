package com.snb.k8sdemoclient;

import com.snb.k8sdemoclient.config.K8sConfigMap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
@EnableConfigurationProperties(K8sConfigMap.class)
public class K8sdemoclientApplication {
    public static void main(String[] args) {
        SpringApplication.run(K8sdemoclientApplication.class, args);
    }
}
