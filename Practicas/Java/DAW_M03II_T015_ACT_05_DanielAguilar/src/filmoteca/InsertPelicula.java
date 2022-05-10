package filmoteca;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class InsertPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField das_textFieldTitulo;
	private JTextField das_textFieldPais;
	private JTextField das_textFieldDuracion;
	private JTextField das_textFieldGenero;

	public InsertPelicula() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.setLocationRelativeTo(null); 

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel das_titTitulo = new JLabel("Titulo:");
		das_titTitulo.setBounds(76, 47, 61, 16);
		contentPane.add(das_titTitulo);
		
		JLabel das_titDirector = new JLabel("Director:");
		das_titDirector.setBounds(76, 75, 61, 16);
		contentPane.add(das_titDirector);
		
		JLabel das_titPais = new JLabel("Pais:");
		das_titPais.setBounds(76, 103, 61, 16);
		contentPane.add(das_titPais);
		
		JLabel das_titDuracion = new JLabel("Duracion:");
		das_titDuracion.setBounds(76, 139, 61, 16);
		contentPane.add(das_titDuracion);
		
		JLabel das_titGenero = new JLabel("Genero:");
		das_titGenero.setBounds(76, 177, 61, 16);
		contentPane.add(das_titGenero);
		
		
		das_textFieldTitulo = new JTextField();
		das_textFieldTitulo.setBounds(179, 42, 201, 26);
		contentPane.add(das_textFieldTitulo);
		das_textFieldTitulo.setColumns(10);
		
		das_textFieldPais = new JTextField();
		das_textFieldPais.setBounds(179, 98, 201, 26);
		contentPane.add(das_textFieldPais);
		das_textFieldPais.setColumns(10);
		
		das_textFieldDuracion = new JTextField();
		das_textFieldDuracion.setBounds(179, 134, 201, 26);
		contentPane.add(das_textFieldDuracion);
		das_textFieldDuracion.setColumns(10);
		
		das_textFieldGenero = new JTextField();
		das_textFieldGenero.setBounds(179, 172, 201, 26);
		contentPane.add(das_textFieldGenero);
		das_textFieldGenero.setColumns(10);
		
		// COMBOBOX
		// Extraccion de directores
		ArrayList<String> directores = new ArrayList<String>();
		try {
			directores = GestionBBDD.listarDirectores();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Conversion a array String del ArrayList
		String[] arrayCombo = directores.toArray(new String[directores.size()]);
		// Creacion del combobox
		JComboBox das_comboBoxDirector = new JComboBox(arrayCombo);
		das_comboBoxDirector.setBounds(179, 71, 201, 27);
		contentPane.add(das_comboBoxDirector);
	
		
		JButton das_btnCrear = new JButton("Crear película");
		das_btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			// Seleccion primer caracter director	
				int numero;
				numero = Funciones.retornaNumDir(das_comboBoxDirector.getSelectedItem());
			// Añadir película	
				try {
					GestionBBDD.insertarPelicula(das_textFieldTitulo.getText(), numero, das_textFieldPais.getText(), Integer.parseInt(das_textFieldDuracion.getText()), das_textFieldGenero.getText());
					JDialog das_aviso = new JDialog();
					JLabel das_mensaje = new JLabel("Película creada");
					das_aviso.getContentPane().add(das_mensaje); 
					das_aviso.setSize(300, 100); 
					das_aviso.setLocationRelativeTo(null); 
					das_aviso.setVisible(true);
					dispose();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		das_btnCrear.setBounds(155, 211, 142, 36);
		contentPane.add(das_btnCrear);
	
	
	
	}
}
