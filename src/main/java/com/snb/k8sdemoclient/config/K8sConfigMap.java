package com.snb.k8sdemoclient.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author chao.wang
 * @Email chao.wang@snowballtech.com
 * @Date Created on 2021-02-22 下午11:44
 * @Modified By
 * @Description
 */

@Configuration(proxyBeanMethods=false)
@ConfigurationProperties(prefix = "test")
public class K8sConfigMap {

    private String showData = "this is a default message!";

    public String getShowData() {
        return showData;
    }

    public void setShowData(String showData) {
        this.showData = showData;
    }
}
