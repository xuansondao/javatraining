package edu.java.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/synch", asyncSupported = true)
public class AsynchServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		final AsyncContext ctx = req.startAsync();
//		ctx.setTimeout(60*1000);
//		ctx.start(new Runnable() {
//			
//			public void run() {
//				// TODO Auto-generated method stub
//				try {
//					Thread.sleep(3*1000);
//					PrintWriter writer = ctx.getResponse().getWriter();
//					URL obj = new URL("https://www.google.com.vn");
//					HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//					BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
//					String line = null;
//					while((line = reader.readLine()) != null) {
//						writer.write(line);
//					}
//					ctx.complete();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//			}
//		});
	}

}
