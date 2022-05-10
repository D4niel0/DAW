package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import funciones.Funcs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class VentanaLogin extends JFrame {

	private JPanel das_panelLogin;
	private JTextField das_textUser;
	private JPasswordField das_textPass;

	public VentanaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 249);
		das_panelLogin = new JPanel();
		das_panelLogin.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(das_panelLogin);
		das_panelLogin.setLayout(null);
		
		setTitle("VENTANA DE LOGIN"); // TTITULO DE LA VENTANA
		setLocationRelativeTo(null); // CENTRAR VENTANA
		
		JLabel das_lblTitLog = new JLabel("LOGIN");
		das_lblTitLog.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblTitLog.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		das_lblTitLog.setBounds(6, 16, 388, 16);
		das_panelLogin.add(das_lblTitLog);
		
		JLabel das_lblTitUser = new JLabel("USUARIO");
		das_lblTitUser.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		das_lblTitUser.setBounds(74, 57, 61, 16);
		das_panelLogin.add(das_lblTitUser);
		
		JLabel das_lblTitPass = new JLabel("CONTRASEÑA");
		das_lblTitPass.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		das_lblTitPass.setBounds(74, 85, 94, 16);
		das_panelLogin.add(das_lblTitPass);
		
		das_textUser = new JTextField();
		das_textUser.setBounds(181, 52, 130, 26);
		das_panelLogin.add(das_textUser);
		das_textUser.setColumns(10);
				
		das_textPass = new JPasswordField();
		das_textPass.setBounds(180, 80, 131, 26);
		das_panelLogin.add(das_textPass);
		
		
		JLabel das_lblTitSinDatos = new JLabel("DEBES INTRODUCIR LOS DATOS");
		das_lblTitSinDatos.setVisible(false);
		das_lblTitSinDatos.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblTitSinDatos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		das_lblTitSinDatos.setForeground(Color.RED);
		das_lblTitSinDatos.setBounds(6, 132, 388, 16);
		das_panelLogin.add(das_lblTitSinDatos);
		

		
		JLabel das_lblTitErrorAccs = new JLabel("CREDENCIALES INCORRECTAS");
		das_lblTitErrorAccs.setVisible(false);
		das_lblTitErrorAccs.setForeground(Color.RED);
		das_lblTitErrorAccs.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		das_lblTitErrorAccs.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblTitErrorAccs.setBounds(6, 113, 388, 16);
		das_panelLogin.add(das_lblTitErrorAccs);
		
		JButton das_btnAcceder = new JButton("Aceptar");
		das_btnAcceder.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		das_btnAcceder.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				// Realizo este paso ya que me daba problemas al usar la función directamente en un if, por lo que
				// almaceno el resultado de la fución previamente en una variable para utilizarla
				boolean das_result = false;;
				try {
					das_result = Funcs.checking(das_textUser.getText(), das_textPass.getText());
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				// Si pulsamos el botón...
				if (das_btnAcceder==e.getSource()) {
					// Si está vacio...
					if (das_textUser.getText().isEmpty() || das_textPass.getText().isEmpty() ) {
						das_lblTitSinDatos.setVisible(true);
					} else if (das_result == false) {
						das_lblTitErrorAccs.setVisible(true);		
				} else {
					// JOptionPane.showMessageDialog(null, "hola"); // TEST CASE
					VentanaAddTrab frame = new VentanaAddTrab(das_textUser.getText());
					frame.setVisible(true);
					dispose();
				}
			}
			}});

		das_btnAcceder.setBounds(141, 160, 117, 29);
		das_panelLogin.add(das_btnAcceder);

	}

		
}
