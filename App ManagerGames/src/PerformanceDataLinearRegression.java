import weka.classifiers.Evaluation;

public class PerformanceDataLinearRegression extends PerformanceData {
	private double correlationCoefficient;
	private double meanAbsoluteError;
	private double rootMeanSquaredError;
	private double rootRelativeSquaredError; 

	public boolean setData(Evaluation modelData) {
		try {
			this.correlationCoefficient = modelData.correlationCoefficient();
			this.meanAbsoluteError = modelData.meanAbsoluteError();
			this.rootMeanSquaredError = modelData.rootMeanSquaredError();
			this.rootRelativeSquaredError = modelData.rootRelativeSquaredError();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	public double getCorrelationCoefficient() {
		return correlationCoefficient;
	}

	public double getMeanAbsoluteError() {
		return meanAbsoluteError;
	}

	public double getRootMeanSquaredError() {
		return rootMeanSquaredError;
	}

	public double getRootRelativeSquaredError() {
		return rootRelativeSquaredError;
	}
}