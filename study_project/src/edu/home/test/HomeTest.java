package edu.home.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HomeTest {

		List<Integer> s = new ArrayList<>();
		Set<Integer> w = new HashSet<>();
		
	
	public void ex1() {
		
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(2);
		s.add(4);
		
		for(Integer a : s) {
			System.out.print(a+" ");
		}
		
		for(Integer a: s) {
			w.add(a);
		}
		
		System.out.println(w);
		
		
	}
}
