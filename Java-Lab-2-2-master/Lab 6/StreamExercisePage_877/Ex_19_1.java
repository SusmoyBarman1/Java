package LabExercise;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Ex_19_1 {

	private static Scanner in;

	public static void main(String[] args) throws IOException
	{
		String file = "D:\\Academic\\2-2\\Java_Practice\\eclipse\\StreamTest\\src\\LabExercise\\file.txt";
        in = new Scanner(new File(file));
        
	    List<String> wordList = new ArrayList<>();
	    
	    while (in.hasNext()) 
	    { 
	    	wordList.add(in.next()); 
	    }
	    

	    long count = 0;
//	    for (String w : wordList)
//	    {
//	    	System.out.println(w);
//	        //if (w.equals("the")) { count++; }
//        }
//	    System.out.println("Long words: " + count);
	 
	     //The same computation with streams
	    count = wordList.stream()
	           .filter(w -> w.equals("the"))
	           .count();
	 
	    System.out.println("Expecting words: " + count);
	}
}
