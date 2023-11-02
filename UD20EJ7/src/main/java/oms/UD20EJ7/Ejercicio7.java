package oms.UD20EJ7;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.math3.util.Precision;

public class Ejercicio7 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCantidad;
	private JLabel lblResultado;
	private JButton btnCambioMonedas;
	private JButton btnCambiar;
	private String moneda_actual;
	private final double TASA = 166.386;

	/**
	 * Create the frame.
	 */
	public Ejercicio7() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCantidad = new JLabel("Cantidad a convertir");
		lblCantidad.setBounds(10, 23, 111, 14);
		contentPane.add(lblCantidad);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(132, 20, 86, 20);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		
		lblResultado = new JLabel("Resultado:");
		lblResultado.setBounds(241, 23, 183, 14);
		contentPane.add(lblResultado);
		
		btnCambioMonedas = new JButton("Euros a ptas");
		btnCambioMonedas.addActionListener(calcular);
		btnCambioMonedas.setBounds(80, 70, 111, 23);
		contentPane.add(btnCambioMonedas);
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(cambiar);
		btnCambiar.setBounds(217, 70, 111, 23);
		contentPane.add(btnCambiar);
		
		moneda_actual = "Euros";
		
		setLocationRelativeTo(null);
	}
	
	ActionListener calcular = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if(!textCantidad.getText().equals("")) {
					double cantidad = Double.parseDouble(textCantidad.getText());
					if(moneda_actual.equals("Euros")) {
						cantidad *= TASA;
					}
					else if(moneda_actual.equals("Ptas")) {
						cantidad /= TASA;
					}
					lblResultado.setText("Resultado: "+Precision.round(cantidad,2));
				}
			}
			catch(NumberFormatException excepcion) {
				System.out.println("Error: tienes que introducir un numero: "+excepcion.getMessage());
			}		
		}
	};
	
	ActionListener cambiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(btnCambioMonedas.getText().equals("Euros a ptas")) {
				btnCambioMonedas.setText("Ptas a euros");
				moneda_actual = "Ptas";
			}
			else if(btnCambioMonedas.getText().equals("Ptas a euros")){
				btnCambioMonedas.setText("Euros a ptas");
				moneda_actual = "Euros";
			}
		}
	};

}
