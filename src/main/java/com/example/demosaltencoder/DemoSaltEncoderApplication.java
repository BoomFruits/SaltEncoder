package com.example.demosaltencoder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoSaltEncoderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSaltEncoderApplication.class, args);
//		byte[] hashedPassword = SecureUtils.encrypt("hello");
//		System.out.println(hashedPassword);
//		byte[] hashedPassword1 = SecureUtils.encrypt("hello");
//		System.out.println(hashedPassword1);
	}
}
