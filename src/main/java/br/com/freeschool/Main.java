package br.com.freeschool;

import java.io.InputStream;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.freeschool.utils.AppContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		new Timer().scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				requestForHerokuNoSleep();
			}
		}, 0,  29 * 60000);
		SpringApplication.run(AppContext.class, args);
	}

	public static void requestForHerokuNoSleep() {
		InputStream is;
		try {
			URL url = new URL("http://ezschool.herokuapp.com/api/public/user");
			is = url.openStream();
			is.close();
			System.out.println("Request for heroku...");
		} catch (Exception e) {
		}
	}
}
