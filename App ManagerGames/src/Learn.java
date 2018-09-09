public abstract class Learn extends OperationMode {

	public void initialize() {
		addAlgorithms();
	}
	
	public int classify(int[] features) {
		return -1;
	}
	
	public double test() {
		return -1;
	}

	public boolean train(int featuresSize) {
		return classifier.train(featuresSize);
	}

	protected abstract void addAlgorithms();
}