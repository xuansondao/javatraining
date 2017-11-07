package edu.java.web.client;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns="/html")
public class GzipFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("\n Destroy filter! \n");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
//		PrintWriter writer = response.getWriter();
//		writer.println("=============\nFilter intercepted\n==============");
//		writer.flush();
//		
//		chain.doFilter(request, response);
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		
		String encoding = httpServletRequest.getHeader("Accept-Encoding");
		if(encoding != null && encoding.indexOf("gzip") > -1) {
			httpServletResponse.addHeader("Content-Encoding", "gzip");
			GZipServletResponseWrapper gzipResponse = new GZipServletResponseWrapper(httpServletResponse);
			chain.doFilter(request, gzipResponse);
			gzipResponse.close();
		}else {
			chain.doFilter(request, response);
		}
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("\nDestroy Filter!\n");
	}
	
}
