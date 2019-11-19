package LabExercise;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Ex_19_3 {

	private static Scanner in;

	public static void main(String[] args) throws IOException
	{
		String file = "D:\\Academic\\2-2\\Java_Practice\\eclipse\\StreamTest\\src\\LabExercise\\file.txt";
        in = new Scanner(new File(file));
        
	    List<String> wordList = new ArrayList<>();
	    
	    while (in.hasNextLine()) 
	    { 
	    	wordList.add(in.nextLine()); 
	    }
	    

	    long count = 0;
	    String key = "the";
	    
	    
	    for (String w : wordList)
	    {
	    	if(w.contains(key))
	    	{
	    		System.out.println(w);
	    	}
	    	
	    }
	}
}
