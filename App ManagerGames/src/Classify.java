public class Classify extends OperationMode {

	public void initialize() {
		classifier.loadData();		
	}

	public int classify(int[] features) {
		return classifier.classify(features);
	}

	public double test() {
		return -1;
	}

	public boolean train(int featuresSize) {
		// TODO Auto-generated method stub
		return false;
	}

}