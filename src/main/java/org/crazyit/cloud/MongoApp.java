package org.crazyit.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class MongoApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(MongoApp.class).run(args);
	}

}
