// Author: Michael Kagnew
// Student number: 300113347
// Course: ITI 1121-A
// Assignment: 2
// Question 1

public class TicTacToe {

    /**
     * <b>main</b> of the application. Creates the instance of GameController and
     * starts the game. If two parameters line and column are passed, they are used.
     * Otherwise, a default value is used. Defaults values are also used if the
     * paramters are too small (less than 2).
     * 
     * @param args command line parameters
     */
    public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

        try {
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

        } catch (NumberFormatException e) {
            System.out.println("Invalid argument, using default...");
            lines = 3;
            columns = 3;
            win = 3;
        }

        Player[] players;

        // YOUR CODE HERE
        game = new TicTacToeGame(lines, columns, win);
        players = new Player[2];
        players[0] = new HumanPlayer();
        players[1] = new ComputerRandomPlayer();

        boolean firstGo = true;
        boolean cont = true;
        int firstP = Utils.generator.nextInt(2);
        while (game.getGameState().equals(GameState.PLAYING) && cont == true) {

            players[(game.getLevel() + firstP) % 2].play(game); // WIll always alternate

            if (!(game.getGameState().equals(GameState.PLAYING))) {
                boolean flag = true;
                System.out.println("Game over");
                System.out.println(game.toString());
                System.out.println("Result: " + game.getGameState());
                
                while (flag){
                    System.out.print("Play again(Y)?: ");
                    String ans = Utils.console.readLine().strip();

                    // Changes firstP to alternate
                    if (ans.equals("y")) {
                        firstP = (firstP == 1) ? 0 : 1;
                        game = new TicTacToeGame(lines, columns, win);
                        flag = false;
                    } else if (ans.equals("n")){
                        cont = false;
                        flag = false;
                        System.out.println("Goodbye!");
                    
                    } else {
                        System.out.println("Not a correct choice");
                    }
                }
           
            }

        }

    }

}
