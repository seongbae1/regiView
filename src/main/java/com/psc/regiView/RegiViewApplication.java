package com.psc.regiView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.psc.regiView.constants.Constant;

@SpringBootApplication
public class RegiViewApplication implements ApplicationRunner {

	@Autowired
	private Constant constant;
	
	public static void main(String[] args) {
		SpringApplication.run(RegiViewApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(constant.ip);
		System.out.println(constant.port);
	}

}
