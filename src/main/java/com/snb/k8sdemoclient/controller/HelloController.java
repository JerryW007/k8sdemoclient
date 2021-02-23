package com.snb.k8sdemoclient.controller;

import com.snb.k8sdemoclient.config.K8sConfigMap;
import com.snb.k8sdemoclient.service.HelloService;
import com.snb.k8sdemoclient.service.feign.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chao.wang
 * @Email chao.wang@snowballtech.com
 * @Date Created on 2021-02-18 上午11:35
 * @Modified By
 * @Description
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private FeignService feignService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private K8sConfigMap k8sConfigMap;

    @Autowired
    private Environment env;
    @GetMapping("/instance")
    public List<ServiceInstance> getInstance(String serviceId) {
        return discoveryClient.getInstances(serviceId);
    }

    @GetMapping("/service")
    public Object getClient() {
        return discoveryClient.getServices();
    }
    @RequestMapping("/hello")
    public String hello(){
        return "I'm the k8s client ";
    }

    @RequestMapping("/demoHello")
    public String demoHello(){
        return helloService.getDataFromSpringCloudK8SProvider();
    }

    @RequestMapping("/feignHello")
    public String feignHello(){
        return feignService.hello();
    }

    @GetMapping("/getConfigMap")
    public String getConfigMap(String key) {
        return "test: " + env.getProperty(key) + " " + k8sConfigMap.getShowData();

    }
}
