package org.fran.anotherjavaprogrammer.lambda;

import java.time.Clock;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class CollectionLambdaTest {

	private static final int MAX = 100_000;
	
	public static void main (String[] args) {
	
		final long start = Clock.tickSeconds(ZoneId.systemDefault()).millis();
		final List<String> list = new ArrayList<>();
		
		for (int i = 0; i < MAX; i++) {
			list.add(String.valueOf(i));
		}
		
		final OptionalDouble avg = list.stream().
				mapToInt(s -> Integer.parseInt(s)).
				distinct().
				average();
		
		final long count = list.stream().
				mapToInt(s -> Integer.valueOf(s)).
				filter(n -> n >= 1000).
				count();
		
		final long end = Clock.tickSeconds(ZoneId.systemDefault()).millis();
		
		if (avg.isPresent()) {
			System.out.println("Average value: " + avg.getAsDouble());
		} else {
			System.out.println("Is not possible to calculate average value");
		}
		
		System.out.println("Elements number over 1000: " + count);
		System.out.println("Run Time: " + (end-start));
	}
}
