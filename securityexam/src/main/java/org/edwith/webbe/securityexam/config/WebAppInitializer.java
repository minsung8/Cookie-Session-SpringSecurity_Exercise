package org.edwith.webbe.securityexam.config;

import javax.servlet.*;
import org.springframework.web.filter.CharacterEncodingFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer  {

	@Override
	protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfig.class, SecurityConfig.class};		// spring config파일 설정
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {		// spring web config 파일을 설정 => webconfig는 bean을 RootConfig에서 설정한 곳부터 찾는다
        return new Class<?>[]{MvcConfig.class};
	}

	
	/*
	 getServletMapping()은 DispatcherServlet이 매핑되기 위한 하나 혹은 여러 개의 패스를 지정한다
	 위의 코드에서는 애플리케이션 기본 서블릿인 /에만 매핑 => 모든 요청 처리
	 원래 서블릿에는 /을 처리하는 DefaultServlet이 설정되어 있음
	 */
	
	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	protected Filter[] getServletFilters() {		// 필터 설정
		
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[]{encodingFilter};
	}

}
