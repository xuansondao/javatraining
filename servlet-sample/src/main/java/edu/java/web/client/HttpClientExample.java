package edu.java.web.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HttpClientExample {
	static BufferedReader reader = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test2();
	}

	public static void Test1() {

		try {
			URL url = new URL("http://localhost:8080/html");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.addRequestProperty("Accept-Encoding", "gzip");
			int reponCode = con.getResponseCode();
			System.out.println("Response Code: " + reponCode);
			reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void Test2() {
		ExecutorService executor = Executors.newSingleThreadExecutor();

		executor.submit(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				URL object;
				try {
					object = new URL("http://localhost:8080/synch");
					HttpURLConnection con = (HttpURLConnection) object.openConnection();
					con.setRequestMethod("GET");
					con.addRequestProperty("Accept-Encoding", "gzip");
					reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
					String line = null;
					while ((line = reader.readLine()) != null) {
						System.out.println(line);
					}

				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		executor.shutdown();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
