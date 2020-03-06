import java.io.IOException;
public class TryCatchThrow_Demo {

   public static void main(String args[])  {		
         throwingMethod();
}

   public static void throwingMethod() throws IllegalStateException{
	//some code...
      System.out.println("Running the method throwingMethod");
      throw new IOException();
   }
}
  