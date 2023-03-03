package edu.kh.tycoon.service;

public class TycoonService {

	
	
	public int[] guestnum() {
		// 랜덤 손님 수 출력
		int[] guest = new int[6];
		
		for(int i= 0; i<guest.length;i++) {
			guest[i]=(int)(Math.random()*5);
		}
		return guest;
	}
}
