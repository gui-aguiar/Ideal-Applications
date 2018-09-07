public abstract class Algorithm {
	PerformanceData performanceData;
	
	public abstract int predict(int[] features);

	public abstract boolean fit(int[][] features, int[] labels);
	
}