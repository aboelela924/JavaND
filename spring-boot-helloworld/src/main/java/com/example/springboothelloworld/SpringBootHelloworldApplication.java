package com.example.springboothelloworld;

import com.example.springboothelloworld.servlet.HelloFilter;
import com.example.springboothelloworld.servlet.HelloListener;
import com.example.springboothelloworld.servlet.HelloServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootHelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloworldApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean(){
		FilterRegistrationBean filter = new FilterRegistrationBean(new HelloFilter());
		filter.addUrlPatterns("/helloServlet");
		return filter;
	}

	@Bean
	public ServletRegistrationBean getServletRegistrationBean(){
		ServletRegistrationBean servlet = new ServletRegistrationBean(new HelloServlet());
		servlet.addUrlMappings("/helloServlet");
		return servlet;
	}

	@Bean
	public ServletListenerRegistrationBean<HelloListener> getServletRegistrationListener(){
		ServletListenerRegistrationBean listener =
				new ServletListenerRegistrationBean(new HelloListener());
		return listener;
	}

}
