package cgi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;


public class CurvasFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT= 600;

	private Curvas painel;

	public CurvasFrame(){
		setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        
		JMenuBar barra = new JMenuBar();
		barra.add(criarMenuFicheiro());
		barra.add(criarMenuMenu1());
		barra.add(criarMenuAjuda());
		setJMenuBar(barra);

		painel = new Curvas();
		setContentPane(painel);
	}

	private JMenu criarMenuFicheiro(){
		JMenu menu = new JMenu("File");
		menu.add(criarItemMenuFicheiro("New"));
		menu.add(new JSeparator());
		menu.add(criarItemMenuFicheiro("Exit"));
		return menu;
	}

	private JMenuItem criarItemMenuFicheiro(String texto) {
		JMenuItem item = new JMenuItem(texto);

		class ListenerItemMenu implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("New"))
					painel.limparDesenho();
				else if(e.getActionCommand().equals("Exit"))
					System.exit(0);
			}	
		}

		item.addActionListener(new ListenerItemMenu());
		return item;	
	}


	private JMenu criarMenuMenu1(){
		JMenu menu = new JMenu("Menu");
		menu.add(criarItemMenuMenu1("Item 1"));
		menu.add(criarItemMenuMenu1("Item 2"));
		menu.add(criarItemMenuMenu1("Item 3"));
		menu.add(criarItemMenuMenu1("Item 4"));
		return menu;
	}

	private JMenuItem criarItemMenuMenu1(String texto){
		JMenuItem item = new JMenuItem(texto);

		class ListenerItemMenu implements ActionListener{
			public void actionPerformed(ActionEvent event){
				System.out.println("Item escolhido!");
			}
		}

		item.addActionListener(new ListenerItemMenu());
		return item;
	}

	private JMenuItem criarItemMenuAjuda(String texto) {
		JMenuItem item = new JMenuItem(texto);

		class ListenerItemMenu implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand().equals("About"))
					JOptionPane.showMessageDialog(null, 
							"Demo para programar em Java/Swing)\n");
			}
		}
		item.addActionListener(new ListenerItemMenu());
		return item;
	}
	
	private JMenu criarMenuAjuda(){
		JMenu menu = new JMenu("Help");		
		menu.add(criarItemMenuAjuda("About"));
		return menu;
	}
}
