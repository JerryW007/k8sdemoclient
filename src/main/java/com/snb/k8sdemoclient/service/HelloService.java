package com.snb.k8sdemoclient.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chao.wang
 * @Email chao.wang@snowballtech.com
 * @Date Created on 2021-02-18 上午11:38
 * @Modified By
 * @Description
 */
@Service
public class HelloService {

//    @Autowired
//    private RestTemplate restTemplate;

    public String getDataFromSpringCloudK8SProvider(){
        return "http:///k8s-demo/hello";
    }

    /**
     * 熔断时调用的方法
     * @return
     */
    private String getFallbackName() {
        return "Fallback"
                + ", "
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }
}
