package com.andexp.jbmmgenerator;
public class Main {
	public static void main(String args[]){
		AsyncGenerator[] generators = new AsyncGenerator[6];
		
		generators[0] = new AsyncGenerator(1,250);
		generators[1] = new AsyncGenerator(251,500);
		generators[2] = new AsyncGenerator(501,750);
		generators[3] = new AsyncGenerator(750,1000);
		generators[4] = new AsyncGenerator(1001,1250);
		generators[5] = new AsyncGenerator(1251,1506);
		
		for (int i = 0; i < generators.length; i++) {
			generators[i].start();
		}
		
	}
}
