import java.util.Scanner;
public class Test{
	

	public static void main(String [] args){

		Scanner input = new Scanner(System.in);
		TicTacToeGame b1 = new TicTacToeGame(3,3,3);

		while (true){
			int counter = 6;
			if (b1.getLevel() >2){
				
				TicTacToeGame b2 = new TicTacToeGame(b1, input.nextInt() );
				System.out.println("here is the b2 board");
				System.out.println(b2);
				//System.out.println("this is input for b2");
				
				
			} 
			System.out.println("input");
			System.out.println("This is b1 board");
			System.out.println(b1);
			System.out.println("This is b1 in");

			b1.play(input.nextInt());
			
		

		}
	}
}