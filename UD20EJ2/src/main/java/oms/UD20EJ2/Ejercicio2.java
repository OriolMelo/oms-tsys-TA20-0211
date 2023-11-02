package oms.UD20EJ2;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton boton2;
	private JButton boton1;
	private JLabel infoPulsado;


	/**
	 * Create the frame.
	 */
	public Ejercicio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 82);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		infoPulsado = new JLabel("Has pulsado: ninguno");
		infoPulsado.setBounds(20, 11, 149, 14);
		contentPane.add(infoPulsado);
		
		boton1 = new JButton("Boton 1");
		boton1.addActionListener(pulsar); 
		boton1.setBounds(165, 7, 89, 23);
		contentPane.add(boton1);
		
		boton2 = new JButton("Boton 2");
		boton2.addActionListener(pulsar);
		boton2.setBounds(264, 7, 89, 23);
		contentPane.add(boton2);

		setLocationRelativeTo(null);
	}

	ActionListener pulsar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton boton = (JButton)e.getSource();
			infoPulsado.setText("Has pulsado:  "+boton.getText());
		}
	};
}
