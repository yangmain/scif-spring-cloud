package com.greenever.archetype;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 服务启动类
 *
 * @author archetype-generator
 * @since 2020-03-23
 */
@SpringBootApplication(scanBasePackages = {"com.greenever.archetype"})
@MapperScan(value = {"com.greenever.archetype.mapper"})
@EnableDiscoveryClient
public class Bootstrap {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Bootstrap.class);
        springApplication.addListeners(new ApplicationPidFileWriter("pid"));
        springApplication.run(args);
    }

}
