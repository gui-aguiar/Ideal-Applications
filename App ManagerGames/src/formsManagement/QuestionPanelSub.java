package formsManagement;

import javax.swing.JLabel;
import java.text.NumberFormat;
import java.text.ParseException;
import javax.swing.JTextArea;
import javax.swing.text.NumberFormatter;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.Font;

public class QuestionPanelSub extends QuestionPanel {
	
	private static final long serialVersionUID = 1L;
	private JTextArea txtrQuestion1;
	private JTextArea txtrQuestion2;
	private JTextArea txtrQuestion3;
	private JLabel title;
	private JFormattedTextField fttQuestion1;
	private JFormattedTextField fttQuestion2;
	private JFormattedTextField fttQuestion3;
	private JFormattedTextField fttAccQuestion1;
	private JFormattedTextField fttAccQuestion2;
	private JFormattedTextField fttAccQuestion3;
	
	public QuestionPanelSub(MainForm mainform) {
		this.mainForm = mainform;
		class ControlTextFieldsListenter implements DocumentListener {
            
			public void refreshValues() throws ParseException {	
				int value1 = 0, value2 = 0, value3 = 0;
				if (! fttQuestion1.getText().equals("") ) {					
					fttQuestion1.commitEdit();
					value1 = (int) fttQuestion1.getValue();
				}
				if (! fttQuestion2.getText().equals("") ) {					
					fttQuestion2.commitEdit();
					value2 = (int) fttQuestion2.getValue();
				}
				if (! fttQuestion3.getText().equals("") ) {					
					fttQuestion3.commitEdit();
					value3 = (int) fttQuestion3.getValue();
				}
				fttAccQuestion1.setText(Integer.toString(value1 + 0));
				fttAccQuestion2.setText(Integer.toString(value2 + value1));
				fttAccQuestion3.setText(Integer.toString(value3 + value2 + value1));
            }

			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					refreshValues();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					refreshValues();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					refreshValues();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
        }		
		ControlTextFieldsListenter controlTextFields = new ControlTextFieldsListenter();	
		
		txtrQuestion1 = new JTextArea();
		txtrQuestion1.setWrapStyleWord(true);
		txtrQuestion1.setLineWrap(true);
		txtrQuestion1.setOpaque(false);  
		txtrQuestion1.setText("Voc\u00EA acha dif\u00EDcil se apresentar para outras pessoas.");
		txtrQuestion1.setBounds(10, 45, 427, 131);
		add(txtrQuestion1);
		
		txtrQuestion2 = new JTextArea();
		txtrQuestion2.setWrapStyleWord(true);
		txtrQuestion2.setLineWrap(true);
		txtrQuestion2.setOpaque(false); 
		txtrQuestion2.setText("Voc\u00EA fica frequentemente t\u00E3o absorto em seus pensamentos que ignora ou esquece do seu entorno.");
		txtrQuestion2.setOpaque(false);
		txtrQuestion2.setBounds(10, 187, 427, 131);
		add(txtrQuestion2);
		
		txtrQuestion3 = new JTextArea();
		txtrQuestion3.setWrapStyleWord(true);
		txtrQuestion3.setLineWrap(true);
		txtrQuestion3.setOpaque(false); 
		txtrQuestion3.setText("Voc\u00EA acha dif\u00EDcil se apresentar para outras pessoas.");
		txtrQuestion3.setOpaque(false);
		txtrQuestion3.setBounds(10, 329, 427, 131);
		add(txtrQuestion3);
		
		JLabel lblInvestimento = new JLabel("Investimento");
		lblInvestimento.setBounds(444, 11, 78, 14);
		add(lblInvestimento);
		
		JLabel lblAcumulado = new JLabel("Acumulado");
		lblAcumulado.setBounds(523, 11, 66, 14);
		add(lblAcumulado);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(599, 11, 41, 14);
		add(lblStatus);
		
		JLabel lblOk = new JLabel("OK");
		lblOk.setBounds(605, 50, 25, 14);
		add(lblOk);
		
		JLabel label = new JLabel("OK");
		label.setBounds(605, 217, 25, 14);
		add(label);
		
		JLabel label_1 = new JLabel("OK");
		label_1.setBounds(605, 362, 25, 14);
		add(label_1);
		
		NumberFormat format = NumberFormat.getInstance();
	    NumberFormatter formatter = new NumberFormatter(format);
	    formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(Integer.MAX_VALUE);
		formatter.setAllowsInvalid(false);
		formatter.setCommitsOnValidEdit(true);
		
		fttQuestion1 = new JFormattedTextField(formatter);
		fttQuestion1.setHorizontalAlignment(SwingConstants.CENTER);
		fttQuestion1.setText("0");
		fttQuestion1.setBounds(447, 47, 48, 20);
		fttQuestion1.getDocument().addDocumentListener(controlTextFields);
		add(fttQuestion1);

		fttAccQuestion1 = new JFormattedTextField(formatter);
		fttAccQuestion1.setText("0");
		fttAccQuestion1.setEditable(false);
		fttAccQuestion1.setBounds(523, 47, 39, 20);
		add(fttAccQuestion1);
		
		fttAccQuestion2 = new JFormattedTextField(formatter);
		fttAccQuestion2.setText("0");
		fttAccQuestion2.setEditable(false);
		fttAccQuestion2.setBounds(523, 214, 39, 20);
		add(fttAccQuestion2);
		
		fttAccQuestion3 = new JFormattedTextField(formatter);
		fttAccQuestion3.setText("0");
		fttAccQuestion3.setEditable(false);
		fttAccQuestion3.setBounds(523, 359, 39, 20);
		add(fttAccQuestion3);
		
		fttQuestion2 = new JFormattedTextField(formatter);
		fttQuestion2.setText("0");
		fttQuestion2.setHorizontalAlignment(SwingConstants.CENTER);
		fttQuestion2.setBounds(447, 214, 48, 20);
		fttQuestion2.getDocument().addDocumentListener(controlTextFields);
		add(fttQuestion2);
		
		title = new JLabel("T\u00EDtulo");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 12));
		title.setBounds(10, 6, 400, 23);
		add(title);
		
		fttQuestion3 = new JFormattedTextField(formatter);
		fttQuestion3.setText("0");
		fttQuestion3.setHorizontalAlignment(SwingConstants.CENTER);
		fttQuestion3.setBounds(447, 359, 48, 20);
		fttQuestion3.getDocument().addDocumentListener(controlTextFields);
		add(fttQuestion3);			
	}
	
	public void setFirstValue() {
		
	}

	public void setTitle(String text) {
		title.setText(text);		
	}
	
	public void setQuestionLabel(int index, String question) {
		switch (index) {
		case 1:
            txtrQuestion1.setText(question);
            break;
        case 2:
        	txtrQuestion2.setText(question);
            break;
        case 3:
        	txtrQuestion3.setText(question);
            break;
		default:
			break;
		}
	}

	@Override
	protected boolean checkAnswerRules() {
		boolean validateValues = true;
		if (this.isLastPanel) {
			validateValues = false;
		}
		return validateValues;
	}

	@Override
	protected void collectData() {
		int arrayInitialDataIndex = this.index * 3;
		this.data[arrayInitialDataIndex] = Integer.parseInt(fttQuestion1.getText());		
		this.data[arrayInitialDataIndex + 1] = Integer.parseInt(fttQuestion2.getText());	
		this.data[arrayInitialDataIndex + 2] = Integer.parseInt(fttQuestion3.getText());			
	}
	
	private boolean validateValues() {
		return true;
	}
}