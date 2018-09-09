package formsManagement;

import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;

public class QuestionPanelSub extends QuestionPanel {
	
	private static final long serialVersionUID = 1L;
	private final ButtonGroup buttonGroupQuestion1 = new ButtonGroup();
	private final ButtonGroup buttonGroupQuestion2 = new ButtonGroup();
	private final ButtonGroup buttonGroupQuestion3 = new ButtonGroup();
	private final ButtonGroup buttonGroupQuestion4 = new ButtonGroup();
	private final ButtonGroup buttonGroupQuestion5 = new ButtonGroup();
	private final ButtonGroup buttonGroupQuestion6 = new ButtonGroup();
	
	private ArrayList<ButtonGroup> buttonGroupList;
	
	private JTextArea txtrQuestion1;
	private JTextArea txtrQuestion2;
	private JTextArea txtrQuestion3;
	private JTextArea txtrQuestion4;
	private JTextArea txtrQuestion5;
	private JTextArea txtrQuestion6;

	public QuestionPanelSub() {
		buttonGroupList = new  ArrayList<ButtonGroup>();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		buttonGroupQuestion1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(128, 66, 21, 23);
		add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("");
		buttonGroupQuestion1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(187, 66, 21, 23);
		add(rdbtnNewRadioButton_1);
		
		JRadioButton radioButton = new JRadioButton("");
		buttonGroupQuestion1.add(radioButton);
		radioButton.setBounds(236, 66, 21, 23);
		add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		buttonGroupQuestion1.add(radioButton_1);
		radioButton_1.setBounds(289, 66, 21, 23);
		add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		buttonGroupQuestion1.add(radioButton_2);
		radioButton_2.setBounds(341, 66, 21, 23);
		add(radioButton_2);
		
		JRadioButton radioButton_3 = new JRadioButton("");
		buttonGroupQuestion1.add(radioButton_3);
		radioButton_3.setBounds(453, 66, 21, 23);
		add(radioButton_3);
		
		JRadioButton radioButton_4 = new JRadioButton("");
		buttonGroupQuestion1.add(radioButton_4);
		radioButton_4.setBounds(390, 66, 21, 23);
		add(radioButton_4);
		
		buttonGroupList.add(buttonGroupQuestion1);
		
		JLabel lblNewLabel_1 = new JLabel("Concordo");
		lblNewLabel_1.setBounds(58, 66, 62, 23);
		add(lblNewLabel_1);
		
		JLabel lblDiscordo = new JLabel("Discordo");
		lblDiscordo.setBounds(514, 66, 81, 23);
		add(lblDiscordo);
		
		JRadioButton radioButton_5 = new JRadioButton("");
		buttonGroupQuestion2.add(radioButton_5);
		radioButton_5.setBounds(128, 141, 21, 23);
		add(radioButton_5);
		
		JRadioButton radioButton_6 = new JRadioButton("");
		buttonGroupQuestion2.add(radioButton_6);
		radioButton_6.setBounds(187, 141, 21, 23);
		add(radioButton_6);
		
		JRadioButton radioButton_7 = new JRadioButton("");
		buttonGroupQuestion2.add(radioButton_7);
		radioButton_7.setBounds(236, 141, 21, 23);
		add(radioButton_7);
		
		JRadioButton radioButton_8 = new JRadioButton("");
		buttonGroupQuestion2.add(radioButton_8);
		radioButton_8.setBounds(289, 141, 21, 23);
		add(radioButton_8);
		
		JRadioButton radioButton_9 = new JRadioButton("");
		buttonGroupQuestion2.add(radioButton_9);
		radioButton_9.setBounds(341, 141, 21, 23);
		add(radioButton_9);
		
		JRadioButton radioButton_10 = new JRadioButton("");
		buttonGroupQuestion2.add(radioButton_10);
		radioButton_10.setBounds(453, 141, 21, 23);
		add(radioButton_10);
		
		JRadioButton radioButton_11 = new JRadioButton("");
		buttonGroupQuestion2.add(radioButton_11);
		radioButton_11.setBounds(390, 141, 21, 23);
		add(radioButton_11);
		
		buttonGroupList.add(buttonGroupQuestion2);
		
		JLabel label_1 = new JLabel("Concordo");
		label_1.setBounds(58, 141, 62, 23);
		add(label_1);
		
		JLabel label_2 = new JLabel("Discordo");
		label_2.setBounds(514, 141, 81, 23);
		add(label_2);	
		
		txtrQuestion1 = new JTextArea();
		txtrQuestion1.setWrapStyleWord(true);
		txtrQuestion1.setLineWrap(true);
		txtrQuestion1.setOpaque(false);  
		txtrQuestion1.setText("Voc\u00EA acha dif\u00EDcil se apresentar para outras pessoas.");
		txtrQuestion1.setBounds(10, 24, 620, 48);
		add(txtrQuestion1);
		
		txtrQuestion2 = new JTextArea();
		txtrQuestion2.setWrapStyleWord(true);
		txtrQuestion2.setLineWrap(true);
		txtrQuestion2.setOpaque(false); 
		txtrQuestion2.setText("Voc\u00EA fica frequentemente t\u00E3o absorto em seus pensamentos que ignora ou esquece do seu entorno.");
		txtrQuestion2.setOpaque(false);
		txtrQuestion2.setBounds(10, 96, 620, 48);
		add(txtrQuestion2);
		
		JRadioButton radioButton_12 = new JRadioButton("");
		buttonGroupQuestion3.add(radioButton_12);
		radioButton_12.setBounds(128, 216, 21, 23);
		add(radioButton_12);
		
		JRadioButton radioButton_13 = new JRadioButton("");
		buttonGroupQuestion3.add(radioButton_13);
		radioButton_13.setBounds(187, 216, 21, 23);
		add(radioButton_13);
		
		JRadioButton radioButton_14 = new JRadioButton("");
		buttonGroupQuestion3.add(radioButton_14);
		radioButton_14.setBounds(236, 216, 21, 23);
		add(radioButton_14);
		
		JRadioButton radioButton_15 = new JRadioButton("");
		buttonGroupQuestion3.add(radioButton_15);
		radioButton_15.setBounds(289, 216, 21, 23);
		add(radioButton_15);
		
		JRadioButton radioButton_16 = new JRadioButton("");
		buttonGroupQuestion3.add(radioButton_16);
		radioButton_16.setBounds(341, 216, 21, 23);
		add(radioButton_16);
		
		JRadioButton radioButton_17 = new JRadioButton("");
		buttonGroupQuestion3.add(radioButton_17);
		radioButton_17.setBounds(453, 216, 21, 23);
		add(radioButton_17);
		
		JRadioButton radioButton_18 = new JRadioButton("");
		buttonGroupQuestion3.add(radioButton_18);
		radioButton_18.setBounds(390, 216, 21, 23);
		add(radioButton_18);
		
		buttonGroupList.add(buttonGroupQuestion3);
		
		JLabel label = new JLabel("Concordo");
		label.setBounds(58, 216, 62, 23);
		add(label);
		
		txtrQuestion3 = new JTextArea();
		txtrQuestion3.setWrapStyleWord(true);
		txtrQuestion3.setLineWrap(true);
		txtrQuestion3.setOpaque(false); 
		txtrQuestion3.setText("Voc\u00EA acha dif\u00EDcil se apresentar para outras pessoas.");
		txtrQuestion3.setOpaque(false);
		txtrQuestion3.setBounds(10, 171, 620, 48);
		add(txtrQuestion3);
		
		JLabel label_3 = new JLabel("Discordo");
		label_3.setBounds(514, 216, 81, 23);
		add(label_3);
		
		txtrQuestion4 = new JTextArea();
		txtrQuestion4.setWrapStyleWord(true);
		txtrQuestion4.setLineWrap(true);
		txtrQuestion4.setOpaque(false); 
		txtrQuestion4.setText("Voc\u00EA acha dif\u00EDcil se apresentar para outras pessoas.");
		txtrQuestion4.setOpaque(false);
		txtrQuestion4.setBounds(10, 246, 620, 48);
		add(txtrQuestion4);
		
		JLabel label_4 = new JLabel("Concordo");
		label_4.setBounds(58, 291, 62, 23);
		add(label_4);
		
		JRadioButton radioButton_19 = new JRadioButton("");
		buttonGroupQuestion4.add(radioButton_19);
		radioButton_19.setBounds(128, 291, 21, 23);
		add(radioButton_19);
		
		JRadioButton radioButton_20 = new JRadioButton("");
		buttonGroupQuestion4.add(radioButton_20);
		radioButton_20.setBounds(187, 291, 21, 23);
		add(radioButton_20);
		
		JRadioButton radioButton_21 = new JRadioButton("");
		buttonGroupQuestion4.add(radioButton_21);
		radioButton_21.setBounds(236, 291, 21, 23);
		add(radioButton_21);
		
		JRadioButton radioButton_22 = new JRadioButton("");
		buttonGroupQuestion4.add(radioButton_22);
		radioButton_22.setBounds(289, 291, 21, 23);
		add(radioButton_22);
		
		JRadioButton radioButton_23 = new JRadioButton("");
		buttonGroupQuestion4.add(radioButton_23);
		radioButton_23.setBounds(341, 291, 21, 23);
		add(radioButton_23);
		
		JRadioButton radioButton_24 = new JRadioButton("");
		buttonGroupQuestion4.add(radioButton_24);
		radioButton_24.setBounds(390, 291, 21, 23);
		add(radioButton_24);
		
		JRadioButton radioButton_25 = new JRadioButton("");
		buttonGroupQuestion4.add(radioButton_25);
		radioButton_25.setBounds(453, 291, 21, 23);
		add(radioButton_25);
		
		buttonGroupList.add(buttonGroupQuestion4);
		
		JLabel label_5 = new JLabel("Discordo");
		label_5.setBounds(514, 291, 81, 23);
		add(label_5);
		
		txtrQuestion5 = new JTextArea();
		txtrQuestion5.setWrapStyleWord(true);
		txtrQuestion5.setLineWrap(true);
		txtrQuestion5.setOpaque(false); 
		txtrQuestion5.setText("Voc\u00EA acha dif\u00EDcil se apresentar para outras pessoas.");
		txtrQuestion5.setOpaque(false);
		txtrQuestion5.setBounds(10, 321, 620, 48);
		add(txtrQuestion5);
		
		JLabel label_6 = new JLabel("Concordo");
		label_6.setBounds(58, 366, 62, 23);
		add(label_6);
		
		JRadioButton radioButton_26 = new JRadioButton("");
		buttonGroupQuestion5.add(radioButton_26);
		radioButton_26.setBounds(128, 366, 21, 23);
		add(radioButton_26);
		
		JRadioButton radioButton_27 = new JRadioButton("");
		buttonGroupQuestion5.add(radioButton_27);
		radioButton_27.setBounds(187, 366, 21, 23);
		add(radioButton_27);
		
		JRadioButton radioButton_28 = new JRadioButton("");
		buttonGroupQuestion5.add(radioButton_28);
		radioButton_28.setBounds(236, 366, 21, 23);
		add(radioButton_28);
		
		JRadioButton radioButton_29 = new JRadioButton("");
		buttonGroupQuestion5.add(radioButton_29);
		radioButton_29.setBounds(289, 366, 21, 23);
		add(radioButton_29);
		
		JRadioButton radioButton_30 = new JRadioButton("");
		buttonGroupQuestion5.add(radioButton_30);
		radioButton_30.setBounds(341, 366, 21, 23);
		add(radioButton_30);
		
		JRadioButton radioButton_31 = new JRadioButton("");
		buttonGroupQuestion5.add(radioButton_31);
		radioButton_31.setBounds(390, 366, 21, 23);
		add(radioButton_31);
		
		JRadioButton radioButton_32 = new JRadioButton("");
		buttonGroupQuestion5.add(radioButton_32);
		radioButton_32.setBounds(453, 366, 21, 23);
		add(radioButton_32);
		
		buttonGroupList.add(buttonGroupQuestion5);
		
		JLabel label_7 = new JLabel("Discordo");
		label_7.setBounds(514, 366, 81, 23);
		add(label_7);
		
		txtrQuestion6 = new JTextArea();
		txtrQuestion6.setWrapStyleWord(true);
		txtrQuestion6.setLineWrap(true);
		txtrQuestion6.setOpaque(false); 
		txtrQuestion6.setText("Voc\u00EA acha dif\u00EDcil se apresentar para outras pessoas.");
		txtrQuestion6.setOpaque(false);
		txtrQuestion6.setBounds(10, 394, 620, 48);
		add(txtrQuestion6);
		
		JLabel label_8 = new JLabel("Concordo");
		label_8.setBounds(58, 439, 62, 23);
		add(label_8);
		
		JRadioButton radioButton_33 = new JRadioButton("");
		buttonGroupQuestion6.add(radioButton_33);
		radioButton_33.setBounds(128, 439, 21, 23);
		add(radioButton_33);
		
		JRadioButton radioButton_34 = new JRadioButton("");
		buttonGroupQuestion6.add(radioButton_34);
		radioButton_34.setBounds(187, 439, 21, 23);
		add(radioButton_34);
		
		JRadioButton radioButton_35 = new JRadioButton("");
		buttonGroupQuestion6.add(radioButton_35);
		radioButton_35.setBounds(236, 439, 21, 23);
		add(radioButton_35);
		
		JRadioButton radioButton_36 = new JRadioButton("");
		buttonGroupQuestion6.add(radioButton_36);
		radioButton_36.setBounds(289, 439, 21, 23);
		add(radioButton_36);
		
		JRadioButton radioButton_37 = new JRadioButton("");
		buttonGroupQuestion6.add(radioButton_37);
		radioButton_37.setBounds(341, 439, 21, 23);
		add(radioButton_37);
		
		JRadioButton radioButton_38 = new JRadioButton("");
		buttonGroupQuestion6.add(radioButton_38);
		radioButton_38.setBounds(390, 439, 21, 23);
		add(radioButton_38);
		
		JRadioButton radioButton_39 = new JRadioButton("");
		buttonGroupQuestion6.add(radioButton_39);
		radioButton_39.setBounds(453, 439, 21, 23);
		add(radioButton_39);
		
		buttonGroupList.add(buttonGroupQuestion6);
		
		JLabel label_9 = new JLabel("Discordo");
		label_9.setBounds(514, 439, 81, 23);
		add(label_9);
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
        case 4:
        	txtrQuestion4.setText(question);
            break;
        case 5:
        	txtrQuestion5.setText(question);
            break;
        case 6:
        	txtrQuestion6.setText(question);
            break;
		default:
			break;
		}
	}

	@Override
	protected boolean checkAnswerRules() {
		boolean selectedAllAnswers = true;
		for (int i = 0; i < buttonGroupList.size(); i++ ) {
			ButtonGroup btGroup = buttonGroupList.get(i);	
			selectedAllAnswers = selectedAllAnswers && ( btGroup.getSelection() != null); 
		}
		return selectedAllAnswers;
	}

	@Override
	protected void collectData() {
		int arrayInitialDataIndex = this.index * 6;
		for (int i = 0; i < buttonGroupList.size(); i++ ) {
			ButtonGroup btGroup = buttonGroupList.get(i);		
			int buttonIndex = 1;
			for (Enumeration<AbstractButton> buttons = btGroup.getElements(); buttons.hasMoreElements();) {
				AbstractButton button = buttons.nextElement();
				if (button.isSelected()) {
					this.data[arrayInitialDataIndex + i] = buttonIndex;
					break;
				}
				buttonIndex += 1;
		    }		
		}
	}
}