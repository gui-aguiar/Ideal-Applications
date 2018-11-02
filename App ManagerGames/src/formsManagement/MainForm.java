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
		this.setInstructions("Instruções: De acordo com o cenário que foi apresentado pelo professor, você deve preencher os seguintes item de cada página com a quantidade de capital a ser investido. Cada item mostra o valor acumulado até então, sendo que o total não deverá exceder o valor estipulado pelo cenário. Os valores estão sendo considerados em mil reais.");
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
		questionPanel1.setQuestionLabel(1, "Melhorar o desempenho operacional implica em buscar meios/processos mais eficazes, ou seja, é o aumento da produtividade, que resulta em melhor aplicação dos recursos disponíveis.");
		questionPanel1.setQuestionLabel(2, "Verificações de desempenho buscam aprimorar processos e resultados e auxiliam na diversificação das atividades de execução. Isso ocorre por que com um bom desempenho operacional a produção está bem organizada e engajada atendendo as variações de ");
		questionPanel1.setQuestionLabel(3, "O bom desempenho operacional possibilita melhores resultados sobre produtos, processos e prazos. Obtidos através da avaliação dos processos vigentes e garantindo agilidade.");
		questionPanel1.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel2 = new QuestionPanelSub(this);
		questionPanel2.setData(dataToPredict);
		questionPanel1.setIndex(1);
		questionPanelsPane.add("Questions2", questionPanel2);
		questionPanel2.setTitle("Desenvolvimento de Novos Produtos");
		questionPanel2.setQuestionLabel(1, "Produtos e processos inovadores, apesar de geralmente terem alto investimento inicial, tendem a reduzir os custos operacionais a médio e longo prazo");
		questionPanel2.setQuestionLabel(2, "O desenvolvimento de novos produtos e processos aumenta o leque de possibilidades de atendimento das diferentes necessidades da organização e dos consumidores");
		questionPanel2.setQuestionLabel(3, "O desenvolvimento de novos produtos tem relação com facilidades no processo, produtos determinantes na construção da imagem da organização, e melhoria da qualidade do produto");
		questionPanel2.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel3 = new QuestionPanelSub(this);
		questionPanel3.setData(dataToPredict);
		questionPanel1.setIndex(2);
		questionPanelsPane.add("Questions3", questionPanel3);
		questionPanel3.setTitle("Equipamentos e Tecnologia");
		questionPanel3.setQuestionLabel(1, "Investimentos em equipamentos e tecnologias, apesar de inicialmente serem onerosos, levam a uma redução de custos no decorrer dos processos produtivos");
		questionPanel3.setQuestionLabel(2, "Inovações tecnológicas melhoram processos de produção. Equipamentos multifuncionais e equipes treinadas para o uso destas tornam-se capazes de atender diferentes demandas");
		questionPanel3.setQuestionLabel(3, "As pessoas raramente conseguem aborrecê-lo.A organização deve dispor de equipamentos e tecnologias que apresentem um bom desempenho, ou seja, confiáveis.  O que permite estabilidade e qualidade no processo produtivo. E ainda, agilidade na execução das tarefas, tornando-as mais rápidas");
		questionPanel3.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel4 = new QuestionPanelSub(this);
		questionPanel4.setData(dataToPredict);
		questionPanel1.setIndex(3);
		questionPanelsPane.add("Questions4", questionPanel4);
		questionPanel4.setTitle("Fábrica");
		questionPanel4.setQuestionLabel(1, "Em uma discussão, a verdade deve ser mais importante que a sensibilidade das pessoas.A manutenção constante de equipamentos, logística interna e externa da organização, permite a prevenção de situações adversas, evitando gastos desnecessários e não esperados");
		questionPanel4.setQuestionLabel(2, "A adequada distribuição de equipamentos e layout flexível permitem fácil adaptação às necessidades encontradas durante a produção");
		questionPanel4.setQuestionLabel(3, "Ambientes adequados colaboram para a produção, a boa localização, manutenção e layout influenciam o processo garantindo rapidez e qualidade tanto na produção quanto no atendimento do cliente");
		questionPanel4.setTotalAmount(totalAmount);
	
		QuestionPanelSub questionPanel5 = new QuestionPanelSub(this);
		questionPanel5.setData(dataToPredict);
		questionPanel1.setIndex(4);
		questionPanelsPane.add("Questions5", questionPanel5);
		questionPanel5.setTitle("Gestão Ambiental");
		questionPanel5.setQuestionLabel(1, "A busca por processos produtivos limpos leva à redução do desperdício e ao tratamento adequado dos resíduos, podendo reduzir custos.");
		questionPanel5.setQuestionLabel(2, "A política de gestão ambiental adotada na empresa se mostra presente na concepção de produtos e processos. A equipe e os equipamentos devem ser flexíveis quanto à introdução de novos conceitos ambientais.");
		questionPanel5.setQuestionLabel(3, "A estrutura da empresa deve ser segura e confiável para investigar e minimizar potenciais acidentes causadores de danos ambientais. Para tanto, deve haver treinamento e melhoria constante dos processos a fim de contribuir para o meio ambiente.");
		questionPanel5.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel6 = new QuestionPanelSub(this);
		questionPanel6.setData(dataToPredict);
		questionPanel1.setIndex(5);
		questionPanelsPane.add("Questions6", questionPanel6);
		questionPanel6.setTitle("Investimentos");
		questionPanel6.setQuestionLabel(1, "O investimento em treinamento e a aquisição de novos equipamentos são, inicialmente, onerosos para a organização, mas, com o tempo, passam a gerar menores custos.");
		questionPanel6.setQuestionLabel(2, "A solução de imprevistos e mudanças repentinas podem ser solucionadas com investimento em equipamentos e colaboradores multifuncionais.");
		questionPanel6.setQuestionLabel(3, "Investimentos em bons equipamentos e no desenvolvimento dos colaboradores permitem desempenhos produtivos apropriados, aprimoram tarefas, melhorando a qualidade total da organização e acelerando o processo produtivo.");
		questionPanel6.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel7 = new QuestionPanelSub(this);
		questionPanel7.setData(dataToPredict);
		questionPanel1.setIndex(6);
		questionPanelsPane.add("Questions7", questionPanel7);
		questionPanel7.setTitle("Organização e cultura");
		questionPanel7.setQuestionLabel(1, "Culturas que incorporam o conceito lean transmitem valores que levam ao comprometimento dos colaboradores, fazendo com que eles sintam-se responsáveis pelos resultados, utilizando os recursos de forma mais consciente.");
		questionPanel7.setQuestionLabel(2, "Uma cultura que valoriza a multifuncionalidade organizacional permite que a organização esteja apta a atender demandas variadas.");
		questionPanel7.setQuestionLabel(3, "través da cultura organizacional transmite-se aos colaboradores e aos clientes potenciais valores da organização. O que contribui aos aspectos de confiabilidade e eficiência e agilidade no processo ao constatarem e absorver as técnicas e atividades adequadas a serem utilizadas.");
		questionPanel7.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel8 = new QuestionPanelSub(this);
		questionPanel8.setData(dataToPredict);
		questionPanel1.setIndex(7);
		questionPanelsPane.add("Questions8", questionPanel8);
		questionPanel8.setTitle("PCP");
		questionPanel8.setQuestionLabel(1, "O PCP permite o acompanhamento adequado da utilização dos recursos, fazendo com que recursos sejam aproveitados de maneira racional, evitando desperdícios e reduzindo os custos operacionais. E ainda buscando o aumento da produtividade tornando o processo menos custosoVocê raramente se sente inseguro.");
		questionPanel8.setQuestionLabel(2, "Por meio do PCP criam-se facilidades para alterações demandadas do sistema de produção. Analisa-se o ambiente interno e externo e procura-se ajustar a organização de forma a atender as diversas demandas existentes. Considera-se as diferentes demandas possibilitando um processo produtivo flexível");
		questionPanel8.setQuestionLabel(3, "Fazem com que a organização ajuste sua produção por meio de planos operacionais que permitem maior previsibilidade do processo produtivo; do controle que permite que a organização tenha informações constantes a respeito do desenvolvimento de produtos; e da programação da produção que organiza as operações em uma sequência ótima.");
		questionPanel8.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel9 = new QuestionPanelSub(this);
		questionPanel9.setData(dataToPredict);
		questionPanel1.setIndex(8);
		questionPanelsPane.add("Questions9", questionPanel9);
		questionPanel9.setTitle("Saúde e Segurança");
		questionPanel9.setQuestionLabel(1, "Processos produtivos seguros reduzem o número de acidentes de trabalho, refletindo em baixos níveis de paradas e absenteísmo e, conseqüentemente, melhor utilização dos recursos.");
		questionPanel9.setQuestionLabel(2, "Sua mente está sempre trabalhando com ideias e planos inexplorados.A organização do ambiente de trabalho e as condições salutares e de segurança tendem a conferir satisfação no trabalho. Isto leva a redução do absenteísmo mantendo as equipes mais completas e as habilidades disponíveis contribuindo assim para a flexibilidade do sistema de produção.");
		questionPanel9.setQuestionLabel(3, "Você não se chamaria de sonhadorO cuidado com a saúde e segurança dos profissionais propicia um ambiente produtivo estável, influenciando positivamente na motivação do trabalhador, propiciando condições para melhores resultados na produção.");
		questionPanel9.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel10 = new QuestionPanelSub(this);
		questionPanel10.setData(dataToPredict);
		questionPanel1.setIndex(9);
		questionPanelsPane.add("Questions10", questionPanel10);
		questionPanel10.setTitle("Tempo de ciclo");
		questionPanel10.setQuestionLabel(1, "Tempos de Ciclo curtos levam a redução de custos à medida que mais clientes podem ser atendidos com os mesmos recursos, bem como a diluição dos custos fixos.");
		questionPanel10.setQuestionLabel(2, "O conhecimento e o domínio dos tempos de ciclo e das tarefas que o compõe permite a manipulação confiável dos processos; isto confere a possibilidade de alterações confíáveis na programação; permite a introdução de novos produtos ou alteração nos processos em andamento, de forma rápida e precisa.");
		questionPanel10.setQuestionLabel(3, "Sua eficiência é garantida através do acoplamento das etapas, conhecimento (domínio) dos tempos de ciclo no decorrer do processo, acompanhamento do ciclo completo, garantindo um processo produtivo rápido (Tempos de Ciclo curtos) ou a padrões de tempo entendidos como adequados.");
		questionPanel10.setTotalAmount(totalAmount);
		
		QuestionPanelSub questionPanel11 = new QuestionPanelSub(this);
		questionPanel11.setData(dataToPredict);
		questionPanel1.setIndex(10);
		questionPanel11.setIsLastPanel(true);
		questionPanelsPane.add("Questions11", questionPanel11);
		questionPanel11.setTitle("Qualidade");
		questionPanel11.setQuestionLabel(1, "A não qualidade acarreta danos à imagem da organização. Refugo e retrabalho implicam em maiores gastos com materiais desperdiçados e horas trabalhadas, ou conversão em produtos de valor inferior");
		questionPanel11.setQuestionLabel(2, "Bons projetos de bens e serviços, equipamentos flexíveis, informações prontamente disponíveis e pessoas treinadas em suas funções e nas técnicas de qualidade, levam à facilidade nas alterações dos resultados demandados pelo mercado");
		questionPanel11.setQuestionLabel(3, "Bens e serviços são produzidos de acordo com os preceitos da Qualidade Total o que leva a resultados superiores tornando o resultado mais rapidamente disponível.");
		questionPanel11.setTotalAmount(totalAmount);
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
		JOptionPane.showMessageDialog(this, "Seu pontuação é: " + Integer.toString((int) prediction),
			"Resultado!", JOptionPane.INFORMATION_MESSAGE);
	}	
		
}