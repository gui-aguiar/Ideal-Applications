package machineLearning;

public class Application {

	private int numberOfQuestions;
	private int numberOfPages;
	private OperationMode operationMode;

	private Inductor inductor;

    public Application() {
    	inductor = new Inductor(getNumberOfQuestions());
		operationMode = new LinearRegressionLearn();
		inductor.setOperationMode(operationMode);
		
    	inductor.run();
	}

    public OperationMode getOperationMode() {
		return operationMode;
	}

	public void setOperationMode(OperationMode operationMode) {
		this.operationMode = operationMode;
	}

	public int setNumberOfQuestionForms() {
		return this.numberOfPages;
	}
	public void setNumberOfQuestionForms(int numberOfForms) {
		this.numberOfPages = numberOfForms;		
	}

	public int getNumberOfQuestions() {
		return this.numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;		
	}
	
	public double classify(double[] features) {
		return inductor.classify(features);
	}

	public double test() {
		return inductor.test();
	}

	public boolean train() {
		return inductor.train();
	}
	
	public void close() {
		inductor.close();
	}
}