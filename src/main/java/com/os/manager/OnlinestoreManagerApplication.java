
package com.os.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@ SpringBootApplication
@ MapperScan ("com.os.manager.dao")
public class OnlinestoreManagerApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(OnlinestoreManagerApplication.class, args);
	}
}
