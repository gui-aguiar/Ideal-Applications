public class Inductor {

	private OperationMode operationMode;
	////Classificador classificador;
	private int featuresSize;

	public Inductor(int feturesSize) {
		this.featuresSize = feturesSize;
		//classificador = new Classificador();
	}

	public OperationMode getOperationMode() {
		return this.operationMode;
	}

	public void setOperationMode(OperationMode operationMode) {
		this.operationMode = operationMode;
	}

	public void run() {
		//modoOperacao.setClassificador(classificador);
		operationMode.initialize();
	}

	public boolean setAlgorithm(int index) {
		return this.setAlgorithm(index);
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
		// TODO - implement Indutor.close
		throw new UnsupportedOperationException();
	}

}