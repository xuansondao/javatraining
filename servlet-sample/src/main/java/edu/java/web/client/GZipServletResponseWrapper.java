package edu.java.web.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GZipServletResponseWrapper extends HttpServletResponseWrapper {
	private GZipServletOutputStream stream = null;
	private PrintWriter writer = null;

	public GZipServletResponseWrapper(HttpServletResponse response) {
		super(response);
		// TODO Auto-generated constructor stub
	}

	public void close() throws IOException {
		if (stream != null) {
			stream.close();
		}
	}

	public void flushBuffer() throws IOException {
		if (writer != null) {
			writer.flush();
		}
		stream.flush();
	}
	
	public ServletOutputStream getOutputStream(){
		if(stream != null) return stream;
		stream = new GZipServletOutputStream(getOutputStream());
		return stream;
		
	}
	
	public PrintWriter getWriter() {
		if(writer == null) {
			stream = (GZipServletOutputStream) getOutputStream();
			String encoding = getResponse().getCharacterEncoding();
			writer = new PrintWriter(new OutputStreamWriter(stream));
		}
		return writer;
	}
}
