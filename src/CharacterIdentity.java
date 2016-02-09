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
import com.opencsv.CSVReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CharacterIdentity extends JFrame
{ 
	
	public static void main(String[] args) {
		new CharacterIdentity();
		
	}
		
	Map<Integer,String> factss = new HashMap<Integer,String>(); 
	Map<Integer,String> alpha = new HashMap<Integer,String>();
	
	public void loadfromCSV() 
	{
		try{
		CSVReader reader = new CSVReader(new FileReader("/Users/cmills/Documents/workspace/Character/bin/entityfacts.csv"));
	     String [] nextLine;
	     while ((nextLine = reader.readNext()) != null) { //creates while loop--looks through the stuff in the map
	    	 try{
	    		 System.out.println(nextLine[1] + " " + nextLine[4]);
	    		 factss.put(Integer.parseInt(nextLine[1], 16), nextLine[4]); //puts values into two lists-one is ints, one strings-matches them up
	    	 }
	    	 catch(Exception e){ //will let code work even after exception happens
	    		 
	    	 }
	        // nextLine[] is an array of values from the line
	     
	     
	     }
		} 
		catch(Exception e){
			throw new RuntimeException(e); //will have code still run after all exceptions 
		}
	   
	}
	

	public CharacterIdentity() {
	super("project");
		loadfromCSV();
		
		
		final JTextField textField = new JTextField(20);
		this.getContentPane().add(textField, BorderLayout.CENTER); 
		this.setVisible (true);
		this.setSize(500,500);
		textField.setFont(new Font("Serif", Font.BOLD, 50)); 
		final JLabel unicode = new JLabel ("unicode");
		final JLabel entities = new JLabel("entities");
		this.getContentPane().add(unicode, BorderLayout.NORTH);
		this.getContentPane().add(entities, BorderLayout.SOUTH);
		DocumentListener listener = new DocumentListener() { 
	
			public void insertUpdate(DocumentEvent e)
			{
				
				String text = textField.getText(); 
				int firstChar = text.charAt(0); //makes the first letter an "int"
				String eng = factss.get(firstChar); //takes in the letter 
				//eng = factss.get("");
				unicode.setText(eng + "decimal and entity: " + firstChar + " " + "&#" + firstChar + "; " +"hex and hex entity: 0x" + String.format("%04x", firstChar) + " &#x" + String.format("%04x", firstChar) + ";");  //makes the decimal and hex value appear for the int
			
				entities.setText(eng);
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
}

	
