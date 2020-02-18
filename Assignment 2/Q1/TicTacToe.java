

public class TicTacToe{

   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If two parameters line  and column
     * are passed, they are used. 
     * Otherwise, a default value is used. Defaults values are also
     * used if the paramters are too small (less than 2).
     * 
     * @param args
     *            command line parameters
     */
     public static void main(String[] args) {

        StudentInfo.display();

        TicTacToeGame game;
        int lines = 3;
        int columns = 3;
        int win = 3;

   
        try{
            if (args.length >= 2) {
                lines = Integer.parseInt(args[0]);
                if(lines<2){
                    System.out.println("Invalid argument, using default...");
                    lines = 3;
                }
                columns = Integer.parseInt(args[1]);
                if(columns<2){
                    System.out.println("Invalid argument, using default...");
                    columns = 3;
                }
            }
            if (args.length >= 3){
                win = Integer.parseInt(args[2]);
                if(win<2){
                    System.out.println("Invalid argument, using default...");
                    win = 3;
                }
            } 
            if (args.length > 3){
                System.out.println("Too many arguments. Only the first 3 are used.");
            } 

        } catch(NumberFormatException e){
            System.out.println("Invalid argument, using default...");
            lines   = 3;
            columns  = 3;
            win = 3;
        }
        
        Player[] players;



        // YOUR CODE HERE 
        game = new TicTacToeGame(lines, columns, win);
        players= new Player[2];
        players[0] = new HumanPlayer();
        players[1] = new ComputerRandomPlayer();
        
        boolean firstGo = true;
        boolean cont = true;
        int firstP= Utils.generator.nextInt(2);
        //TEST OUT IMPLEMENTATION OF HUMANPLAYER AND ROBOT
        while(game.getGameState().equals(GameState.PLAYING) && cont == true){
            
            if (true){ //Will set this to false after first game ends
             
             /*   if (game.getLevel() % 2 == 0){
                    player[firstP].play(game); //Based off randomizer, this person will play first

                } else { //This is for the peson that goes next, has to check to see who is the one who didn't go first
                    if (firstP == 0){
                      player[1].play(game);  
                    } else {
                        player[0].play(game);
                    }
                 
                  }*/
                  players[(game.getLevel() + firstP) % 2].play(game); //WIll always alternate
                
                if (!(game.getGameState().equals(GameState.PLAYING))) {
                    System.out.println("Result: " + game.getGameState())
                    System.out.println("would you like to continue? Type yes or no");
                    String ans = Utils.console.readLine().strip();

                    //Switches the positions, no need to change anything. Should we change firstP instead?
                    if (ans.equals("yes")){
                        //firstGo == false;
                       /* Player temp = players[1];
                        players[1] = new players[0].getClass();
                        players[0] = new temp.getClass();
                    */
                        firstP = (firstP == 1) ? 0: 1;
                        game = new TicTacToeGame(lines, columns, win);
                    } else {
                        cont = false;
                        System.out.println("Goodbye!");
                    }
                }   


             } /*else {
                  if (game.getLevel() % 2 == 0){
                    player[0].play(game); //Based off randomizer, this person will play first

                  } else { //This is for the peson that goes next, has to check to see who is the one who didn't go first
                    player[1].play(game);
                    }
                 
                  }*/

            }

        }

    }

