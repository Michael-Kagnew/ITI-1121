public class Q2{

	public static void main(String[] args){

		for (int x = 1; x < 31; x++){

			if (x%15 == 0){
				System.out.println(x + " FizzBuzz");
			} else if (x%5 == 0){
				System.out.println(x + " Buzz");
			} else if (x%3 == 0){
				System.out.println(x + " Fizz");
			}


		}
	}

}