package com.ourowproject.owproject;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;

import java.io.PrintStream;
import java.util.Arrays;

@SpringBootApplication
@EnableCaching
public class OwprojectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(OwprojectApplication.class, args);

		SpringApplication app = new SpringApplication(OwprojectApplication.class);
		app.setBanner((environment, sourceClass, out) -> out.print(" _____  _    _  ______             _              ______          _           _   \n" +
                "|  _  || |  | | | ___ \\           (_)             | ___ \\        (_)         | |  \n" +
                "| | | || |  | | | |_/ /_ _ ___ ___ _  ___  _ __   | |_/ / __ ___  _  ___  ___| |_ \n" +
                "| | | || |/\\| | |  __/ _` / __/ __| |/ _ \\| '_ \\  |  __/ '__/ _ \\| |/ _ \\/ __| __|\n" +
                "\\ \\_/ /\\  /\\  / | | | (_| \\__ \\__ \\ | (_) | | | | | |  | | | (_) | |  __/ (__| |_ \n" +
                " \\___/  \\/  \\/  \\_|  \\__,_|___/___/_|\\___/|_| |_| \\_|  |_|  \\___/| |\\___|\\___|\\__|\n" +
                "                                                                _/ |              \n" +
                "                                                               |__/               "));
		app.run(args);
	}
}
