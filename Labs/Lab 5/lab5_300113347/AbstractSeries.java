public abstract class AbstractSeries implements Series {

    public double[] take(int k) {

        // implement the method
         double[] sum = new double [k];
		for (int x = 0; x < k; x++){
        	sum[x] = next();
        }

        return sum;
    }

 
}