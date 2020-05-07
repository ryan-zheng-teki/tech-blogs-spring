package com.qiusuo.techblogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class TechBlogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechBlogsApplication.class, args);
		Path currentWorkingDir = Paths.get("").toAbsolutePath();
		System.out.println(currentWorkingDir.normalize().toString());
	}
}
