package com.dev;

import com.dev.Enums.ConfigEnum;
import com.dev.Utils.ConfigUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Dev2019 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Dev2019.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Dev2019.class, args);
        if (ConfigUtils.getConfig(ConfigEnum.log_beans_names, false)) {
            LOGGER.info("Loaded beans:");
            for(String beanName : context.getBeanDefinitionNames()) {
                LOGGER.info(beanName);
            }
        }
        LOGGER.info("Application started.");
    }
}
