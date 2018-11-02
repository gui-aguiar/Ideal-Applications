package machineLearning;

import java.util.ArrayList;

public class Classifier {

	private ArrayList<Algorithm> algorithms;
	private Algorithm currentAlgorithm;     
	private DataDAO dataDAO;
	private double[][] normalizedFeatures;
	
	public Classifier() {
		algorithms = new  ArrayList<Algorithm>();
		createDataDAO();
	}

	private void createDataDAO() {
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

	private void saveAlgorithms() {
		for(Algorithm algorithm: algorithms){
    		algorithm.save();
    	}
	}

    public boolean train(int featuresSize) {
    	boolean fitResult = true;
    	this.loadData(featuresSize);
    	for(Algorithm algorithm: algorithms){
    		fitResult = algorithm.fit(normalizedFeatures, dataDAO.getLabels()) && fitResult;
    	}
    	setCurrentAlgorithm(0);
    	return fitResult;
	}
    
	private void loadData(int featuresSize) {		
		dataDAO.load();
		this.normalizeData();
	}
	
	public void load() {
		for(Algorithm algorithm: algorithms){
    		algorithm.read();
    	}	
	}

	public void normalizeData() {
		int minValue = 1;
		int maxValue = 7;
		
		double [][] rawData = dataDAO.getFeatures();
		normalizedFeatures = new double[rawData.length][rawData[0].length];
		for (int i = 0; i < rawData.length; i++) {
			for (int j = 0; j < rawData[0].length; j++ ) {
				normalizedFeatures[i][j] = ((rawData[i][j] - minValue) / (maxValue - minValue));
			}
		}
	}

	public double classify(double[] features) {
	  return currentAlgorithm.predict(features);
	}
	
	public void close() {
		this.saveAlgorithms();
	}

}