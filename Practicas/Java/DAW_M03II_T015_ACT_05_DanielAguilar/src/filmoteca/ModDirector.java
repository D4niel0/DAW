package filmoteca;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;

import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModDirector extends JFrame {

	private JPanel contentPane;
	private JTextField das_textFieldNombre;
	private JTextField das_textFieldApellidos;

	public ModDirector() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JLabel das_lblSelecc = new JLabel("Selecciona director");
		das_lblSelecc.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblSelecc.setBounds(6, 18, 438, 16);
		contentPane.add(das_lblSelecc);
		
		
		// COMBOBOX DIRECTORES
		// Extraccion de directores
		ArrayList<String> directores = new ArrayList<String>();
		try {
			directores = GestionBBDD.listarDirectores();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		// Conversion a array String del ArrayList
		String[] arrayComboDirectores = directores.toArray(new String[directores.size()]);
		// Creacion del combobox
		JComboBox das_comboBox = new JComboBox(arrayComboDirectores);
		das_comboBox.setBounds(119, 46, 211, 27);
		contentPane.add(das_comboBox);
		
		JLabel das_lblNombre = new JLabel("Nombre");
		das_lblNombre.setBounds(86, 95, 61, 16);
		contentPane.add(das_lblNombre);
		
		das_textFieldNombre = new JTextField();
		das_textFieldNombre.setBounds(177, 90, 153, 26);
		contentPane.add(das_textFieldNombre);
		das_textFieldNombre.setColumns(10);
		
		JLabel das_lblApellidos = new JLabel("Apellidos");
		das_lblApellidos.setBounds(86, 134, 61, 16);
		contentPane.add(das_lblApellidos);
		
		das_textFieldApellidos = new JTextField();
		das_textFieldApellidos.setBounds(177, 128, 153, 26);
		contentPane.add(das_textFieldApellidos);
		das_textFieldApellidos.setColumns(10);
		
		JButton das_btnMod = new JButton("Modificar");
		das_btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Seleccion primer caracter director	
				int numero;
				numero = Funciones.retornaNumDir(das_comboBox.getSelectedItem());
				try {
					GestionBBDD.modDirector(das_textFieldNombre.getText(), das_textFieldApellidos.getText(), numero);
					JDialog das_aviso = new JDialog();
					JLabel das_mensaje = new JLabel("Director modificado");
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
		das_btnMod.setBounds(154, 191, 117, 37);
		contentPane.add(das_btnMod);
	}

}
