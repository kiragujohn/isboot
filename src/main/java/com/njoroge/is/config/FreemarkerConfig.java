
package com.njoroge.is.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * @author John Njoroge
 * @date 16/05/2019
 */
@Configuration
public class FreemarkerConfig {

    @Bean
    public FreeMarkerConfigurationFactoryBean
            freeMarkerConfigurationFactoryBean() {

        FreeMarkerConfigurationFactoryBean freeMarkerConfigurationFactoryBean =
                new FreeMarkerConfigurationFactoryBean();

        freeMarkerConfigurationFactoryBean.setTemplateLoaderPaths(
                "classpath:com/njoroge/is/helper/email" );

        return freeMarkerConfigurationFactoryBean;
    }
}
