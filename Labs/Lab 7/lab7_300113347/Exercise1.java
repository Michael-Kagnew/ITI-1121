import java.io.IOException;

public class Exercise1 {

    public static void throwException(int exceptionNumber) throws Exception{
        if(exceptionNumber==1){
            throw new Exception();
        }
        if(exceptionNumber==2){
            throw new ArrayIndexOutOfBoundsException();
        }
        if(exceptionNumber==3){
            throw new IOException();
        }
        if(exceptionNumber==4){
            throw new IllegalArgumentException();
        }
        if(exceptionNumber==5){
            throw new NullPointerException();
        }
    }

    /*
        Returns the name of the exception thrown by the method throwException.
        Method that handles the exceptions thrown by the throwException method.
        
        @param exceptionNumber
        @return The exception name or "NoException" if no exception was caught.
     */
    public static String catchException(int exceptionNumber){
        try{
            throwException(exceptionNumber);
        }
        // YOUR CODE HERE
        catch(IOException e){
            System.out.println("The exception type is: IOException . The exception number is " + 3);
            return "IOException";

        }
        
         catch(ArrayIndexOutOfBoundsException e){
             System.out.println("The exception type is: ArrayIndexOutOfBoundsException . The exception number is " + 2);
             return "ArrayIndexOutOfBoundsException";
         }
         catch(IllegalArgumentException e){
             System.out.println("The exception type is: ArrayIndexOutOfBoundsException . The exception number is " + 4);
             return "IllegalArgumentException";
         }
         catch (NullPointerException e){
             System.out.println("The exception type is: NullPointerException . The exception number is " + 5);
             return "NullPointerException";
         }
          catch(Exception e){ //Last one because if not, everything would be caught at this point
            System.out.println("The exception type is: Exception . The exception number is " + 1);
            return "Exception";
         }
        return "NoException";
    }

    public static void main(String[] args) {
        int exceptionNumber=(int)(Math.random()*5) + 1;
        String exceptionName = catchException(exceptionNumber);
        System.out.println("Exception number: " + exceptionNumber);
        System.out.println("Exception name: " + exceptionName);
    }

}