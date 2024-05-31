package com.seleniumexpress.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRegistration;

public class LoveAppConfiguration implements WebApplicationInitializer 
	{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		XmlWebApplicationContext webApplicationContext = new XmlWebApplicationContext();
		webApplicationContext.setConfigLocations("classpath:application-configuration.xml");
		
		// creating dispatcher servlet object
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplicationContext);
		
		// Register the dispatcher servlet to servlet context object
		ServletRegistration.Dynamic myCustomServlet =  servletContext.addServlet("myDispatcherServlet", dispatcherServlet);
		
		myCustomServlet.setLoadOnStartup(1);
		myCustomServlet.addMapping("/love.com/*");
		
		webApplicationContext.close();
	}

}
