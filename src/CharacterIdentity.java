import javax.swing.JFrame;
import javax.swing.JTextField;


public class CharacterIdentity extends JFrame
{
public static void main(String[] args){
JFrame frame = new JFrame ("project");
JTextField textField = new JTextField(20);
frame.getContentPane().add(textField); 
frame.setVisible (true);
frame.setSize(500,500);

}
}
