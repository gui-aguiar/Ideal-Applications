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
    	this.createMainForm(); 	
    	  
		inductor = new Inductor(getNumberOfQuestions());
		operationMode = new LogisticRegressionLearn();
		inductor.setOperationMode(operationMode);
		
    	inductor.run();
	}

	public void configure() {
		setNumberOfQuestionForms(10); 
		setNumberOfQuestions(60);
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

	public int setNumberOfQuestionForms() {
		return this.numberOfPages;
	}
	public void setNumberOfQuestionForms(int numberOfForms) {
		this.numberOfPages = numberOfForms;		
	}

	public int getNumberOfQuestions() {
		return this.numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;		
	}

	public void createMainForm() {
		mainForm = new MainForm(this);
		mainForm.setNumberOfQuestionForms(numberOfPages);  // APAGAR settile e set instructions daqui
		mainForm.setTitle("Teste de Personalidade");
		mainForm.setInstructions("Instruções: as seguintes afirma\u00E7\u00F5es dizem respeito \u00E0 sua percep\u00E7\u00E3o sobre voc\u00EA em uma variedade de situa\u00E7\u00F5es. Sua tarefa \u00E9 indicar a for\u00E7a do seu acordo com cada afirma\u00E7\u00E3o, utilizando uma escala em que 1 denota forte desacordo, 5 denota forte concord\u00E2ncia e 2, 3 e 4 representam julgamentos interm\u00E9dios. Nas caixas ap\u00F3s cada declara\u00E7\u00E3o, clique em um n\u00FAmero de 1 a 5 da seguinte escala:\r\n\r\n        Discordo fortemente\r\n        Discordar\r\n        Nem discorda nem concorda\r\n        Aceita\r\n        Concordo plenamente \r\n\r\nN\u00E3o h\u00E1 respostas \"corretas\" ou \"erradas\", ent\u00E3o selecione o n\u00FAmero que mais reflete em cada declara\u00E7\u00E3o. Tome seu tempo e considere cada declara\u00E7\u00E3o com cuidado. Depois de concluir todas as perguntas, clique em \"Enviar\" na parte inferior.");
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