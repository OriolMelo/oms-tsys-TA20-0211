package oms.UD20EJ1;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	public Ejercicio1() {
		setTitle("Modificador de tamaño");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Etiqueta a redimensionar");
		lblNewLabel.setBackground(new Color(255, 128, 64));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 142, 41);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Aumento en x:");
		lblNewLabel_1.setBounds(10, 199, 89, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(111, 196, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Aumento en y:");
		lblNewLabel_1_1.setBounds(238, 199, 89, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(327, 196, 86, 20);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("Cambiar tamaño");
		btnNewButton.addActionListener(modificar);
		btnNewButton.setBounds(156, 227, 128, 23);
		btnNewButton.addActionListener(modificar);
		contentPane.add(btnNewButton);
		
		setLocationRelativeTo(null);
	}
	
	ActionListener modificar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if(!textField.getText().equals("") && !textField_1.getText().equals("")) {
					int extra_width = Integer.parseInt(textField.getText());
					int extra_height = Integer.parseInt(textField_1.getText());
					lblNewLabel.setSize(lblNewLabel.getWidth()+extra_width, lblNewLabel.getHeight()+extra_height);
				}
			}
			catch(NumberFormatException excepcion) {
				System.out.println("Error: tienes que introducir un entero: "+excepcion.getMessage());
			}
		}
	};
}
