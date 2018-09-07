import java.util.ArrayList;

public class Classifier {

	private ArrayList<Algorithm> algorithms;
	private Algorithm currentAlgorithm;     
	private DataDAO dataDAO;
	
	public Classifier() {
		algorithms = new  ArrayList<Algorithm>();
		dataDAO = new DataDAOCSV("DadosAplicacaoPsicologica.csv");
	}
		
	public ArrayList<Algorithm> getAlgorithms() {
		return algorithms;
	}
	
	public void setCurrentAlgorithm(int currentAlgorithm) {
		this.currentAlgorithm = this.algorithms.get(currentAlgorithm);
	}

	public Algorithm getCurrentAlgorithm() {
		return this.currentAlgorithm;
	}

	public void saveAlgorithms() {
		for(Algorithm algorithm: algorithms){
    		//algorithm.save;
    	}
	}

    public boolean train(int featuresSize) {
    	boolean fitResult = true;
    	this.loadData(featuresSize);
    	for(Algorithm algorithm: algorithms){
    		fitResult = algorithm.fit(dataDAO.getFeatures(), dataDAO.getLabels()) && fitResult;
    	}
    	return fitResult;
	}
    
	private void loadData(int featuresSize) {		
		dataDAO.load();       // a intençao esta em realmente ler os dados da parada? la do CSV, mas se aqui eu leio do CSV e normalizo, pq que eu tenho que fazer quando eu ja estou classificando?
		this.normalizeData();
	}
	
	public void load() {
		// aqui seria carregar o algoritnmo pronto. Seria apenas um classifier LOAD
	}

	public void normalizeData() {
		//throw new UnsupportedOperationException();
	}

	public int classify(int[] features) {
	  return currentAlgorithm.predict(features);
	}

}