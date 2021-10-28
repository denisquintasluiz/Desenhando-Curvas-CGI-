package cgi;
import javax.swing.JFrame;
/**
 * @author Professores de CGI
 */
public class Main {

	public static void main(String[] args) {
		//Criar o frame da aplicacao
		CurvasFrame frame = new CurvasFrame();				
		frame.setTitle("Curvas CGI"); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Tornar o frame visivel
		frame.setVisible(true);									
	}
}
