public class Rational {

    private int numerator;
    private int denominator;

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

        reduce();


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

        int num = numerator + other.numerator;
        int den = denominator + other. numerator;

        sum = new Rational(num, den);

        return sum;
    }

    public static Rational plus(Rational a, Rational b) {
    	// Your code here
        Rational sum;

        int num = a.numerator + b.numerator;
        int den = a.denominator + b.denominator;

        sum = new Rational (num,den);


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
      // Your code here
    }

    public boolean equals(Rational other) {
      // Your code here
        return (other.numerator == numerator && denominator == other.denominator);
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