package com.sharism.user_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.sharism.user_server.mapper")//将项目中对应的mapper类的路径加进来就可以了
public class UserServerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UserServerApplication.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);

	}

}
/*
public class UserServerApplication  {

	public static void main(String[] args) {
		SpringApplication.run(UserServerApplication.class, args);
	}
}

*/
