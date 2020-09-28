package org.edwith.webbe.securityexam.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.edwith.webbe.securityexam.controller"})
public class MvcConfig implements WebMvcConfigurer{
	
	
	// default servlet 핸들러 설정
	// 원래 서블릿은 모든 요청을 처리하는  default servlet을 제공 => spring에서 설정한 path는 스프링이 처리하고,
	// 나머지 경로에 대한 처리는 default servlet가 처리
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	// spring MVC에서 jsp view가 위치하는 경로 설정
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view", ".jsp");
	}
	
	// /로 요청이 들어오면 /main 으로 redirect
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "/main");
	}
	
	// /resources에 있는 경로들을 /resources/**로 접근하게 함
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}
	