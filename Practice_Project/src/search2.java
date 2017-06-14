import java.util.*;
import java.lang.*;
import java.util.Scanner;

public class search2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,List<String>> hmap=new HashMap<String,List<String>>();
		
		List<String> l1=new ArrayList<String>();
		List<String> l2=new ArrayList<String>();
		l1.add("Kanika");
		l1.add("riya");
		l2.add("mangoes");
		l2.add("apple");
		hmap.put("names" , l1);
		hmap.put("fruits" , l2);
		System.out.println(hmap);
        
		
		// to print all the key value pairs in java
		for(Map.Entry<String,List<String>> entry :hmap.entrySet())
		{
			String key=entry.getKey();
			List<String> values=entry.getValue();
			System.out.println(key);
			System.out.println(values);
		}
		
		// to search for a given key
		System.out.println("Enter the key to be searched");
		Scanner sc=new Scanner(System.in);
		String key=sc.nextLine();
		if(!hmap.containsKey(key))
			System.out.println("Key not found");
		else 
			{
			   System.out.println("Key found");
			   //printing all the multiple values for a given key in java hashmap
			  System.out.println(hmap.get(key));
			   
			}
	}
	
	// to print all the values for a given key in hashmap

}
