package com.cts.swapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApp implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext ctx) throws ServletException {
		
		AnnotationConfigWebApplicationContext webctx=new AnnotationConfigWebApplicationContext();
		webctx.register(SpringWebMvcConfig.class);
		webctx.setServletContext(ctx);
		
		ServletRegistration.Dynamic servlet=ctx.addServlet("dispatcher", new DispatcherServlet(webctx));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		
	}

	
	
}
