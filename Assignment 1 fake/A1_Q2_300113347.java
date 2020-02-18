//Author: Michael Kagnew
//Student Number: 300113347
//Course: ITI 1121 A
//Assignment: 1
//QUestion 2
import java.util.Scanner;

public class A1_Q2_300113347 {

	
	public static boolean two_length_run(int [] arr) {
		
		boolean check=false;
		
		for (int x=0; x<arr.length-1; x++) {
			
			if (arr[x+1]==arr[x]) {
				check=true;
				break;	
			}
		
		}
		return check;	
	
	}
	
	
	public static void main(String[] args) {
		StudentInfo.display(); //NEEDED AT ALL TIMES
		//This section is to get the input of the user in a string, then split
		Scanner input=new Scanner(System.in);
		System.out.println("input your values");
		String val=input.nextLine();
		String [] arr=val.strip().split("\\s+");
		
		int [] arrayNum=new int[arr.length];
		
		//Converts the string inputs into integer
		for (int y=0; y<arr.length; y++ ) {
			arrayNum[y]=Integer.parseInt(arr[y]);
			
		boolean x=A1_Q2_300113347.two_length_run(arrayNum);
		System.out.println(x);
	}

}
	
	
}
