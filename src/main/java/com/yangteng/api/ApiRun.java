package com.yangteng.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yangteng.api.mapper")
public class ApiRun {

	public static void main(String[] args) {
		SpringApplication.run(ApiRun.class, args);
	}

}
