public class Geometric extends AbstractSeries {

    // instance variables
    double count = 0;
    double geomat = 0;
    public double next() {

        // implement the method
    	geomat = geomat + Math.pow(0.5, count);

    	count+=1;

    	return geomat;
    }
}