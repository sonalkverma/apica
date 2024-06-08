package com.apica.kafka.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSourceConfiguration {

	@Value("${spring.datasource.url}")
	String url;
	
	@Value("${spring.datasource.username}")
	String userName;
	
	@Value("${spring.datasource.password}")
	String password;
	
	@Bean
	DSLContext dslContext() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return DSL.using(conn, SQLDialect.MYSQL);
	}
}
