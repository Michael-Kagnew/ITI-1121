
/**
* this class represents a rational number
* <p>
* 
* Designed to have a number in the form of a fraction, having various methods to manipulate the number
* @author  Bob Smith
*/

public class Rational {

    private int numerator;
    private int denominator;
    private static int commonden;

    /**
    *Constructor for rational object that initalizes rational number with denominator of 1 
    *@param numerator  the numerator of said object
    */
    public Rational(int numerator) {
	     // Your code here
        this.numerator = numerator;
        denominator = 1;
    }


    /**
    *Constructor for rational object that takes in two inputs 
    *@param numerator  the numerator of said rational object
    *@param denominator the denominator of said rational object
    */
    public Rational(int numerator, int denominator) {
	     // Your code here
        this.numerator = numerator;
        this.denominator = denominator;

          if (numerator > denominator){

            for (int x = denominator; x>0; x--){
                if (numerator%x == 0 && denominator%x == 0){
                   this.numerator/=x;
                   this.denominator/=x;
                }
            }
        } else{
             for (int x = numerator; x>0; x--){
                if (numerator%x == 0 && denominator%x == 0){
                    this.numerator/=x;
                    this.denominator/=x;
                }
            }
        }

    }

    /**
    *This is a getter method
    *Used to return the numerator of the Rational object
    *@return int  Returns Rational object's numerator
    *
    */
    public int getNumerator() {
	     return numerator;
    }

    /**
    *This is a getter method
    *Used to return the denominator of the Rational object
    *@return int  Returns Rational object's denominator
    *
    */
    public int getDenominator() {
	     return denominator;
    }

   
   /**
    *This is a function to create Rational object of the sum of current object and other
    *Uses addition and return's the new Rational object
    *@param other  this is the object passed into the function that will be added with the current object
    *@return Rational  returns the sum of the Rational objects
    */

    public Rational plus(Rational other) {
	     // Your code here
        Rational sum;
        commonden = other.denominator * denominator;
        int num = numerator*other.denominator + other.numerator*denominator;
        //int den = denominator + other. numerator;

        sum = new Rational(num, commonden);
        sum.reduce();

        return sum;
    }

    /**
    *This is a function to create Rational object of the sum of two passed through objects
    *Uses addition and return's the new Rational object
    *@param a  First rational object that will be added
    *@param b  Second rational object that will be added
    *@return Rational  returns the sum of the Rational objects a and b
    */
    public static Rational plus(Rational a, Rational b) {
    	// Your code here
        Rational sum;
        commonden = a.denominator * b.denominator;
        int num = a.numerator*b.denominator + b.numerator*a.denominator;
      //  int den = a.denominator + b.denominator;

        sum = new Rational(num, commonden);
        sum.reduce();

        return sum;
    }

    /**
    *This function reduces the current object
    *Determines the lowest representation of the Rational Object
    */
    private  void reduce() {
      // Your code here

        if (numerator > denominator){

            for (int x = denominator; x>0; x--){
                if (numerator%x == 0 && denominator%x == 0){
                    numerator/=x;
                    denominator/=x;
                }
            }
        } else{
             for (int x = numerator; x>0; x--){
                if (numerator%x == 0 && denominator%x == 0){
                    numerator/=x;
                    denominator/=x;
                }
            }
        }
    }

    // Euclid's algorithm for calculating the greatest common divisor
    private int gcd(int a, int b) {
      // Note that the loop below, as-is, will time out on negative inputs.
      // The gcd should always be a positive number.
      // Add code here to pre-process the inputs so this doesn't happen.

    	while (a != b)
    	    if (a > b)
    		     a = a - b;
    	    else
    		     b = b - a;
    	return a;
    }


    /**
    *This function compares the current object to a passed object
    *Subtractions the two objects to determine if current object is greater, equal to, less than passed object
    *@param other  Passed through object that will be compared to
    *@return int  Returns the difference between the two Rational objects
    */
    public int compareTo(Rational other) {
      return (numerator* other.denominator - other.numerator * denominator);
    }

    /**
    *This function determines if two Rational objects are equal
    *With common denominator, determines if the two Rational objects have equal numerators
    *@param other  Passed through object that will be compared to
    *@return boolean  Returns true if the numerators are equal, otherwise returns false
    */
    public boolean equals(Rational other){
      // Your code here
      return (numerator *other.denominator == other.numerator * denominator); 
    }

    /**
    *This function creates a string to represent the Rational object
    *@return String  Returns the string representation of the object
    */
    public String toString() {
    	String result;
    	if (denominator == 1) {
    	    // Your code here
            result = Integer.toString(numerator);
    	} else {
    	    // Your code here
            result = Integer.toString(numerator) + "/" + Integer.toString(denominator);
    	}
    	return result;
    }

}