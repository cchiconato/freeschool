package br.com.intro;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.intro.utils.AppContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		new Timer().scheduleAtFixedRate(new TimerTask(){
		    @Override
		    public void run(){
		       System.out.println("A Kiss every 5 seconds");
		    }
		},0,25000);
		SpringApplication.run(AppContext.class, args);
	}

}
