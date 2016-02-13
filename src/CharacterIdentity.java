//Sources: https://docs.oracle.com/javase/tutorial/uiswing/layout/visual.html#flow, http://stackoverflow.com/questions/5729806/encode-string-to-utf-8
//Sources: http://stackoverflow.com/questions/4477714/how-to-convert-a-char-from-alphabetical-character-to-hexadecimal-number-in-java, http://stackoverflow.com/questions/8504615/get-unicode-value-of-character
//Sources: https://docs.oracle.com/javase/7/docs/api/javax/swing/event/DocumentListener.html, http://stackoverflow.com/questions/5443682/how-add-a-listener-for-jtexfield-when-it-changing
//Sources: http://mindprod.com/products1.html#ENTITIES, http://www.unicode.org/charts/charindex.html, http://stackoverflow.com/questions/13021683/adding-a-label-for-a-jtextfield
//Source: http://stackoverflow.com/questions/25276020/listen-to-the-paste-events-jtextarea

import java.awt.BorderLayout; //imports stuff that's necessary for the code to work
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


public class CharacterIdentity extends JFrame //creates JFrame
{
	
	static ArrayList<String[]> data; //arraylist of strings called data
	
	
	public static void main(String[] args){ //creates function "main"
		
		data = csvfile.getData(); //puts the data from the csv file into "data"
		
		JFrame frame = new JFrame ("project"); //names the Jframe project 
		final JTextField textField = new JTextField(20); //creates Jtextfield, named it textField
		frame.getContentPane().add(textField);  //puts the textfield on the content pane
		frame.setVisible (true); //you can see it now
		frame.setSize(500,500);  //sets dimensions
		textField.setFont(new Font("Serif", Font.BOLD, 50));  //makes font serif, bold, size 50
		final JLabel unicode = new JLabel ("unicode"); //creates label unicode
		final JLabel entities = new JLabel("engdef"); //creates label engdef
		frame.getContentPane().add(unicode, BorderLayout.NORTH); //puts the unicode label at top of contentpane
		frame.getContentPane().add(entities, BorderLayout.SOUTH); //puts the entities label at bottom of contentpane
		
		DocumentListener listener = new DocumentListener() { //makes a document listener named listener
	
			public void insertUpdate(DocumentEvent e)   //lets the listener work correctly
			{
				String text = textField.getText();  //puts whatever text is put into the textfield into a varible "text
				int firstChar = text.charAt(0); //makes the first letter an "int"
				unicode.setText("decimal and entity: " + firstChar + " " + "&#" + firstChar + "; " +"hex and hex entity: 0x" + String.format("%04x", firstChar) + " &#x" + String.format("%04x", firstChar) + ";");  //makes the decimal and hex value appear for the int, and hex entity 
				entities.setText("engdef:" + findName("0x" + String.format("%x", firstChar)) + " alpha: " + findAlpha("0x" + String.format("%x", firstChar)) + " print in java : u" + String.format("%04x", firstChar));  //prints in bottom jlabel the engdeg, alpha, and  how to print in java
			}

		
			public void removeUpdate(DocumentEvent e) 
			{
				// TODO Auto-generated method stub
				
			}

			
			public void changedUpdate(DocumentEvent e)
			{
		
				
			}
			
		};
		textField.getDocument().addDocumentListener(listener);  //connects the textfield with the listener
		
	}
	
	static String findName(String hex){ //function findname, takes in a string called "hex"
		for (String[] line : data){  //looks in the data array list and when the column 1 hex values matches with the hex value for the letter in the textfield, print column 4 value/eng def
			if(line[1].endsWith(hex)){
				return line[4];  //returns eng def
			}
		}
		return "";
	}
		
	static String findAlpha(String hex){ //function  findAlpha, takes in string value "hex"
		for (String[] line : data){ //looks in string arrays data 
			if(line[1].endsWith(hex)){//if column1 has a hex value that is the one for the letter in the textfield
				return line[3];  //return column3: alpha entity 
			}
		}
		return "";	
		
	}
}