package br.com.intro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.intro.utils.AppContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(AppContext.class, args);
	}

}
