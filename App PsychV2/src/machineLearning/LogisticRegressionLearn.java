package machineLearning;

public class LogisticRegressionLearn extends Learn {

	@Override
	protected void addAlgorithms() {		
		this.classifier.getAlgorithms().add(new LogisticRegression());
	}

}