// Prints all the lines containing a given word. For each line
// containing the word, it prints the line number followed by the line
// itself.

import java.io.*;

public class Find {

    public static void find( String fileName, String word ) 
        throws IOException, FileNotFoundException {

    BufferedReader input;
    
    //create your BufferedReader
    //Reads into byte info, then character info, then into lines
    input =new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));  //Buffered allows for greater efficiency, putting whole characters into a buffer, instead of 
                                                                                      //Single characters only


        
        int count = 0;
        String line;


   /*     //create a while loop to read your file line by line
      //Verify if your word is in the line being read
      while((line = input.readLine()) != null){//Reads the file line by line 
        lineNumber++;
        if(line.indexOf(word) != -1){ //Word isn't in line
          System.out.println(lineNumber + ":" + line);
        }

*/
        //Substring part
        while((line = input.readLine()) != null){//Reads the file line by line (THANKS TO BUFFERED STREAM CAN DO THIS)
        
          while(line.indexOf(word) != -1) { //If the word exists
            count++;
            line = line.substring(line.indexOf(word) + 1); //In case of the word appearing twice, will continue to check same line
          }
      } 
      System.out.println("there are " + count + " occurence the word \"" + word +"\"");
      
     input.close();  //close your file

    }

    public static void main( String[] args ) 
        throws IOException, FileNotFoundException {

        if ( args.length != 2 ) {
            System.out.println( "Usage: java Find file word" );
            System.exit( 0 );
        }

        find( args[0], args[1] );

    }
}


//output example
// > java Find Find.java IOException
// 10:   throws IOException, FileNotFoundException {
// 28:  throws IOException, FileNotFoundException {