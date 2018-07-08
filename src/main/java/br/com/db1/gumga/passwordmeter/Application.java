package br.com.db1.gumga.passwordmeter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.db1.gumga.passwordmeter")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
