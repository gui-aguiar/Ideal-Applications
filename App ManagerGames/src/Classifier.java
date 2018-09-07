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
	
	public void setCurrentAlgorithm(int currentAlgorithml) {
		this.currentAlgorithm = this.algorithms.get(currentAlgorithml);
	}

	public Algorithm getCurrentAlgorithm() {
		return this.currentAlgorithm;
	}

	public void saveAlgorithms() {
		// TODO - implement Classificador.salvarAlgoritmos -- fazer um for e mandar cada um se salvar?
		throw new UnsupportedOperationException();
	}

    public boolean train(int featuresSize) {
    	boolean fitResult = true;
    	this.loadData();
    	for(Algorithm algoritmo: algorithms){
    		fitResult = algoritmo.fit(dataDAO.getFeatures(), dataDAO.getLabels()) && fitResult;
    	}
    	return fitResult;
	}
    
	public void loadData() {		
		dataDAO.load();
		this.normalizeData();
	}

	public void normalizeData() {
		throw new UnsupportedOperationException();
	}

	public int classify(int[] features) {
	  return currentAlgorithm.predict(features);
	}

}