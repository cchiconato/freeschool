package br.com.intro.utils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@EnableCaching
@ComponentScan (basePackages = {"br.com.intro"})
public class AppContext {
  
  	@Bean(name = "userVerificationEntity")
	  public UserVerificationEntity getUserVerificationEntity() {
	  	  return new UserVerificationEntity();
	  }
}
