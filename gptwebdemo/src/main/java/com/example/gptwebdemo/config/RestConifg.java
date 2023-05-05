package com.example.gptwebdemo.config;

import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Objects;

/**
 * @program: gptwebdemo
 * @description:
 * @author: wjl
 * @create: 2023-05-03 23:12
 **/
@Configuration
public class RestConifg {

    //获取代理ip和端口
    @Value("${http.proxy.ip}")
    private String  ip;
    @Value("${http.proxy.port}")
    private Integer  port;

    @Bean
    public RestTemplate restTemplate(){
        // 这里添加代理 如果  需要访问外网 则需要添加 代理类
        // 关于代理的使用方式 见本人的csdn
        if(StringUtils.isNullOrEmpty(ip)|| Objects.isNull(port)){
            //没有代理时
            return new RestTemplate();
        }
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setProxy(proxy);
        return new RestTemplate(requestFactory);
    }

}
