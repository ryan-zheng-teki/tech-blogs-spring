package com.qiusuo.techblogs;

import de.dentrassi.crypto.pem.PemKeyStoreProvider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.Security;

@SpringBootApplication
public class TechBlogsApplication {

	public static void main(String[] args) throws Exception {
		Security.addProvider(new PemKeyStoreProvider());
		SpringApplication.run(TechBlogsApplication.class, args);
	}
}
