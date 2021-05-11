package com.e2e;

import static org.springframework.boot.SpringApplication.run;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import io.sentry.Sentry;

@SpringBootApplication()
public class ApplicationConfiguration {

  public static void main(String[] args) {
    run(ApplicationConfiguration.class, args);
  }
  
Sentry.init(options -> {
  options.setDsn("https://bc9f31d799d8414995339da94b5dee0a@o302092.ingest.sentry.io/5760008");
});

  @Bean
  public static PropertySourcesPlaceholderConfigurer properties() {
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
    YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
    yaml.setResources(new ClassPathResource("application.yml"));
    propertySourcesPlaceholderConfigurer.setProperties(yaml.getObject());
    return propertySourcesPlaceholderConfigurer;
  }
}
