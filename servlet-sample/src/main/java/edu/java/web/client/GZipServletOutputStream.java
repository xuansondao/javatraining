package edu.java.web.client;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

public class GZipServletOutputStream extends ServletOutputStream {

	private GZipServletOutputStream stream = null;
	
	
	public GZipServletOutputStream(OutputStream output) {
		stream = new GZipServletOutputStream(output);
	}

	@Override
	public boolean isReady() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setWriteListener(WriteListener writeListener) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		stream.close();
	}
	
	@Override
	public void flush() throws IOException {
		stream.flush();
	}
	
	@Override
	public void write(byte[] b) throws IOException {
		stream.write(b);
	}
	
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		stream.write(b, off, len);
	}
	
	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		stream.write(b);
	}

	

}
