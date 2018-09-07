import java.util.ArrayList;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.LinearRegression;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class LinearRegressionAlgorithm extends Algorithm {
	LinearRegression linearRegression;
	Instances myTrainingData; 
	
	@Override
	public boolean fit(int[][] features, int[] labels) {
		int[][] fitData = new int[features.length][features[0].length + 1];
		for (int i = 0; i < features.length; i++) {
			for (int j = 0; j < features[i].length; j++) {
				fitData[i][j] = features[i][j];
			}		
			fitData[i][fitData[0].length - 1] = labels[i];
		}		
		
		ArrayList<Attribute> attributes = new ArrayList<Attribute>();
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
               
        linearRegression = new LinearRegression();
        try {
        	linearRegression.buildClassifier(myTrainingData);
      	

		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}              
        return SetPerformanceData();             
	}
	
	
	@Override
	public int predict(int[] features) {
		return -1;
	}
	
	private boolean SetPerformanceData() {
		performanceData = new PerformanceDataLinearRegression();
		
        Evaluation testModel = null;
		try {
			testModel = new Evaluation(myTrainingData);
			testModel.evaluateModel(linearRegression, myTrainingData);
		} catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		return ((PerformanceDataLinearRegression) performanceData).setData(testModel);		 
	}	
}