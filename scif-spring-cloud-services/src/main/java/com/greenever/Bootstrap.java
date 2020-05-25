package com.greenever;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

/**
 * 账户服务, 程序入口
 *
 * @author archetype-generator
 * @since 2020-03-23
 */
@SpringBootApplication(scanBasePackages = {"com.greenever"})
public class Bootstrap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Bootstrap.class);
        springApplication.addListeners(new ApplicationPidFileWriter("pid"));
        springApplication.run(args);
    }

}
