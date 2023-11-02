package oms.UD20EJ5;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Ejercicio5 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private JButton btnNewButton;
	/**
	 * Create the frame.
	 */
	public Ejercicio5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea = new JTextArea();
		textArea.setBounds(10, 52, 701, 359);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		contentPane.add(textArea);
		
		btnNewButton = new JButton("Limpiar");
		btnNewButton.setBounds(302, 18, 89, 23);
		btnNewButton.addActionListener(limpiar);
		contentPane.add(btnNewButton);
	
		setLocationRelativeTo(null);
		
		textArea.addMouseListener(raton);
		
		
	}
	
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

	ActionListener limpiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textArea.setText("");
		}
	};
}
