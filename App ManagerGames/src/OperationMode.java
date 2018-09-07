public abstract class OperationMode {

	Classifier classifier;
	
	public OperationMode(Classifier classificador) {
		this.classifier = classificador;
	}

	public OperationMode() {
		this.classifier = new Classifier();
	}
	
	public abstract void initialize();

	public abstract int classify(int[] features);

	public abstract double test();

	public abstract boolean train(int featuresSize);

	public void setClassificador(Classifier classificador) {
		this.classifier = classificador; 
	}

}