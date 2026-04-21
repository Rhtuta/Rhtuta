package org.cfs.BootP01;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootP01Application implements CommandLineRunner {
	private Notification notification;

	public BootP01Application(Notification notification) {
		this.notification = notification;
	}

	public static void main(String[] args) {
		SpringApplication.run(BootP01Application.class, args);


	}

	@Override
	public void run(String... args) throws Exception {
		notification.notifyUser();
	}
}
