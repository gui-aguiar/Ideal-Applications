package machineLearning;

public class LinearRegressionLearn extends Learn {

	@Override
	protected void addAlgorithms() {		
		this.classifier.getAlgorithms().add(new LinearRegressionAlgorithm());
	}
}