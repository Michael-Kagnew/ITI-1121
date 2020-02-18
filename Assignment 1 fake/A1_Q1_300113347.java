//Author: Michael Kagnew
//Student Number: 300113347
//Course: ITI 1121 A
//Assignment: 1
//Question 1
import java.util.Scanner;

/*
[PUT CLASS DESCREPITION HERE AS STATED BY JAVADOC]

*/
public class A1_Q1_300113347 {
	
	public static int number_divisible(int [] array, int n) {
		
	int count=0;
	
	for ( int x: array) {
		if (x%n==0) {
			count++;
			
		}		
	}
	return count;
	}
	
	public static void main(String[] args) {
	/*String[] a = new String[6];
	int [] y= {1,2,3,4};
	int x = A1_Q1_300113347.number_divisible(new int[] {3,4,5}, 3); 
	System.out.println(x);
	*/
	StudentInfo.display(); // NEEDED AT ALL ASSIGNMENTS
	Scanner input=new Scanner(System.in);
	System.out.println("input your values");
	String val=input.nextLine();
	String [] arr=val.strip().split("\\s+");
	
	int [] arrayNum=new int[arr.length];
	
	
	for (int y=0; y<arr.length; y++ ) {
		arrayNum[y]=Integer.parseInt(arr[y]);
		
	}

	int x = number_divisible(arrayNum, 3); 

	System.out.println(x);
}
}
