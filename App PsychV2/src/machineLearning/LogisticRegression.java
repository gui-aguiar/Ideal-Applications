package machineLearning;

import java.util.ArrayList;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.RegressionByDiscretization;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class LogisticRegression extends Algorithm {
	RegressionByDiscretization discretRegression;
	Instances myTrainingData; 
	ArrayList<Attribute> attributes;
	
	@Override
	public boolean fit(double[][] features, double[] labels) {
		double[][] fitData = new double[features.length][features[0].length + 1];
		for (int i = 0; i < features.length; i++) {
			for (int j = 0; j < features[i].length; j++) {
				fitData[i][j] = features[i][j];
			}		
			fitData[i][fitData[0].length - 1] = labels[i];
		}		
		
		attributes = new ArrayList<Attribute>();
        for (int att = 0; att < fitData[0].length; att++) {
        	attributes.add(new Attribute("Attribute" + att, att));
        }
        
        myTrainingData = new Instances("Rel", attributes, fitData[0].length);
        myTrainingData.setClassIndex(fitData[0].length-1);
       
        for (int inst = 0; inst < fitData.length; inst++) {
        	DenseInstance trainingExample = new DenseInstance(fitData[inst].length);
        	for (int j = 0; j < fitData[inst].length; j++) {
        		trainingExample.setValue(j, fitData[inst][j]);
        	}
        	myTrainingData.add(trainingExample);    
        }      
               
        discretRegression = new RegressionByDiscretization();
        try {
        	discretRegression.buildClassifier(myTrainingData);
      	

		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}              
        return SetPerformanceData();             
	}
	
	
	@Override
	public double predict(double[] features) {		
		Instances dataUnlabeled = new Instances("Sample", attributes, 0);		
		DenseInstance dataToPredict = new DenseInstance(features.length +1);
		
	    for (int i = 0; i < features.length; i++) { 
	    	dataToPredict.setValue(i, features[i]);
	    }	
	    dataToPredict.setValue(features.length , -1);
	    try {
			dataUnlabeled.add(dataToPredict);
			dataUnlabeled.setClassIndex(dataUnlabeled.numAttributes() - 1);        					
			return discretRegression.classifyInstance(dataUnlabeled.firstInstance());
		} catch (Exception e) {			
			e.printStackTrace();
			return -1;
		}
	}
	
	private boolean SetPerformanceData() {
		performanceData = new PerformanceDataLogisticRegression();
		
        Evaluation testModel = null;
		try {
			testModel = new Evaluation(myTrainingData);
			testModel.evaluateModel(discretRegression, myTrainingData);
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return ((PerformanceDataLogisticRegression) performanceData).setData(testModel);		 
	}


	@Override
	public void save() {
		// unimplemented for this application		
	}

	@Override
	public void read() {
		// unimplemented for this application
	}	
}