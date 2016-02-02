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


public class CharacterIdentity extends JFrame
{
	
	
	public static void main(String[] args){
		
		
		
		JFrame frame = new JFrame ("project");
		final JTextField textField = new JTextField(20);
		frame.getContentPane().add(textField); 
		frame.setVisible (true);
		frame.setSize(500,500);
		textField.setFont(new Font("Serif", Font.BOLD, 50)); 
		final JLabel unicode = new JLabel ("unicode");
		final JLabel entities = new JLabel("entities");
		frame.getContentPane().add(unicode, BorderLayout.NORTH);
		frame.getContentPane().add(entities, BorderLayout.SOUTH);
		DocumentListener listener = new DocumentListener() { 
	
		
		

			@Override
			public void insertUpdate(DocumentEvent e)
			{
				String text = textField.getText(); 
				int firstChar = text.charAt(0); //makes the first letter an "int"
				unicode.setText("decimal and entity: " + firstChar + " " + "&#" + firstChar + "; " +"hex and hex entity: 0x" + String.format("%04x", firstChar) + " &#x" + String.format("%04x", firstChar) + ";");  //makes the decimal and hex value appear for the int
				
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
