package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {

	public static void main(String[] args) {
		
		
		List<testObject> testlist = new ArrayList<testObject>();
		
		testlist.add(new testObject(1, "kranthi"));
		testlist.add(new testObject(1, "Krishna"));
		testlist.add(new testObject(2, "Abhilash"));
		testlist.add(new testObject(3, "Mohan"));
		testlist.add(new testObject(3, "Mouli"));
		testlist.add(new testObject(3, "Chandu"));
		testlist.add(new testObject(4, "Gopal"));
		testlist.add(new testObject(4, "Srinu"));
		testlist.add(new testObject(6, "Vani"));
		
		
List<testObject> testlist2 = new ArrayList<testObject>();
		
		testlist2.add(new testObject(1, "test1"));
		testlist2.add(new testObject(1, "test2"));
		testlist2.add(new testObject(2, "test3"));
		testlist2.add(new testObject(3, "test4"));
		
		
		Map<Integer, List<testObject>> getTest =
				 testlist
				.stream()
				.collect(Collectors.groupingBy(testObject::getId));
		
		Map<Integer, List<testObject>> getTest2 =
				 testlist2
				.stream()
				.collect(Collectors.groupingBy(testObject::getId));
		
		getTest.forEach((key, value) -> System.out.println(key + " : " + value.toString()));
		
		getTest2.forEach((key, value) -> System.out.println(key + " : " + value.toString()));
		
		Map<Integer, List<testObject>> map3 = Stream.of(getTest, getTest2)
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> new ArrayList<>(e.getValue()),
                        (left, right) -> {left.addAll(right); return left;}
                ));
		map3.forEach((k,v) ->  System.out.println(k + " : " + v.toString()));
	}

}
