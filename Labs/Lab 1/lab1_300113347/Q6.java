import java.util.Scanner;
import java.util.Collection;

public class Q6{
	public static void main(String[] args){
		Scanner input= new Scanner (System.in);
		double [] grades= new double[10];

		for (int x=0; x<10; x++){
			System.out.println("Please input a grade");
			grades[x]= input.nextInt();
		}

		System.out.println("the average is " + calculateAverage(grades));

	}

	public static double calculateAverage(double[] notes){
		double sum=0;
		for (double x: notes){
			sum+=x;
		}
		double avg= sum/10;
		return avg;
	}

	public static double calculateMedian(double[] notes){
		Collections.sort(notes);

		return ((notes[5]+notes[6])/2);
	}

	public static int calculateNumberFailed(double[] notes){
		int count=0;

		for (double x: notes){
			if (x<50){
				count++;
			}
		}
		return count;
	}

	public static int calculateNumberPassed(double[] notes){
		int count=0;

		return (10-calculateNumberFailed(notes));
	}
*/
}