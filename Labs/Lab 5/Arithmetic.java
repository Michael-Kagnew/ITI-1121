public class Arithmetic extends AbstractSeries {

    // instance variables

	double count = 1;
	double sum = 0;
    public double next() {

        // implement the method
        sum = sum + 1*count;
        count++;
        return sum;
    }

}