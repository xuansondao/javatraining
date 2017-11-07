package edu.java.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


public class SimpleServletListener implements ServletContextListener {
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("\n\nServletContextListener destroyed\n\n");
	}
	
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		System.out.println("\n\nServletContextListener started");
	}
}


