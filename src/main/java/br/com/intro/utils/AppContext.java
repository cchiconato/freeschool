package br.com.intro.utils;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import br.com.intro.user.UserVerificationEmailSender;
import br.com.intro.user.UserVerificationEntity;

@Configuration
@EnableAutoConfiguration
@EnableCaching
@ComponentScan (basePackages = {"br.com.intro"})
public class AppContext {
  
  	@Bean(name = "userVerificationEntity")
	  public UserVerificationEntity getUserVerificationEntity() {
	  	  return new UserVerificationEntity();
	  }
  	
	@Bean(name = "userVerificationEmailSender")
	  public UserVerificationEmailSender getUserVerificationEmailSender() {
	  	  return new UserVerificationEmailSender();
	  }
  	
}
