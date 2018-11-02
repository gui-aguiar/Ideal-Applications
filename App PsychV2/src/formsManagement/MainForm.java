package formsManagement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import machineLearning.Application;
import machineLearning.Classify;

public class MainForm extends JFrame{

	Panel mainPanel;
	Panel questionPanelsPane;
	JTextArea intructions;
	Label title;
	
	int numberOfQuestionForms;
	int numberOfQuestions;
	double[] dataToPredict;
	
	Application application;
	
	private static final long serialVersionUID = 1L;
	
	public static void main(String args[]) {
		new MainForm();
	}
	
	public MainForm () {
		configureCloseAction();
		defineDataInfo();
		setInstrucionsPanelComponents();
		setQuestionPanelsComponents();
		checkNumberOfPages();
		setFormInfo();	
		runApplication();		
	}

	private void configureCloseAction() {
		this.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		       application.close();		       
		    }
		});
	}
		
	private void defineDataInfo() {
		this.setNumberOfQuestionForms(10);
		this.setNumberOfQuestions(60);
		dataToPredict = new double[this.getNumberOfQuestions()];
	}

	private void setFormInfo() {
		this.setTitle("Teste de Personalidade");
		this.setInstructions("Instru��es: as seguintes afirma\u00E7\u00F5es dizem respeito \u00E0 sua percep\u00E7\u00E3o sobre voc\u00EA em uma variedade de situa\u00E7\u00F5es. Sua tarefa \u00E9 indicar a for\u00E7a do seu acordo com cada afirma\u00E7\u00E3o, utilizando uma escala em que 1 denota forte desacordo, 5 denota forte concord\u00E2ncia e 2, 3 e 4 representam julgamentos interm\u00E9dios. Nas caixas ap\u00F3s cada declara\u00E7\u00E3o, clique em um n\u00FAmero de 1 a 5 da seguinte escala:\r\n\r\n        Discordo fortemente\r\n        Discordar\r\n        Nem discorda nem concorda\r\n        Aceita\r\n        Concordo plenamente \r\n\r\nN\u00E3o h\u00E1 respostas \"corretas\" ou \"erradas\", ent\u00E3o selecione o n\u00FAmero que mais reflete em cada declara\u00E7\u00E3o. Tome seu tempo e considere cada declara\u00E7\u00E3o com cuidado. Depois de concluir todas as perguntas, clique em \"Enviar\" na parte inferior.");
	}

	private void runApplication() {
		this.application = new Application(this.getNumberOfQuestions());		
		this.application.setNumberOfQuestionForms(this.getNumberOfQuestionForms());
		//this.application.setNumberOfQuestions(this.getNumberOfQuestions());
	}
   
	public void setApplication(Application application) {
		this.application = application;
	}

	public int getNumberOfQuestionForms() {
		return numberOfQuestionForms;
	}

	public void setNumberOfQuestionForms(int numberOfQuestionForms) {
		this.numberOfQuestionForms = numberOfQuestionForms;
	}

	public int getNumberOfQuestions() {
		return numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	protected void setInstrucionsPanelComponents() {
		this.setVisible(true);
		this.setBounds(100, 100, 680, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		mainPanel = new Panel();
		
		mainPanel.setBounds(10, 10, 680, 590);
		this.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		mainPanel.setVisible(true);
		
		title = new Label();
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 22));
		title.setBounds(182, 35, 251, 66);
		mainPanel.add(title);
		
		intructions = new JTextArea();
		intructions.setLineWrap(true);
		intructions.setFont(new Font("Tahoma", Font.PLAIN, 11));
		intructions.setEditable(false);
		intructions.setBounds(10, 153, 594, 206);
		intructions.setOpaque(false);  
	    mainPanel.add(intructions);
		
		Button button = new Button("Iniciar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				startTest();
			}
		});
		button.setBounds(273, 500, 70, 22);
		mainPanel.add(button);
		this.repaint();
	}
	
	private void setQuestionPanelsComponents() {
		questionPanelsPane = new Panel();
		questionPanelsPane.setVisible(false);
		questionPanelsPane.setBounds(10, 10, 640, 590);
		getContentPane().add(questionPanelsPane);
		questionPanelsPane.setLayout(new CardLayout(0, 0));

		addQuestionPanels();	
	}	

	private void addQuestionPanels() {
		QuestionPanelSub questionPanel1 = new QuestionPanelSub(this);
		questionPanel1.setData(dataToPredict);
		questionPanel1.setIsFirstPanel(true);
		questionPanel1.setIndex(0);
		questionPanelsPane.add("Questions1", questionPanel1);
		questionPanel1.setQuestionLabel(1, "Voc� acha dif�cil se apresentar para outras pessoas.");
		questionPanel1.setQuestionLabel(2, "Voc� fica frequentemente t�o absorto em seus pensamentos que ignora ou esquece do seu entorno.");
		questionPanel1.setQuestionLabel(3, "Voc� tenta responder aos seus e-mails o mais rapidamente poss�vel e n�o suporta uma caixa de entrada bagun�ada.");
		questionPanel1.setQuestionLabel(4, "Voc� permanece relaxado e concentrado mesmo sob press�o.");
		questionPanel1.setQuestionLabel(5, "Geralmente, voc� n�o inicia conversas.");
		questionPanel1.setQuestionLabel(6, "Voc� raramente faz alguma coisa por pura curiosidade.");
		
		QuestionPanelSub questionPanel2 = new QuestionPanelSub(this);
		questionPanel2.setData(dataToPredict);
		questionPanel2.setIndex(1);
		questionPanelsPane.add("Questions2", questionPanel2);
		questionPanel2.setQuestionLabel(1, "Voc� se sente superior �s outras pessoas.");
		questionPanel2.setQuestionLabel(2, "Ser organizado � mais importante para voc� do que ser adapt�vel.");
		questionPanel2.setQuestionLabel(3, "Voc� � geralmente muito motivado e cheio de energia.");
		questionPanel2.setQuestionLabel(4, "Vencer um debate significa menos para voc� do que assegurar que ningu�m fique aborrecido.");
		questionPanel2.setQuestionLabel(5, "Voc� frequentemente sente que tem que se justificar para outras pessoas.");
		questionPanel2.setQuestionLabel(6, "Seus ambientes dom�stico e de trabalho s�o bem organizados.");
		
		QuestionPanelSub questionPanel3 = new QuestionPanelSub(this);
		questionPanel3.setData(dataToPredict);
		questionPanel3.setIndex(2);
		questionPanelsPane.add("Questions3", questionPanel3);
		questionPanel3.setQuestionLabel(1, "Voc� n�o se importa em ser o centro das aten��es.");
		questionPanel3.setQuestionLabel(2, "Voc� se considera mais pr�tico do que criativo.");
		questionPanel3.setQuestionLabel(3, "As pessoas raramente conseguem aborrec�-lo.");
		questionPanel3.setQuestionLabel(4, "Seus planos de viagem s�o geralmente bem pensados.");
		questionPanel3.setQuestionLabel(5, "Frequentemente, � dif�cil para voc� se relacionar com os sentimentos das outras pessoas.");
		questionPanel3.setQuestionLabel(6, "Seu humor pode mudar muito rapidamente.");
		
		QuestionPanelSub questionPanel4 = new QuestionPanelSub(this);
		questionPanel4.setData(dataToPredict);
		questionPanel4.setIndex(3);
		questionPanelsPane.add("Questions4", questionPanel4);
		questionPanel4.setQuestionLabel(1, "Em uma discuss�o, a verdade deve ser mais importante que a sensibilidade das pessoas.");
		questionPanel4.setQuestionLabel(2, "Voc� raramente se preocupa em como suas a��es afetam as outras pessoas.");
		questionPanel4.setQuestionLabel(3, "Seu estilo de trabalho aproxima-se mais de picos de energia aleat�rios do que uma abordagem met�dica e organizada.");
		questionPanel4.setQuestionLabel(4, "Geralmente, voc� tem inveja dos outros.");
		questionPanel4.setQuestionLabel(5, "Um livro ou um v�deo game interessante � frequentemente melhor que um evento social.");
		questionPanel4.setQuestionLabel(6, "Ser capaz de desenvolver um plano e manter-se firme na sua execu��o � a parte mais importante de todo projeto.");
		
		QuestionPanelSub questionPanel5 = new QuestionPanelSub(this);
		questionPanel5.setData(dataToPredict);
		questionPanel5.setIndex(4);
		questionPanelsPane.add("Questions5", questionPanel5);
		questionPanel5.setQuestionLabel(1, "Voc� raramente se deixa levar por fantasias e ideias.");
		questionPanel5.setQuestionLabel(2, "Voc� se v� frequentemente perdido em seus pensamentos quando est� em contato com a natureza.");
		questionPanel5.setQuestionLabel(3, "Se algu�m n�o responde ao seu e-mail rapidamente, voc� come�a a se preocupar se disse alguma coisa errada.");
		questionPanel5.setQuestionLabel(4, "Como pai/m�e, preferiria de ver seu/sua filho(a) crescer bondoso(a) do que inteligente.");
		questionPanel5.setQuestionLabel(5, "Voc� n�o deixa outras pessoas influenciarem suas a��es.");
		questionPanel5.setQuestionLabel(6, "Seus sonhos t�m a tend�ncia de se concentrar no mundo real e seus eventos.");
		
		QuestionPanelSub questionPanel6 = new QuestionPanelSub(this);
		questionPanel6.setData(dataToPredict);
		questionPanel6.setIndex(5);
		questionPanelsPane.add("Questions6", questionPanel6);
		questionPanel6.setQuestionLabel(1, "N�o leva muito tempo para voc� come�ar a se envolver em atividades sociais em seu novo local de trabalho.");
		questionPanel6.setQuestionLabel(2, "Voc� � mais um improvisador nato do que um planejador cuidadoso.");
		questionPanel6.setQuestionLabel(3, "Suas emo��es o controlam mais do que voc� as controla.");
		questionPanel6.setQuestionLabel(4, "Voc� aprecia ir a eventos sociais que envolvem o uso de fantasias ou encena��o.");
		questionPanel6.setQuestionLabel(5, "Voc� frequentemente despende tempo explorando ideias irrealistas e impratic�veis, ainda que intrigantes.");
		questionPanel6.setQuestionLabel(6, "Voc� prefere improvisar do que despender tempo para criar um plano detalhado.");
		
		QuestionPanelSub questionPanel7 = new QuestionPanelSub(this);
		questionPanel7.setData(dataToPredict);
		questionPanel7.setIndex(6);
		questionPanelsPane.add("Questions7", questionPanel7);
		questionPanel7.setQuestionLabel(1, "Voc� � uma pessoa relativamente reservada e sossegada.");
		questionPanel7.setQuestionLabel(2, "Se voc� tivesse uma empresa, acharia muito dif�cil demitir funcion�rios leais mas com baixo desempenho.");
		questionPanel7.setQuestionLabel(3, "Voc� frequentemente contempla as raz�es da exist�ncia humana.");
		questionPanel7.setQuestionLabel(4, "A l�gica � geralmente mais importante que o cora��o na hora de se tomar decis�es importantes.");
		questionPanel7.setQuestionLabel(5, "Manter suas op��es em aberto � mais importante do que manter uma lista de afazeres.");
		questionPanel7.setQuestionLabel(6, "Se seu amigo est� triste por algum motivo, � mais prov�vel que voc� ofere�a apoio emocional do que sugest�es para enfrentar o problema.");
		
		QuestionPanelSub questionPanel8 = new QuestionPanelSub(this);
		questionPanel8.setData(dataToPredict);
		questionPanel8.setIndex(7);
		questionPanelsPane.add("Questions8", questionPanel8);
		questionPanel8.setQuestionLabel(1, "Voc� raramente se sente inseguro.");
		questionPanel8.setQuestionLabel(2, "Voc� n�o tem dificuldades em criar um cronograma pessoal e em segui-lo.");
		questionPanel8.setQuestionLabel(3, "Estar certo � mais importante do que ser cooperativo, quando se trata de trabalho em equipe.");
		questionPanel8.setQuestionLabel(4, "Voc� acha que a vis�o de todos deve ser respeitada, independentemente de ser ou n�o baseada em fatos.");
		questionPanel8.setQuestionLabel(5, "Voc� se sente com mais energia ap�s despender tempo com um grupo de pessoas.");
		questionPanel8.setQuestionLabel(6, "Voc� perde suas coisas com frequ�ncia.");
		
		QuestionPanelSub questionPanel9 = new QuestionPanelSub(this);
		questionPanel9.setData(dataToPredict);
		questionPanel9.setIndex(8);
		questionPanelsPane.add("Questions9", questionPanel9);
		questionPanel9.setQuestionLabel(1, "Voc� se v� como muito est�vel emocionalmente.");
		questionPanel9.setQuestionLabel(2, "Sua mente est� sempre trabalhando com ideias e planos inexplorados.");
		questionPanel9.setQuestionLabel(3, "Voc� n�o se chamaria de sonhador.");
		questionPanel9.setQuestionLabel(4, "Voc� geralmente acha dif�cil relaxar ao se dirigir para muitas pessoas.");
		questionPanel9.setQuestionLabel(5, "Falando de modo geral, voc� confia mais em sua experi�ncia do que em sua imagina��o.");
		questionPanel9.setQuestionLabel(6, "Voc� se preocupa demais com o que as outras pessoas pensam.");
		
		QuestionPanelSub questionPanel10 = new QuestionPanelSub(this);
		questionPanel10.setData(dataToPredict);
		questionPanel10.setIsLastPanel(true);
		questionPanel10.setIndex(9);
		questionPanelsPane.add("Questions10", questionPanel10);
		questionPanel10.setQuestionLabel(1, "Se o ambiente est� lotado, voc� fica perto das paredes, evitando o centro.");
		questionPanel10.setQuestionLabel(2, "Voc� tem uma tend�ncia a procrastinar at� n�o haver mais tempo para fazer tudo.");
		questionPanel10.setQuestionLabel(3, "Voc� se sente muito ansioso em situa��es de estresse.");
		questionPanel10.setQuestionLabel(4, "Voc� acredita que � mais recompensador ser querido pelos outros do que poderoso.");
		questionPanel10.setQuestionLabel(5, "Voc� sempre foi interessado em coisas n�o convencionais e amb�guas, por ex., em livros, arte ou filmes.");
		questionPanel10.setQuestionLabel(6, "Voc� frequentemente toma a iniciativa em situa��es sociais.");
	}
	
	private void checkNumberOfPages() {
		if (this.numberOfQuestionForms != questionPanelsPane.getComponentCount()) {
			JOptionPane.showMessageDialog(this, "N�mero de p�ginas criadas n�o est� consistente com a defini��o da aplica��o.",
				    "Aten��o", JOptionPane.ERROR_MESSAGE);
			throw new UnsupportedOperationException("The number of pages configured doesnt match the configured");
		}
	}
	
	protected void startTest() {
		if (application.getOperationMode() instanceof  machineLearning.Learn ) {
			if (application.train()) {
				Classify classify = new Classify();
				classify.setClassifier((application.getOperationMode().getClassifier()));
				application.setOperationMode(classify);
			}
		} 

	    mainPanel.setVisible(false);
	    questionPanelsPane.setVisible(true);				
	}
		
	public void setInstructions(String text) {
		intructions.setText(text);		
	}
	
	public void setTitle(String text) {
		title.setText(text);		
	}
	
	public void finish() {
		double prediction = application.classify(dataToPredict);
		setFinishMessage(prediction);
	}

	private void setFinishMessage(double prediction) {
		String profile;
		
		switch( (int) prediction) {
		case 0: 
			profile = "Analista";
			break;
		case 1: ;
			profile = "Diplomata";
			break;
		case 2: ;
			profile = "Sentinela";
			break;
		case 3: 
			profile = "Explorador";
			break;
		default: profile = "Desconhecido";
		}
		JOptionPane.showMessageDialog(this, "Seu perfil psicol�gico foi identificado como: " + profile,
			    "Resultado!", JOptionPane.INFORMATION_MESSAGE);
	}
		
}