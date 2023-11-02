package oms.UD20EJ3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Ejercicio3 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton boton2;
	private JButton boton1;
	private JLabel infoPulsado1;
	private JLabel infoPulsado2;

	private int nveces1;
	private int nveces2;

	/**
	 * Create the frame.
	 */
	public Ejercicio3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 318, 129);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		infoPulsado1 = new JLabel("Boton 1: 0 veces");
		infoPulsado1.setBounds(20, 11, 149, 14);
		contentPane.add(infoPulsado1);
		
		boton1 = new JButton("Boton 1");
		boton1.addActionListener(pulsar); 
		boton1.setBounds(20, 36, 89, 23);
		contentPane.add(boton1);
		
		boton2 = new JButton("Boton 2");
		boton2.addActionListener(pulsar);
		boton2.setBounds(179, 36, 89, 23);
		contentPane.add(boton2);
		
		infoPulsado2 = new JLabel("Boton 2: 0 veces");
		infoPulsado2.setBounds(179, 11, 149, 14);
		contentPane.add(infoPulsado2);

		nveces1 = 0;
		nveces2 = 0;
		
		setLocationRelativeTo(null);
	}

	ActionListener pulsar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(boton1== (JButton)e.getSource()) {
				nveces1++;
				infoPulsado1.setText("Boton 1:  "+nveces1+" veces");
			}
			else if(boton2== (JButton)e.getSource()) {
				nveces2++;
				infoPulsado2.setText("Boton 2:  "+nveces2+" veces");
			}
		}
	};

}
