package oms.UD20EJ6;
import org.apache.commons.math3.util.Precision;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicio6 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textAltura;
	private JTextField textPeso;
	private JLabel lblIMC;

	/**
	 * Create the frame.
	 */
	public Ejercicio6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura (metros)");
		lblAltura.setBounds(10, 23, 111, 14);
		contentPane.add(lblAltura);
		
		textAltura = new JTextField();
		textAltura.setBounds(105, 20, 86, 20);
		contentPane.add(textAltura);
		textAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso (kg)");
		lblPeso.setBounds(228, 23, 103, 14);
		contentPane.add(lblPeso);
		
		textPeso = new JTextField();
		textPeso.setColumns(10);
		textPeso.setBounds(323, 20, 86, 20);
		contentPane.add(textPeso);
		
		JButton botonCalcular = new JButton("Calcular IMC");
		botonCalcular.addActionListener(calcular);
		botonCalcular.setBounds(80, 70, 111, 23);
		contentPane.add(botonCalcular);
		
		lblIMC = new JLabel("IMC: ");
		lblIMC.setBounds(228, 74, 103, 14);
		contentPane.add(lblIMC);
		
		setLocationRelativeTo(null);
	}
	
	ActionListener calcular = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if(!textAltura.getText().equals("") && !textPeso.getText().equals("")) {
					double altura = Double.parseDouble(textAltura.getText());
					double peso = Double.parseDouble(textPeso.getText());
					double imc = peso/(Math.pow(altura, 2));
					lblIMC.setText("IMC: "+Precision.round(imc, 2));
				}
			}
			catch(NumberFormatException excepcion) {
				System.out.println("Error: tienes que introducir un numero: "+excepcion.getMessage());
			}		
		}
	};
}
