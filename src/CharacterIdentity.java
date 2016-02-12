//Sources: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#flow, http://stackoverflow.com/questions/5729806/encode-string-to-utf-8
//Sources: http://stackoverflow.com/questions/4477714/how-to-convert-a-char-from-alphabetical-character-to-hexadecimal-number-in-java, http://stackoverflow.com/questions/8504615/get-unicode-value-of-character
//Sources: https://docs.oracle.com/javase/7/docs/api/javax/swing/event/DocumentListener.html, http://stackoverflow.com/questions/5443682/how-add-a-listener-for-jtexfield-when-it-changing
//Sources: http://mindprod.com/products1.html#ENTITIES, http://www.unicode.org/charts/charindex.html, http://stackoverflow.com/questions/13021683/adding-a-label-for-a-jtextfield
//Source: http://stackoverflow.com/questions/25276020/listen-to-the-paste-events-jtextarea

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CharacterIdentity extends JFrame
{
	
	static ArrayList<String[]> data;
	
	
	public static void main(String[] args){
		
		data = csvfile.getData();
		
		JFrame frame = new JFrame ("project");
		final JTextField textField = new JTextField(20);
		frame.getContentPane().add(textField); 
		frame.setVisible (true);
		frame.setSize(500,500);
		textField.setFont(new Font("Serif", Font.BOLD, 50)); 
		final JLabel unicode = new JLabel ("unicode");
		final JLabel entities = new JLabel("engdef");
		frame.getContentPane().add(unicode, BorderLayout.NORTH);
		frame.getContentPane().add(entities, BorderLayout.SOUTH);
		
		DocumentListener listener = new DocumentListener() { 
	
			public void insertUpdate(DocumentEvent e)
			{
				String text = textField.getText(); 
				int firstChar = text.charAt(0); //makes the first letter an "int"
				unicode.setText("decimal and entity: " + firstChar + " " + "&#" + firstChar + "; " +"hex and hex entity: 0x" + String.format("%04x", firstChar) + " &#x" + String.format("%04x", firstChar) + ";");  //makes the decimal and hex value appear for the int
				entities.setText("engdef:" + findName("0x" + String.format("%x", firstChar)) + "alpha: " + findName("0x" + String.format("%x", firstChar)));
			}

		
			public void removeUpdate(DocumentEvent e)
			{
				// TODO Auto-generated method stub
				
			}

			
			public void changedUpdate(DocumentEvent e)
			{
		
				
			}
			
		};
		textField.getDocument().addDocumentListener(listener); 
		
		
		
		
	}
	
	static String findName(String hex){
		for (String[] line : data){
			if(line[1].endsWith(hex)){
				return line[4]; 
			}
		}
		return "";
	}
		
	static String findAlpha(String hex){
		for (String[] line : data){
			if(line[1].endsWith(hex)){
				return line[3]; 
			}
		}
		return "";	
		
	
	}
}