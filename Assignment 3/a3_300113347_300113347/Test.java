// Author: Michael Kagnew
// Student number: 300113347
// Course: ITI 1121-A
// Assignment: 3
public class Test {

	public static void printTest(TicTacToeGame g){
        g.reset();
        while (g.hasNext()) {
            g.next();
            System.out.println(g.toStringTransformed());
        }

        System.out.println("reset:");
        g.reset();
        while (g.hasNext()) {
            g.next();
            System.out.println(g.toStringTransformed());
        }
	}
    public static void main(String[] args) {
        
        TicTacToeGame g;
 
        System.out.println("Test on a 3x3 game");
        g = new TicTacToeGame();
        g.play(0);
        g.play(2);
        g.play(3);
        printTest(g);
        System.out.println("Test on a 5x4 game");
        g = new TicTacToeGame(4,5);
        g.play(0);
        g.play(2);
        g.play(3);
        printTest(g);
    }
}
