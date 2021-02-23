package com.snb.k8sdemoclient.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author chao.wang
 * @Email chao.wang@snowballtech.com
 * @Date Created on 2021-02-19 下午4:00
 * @Modified By
 * @Description
 */
@FeignClient(name = "mp-k8sdemo-group-svc",fallback = FeignService.FeignSeverFallback.class)
public interface FeignService {

    @GetMapping("hello")
    String hello();

    @Component
    class FeignSeverFallback implements FeignService {

        @Override
        public String hello() {
            return "hello Error";
        }
    }
}
