public class Test extends OperationMode {

	@Override
	public void initialize() {
		classifier.loadData();
		this.test();		
	}

	@Override
	public int classify(int[] features) {
		// TODO talvez trabalhar com exceçoes aqui
		return -1;
	}

	public double test() {
		return 0;// criar metodos de testes - meu digrama do caso de uso testar ta errado, pq eu recebo essa msg e mando ela pra mim mesmo com o mesmo nome...
	}

	@Override
	public boolean train(int featuresSize) {
		// TODO Auto-generated method stub
		return false;
	}
}