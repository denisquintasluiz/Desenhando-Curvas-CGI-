
package cgi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JPanel;
import java.util.Arrays;

public class Curvas extends JPanel {

	// Constantes
	private static final long serialVersionUID = 1L;

	// Variaveis Globais
	int x, xnovo,xn;
	int y, ynovo,yn;
    int cont;
	/* vector pra guardar todos os pontos */
	private Vector<Point> points = new Vector<Point>();

	public Curvas() {
		cont=0;
		// Fundo de cor branca
		setBackground(Color.WHITE);

		MouseListener ml = new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getButton() != MouseEvent.BUTTON1)
					return;
				if (e.getClickCount() != 1) {
					return;
				}
				// pegando Coordenadas
				x = e.getX();
				y = e.getY();
				xnovo = x;
				ynovo = y;


				// colocando o ponto no Vetor
				Point ponto = new Point(x, y);
				points.add(ponto);

				// criando objeto da Classe Graphics2D
				Graphics2D g = (Graphics2D) getGraphics();

				g.setXORMode(getBackground());

				// configurando a caneta
				g.setPaintMode();

				/*
				 * escrevendo linhas continuas unindo os pontos sequencialmente
				 */
				if(cont==0) {
				g.drawLine(points.get(cont).getX(), points.get(cont).getY(), x, y);
				cont++;
				}
				 
                   //Curva de Bezier
				if (points.size() - 1 == 3) {
					// definindo os pontos iniciais
					int xini = points.get(0).getX();
					int yini = points.get(0).getY();
                    g.setColor(Color.RED);
					for (double t = 0; t <= 1; t += 0.000100) {
						
						double x = points.get(0).getX() * ((-1 * Math.pow(t, 3)) + 3 * Math.pow(t, 2) - 3 * t + 1)
								+ points.get(1).getX() * (3 * Math.pow(t, 3) - 6 * Math.pow(t, 2) + 3 * t)
								+ points.get(2).getX() * (-3 * Math.pow(t, 3) + 3 * Math.pow(t, 2))
								+ points.get(3).getX() * Math.pow(t, 3);

						double y = points.get(0).getY() * ((-1 * Math.pow(t, 3)) + 3 * Math.pow(t, 2) - 3 * t + 1)
								+ points.get(1).getY() * (3 * Math.pow(t, 3) - 6 * Math.pow(t, 2) + 3 * t)
								+ points.get(2).getY() * (-3 * Math.pow(t, 3) + 3 * Math.pow(t, 2))
								+ points.get(3).getY() * Math.pow(t, 3);

						g.drawLine(xini, yini, (int) x, (int) y);
						xini = (int) x;
						yini = (int) y;
					}
				}
				// Curva de B-Spline:
				if (points.size() - 1 == 3) {
					g.setColor(Color.GREEN);
					// definindo os pontos iniciais
					int xini = points.get(1).getX();
					int yini = points.get(2).getY();

					for (double t = 0; t <= 1; t += 0.000100) {

					

						double x = points.get(0).getX() * ((-1 * Math.pow(t, 3)) + 3 * Math.pow(t, 2) - 3 * t + 1) / 6
								+ points.get(1).getX() * (3 * Math.pow(t, 3) - 6 * Math.pow(t, 2) + 4) / 6
								+ points.get(2).getX() * (-3 * Math.pow(t, 3) + 3 * Math.pow(t, 2) + 3 * t + 1) / 6
								+ points.get(3).getX() * Math.pow(t, 3) / 6;

						double y = points.get(0).getY() * ((-1 * Math.pow(t, 3)) + 3 * Math.pow(t, 2) - 3 * t + 1) / 6
								+ points.get(1).getY() * (3 * Math.pow(t, 3) - 6 * Math.pow(t, 2) + 4) / 6
								+ points.get(2).getY() * (-3 * Math.pow(t, 3) + 3 * Math.pow(t, 2) + 3 * t + 1) / 6
								+ points.get(3).getY() * Math.pow(t, 3) / 6;
						
						g.drawLine((int) x, (int) y, (int) x, (int) y);
						yini = (int) y;
						xini = (int) x;

					}
				}

				// Curva de Catmull-Rom
				if (points.size() - 1 == 3) {
					// definindo os pontos iniciais
					int xini = points.get(1).getX();
					int yini = points.get(1).getY();
                    g.setColor(Color.BLUE);
					for (double t = 0; t <= 1; t += 0.000100) {

						

						double x = points.get(0).getX() * ((-1 * Math.pow(t, 3)) + 2 * Math.pow(t, 2) - t) / 2
								+ points.get(1).getX() * (3 * Math.pow(t, 3) - 5 * Math.pow(t, 2) + 2) / 2
								+ points.get(2).getX() * (-3 * Math.pow(t, 3) + 4 * Math.pow(t, 2) + t) / 2
								+ points.get(3).getX() * (Math.pow(t, 3) - Math.pow(t, 2)) / 2;

						double y = points.get(0).getY() * ((-1 * Math.pow(t, 3)) + 2 * Math.pow(t, 2) - t) / 2
								+ points.get(1).getY() * (3 * Math.pow(t, 3) - 5 * Math.pow(t, 2) + 2) / 2
								+ points.get(2).getY() * (-3 * Math.pow(t, 3) + 4 * Math.pow(t, 2) + t) / 2
								+ points.get(3).getY() * (Math.pow(t, 3) - Math.pow(t, 2)) / 2;

						g.drawLine(xini, yini, (int) x, (int) y);
						xini = (int) x;
						yini = (int) y;
					}

				}

				if (points.size() - 1 == 4)
					points.clear();

			}
		};

		MouseMotionListener mml = new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				// pegando Coordenadas
				xn = e.getX();
				yn = e.getY();
				// criando objeto da Classe Graphics2D
				Graphics2D g = (Graphics2D) getGraphics();

				// colocando no ModoXor
				g.setXORMode(getBackground());

				// apagando e escrevendo Linhas.
				if (points.size() - 1 >= 0) {
					g.drawLine(x, y, xnovo, ynovo);
					g.drawLine(x, y, xn, yn);

					xnovo = xn;
					ynovo = yn;
				}

				if (points.size() - 1 == 3)
					points.clear();
			}

		};

		addMouseListener(ml);
		addMouseMotionListener(mml);

	}


	// Este metodo eh o responsavel por actualizar a area de desenho do componente
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	}

	// Metodo adicionado para se poder receber, do exterior (neste caso do Frame),
	// um pedido para limpar o conteudo
	public void limparDesenho() {
		setBackground(new JPanel().getBackground());
	
	}
}
