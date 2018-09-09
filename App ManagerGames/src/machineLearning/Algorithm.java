package machineLearning;

public abstract class Algorithm {
	PerformanceData performanceData;
	
	public abstract double predict(double[] features);

	public abstract boolean fit(int[][] features, int[] labels);
	
	public abstract void save();

	public abstract void read();	
}