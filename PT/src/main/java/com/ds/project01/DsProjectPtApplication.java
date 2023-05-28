package com.ds.project01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class DsProjectPtApplication {

	public static void main(String[] args) {
		SpringApplication.run(DsProjectPtApplication.class, args);
	}

}
