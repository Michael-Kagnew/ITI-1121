public class Rational {

    private int numerator;
    private int denominator;
    private static int commonden;

    // constructors

    public Rational(int numerator) {
	     // Your code here
        this.numerator = numerator;
        denominator = 1;
    }

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

    // getters

    public int getNumerator() {
	     return numerator;
    }

    public int getDenominator() {
	     return denominator;
    }

    // instance methods

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

    // Transforms this number into its reduced form

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

    public int compareTo(Rational other) {
      return (numerator* other.denominator - other.numerator * denominator);
    }

    public boolean equals(Rational other){
      // Your code here
      return (numerator *other.denominator == other.numerator * denominator); 
    }

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