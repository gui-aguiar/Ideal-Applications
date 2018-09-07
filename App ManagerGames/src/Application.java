public class Application {

	private int numberOfQuestions;
	private int numberOfPages;
	private OperationMode operationMode;

	Inductor inductor;
    MainForm mainForm;
    
	public static void main(String args[]) {
		new Application();
	}
    
    public Application() {
    	this.configure();  
    	inductor.run();
    	this.createMainForm(); // olhar se aqui eu chamo o configurar
	}

	public void configure() {
		setNumberOfQuestions(60);
		setNumberOfQuestionForms(11); // tenho que configurar depois do formulario principal, pq e
		//distribuirQuestoes();
		
		inductor = new Inductor(getNumberOfQuestions());  // numero de questoes tem que vim da onde?
		operationMode = new LinearRegressionLearn();  // MUDPOU DE LUGAR< OLHAR OS DIGRAMAS
		inductor.setOperationMode(operationMode);
	}
	
	private void setTitle(String text) {
		mainForm.setTitle(text);
	}

	private void setInstructions(String text) {
		mainForm.setInstructions(text);		
	}
    
    public OperationMode getOperationMode() {
		return operationMode;
	}

	public void setOperationMode(OperationMode operationMode) {
		this.operationMode = operationMode;
	}

	public void distribuirQuestoes() {
		// TODO - implement Aplicacao.distribuirQuestoes
		//throw new UnsupportedOperationException();
	}

	public int getNumberOfPages() {
		return this.numberOfPages;
	}

	public int getNumberOfQuestions() {
		return this.numberOfQuestions;
	}

	public void setNumberOfQuestionForms(int numberOfForms) {
		this.numberOfPages = numberOfForms;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;		
	}

	public void createMainForm() {
		mainForm = new MainForm(this);
		mainForm.setNumberOfQuestionForms(getNumberOfPages());
		setTitle("Jogo para análise de perfil do gestor");
		setInstructions("Instruções: De acordo com o cenário que foi apresentado pelo professor, você deve preencher os seguintes item de cada página com a quantidade de capital a ser investido. Cada item mostra o valor acumulado até então, sendo que o total nao deverá exceder o valor estipulado pelo cenário. Os valores estão sendo considerados em mil reais.");			
	}
	
	public int classify(int[] features) {
		return inductor.classify(features);
	}

	public double test() {
		return inductor.test();
	}

	public boolean train() {
		return inductor.train();
	}
}