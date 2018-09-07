public abstract class DataDAO {

	protected int[][] features;
	protected int[] labels;

	public abstract void load();

	public void addLog(int[] features, int label) {
		// TODO - implement DadosDAO.addLog
		throw new UnsupportedOperationException();
	}

	public void delLog(int index) {
		// TODO - implement DadosDAO.delLog
		throw new UnsupportedOperationException();
	}

	public int[][] getFeatures() {
		return features;
	}

	public void setFeatures(int[][] features) {
		this.features = features;
	}

	public int[] getLabels() {
		return labels;
	}

	public void setLabels(int[] labels) {
		this.labels = labels;
	}

}