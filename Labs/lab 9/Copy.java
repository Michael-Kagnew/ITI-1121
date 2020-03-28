import java.io.*;

public class Copy {

    public static void copy( String fileName, String outputFileName) 
        throws IOException, FileNotFoundException {  

        InputStreamReader input = null;
        FileOutputStream output = null;

        try{
            input = new InputStreamReader( new FileInputStream( fileName ) ); //open actual file, read it in byte code, then character
        
        output = new FileOutputStream(new File(outputFileName)); //Pass the file name. Is in byte information    
       
        int c;
        while ( ( c = input.read() ) != -1 ) {  //we read character by character since using InputStreamReader
            output.write(c);         //Write contents into char values (readablke)
        }
 
    } finally{
        if (input != null){
            input.close();
        }
    }
        output.close();

    }

    public static void main( String[] args ) 
        throws IOException, FileNotFoundException {

        if ( args.length ==0 ) {
            System.out.println( "Usage: java Copy file" );
            System.exit( 0 );
        }
        try{
                   copy( args[0] , args[1]);
 
       } catch(FileNotFoundException e){
        System.err.println(e.getMessage());
       
       } catch(IOException e){
        System.err.println(e.getMessage());
       }

    }
}