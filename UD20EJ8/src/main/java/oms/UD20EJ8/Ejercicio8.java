package oms.UD20EJ8;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.math3.util.Precision;

public class Ejercicio8 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCantidad;
	private JLabel lblResultado;
	private JButton btnCambioMonedas;
	private JButton btnCambiar;
	private JButton btnBorrar;
	private JButton[] botones;
	private int boton_actual;
	private String moneda_actual;
	private final double TASA = 166.386;

	/**
	 * Create the frame.
	 */
	public Ejercicio8() {
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
		btnCambioMonedas.addKeyListener(pulsar);
		btnCambioMonedas.addKeyListener(mover);
		btnCambioMonedas.setBounds(10, 70, 111, 23);
		contentPane.add(btnCambioMonedas);
		botones = new JButton[3];
		botones[0] = btnCambioMonedas;
		botones[0].requestFocus();
		boton_actual = 0;
		
		btnCambiar = new JButton("Cambiar");
		btnCambiar.addActionListener(cambiar);
		btnCambiar.addKeyListener(pulsar);
		btnCambiar.addKeyListener(mover);
		btnCambiar.setBounds(163, 70, 111, 23);
		contentPane.add(btnCambiar);
		botones[1] = btnCambiar;

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(borrar);
		btnBorrar.addKeyListener(pulsar);
		btnBorrar.addKeyListener(mover);
		btnBorrar.setBounds(313, 70, 111, 23);
		contentPane.add(btnBorrar);
		botones[2] = btnBorrar;
		
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
				JOptionPane.showMessageDialog(null, "Error: tienes que introducir un numero");
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
	
	ActionListener borrar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textCantidad.setText("");
			lblResultado.setText("Resultado: ");
		}
	};
	
	KeyListener pulsar = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode()== KeyEvent.VK_ENTER) {
				((JButton) e.getComponent()).doClick();
			}
		}
	};
	

	KeyListener mover = new KeyAdapter() {
		public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
	            case KeyEvent.VK_LEFT:
	               if (boton_actual == 0) {
		            	  boton_actual=2;
	               }
	               else {
	            	   boton_actual--;
	               }
	                  botones[boton_actual].requestFocus();
	               break;
	            case KeyEvent.VK_RIGHT:
		               if (boton_actual == 2) {
			            	  boton_actual=0;
		               }
		               else {
		            	   boton_actual++;
		               }
		                  botones[boton_actual].requestFocus();
	               break;
	            default:
	               break;
            }
         }
	};

}
