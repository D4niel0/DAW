package filmoteca;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModPelicula extends JFrame {

	private JPanel contentPane;
	private JTextField das_textFieldTitulo;
	private JTextField das_textFieldPais;
	private JTextField das_textFieldDuracion;
	private JTextField das_textFieldGenero;

	public ModPelicula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JLabel das_lblSelecc = new JLabel("Selecciona película");
		das_lblSelecc.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblSelecc.setBounds(6, 21, 438, 16);
		contentPane.add(das_lblSelecc);
		
		// COMBOBOX PELICULAS
		// Extraccion de peliculas
		ArrayList<String> peliculas = new ArrayList<String>();
		try {
			peliculas = GestionBBDD.listarPeliculas();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Conversion a array String del ArrayList
		String[] arrayComboPeliculas = peliculas.toArray(new String[peliculas.size()]);	
		// Creacion de Combobox
		JComboBox das_comboBoxPelicula = new JComboBox(arrayComboPeliculas);
		das_comboBoxPelicula.setBounds(84, 49, 283, 27);
		contentPane.add(das_comboBoxPelicula);
		
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
		JComboBox das_comboBoxDirector = new JComboBox(arrayComboDirectores);
		das_comboBoxDirector.setBounds(177, 124, 190, 27);
		contentPane.add(das_comboBoxDirector);
		
		JLabel das_lblTitulo = new JLabel("Título:");
		das_lblTitulo.setBounds(84, 92, 61, 16);
		contentPane.add(das_lblTitulo);
		
		JLabel das_lblDirector = new JLabel("Director:");
		das_lblDirector.setBounds(84, 128, 61, 16);
		contentPane.add(das_lblDirector);
		
		JLabel das_lblPais = new JLabel("Pais:");
		das_lblPais.setBounds(84, 166, 61, 16);
		contentPane.add(das_lblPais);
		
		JLabel das_lblDuracion = new JLabel("Duración:");
		das_lblDuracion.setBounds(84, 204, 81, 16);
		contentPane.add(das_lblDuracion);
		
		JLabel das_lblGenero = new JLabel("Género:");
		das_lblGenero.setBounds(84, 242, 61, 16);
		contentPane.add(das_lblGenero);
		

		
		das_textFieldTitulo = new JTextField();
		das_textFieldTitulo.setBounds(177, 87, 190, 26);
		contentPane.add(das_textFieldTitulo);
		das_textFieldTitulo.setColumns(10);
		
		das_textFieldPais = new JTextField();
		das_textFieldPais.setBounds(177, 161, 190, 26);
		contentPane.add(das_textFieldPais);
		das_textFieldPais.setColumns(10);
		
		das_textFieldDuracion = new JTextField();
		das_textFieldDuracion.setBounds(177, 199, 190, 26);
		contentPane.add(das_textFieldDuracion);
		das_textFieldDuracion.setColumns(10);
		
		das_textFieldGenero = new JTextField();
		das_textFieldGenero.setBounds(177, 237, 190, 26);
		contentPane.add(das_textFieldGenero);
		das_textFieldGenero.setColumns(10);
		

		JButton das_btnMod = new JButton("Modificar");
		das_btnMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Seleccion primer caracter director	
				int numero;
				numero = Funciones.retornaNumDir(das_comboBoxDirector.getSelectedItem());
				// Modificar pelicula
				try {
					GestionBBDD.modPelicula((String)das_comboBoxPelicula.getSelectedItem(), das_textFieldTitulo.getText(), numero, das_textFieldPais.getText(), Integer.parseInt(das_textFieldDuracion.getText()), das_textFieldGenero.getText());
					JDialog das_aviso = new JDialog();
					JLabel das_mensaje = new JLabel("Película modificada");
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
		das_btnMod.setBounds(145, 291, 151, 41);
		contentPane.add(das_btnMod);
	
	
	
	}

}
