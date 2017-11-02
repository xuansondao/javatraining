package com.xuansondao.lab7;

import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class PrintMessage implements Runnable,Serializable {
	private String message;
	
	public PrintMessage(String message) {
		// TODO Auto-generated constructor stub
		this.message = message;
	}
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		String [] elements = message.split(" ");
		Arrays.stream(elements).forEach(ele ->{
			
			try {
				System.out.println(Thread.currentThread().getName() + "print " + ele);
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		try {
			Thread.sleep((int) ((Math.random()*3)*1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
