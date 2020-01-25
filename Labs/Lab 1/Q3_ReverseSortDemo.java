import java.util.Arrays; 

public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
	//	unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		unorderedLetters = new char[]{};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.print(unorderedLetters[i]);
	}

	//method that sorts a char array into its reverse alphabetical order
	public static void reverseSort(char[] values){
		
		/*Arrays.sort(values);
		char temp = values[values.length-1];

		for (int x = 0; x < values.length/2; x++){
			char temp1=values[x];

			values[x] = values[values.length-1-x];
			values[values.length-1-x]=temp1;
		}*/
		boolean flag = true;
		while (flag){
			flag = false;

			for (int x = 0; x < values.length - 1; x++){
				
				if (values[x] < values[x+1]){
				flag = true;	
				char temp = values [x+1];
				values[x+1] = values[x];
				values[x] = temp;
				
				}
				
			}
		}
	}

}