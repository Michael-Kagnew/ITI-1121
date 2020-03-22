// Reads keyboad input, displays the characters and corresponding Unicodes,
// stops when the end-of-stream is reached.

import java.io.InputStreamReader;
import java.io.IOException;

public class Keyboard {
    public static void main( String[] args ) throws IOException {
        InputStreamReader in = new InputStreamReader( System.in );
        //int i;
        char[] buffer = new char[256];
        int num; //Will store the single char, that will be converted into char type
        String str; //Converts it into a string
        while (in.read(buffer) != -1){ //Puts the read file into a buffer, the read string is in the object in
            str = new String(buffer);

            str = str.trim();
            System.out.println(str);
        }
        System.out.println( "bye" );
    }
}

// > java Keyboard
// On Unix you must type control-d in order to send an eos (-1) to
// the program.