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
		this.setInstructions("Instruções: as seguintes afirma\u00E7\u00F5es dizem respeito \u00E0 sua percep\u00E7\u00E3o sobre voc\u00EA em uma variedade de situa\u00E7\u00F5es. Sua tarefa \u00E9 indicar a for\u00E7a do seu acordo com cada afirma\u00E7\u00E3o, utilizando uma escala em que 1 denota forte desacordo, 5 denota forte concord\u00E2ncia e 2, 3 e 4 representam julgamentos interm\u00E9dios. Nas caixas ap\u00F3s cada declara\u00E7\u00E3o, clique em um n\u00FAmero de 1 a 5 da seguinte escala:\r\n\r\n        Discordo fortemente\r\n        Discordar\r\n        Nem discorda nem concorda\r\n        Aceita\r\n        Concordo plenamente \r\n\r\nN\u00E3o h\u00E1 respostas \"corretas\" ou \"erradas\", ent\u00E3o selecione o n\u00FAmero que mais reflete em cada declara\u00E7\u00E3o. Tome seu tempo e considere cada declara\u00E7\u00E3o com cuidado. Depois de concluir todas as perguntas, clique em \"Enviar\" na parte inferior.");
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
		questionPanel1.setQuestionLabel(1, "Você acha difícil se apresentar para outras pessoas.");
		questionPanel1.setQuestionLabel(2, "Você fica frequentemente tão absorto em seus pensamentos que ignora ou esquece do seu entorno.");
		questionPanel1.setQuestionLabel(3, "Você tenta responder aos seus e-mails o mais rapidamente possível e não suporta uma caixa de entrada bagunçada.");
		questionPanel1.setQuestionLabel(4, "Você permanece relaxado e concentrado mesmo sob pressão.");
		questionPanel1.setQuestionLabel(5, "Geralmente, você não inicia conversas.");
		questionPanel1.setQuestionLabel(6, "Você raramente faz alguma coisa por pura curiosidade.");
		
		QuestionPanelSub questionPanel2 = new QuestionPanelSub(this);
		questionPanel2.setData(dataToPredict);
		questionPanel2.setIndex(1);
		questionPanelsPane.add("Questions2", questionPanel2);
		questionPanel2.setQuestionLabel(1, "Você se sente superior às outras pessoas.");
		questionPanel2.setQuestionLabel(2, "Ser organizado é mais importante para você do que ser adaptável.");
		questionPanel2.setQuestionLabel(3, "Você é geralmente muito motivado e cheio de energia.");
		questionPanel2.setQuestionLabel(4, "Vencer um debate significa menos para você do que assegurar que ninguém fique aborrecido.");
		questionPanel2.setQuestionLabel(5, "Você frequentemente sente que tem que se justificar para outras pessoas.");
		questionPanel2.setQuestionLabel(6, "Seus ambientes doméstico e de trabalho são bem organizados.");
		
		QuestionPanelSub questionPanel3 = new QuestionPanelSub(this);
		questionPanel3.setData(dataToPredict);
		questionPanel3.setIndex(2);
		questionPanelsPane.add("Questions3", questionPanel3);
		questionPanel3.setQuestionLabel(1, "Você não se importa em ser o centro das atenções.");
		questionPanel3.setQuestionLabel(2, "Você se considera mais prático do que criativo.");
		questionPanel3.setQuestionLabel(3, "As pessoas raramente conseguem aborrecê-lo.");
		questionPanel3.setQuestionLabel(4, "Seus planos de viagem são geralmente bem pensados.");
		questionPanel3.setQuestionLabel(5, "Frequentemente, é difícil para você se relacionar com os sentimentos das outras pessoas.");
		questionPanel3.setQuestionLabel(6, "Seu humor pode mudar muito rapidamente.");
		
		QuestionPanelSub questionPanel4 = new QuestionPanelSub(this);
		questionPanel4.setData(dataToPredict);
		questionPanel4.setIndex(3);
		questionPanelsPane.add("Questions4", questionPanel4);
		questionPanel4.setQuestionLabel(1, "Em uma discussão, a verdade deve ser mais importante que a sensibilidade das pessoas.");
		questionPanel4.setQuestionLabel(2, "Você raramente se preocupa em como suas ações afetam as outras pessoas.");
		questionPanel4.setQuestionLabel(3, "Seu estilo de trabalho aproxima-se mais de picos de energia aleatórios do que uma abordagem metódica e organizada.");
		questionPanel4.setQuestionLabel(4, "Geralmente, você tem inveja dos outros.");
		questionPanel4.setQuestionLabel(5, "Um livro ou um vídeo game interessante é frequentemente melhor que um evento social.");
		questionPanel4.setQuestionLabel(6, "Ser capaz de desenvolver um plano e manter-se firme na sua execução é a parte mais importante de todo projeto.");
		
		QuestionPanelSub questionPanel5 = new QuestionPanelSub(this);
		questionPanel5.setData(dataToPredict);
		questionPanel5.setIndex(4);
		questionPanelsPane.add("Questions5", questionPanel5);
		questionPanel5.setQuestionLabel(1, "Você raramente se deixa levar por fantasias e ideias.");
		questionPanel5.setQuestionLabel(2, "Você se vê frequentemente perdido em seus pensamentos quando está em contato com a natureza.");
		questionPanel5.setQuestionLabel(3, "Se alguém não responde ao seu e-mail rapidamente, você começa a se preocupar se disse alguma coisa errada.");
		questionPanel5.setQuestionLabel(4, "Como pai/mãe, preferiria de ver seu/sua filho(a) crescer bondoso(a) do que inteligente.");
		questionPanel5.setQuestionLabel(5, "Você não deixa outras pessoas influenciarem suas ações.");
		questionPanel5.setQuestionLabel(6, "Seus sonhos têm a tendência de se concentrar no mundo real e seus eventos.");
		
		QuestionPanelSub questionPanel6 = new QuestionPanelSub(this);
		questionPanel6.setData(dataToPredict);
		questionPanel6.setIndex(5);
		questionPanelsPane.add("Questions6", questionPanel6);
		questionPanel6.setQuestionLabel(1, "Não leva muito tempo para você começar a se envolver em atividades sociais em seu novo local de trabalho.");
		questionPanel6.setQuestionLabel(2, "Você é mais um improvisador nato do que um planejador cuidadoso.");
		questionPanel6.setQuestionLabel(3, "Suas emoções o controlam mais do que você as controla.");
		questionPanel6.setQuestionLabel(4, "Você aprecia ir a eventos sociais que envolvem o uso de fantasias ou encenação.");
		questionPanel6.setQuestionLabel(5, "Você frequentemente despende tempo explorando ideias irrealistas e impraticáveis, ainda que intrigantes.");
		questionPanel6.setQuestionLabel(6, "Você prefere improvisar do que despender tempo para criar um plano detalhado.");
		
		QuestionPanelSub questionPanel7 = new QuestionPanelSub(this);
		questionPanel7.setData(dataToPredict);
		questionPanel7.setIndex(6);
		questionPanelsPane.add("Questions7", questionPanel7);
		questionPanel7.setQuestionLabel(1, "Você é uma pessoa relativamente reservada e sossegada.");
		questionPanel7.setQuestionLabel(2, "Se você tivesse uma empresa, acharia muito difícil demitir funcionários leais mas com baixo desempenho.");
		questionPanel7.setQuestionLabel(3, "Você frequentemente contempla as razões da existência humana.");
		questionPanel7.setQuestionLabel(4, "A lógica é geralmente mais importante que o coração na hora de se tomar decisões importantes.");
		questionPanel7.setQuestionLabel(5, "Manter suas opções em aberto é mais importante do que manter uma lista de afazeres.");
		questionPanel7.setQuestionLabel(6, "Se seu amigo está triste por algum motivo, é mais provável que você ofereça apoio emocional do que sugestões para enfrentar o problema.");
		
		QuestionPanelSub questionPanel8 = new QuestionPanelSub(this);
		questionPanel8.setData(dataToPredict);
		questionPanel8.setIndex(7);
		questionPanelsPane.add("Questions8", questionPanel8);
		questionPanel8.setQuestionLabel(1, "Você raramente se sente inseguro.");
		questionPanel8.setQuestionLabel(2, "Você não tem dificuldades em criar um cronograma pessoal e em segui-lo.");
		questionPanel8.setQuestionLabel(3, "Estar certo é mais importante do que ser cooperativo, quando se trata de trabalho em equipe.");
		questionPanel8.setQuestionLabel(4, "Você acha que a visão de todos deve ser respeitada, independentemente de ser ou não baseada em fatos.");
		questionPanel8.setQuestionLabel(5, "Você se sente com mais energia após despender tempo com um grupo de pessoas.");
		questionPanel8.setQuestionLabel(6, "Você perde suas coisas com frequência.");
		
		QuestionPanelSub questionPanel9 = new QuestionPanelSub(this);
		questionPanel9.setData(dataToPredict);
		questionPanel9.setIndex(8);
		questionPanelsPane.add("Questions9", questionPanel9);
		questionPanel9.setQuestionLabel(1, "Você se vê como muito estável emocionalmente.");
		questionPanel9.setQuestionLabel(2, "Sua mente está sempre trabalhando com ideias e planos inexplorados.");
		questionPanel9.setQuestionLabel(3, "Você não se chamaria de sonhador.");
		questionPanel9.setQuestionLabel(4, "Você geralmente acha difícil relaxar ao se dirigir para muitas pessoas.");
		questionPanel9.setQuestionLabel(5, "Falando de modo geral, você confia mais em sua experiência do que em sua imaginação.");
		questionPanel9.setQuestionLabel(6, "Você se preocupa demais com o que as outras pessoas pensam.");
		
		QuestionPanelSub questionPanel10 = new QuestionPanelSub(this);
		questionPanel10.setData(dataToPredict);
		questionPanel10.setIsLastPanel(true);
		questionPanel10.setIndex(9);
		questionPanelsPane.add("Questions10", questionPanel10);
		questionPanel10.setQuestionLabel(1, "Se o ambiente está lotado, você fica perto das paredes, evitando o centro.");
		questionPanel10.setQuestionLabel(2, "Você tem uma tendência a procrastinar até não haver mais tempo para fazer tudo.");
		questionPanel10.setQuestionLabel(3, "Você se sente muito ansioso em situações de estresse.");
		questionPanel10.setQuestionLabel(4, "Você acredita que é mais recompensador ser querido pelos outros do que poderoso.");
		questionPanel10.setQuestionLabel(5, "Você sempre foi interessado em coisas não convencionais e ambíguas, por ex., em livros, arte ou filmes.");
		questionPanel10.setQuestionLabel(6, "Você frequentemente toma a iniciativa em situações sociais.");
	}
	
	private void checkNumberOfPages() {
		if (this.numberOfQuestionForms != questionPanelsPane.getComponentCount()) {
			JOptionPane.showMessageDialog(this, "Número de páginas criadas não está consistente com a definição da aplicação.",
				    "Atenção", JOptionPane.ERROR_MESSAGE);
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
		JOptionPane.showMessageDialog(this, "Seu perfil psicológico foi identificado como: " + profile,
			    "Resultado!", JOptionPane.INFORMATION_MESSAGE);
	}
		
}