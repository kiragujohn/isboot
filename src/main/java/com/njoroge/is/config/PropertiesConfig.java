
package com.njoroge.is.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * See http://www.baeldung.com/properties-with-spring
 *
 * See
 * https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-external-config.html
 *
 * Note we probably do not need this file as there is alredy an
 * application.properties
 *
 * To access a property from application.properties
 *
 * @Value("${name}") private String name;
 *
 * Note this config is for an additional property file called 43kare.properties
 *
 *
 * @author John Njoroge
 * @date 16/05/2019
 */

@Configuration
// @PropertySource( "classpath:trade43.properties" )
public class PropertiesConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer
            propertySourcesPlaceholderConfigurer() {

        return new PropertySourcesPlaceholderConfigurer();
    }
}
