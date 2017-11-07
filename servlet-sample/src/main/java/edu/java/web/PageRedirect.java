package edu.java.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/redirect", name = "redirect-servlet")
public class PageRedirect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		String site = new String("http://www.vnexpress.net");
		resp.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);;
		resp.setHeader("Location", site);
	}
	
}
