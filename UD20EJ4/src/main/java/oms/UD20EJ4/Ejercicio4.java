package oms.UD20EJ4;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class Ejercicio4 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public Ejercicio4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(111, 11, 600, 411);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Eventos");
		lblNewLabel.setBounds(10, 203, 91, 14);
		contentPane.add(lblNewLabel);

		setLocationRelativeTo(null);
		
		this.addWindowListener(ventana);
		
		textArea.addKeyListener(teclado);
		
		this.addMouseListener(raton);
	}
	
	WindowAdapter ventana = new WindowAdapter() {
		public void windowOpened(WindowEvent e) {
	    	textArea.append("Ventana abierta. ");
		}
		
		public void windowClosing(WindowEvent e) {
			textArea.append("Ventana cerrandose. ");
		}
		
		public void windowClosed(WindowEvent e) {
			textArea.append("Ventana cerrada. ");
		}
	};
	 
	KeyListener teclado = new KeyListener() {
		public void keyPressed(KeyEvent e) {
	    	textArea.append("Tecla "+e.getKeyText(e.getKeyCode())+" pulsada. ");
		}
		public void keyReleased(KeyEvent e) {
	    	textArea.append("Tecla "+e.getKeyText(e.getKeyCode())+" soltada. ");
		}
		public void keyTyped(KeyEvent e) {
	    	textArea.append("Tecla "+e.getKeyChar()+" typeada. ");
		}
	};
	
	MouseListener raton = new MouseListener() {
		public void mousePressed(MouseEvent e) {
			textArea.append("Boton del raton pulsado. ");
    	}

	    public void mouseReleased(MouseEvent e) {
	    	textArea.append("Boton del raton soltado. ");
	    }

	    public void mouseEntered(MouseEvent e) {
	    	textArea.append("El raton ha entrado en la ventana. ");
	    }

	    public void mouseExited(MouseEvent e) {
	    	textArea.append("El raton ha salido de la ventana. ");
	    }

	    public void mouseClicked(MouseEvent e) {
	    	textArea.append("Boton del raton clicado. ");
	    }
	};
}
