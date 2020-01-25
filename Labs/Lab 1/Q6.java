import java.util.Scanner;
import java.util.Arrays;

public class Q6{
	public static void main(String[] args){
		Scanner input= new Scanner (System.in);
		int size = input.nextInt();
		double [] grades= new double[size];

		for (int x=0; x<10; x++){
			System.out.println("Please input a grade");
			grades[x]= input.nextInt();
		}

		System.out.println("the average is " + calculateAverage(grades));
		System.out.println("the median is " + calculateMedian(grades));
		System.out.println("Number that passed is " + calculateNumberPassed(grades) + "and number that faield is " + calculateNumberFailed(grades));
	}

	public static double calculateAverage(double[] notes){
		double sum=0;
		for (double x: notes){
			sum+=x;
		}
		double avg= sum/notes.length;
		return avg;
	}

	public static double calculateMedian(double[] notes){
		Arrays.sort(notes);
		if (notes.length % 2 == 0){
			return ((notes[(notes.length)/2-1] + notes[(notes.length)/2])/2);
		} else{
			return(notes[(notes.length)/2]);
		}

		
	}

	public static int calculateNumberFailed(double[] notes){
		int count=0;

		for (double x: notes){
			if (x<50.0){
				count++;
			}
		}
		return count;
	}

	public static int calculateNumberPassed(double[] notes){
		int count=0;

		return (notes.length-calculateNumberFailed(notes));
	}
}