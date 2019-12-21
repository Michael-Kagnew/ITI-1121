import java.util.Scanner;

public class A1_Q3_300113347 {
	
	public static int longest_run(int[] arr) {
		/*(array of numbers) -> int
		 Take list of numbers and return the integer value of the longest run in the list
	    Precondition: Inputs separated only by spaces
		 */	
	
		int counter=1;
		int max1=1;
		if (arr.length==0) {
			return 0;
		}
		else if (arr.length==1) {
			return 1;
			
		}
		
		else {
			
			for (int i=0; i<arr.length-1;i++) {
				if (arr[i]==arr[i+1] && i==arr.length-2 && counter>=max1) {
					counter++;
					max1=counter;
				}
				else if (arr[i]==arr[i+1]) {
					counter++;
				}
				else {
					if(counter>max1) {
						max1=counter;
						counter=1;
					}
					else {
						counter=1;
					}
				}
				
			}
		return max1;
		}
	}
	
	
	
	
	public static void main(String[] args) {

		//This section is to get the input of the user in a string, then split
		Scanner input=new Scanner(System.in);
		System.out.println("input your values");
		String val=input.nextLine();
		String [] arr=val.strip().split(" ");

		int [] arrayNum=new int[arr.length];

		//Converts the string inputs into integer
		for (int y=0; y<arr.length; y++ ) {
			arrayNum[y]=Integer.parseInt(arr[y]);

		int numRun= A1_Q3_300113347.longest_run(arrayNum);
		System.out.println(numRun);
	}

}
}
