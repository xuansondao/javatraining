package edu.java.web.client;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;

//import org.apache.http.HttpResponse;
//
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.concurrent.FutureCallback;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
//import org.apache.http.impl.nio.client.HttpAsyncClients;

public class AsyncHttpClientExample {

	public static void main(String[] args) throws InterruptedException {
//		// TODO Auto-generated method stub
//		 CloseableHttpAsyncClient hClient = HttpAsyncClients.createDefault();
//		hClient.start();
//		HttpGet request = new HttpGet("http://localhost:8080/synch");
//		hClient.execute(request, new FutureCallback<HttpResponse>() {
//
//			public void cancelled() {
//				// TODO Auto-generated method stub
//
//			}
//
//			public void completed(HttpResponse arg0) {
//				HttpResponse response = null;
//				// TODO Auto-generated method stub
//				try {
//					InputStream stream = response.getEntity().getContent();
//					BufferedReader reader = null;
//					String line = null;
//					while((line = reader.readLine()) != null) {
//						System.out.println(line);
//					}
//				} catch (UnsupportedOperationException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//
//			public void failed(Exception arg0) {
//				// TODO Auto-generated method stub
//
//			}
//		});
//		int counter = 1;
//		while(counter < 10) {
//			System.out.println("main thread is running " + counter);
//			Thread.sleep(1000);
//			counter++;
//		}
	}

}
