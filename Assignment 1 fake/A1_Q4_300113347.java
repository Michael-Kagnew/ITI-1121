//Author: Michael Kagnew
//Student Number: 300113347
//Course: ITI 1121 A
//Assignment: 1
//Question 4

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class A1_Q4_300113347 {
	
	public static ArrayList<String> read_raw(File file) {
		
		Scanner txtFile = null;
		ArrayList <String> rawList=new ArrayList <String>();
		
		
			
			try {
				 txtFile= new Scanner (file); //Takes the input of the File object, and attempts to read it
				
				
			} catch (FileNotFoundException e) {
				System.out.println("Please input the name of the file");
				}
					
		
		while (txtFile.hasNextLine()) {
			String textLine= txtFile.nextLine().strip();
			rawList.add(textLine);
			
		}
		
		return rawList;
	}
	
	
	public static ArrayList <String> clean_up(ArrayList <String> L){
		/*
		 * The functions takes as input a list of characters.
    It returns a new list containing the same characters as l except that
    one of each characters that appears odd number of times in l is removed
    and all the * characters are removed

    >>> clean_up(['A', '*', '$', 'C', '*', '*', 'P', 'E', 'D', 'D', '#', 'D', 'E', 'B', '$', '#'])
    ['#', '#', '$', '$', 'D', 'D', 'E', 'E']

    >>> clean_up(['A', 'B', '*', 'C', '*', 'D', '*', '*', '*', 'E'])
    []
		
		 */
		
		ArrayList <String> clean_board = new ArrayList<String>();
		
		Map <String, Integer> temp =new HashMap <String, Integer> () ; // Creates a dictionary
		
		for (String x: L) {
			if (!(x.equals("*"))){
				temp.merge(x, 1, Integer::sum);  //Increases the value depending on the number of times the key is encountered
			}
			
		
		}
		
		for (Map.Entry MapElement: temp.entrySet()) {    //Access the key and value
			String key=(String) MapElement.getKey();
			int value= (int) MapElement.getValue();          //The value associated to the key
			//System.out.println(MapElement);
			if ( value%2==0) {
				for (int x=0; x<value; x++) {
					
				}
			
			}
			
			else if (value%2!=0) {
				
				for(int x=0; x<value-1; x++) {
					clean_board.add(key);
				}
			}
		}
		Collections.sort(clean_board);
		return clean_board;
	}
	
	
	
	public static boolean is_rigorous (ArrayList<String> L) {
		boolean clean=true;
		
		Map <String, Integer> temp=new HashMap <String, Integer>();
		for (String x: L) {
				temp.merge(x, 1, Integer::sum);
			}
			
		
		
		for (Map.Entry MapElement: temp.entrySet()) {
			String key=(String) MapElement.getKey();
			int value= (int) MapElement.getValue();
			
			if (value!=2) {
				clean=false;
			}
		}
	
	return clean;
	}
	

	public static void main(String[] args) {

		StudentInfo.display();
		Scanner fileInput = new Scanner(System.in); //Take the file input in cmd
		System.out.print("please input the the name of the text file: ");
		
		File file= new File(fileInput.nextLine().strip());   //Opens the file from the cmd line
		ArrayList<String>  raw=A1_Q4_300113347.read_raw(file);          //Puts the text file into an array, unedited
		ArrayList <String> clean=A1_Q4_300113347.clean_up(raw);
		boolean rig=A1_Q4_300113347.is_rigorous(clean);
		
		System.out.println(raw);
		System.out.println("this is the file without editing");
		System.out.println(clean);
		System.out.println("This is edited");
		System.out.println(rig);
		//String [] hi= {"o", "o", "l", "g"};
		//System.out.println(Arrays.toString(hi));
	//	System.out.println(A1_Q4_300113347.clean_up(raw));
	
	}

}
