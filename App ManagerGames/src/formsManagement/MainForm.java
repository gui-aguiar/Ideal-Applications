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
	double totalAmount = 100;
	
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
		this.setNumberOfQuestionForms(11);
		this.setNumberOfQuestions(33);
		dataToPredict = new double[this.getNumberOfQuestions()];
	}

	private void setFormInfo() {
		this.setTitle("Jogo para gestores");
		this.setInstructions("Instru��es: De acordo com o cen�rio que foi apresentado pelo professor, voc� deve preencher os seguintes item de cada p�gina com a quantidade de capital a ser investido. Cada item mostra o valor acumulado at� ent�o, sendo que o total n�o dever� exceder o valor estipulado pelo cen�rio. Os valores est�o sendo considerados em mil reais.");
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
		questionPanel1.setTitle("Desempenho operacional");
		questionPanel1.setQuestionLabel(1, "Melhorar o desempenho operacional implica em buscar meios/processos mais eficazes, ou seja, � o aumento da produtividade, que resulta em melhor aplica��o dos recursos dispon�veis.");
		questionPanel1.setQuestionLabel(2, "Verifica��es de desempenho buscam aprimorar processos e resultados e auxiliam na diversifica��o das atividades de execu��o. Isso ocorre por que com um bom desempenho operacional a produ��o est� bem organizada e engajada atendendo as varia��es de ");
		questionPanel1.setQuestionLabel(3, "O bom desempenho operacional possibilita melhores resultados sobre produtos, processos e prazos. Obtidos atrav�s da avalia��o dos processos vigentes e garantindo agilidade.");
		questionPanel1.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel2 = new QuestionPanelSub(this);
		questionPanel2.setData(dataToPredict);
		questionPanel1.setIndex(1);
		questionPanelsPane.add("Questions2", questionPanel2);
		questionPanel2.setTitle("Desenvolvimento de Novos Produtos");
		questionPanel2.setQuestionLabel(1, "Produtos e processos inovadores, apesar de geralmente terem alto investimento inicial, tendem a reduzir os custos operacionais a m�dio e longo prazo");
		questionPanel2.setQuestionLabel(2, "O desenvolvimento de novos produtos e processos aumenta o leque de possibilidades de atendimento das diferentes necessidades da organiza��o e dos consumidores");
		questionPanel2.setQuestionLabel(3, "O desenvolvimento de novos produtos tem rela��o com facilidades no processo, produtos determinantes na constru��o da imagem da organiza��o, e melhoria da qualidade do produto");
		questionPanel2.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel3 = new QuestionPanelSub(this);
		questionPanel3.setData(dataToPredict);
		questionPanel1.setIndex(2);
		questionPanelsPane.add("Questions3", questionPanel3);
		questionPanel3.setTitle("Equipamentos e Tecnologia");
		questionPanel3.setQuestionLabel(1, "Investimentos em equipamentos e tecnologias, apesar de inicialmente serem onerosos, levam a uma redu��o de custos no decorrer dos processos produtivos");
		questionPanel3.setQuestionLabel(2, "Inova��es tecnol�gicas melhoram processos de produ��o. Equipamentos multifuncionais e equipes treinadas para o uso destas tornam-se capazes de atender diferentes demandas");
		questionPanel3.setQuestionLabel(3, "As pessoas raramente conseguem aborrec�-lo.A organiza��o deve dispor de equipamentos e tecnologias que apresentem um bom desempenho, ou seja, confi�veis.  O que permite estabilidade e qualidade no processo produtivo. E ainda, agilidade na execu��o das tarefas, tornando-as mais r�pidas");
		questionPanel3.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel4 = new QuestionPanelSub(this);
		questionPanel4.setData(dataToPredict);
		questionPanel1.setIndex(3);
		questionPanelsPane.add("Questions4", questionPanel4);
		questionPanel4.setTitle("F�brica");
		questionPanel4.setQuestionLabel(1, "Em uma discuss�o, a verdade deve ser mais importante que a sensibilidade das pessoas.A manuten��o constante de equipamentos, log�stica interna e externa da organiza��o, permite a preven��o de situa��es adversas, evitando gastos desnecess�rios e n�o esperados");
		questionPanel4.setQuestionLabel(2, "A adequada distribui��o de equipamentos e layout flex�vel permitem f�cil adapta��o �s necessidades encontradas durante a produ��o");
		questionPanel4.setQuestionLabel(3, "Ambientes adequados colaboram para a produ��o, a boa localiza��o, manuten��o e layout influenciam o processo garantindo rapidez e qualidade tanto na produ��o quanto no atendimento do cliente");
		questionPanel4.setTotalAmount(totalAmount);
	
		QuestionPanelSub questionPanel5 = new QuestionPanelSub(this);
		questionPanel5.setData(dataToPredict);
		questionPanel1.setIndex(4);
		questionPanelsPane.add("Questions5", questionPanel5);
		questionPanel5.setTitle("Gest�o Ambiental");
		questionPanel5.setQuestionLabel(1, "A busca por processos produtivos limpos leva � redu��o do desperd�cio e ao tratamento adequado dos res�duos, podendo reduzir custos.");
		questionPanel5.setQuestionLabel(2, "A pol�tica de gest�o ambiental adotada na empresa se mostra presente na concep��o de produtos e processos. A equipe e os equipamentos devem ser flex�veis quanto � introdu��o de novos conceitos ambientais.");
		questionPanel5.setQuestionLabel(3, "A estrutura da empresa deve ser segura e confi�vel para investigar e minimizar potenciais acidentes causadores de danos ambientais. Para tanto, deve haver treinamento e melhoria constante dos processos a fim de contribuir para o meio ambiente.");
		questionPanel5.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel6 = new QuestionPanelSub(this);
		questionPanel6.setData(dataToPredict);
		questionPanel1.setIndex(5);
		questionPanelsPane.add("Questions6", questionPanel6);
		questionPanel6.setTitle("Investimentos");
		questionPanel6.setQuestionLabel(1, "O investimento em treinamento e a aquisi��o de novos equipamentos s�o, inicialmente, onerosos para a organiza��o, mas, com o tempo, passam a gerar menores custos.");
		questionPanel6.setQuestionLabel(2, "A solu��o de imprevistos e mudan�as repentinas podem ser solucionadas com investimento em equipamentos e colaboradores multifuncionais.");
		questionPanel6.setQuestionLabel(3, "Investimentos em bons equipamentos e no desenvolvimento dos colaboradores permitem desempenhos produtivos apropriados, aprimoram tarefas, melhorando a qualidade total da organiza��o e acelerando o processo produtivo.");
		questionPanel6.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel7 = new QuestionPanelSub(this);
		questionPanel7.setData(dataToPredict);
		questionPanel1.setIndex(6);
		questionPanelsPane.add("Questions7", questionPanel7);
		questionPanel7.setTitle("Organiza��o e cultura");
		questionPanel7.setQuestionLabel(1, "Culturas que incorporam o conceito lean transmitem valores que levam ao comprometimento dos colaboradores, fazendo com que eles sintam-se respons�veis pelos resultados, utilizando os recursos de forma mais consciente.");
		questionPanel7.setQuestionLabel(2, "Uma cultura que valoriza a multifuncionalidade organizacional permite que a organiza��o esteja apta a atender demandas variadas.");
		questionPanel7.setQuestionLabel(3, "trav�s da cultura organizacional transmite-se aos colaboradores e aos clientes potenciais valores da organiza��o. O que contribui aos aspectos de confiabilidade e efici�ncia e agilidade no processo ao constatarem e absorver as t�cnicas e atividades adequadas a serem utilizadas.");
		questionPanel7.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel8 = new QuestionPanelSub(this);
		questionPanel8.setData(dataToPredict);
		questionPanel1.setIndex(7);
		questionPanelsPane.add("Questions8", questionPanel8);
		questionPanel8.setTitle("PCP");
		questionPanel8.setQuestionLabel(1, "O PCP permite o acompanhamento adequado da utiliza��o dos recursos, fazendo com que recursos sejam aproveitados de maneira racional, evitando desperd�cios e reduzindo os custos operacionais. E ainda buscando o aumento da produtividade tornando o processo menos custosoVoc� raramente se sente inseguro.");
		questionPanel8.setQuestionLabel(2, "Por meio do PCP criam-se facilidades para altera��es demandadas do sistema de produ��o. Analisa-se o ambiente interno e externo e procura-se ajustar a organiza��o de forma a atender as diversas demandas existentes. Considera-se as diferentes demandas possibilitando um processo produtivo flex�vel");
		questionPanel8.setQuestionLabel(3, "Fazem com que a organiza��o ajuste sua produ��o por meio de planos operacionais que permitem maior previsibilidade do processo produtivo; do controle que permite que a organiza��o tenha informa��es constantes a respeito do desenvolvimento de produtos; e da programa��o da produ��o que organiza as opera��es em uma sequ�ncia �tima.");
		questionPanel8.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel9 = new QuestionPanelSub(this);
		questionPanel9.setData(dataToPredict);
		questionPanel1.setIndex(8);
		questionPanelsPane.add("Questions9", questionPanel9);
		questionPanel9.setTitle("Sa�de e Seguran�a");
		questionPanel9.setQuestionLabel(1, "Processos produtivos seguros reduzem o n�mero de acidentes de trabalho, refletindo em baixos n�veis de paradas e absente�smo e, conseq�entemente, melhor utiliza��o dos recursos.");
		questionPanel9.setQuestionLabel(2, "Sua mente est� sempre trabalhando com ideias e planos inexplorados.A organiza��o do ambiente de trabalho e as condi��es salutares e de seguran�a tendem a conferir satisfa��o no trabalho. Isto leva a redu��o do absente�smo mantendo as equipes mais completas e as habilidades dispon�veis contribuindo assim para a flexibilidade do sistema de produ��o.");
		questionPanel9.setQuestionLabel(3, "Voc� n�o se chamaria de sonhadorO cuidado com a sa�de e seguran�a dos profissionais propicia um ambiente produtivo est�vel, influenciando positivamente na motiva��o do trabalhador, propiciando condi��es para melhores resultados na produ��o.");
		questionPanel9.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel10 = new QuestionPanelSub(this);
		questionPanel10.setData(dataToPredict);
		questionPanel1.setIndex(9);
		questionPanelsPane.add("Questions10", questionPanel10);
		questionPanel10.setTitle("Tempo de ciclo");
		questionPanel10.setQuestionLabel(1, "Tempos de Ciclo curtos levam a redu��o de custos � medida que mais clientes podem ser atendidos com os mesmos recursos, bem como a dilui��o dos custos fixos.");
		questionPanel10.setQuestionLabel(2, "O conhecimento e o dom�nio dos tempos de ciclo e das tarefas que o comp�e permite a manipula��o confi�vel dos processos; isto confere a possibilidade de altera��es conf��veis na programa��o; permite a introdu��o de novos produtos ou altera��o nos processos em andamento, de forma r�pida e precisa.");
		questionPanel10.setQuestionLabel(3, "Sua efici�ncia � garantida atrav�s do acoplamento das etapas, conhecimento (dom�nio) dos tempos de ciclo no decorrer do processo, acompanhamento do ciclo completo, garantindo um processo produtivo r�pido (Tempos de Ciclo curtos) ou a padr�es de tempo entendidos como adequados.");
		questionPanel10.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel11 = new QuestionPanelSub(this);
		questionPanel11.setData(dataToPredict);
		questionPanel1.setIndex(10);
		questionPanel11.setIsLastPanel(true);
		questionPanelsPane.add("Questions11", questionPanel11);
		questionPanel11.setTitle("Qualidade");
		questionPanel11.setQuestionLabel(1, "A n�o qualidade acarreta danos � imagem da organiza��o. Refugo e retrabalho implicam em maiores gastos com materiais desperdi�ados e horas trabalhadas, ou convers�o em produtos de valor inferior");
		questionPanel11.setQuestionLabel(2, "Bons projetos de bens e servi�os, equipamentos flex�veis, informa��es prontamente dispon�veis e pessoas treinadas em suas fun��es e nas t�cnicas de qualidade, levam � facilidade nas altera��es dos resultados demandados pelo mercado");
		questionPanel11.setQuestionLabel(3, "Bens e servi�os s�o produzidos de acordo com os preceitos da Qualidade Total o que leva a resultados superiores tornando o resultado mais rapidamente dispon�vel.");
		questionPanel11.setTotalAmount(totalAmount);
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
		JOptionPane.showMessageDialog(this, "Seu pontua��o �: " + Integer.toString((int) prediction),
			"Resultado!", JOptionPane.INFORMATION_MESSAGE);
	}	
		
}