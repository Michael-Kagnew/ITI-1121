
import java.io.InputStreamReader;
import java.io.IOException;
public class Test {

	public static void main(String[] args) throws IOException{
	InputStreamReader in = new InputStreamReader( System.in );

	char[] buffer = new char[ 256 ];  
                 int num = in.read( buffer );  
                String str = new String( buffer ); 

     System.out.println((char) num);
	}	

}