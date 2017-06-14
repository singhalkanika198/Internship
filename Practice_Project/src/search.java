import java.util.*;

public class search {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);  
        HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
        hmap.put(1,2);
        hmap.put(2,3);
        hmap.put(3,4);
        hmap.put(5,6);
        System.out.println("Enter the key to be searched");
        int key=sc.nextInt();  
        if(!hmap.containsKey(key))
        	System.out.print("Key not found");
        else 
        	System.out.println(hmap.get(key));
	}

}
