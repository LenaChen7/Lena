package java_practice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class List_Practice {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
		names.add("Lena");
		names.add("Alice");
		names.add("Tom");
		names.add(1 , "Annie");	
		names.add(2 , "Felis");
		names.add("Lena");
		
	
	
		System.out.println(names.get(0)); //get the element in given index
		System.out.println(names.indexOf("Lena")); //get the first index of a certain element
		System.out.println(names.lastIndexOf("Lena")); //get the last index of a certain element
//		System.out.println(names.remove("Lena"));   //remove the first one
//		System.out.println(names.remove(0)); //remove the element in given index
		System.out.println(names.size());    //return size of the list
		System.out.println(names.isEmpty()); //boolean
		
		names.set(0, "Miya"); //Replaces the element at the specified position with the specified element.
		System.out.println(names); 
//		System.out.println(names);

	}

}
