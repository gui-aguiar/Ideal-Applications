public class Inductor {

	private OperationMode operationMode;
	private int featuresSize;

	public Inductor(int feturesSize) {
		this.featuresSize = feturesSize;
	}

	public OperationMode getModoOperacao() {
		return this.operationMode;
	}

	public void setOperationMode(OperationMode operationMode) {
		this.operationMode = operationMode;
	}

	public void run() {
		operationMode.initialize();
	}

	public boolean setAlgorithmo(int index) {
		return this.setAlgorithmo(index);
	}

	public int classify(int[] features) {
		return operationMode.classify(features);
	}

	public double test() {
		return operationMode.test();
	}

	public boolean train() {
		return operationMode.train(featuresSize);
	}

	public void close() {
		operationMode.close();
	}

}