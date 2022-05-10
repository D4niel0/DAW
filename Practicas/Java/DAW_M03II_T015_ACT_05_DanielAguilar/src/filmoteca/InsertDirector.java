package filmoteca;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertDirector extends JFrame {

	private JPanel contentPane;
	private JTextField das_textFieldNombre;
	private JTextField das_textFieldApellidos;

	public InsertDirector() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JLabel das_lblNombre = new JLabel("Nombre:");
		das_lblNombre.setBounds(56, 39, 61, 16);
		contentPane.add(das_lblNombre);
		
		JLabel das_lblApellidos = new JLabel("Apellidos:");
		das_lblApellidos.setBounds(56, 79, 82, 16);
		contentPane.add(das_lblApellidos);
		
		das_textFieldNombre = new JTextField();
		das_textFieldNombre.setBounds(150, 34, 130, 26);
		contentPane.add(das_textFieldNombre);
		das_textFieldNombre.setColumns(10);
		
		das_textFieldApellidos = new JTextField();
		das_textFieldApellidos.setBounds(150, 74, 130, 26);
		contentPane.add(das_textFieldApellidos);
		das_textFieldApellidos.setColumns(10);
		
		JButton das_btnInsertar = new JButton("Insertar");
		das_btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionBBDD.insertarDirector(das_textFieldNombre.getText(), das_textFieldApellidos.getText());
					JDialog das_aviso = new JDialog();
					JLabel das_mensaje = new JLabel("Director añadido");
					das_aviso.getContentPane().add(das_mensaje); 
					das_aviso.setSize(300, 100); 
					das_aviso.setLocationRelativeTo(null); 
					das_aviso.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		das_btnInsertar.setBounds(93, 121, 117, 29);
		contentPane.add(das_btnInsertar);
	}

}
