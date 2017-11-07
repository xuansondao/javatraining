package edu.java.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.plaf.FileChooserUI;

@WebServlet(urlPatterns = "/upload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
public class UploadServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String appPath = req.getServletContext().getRealPath("");
		resp.getWriter().println("-----------" + appPath);
		File folder = new File(appPath,"temp");
		if(!folder.exists())folder.mkdir();
		for (Part part : req.getParts()) {
			String name = extractFileName(part);
			byte[] buff = new byte[4*1024];
			int read = -1;
			FileOutputStream outputStream = new FileOutputStream(new File(folder, name));
			try {
				FileInputStream inputStream = (FileInputStream) part.getInputStream();
				while((read = inputStream.read(buff)) != -1) {
					outputStream.write(buff, 0, read);
				}
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				outputStream.close();
			}
		}

		for (Part part : req.getParts()) {
			Collection<String> headers = part.getHeaderNames();
			for (String header : headers) {
				resp.getWriter().println(header + ":" + part.getHeader(header));
			}
		}
		resp.getWriter().println("Upload have been done successfully");
		;
	}

	private String extractFileName(Part part) {
		// TODO Auto-generated method stub
		String content = part.getHeader("content-disposition");
		Pattern pattern = Pattern.compile(".*filename\\=\"(.*)\".*");
		Matcher matcher = pattern.matcher(content);
		return matcher.matches() ? matcher.group(1) : "unknown";
	}

}
