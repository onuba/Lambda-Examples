package org.fran.anotherjavaprogrammer.lambda;

import java.time.Clock;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class CollectionTest {

	private static final int MAX = 100_000;
	
	
	public static void main (String[] args) {
	
		final long start = Clock.tickSeconds(ZoneId.systemDefault()).millis();
		final List<String> list = new ArrayList<>();
		
		for (int i = 0; i < MAX; i++) {
			list.add(String.valueOf(i));
		}
		
		final long avg = getAverage(list);
		
		final long count = getCount(list, 1000);
		
		final long end = Clock.tickSeconds(ZoneId.systemDefault()).millis();
		
		System.out.println("Average value: " + avg);
		System.out.println("Elements number over 1000: " + count);
		System.out.println("Run time: " + (end-start) + " mls");
	}
	
	private static long getAverage(List<String> list) {
		
		long elementsSum = 0L;
		long average = 0L;
		
		if (list != null && list.size() > 0) {
			for (String elem : list) {
				final Integer e = Integer.parseInt(elem);
				elementsSum += e;
			}
			
			average = elementsSum / list.size();
		}
		
		return average;
		
	}
	
	private static int getCount(List<String> list, Integer lowLimit) {
		
		int count = 0;
		
		if (list != null && list.size() > 0) {
			for (String elem : list) {
				final Integer e = Integer.parseInt(elem);
				
				if (e >= lowLimit) {
					count++;
				}
			}
		}
		
		return count;
		
	}
}
