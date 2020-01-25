public class Combination {

    // Instance variables.
    // Remove this comment and declare your instance variables here
    private int num1;
    private int num2;
    private int num3;

    // Constructor
    public Combination( int first, int second, int third ) {
        // Your code here
        num1 = first;
        num2 = second;
        num3 = third;
    }

    // An instance method that compares this object
    // to other.
    // Always check that other is not null, i)
    // an error would occur if you tried to
    // access other.first if other was null, ii)
    // null is a valid argument, the method should
    // simply return false.

    public boolean equals( Combination other ) {
        // Put your code here and remove the line below
        if (other == null){
            return false;
        } else if (num1 == other.num1 && num2 == other.num2 && num3 == other.num3){
            return true;
        } else {
            return false;
        }

    }

    // Returns a String representation of this Combination.

    public String toString() {
        // Put your code here and remove the line below
        String display=String.valueOf(num1)+":" + String.valueOf(num2) + ":" +
                      String.valueOf(num3);

        return display;
    }

    public void setLock(int x, int y, int z){
        num1 = x;
        num2 = y;
        num3= z;
    }
}        

            