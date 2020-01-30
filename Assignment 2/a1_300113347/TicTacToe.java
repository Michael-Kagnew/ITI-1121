
// Author: Michael Kagnew
// Student number: 300113347
// Course: ITI 1121-A
// Assignment: 1
import java.io.Console;

public class TicTacToe {

    /**
     * <b>main</b> of the application. Creates the instance of TicTacToeGame and
     * starts the game. If two parameters lines and columns are passed, they are
     * used. If the paramters lines, columns and win are passed, they are used.
     * Otherwise, a default value is used. Defaults values (3) are also used if the
     * paramters are too small (less than 2). Here, we assume that the command lines
     * arguments are indeed integers
     *
     * @param args command lines parameters
     */
    public static void main(String[] args) {

        StudentInfo.display();

        Console console = System.console();
        TicTacToeGame game;
        int lines, columns, win;
        lines = 5;
        columns = 5;
        win = 3;

        if (args.length >= 2) {
            lines = Integer.parseInt(args[0]);
            if (lines < 2) {
                System.out.println("Invalid argument, using default...");
                lines = 3;
            }
            columns = Integer.parseInt(args[1]);
            if (columns < 2) {
                System.out.println("Invalid argument, using default...");
                columns = 3;
            }
        }
        if (args.length >= 3) {
            win = Integer.parseInt(args[2]);
            if (win < 2) {
                System.out.println("Invalid argument, using default...");
                win = 3;
            }
        }
        if (args.length > 3) {
            System.out.println("Too many arguments. Only the first 3 are used.");
        }

        game = new TicTacToeGame(lines, columns, win);

        while (game.getGameState().equals(GameState.PLAYING)) {
            System.out.println(game.toString());
            System.out.println(game.getGameState());

            if (game.getLevel() % 2 == 0) {
                System.out.print("X to play: ");

            } else {
                System.out.print("O to play: ");
            }

            int myNum = Integer.parseInt(console.readLine());
            myNum -= 1;

            if (myNum < 0 || myNum > lines * columns - 1) {
                System.out.println("Invalid index. Try again");

            } else if (game.valueAt(myNum) != CellValue.EMPTY) {
                System.out.println("Position already played");
            } else {
                game.play(myNum);

            }

        }

        if (game.getGameState().equals(GameState.XWIN)) {
            System.out.println("Xwins!");
        } else if (game.getGameState().equals(GameState.OWIN)) {
            System.out.println("Owins!");
        } else {
            System.out.println("Draw");
        }

    }

}