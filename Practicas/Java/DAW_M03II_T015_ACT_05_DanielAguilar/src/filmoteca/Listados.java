package filmoteca;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Listados extends JFrame {

	// CONEXION
	// Añado una conexion a la BBDD y a ResulSet aqui
	Connection con=null;
	ResultSet rs=null;
	Statement stmt = null;
	private static String das_datosConexion ="jdbc:mysql://127.0.0.1:8889/";
	private static String das_baseDatos = "FILMOTECA";
	private static String das_usuario = "root";
	private static String das_password = "4246";
	
	private JPanel contentPane;
	private JTextField das_textFieldNom;
	private JTextField das_textFieldPais;
	private JTextField das_textFieldGen;
	private JTextField das_textFieldDir;
	private JTextField das_textFieldDura;

	public Listados() {
		
		
		try {
			con = DriverManager.getConnection(das_datosConexion+das_baseDatos, das_usuario, das_password);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 526, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 

		
		JLabel das_lblDir = new JLabel("Director");
		das_lblDir.setBounds(27, 19, 61, 16);
		contentPane.add(das_lblDir);
		
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
		JComboBox das_comboBoxDir = new JComboBox(arrayComboDirectores);
		das_comboBoxDir.setBounds(100, 15, 148, 27);
		contentPane.add(das_comboBoxDir);
		// Esto deja el combobox vacio
		das_comboBoxDir.setSelectedIndex(-1);
		
		JLabel das_lblGen = new JLabel("Género");
		das_lblGen.setBounds(272, 19, 61, 16);
		contentPane.add(das_lblGen);
		
		
		// COMBOBOX GENEROS
		// Extraccion de directores
		ArrayList<String> generos = new ArrayList<String>();
		try {
			generos = GestionBBDD.listarGeneros();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		// Conversion a array String del ArrayList
		String[] arrayComboGeneros = generos.toArray(new String[generos.size()]);
		// Creacion del combobox
		JComboBox das_comboBoxGen = new JComboBox(arrayComboGeneros);
		das_comboBoxGen.setBounds(345, 15, 175, 27);
		contentPane.add(das_comboBoxGen);
		das_comboBoxGen.setSelectedIndex(-1);
		
		
		JLabel das_lblSelec = new JLabel("Selecciona un criterio de búsqueda");
		das_lblSelec.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblSelec.setBounds(6, 95, 514, 16);
		contentPane.add(das_lblSelec);
		
		JLabel das_lblNose = new JLabel("No se han encontrado resultados");
		das_lblNose.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblNose.setBounds(6, 123, 514, 16);
		das_lblNose.setVisible(false);
		contentPane.add(das_lblNose);
		
		das_textFieldNom = new JTextField();
		das_textFieldNom.setEnabled(false);
		das_textFieldNom.setEditable(false);
		das_textFieldNom.setBounds(100, 151, 148, 26);
		contentPane.add(das_textFieldNom);
		das_textFieldNom.setColumns(10);
		
		das_textFieldPais = new JTextField();
		das_textFieldPais.setEnabled(false);
		das_textFieldPais.setEditable(false);
		das_textFieldPais.setBounds(100, 189, 148, 26);
		contentPane.add(das_textFieldPais);
		das_textFieldPais.setColumns(10);
		
		das_textFieldGen = new JTextField();
		das_textFieldGen.setEnabled(false);
		das_textFieldGen.setEditable(false);
		das_textFieldGen.setBounds(100, 227, 148, 26);
		contentPane.add(das_textFieldGen);
		das_textFieldGen.setColumns(10);
		
		das_textFieldDir = new JTextField();
		das_textFieldDir.setEnabled(false);
		das_textFieldDir.setEditable(false);
		das_textFieldDir.setBounds(345, 151, 175, 26);
		contentPane.add(das_textFieldDir);
		das_textFieldDir.setColumns(10);
		
		das_textFieldDura = new JTextField();
		das_textFieldDura.setEnabled(false);
		das_textFieldDura.setEditable(false);
		das_textFieldDura.setBounds(345, 189, 175, 26);
		contentPane.add(das_textFieldDura);
		das_textFieldDura.setColumns(10);
		
		// DECLARACION BOTON SIGUIENTE
		JButton das_btnSiguiente = new JButton("Siguiente");
		das_btnSiguiente.setEnabled(false);
		das_btnSiguiente.setBounds(331, 277, 117, 29);
		contentPane.add(das_btnSiguiente);
		

		
		
		JButton das_btnBuscar = new JButton("Buscar");
		das_btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String query;
			try {	
				// Si los dos combobox están vacios
				if (das_comboBoxDir.getSelectedIndex() == -1 && das_comboBoxGen.getSelectedIndex() == -1) {
					query = "SELECT P.Titulo, P.Pais, P.Genero, P.Duracion, CONCAT(D.Nombre,' ',D.Apellidos) FROM DIRECTOR D INNER JOIN PELICULA P ON D.id_director=P.Director";
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						     ResultSet.CONCUR_READ_ONLY);
					rs = stmt.executeQuery(query); 					
					if (rs.next()) {
						das_btnSiguiente.setEnabled(true);
						das_textFieldNom.setText(rs.getString(1));
						das_textFieldPais.setText(rs.getString(2));
						das_textFieldGen.setText(rs.getString(3));
						das_textFieldDura.setText(rs.getString(4));
						das_textFieldDir.setText(rs.getString(5));
						das_lblNose.setVisible(false);
					} else {
						das_btnSiguiente.setEnabled(false);
						das_lblNose.setVisible(true);
						das_textFieldNom.setText("");
						das_textFieldPais.setText("");
						das_textFieldGen.setText("");
						das_textFieldDura.setText("");
						das_textFieldDir.setText("");
					}
				// Si esta seleccionado solo director
				} else if (das_comboBoxDir.getSelectedIndex() >= 0 && das_comboBoxGen.getSelectedIndex() == -1) {
					int numero;
					numero = Funciones.retornaNumDir(das_comboBoxDir.getSelectedItem());
					query = "SELECT P.Titulo, P.Pais, P.Genero, P.Duracion, CONCAT(D.Nombre,' ',D.Apellidos) FROM DIRECTOR D INNER JOIN PELICULA P ON D.id_director=P.Director WHERE D.id_director=" + numero + ";";
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						     ResultSet.CONCUR_READ_ONLY);
					rs = stmt.executeQuery(query); 
					if (rs.next()) {
						das_btnSiguiente.setEnabled(true);
						das_textFieldNom.setText(rs.getString(1));
						das_textFieldPais.setText(rs.getString(2));
						das_textFieldGen.setText(rs.getString(3));
						das_textFieldDura.setText(rs.getString(4));
						das_textFieldDir.setText(rs.getString(5));
						das_lblNose.setVisible(false);
					} else {
						das_btnSiguiente.setEnabled(false);
						das_lblNose.setVisible(true);
						das_textFieldNom.setText("");
						das_textFieldPais.setText("");
						das_textFieldGen.setText("");
						das_textFieldDura.setText("");
						das_textFieldDir.setText("");
					}
				// Si esta seleccionado solo genero	
				} else if (das_comboBoxDir.getSelectedIndex() == -1 && das_comboBoxGen.getSelectedIndex() >= 0) {
					query = "SELECT P.Titulo, P.Pais, P.Genero, P.Duracion, CONCAT(D.Nombre,' ',D.Apellidos) FROM DIRECTOR D INNER JOIN PELICULA P ON D.id_director=P.Director WHERE P.Genero='" + (String)das_comboBoxGen.getSelectedItem() + "';";
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						     ResultSet.CONCUR_READ_ONLY);
					rs = stmt.executeQuery(query); 
					if (rs.next()) {
						das_btnSiguiente.setEnabled(true);
						das_textFieldNom.setText(rs.getString(1));
						das_textFieldPais.setText(rs.getString(2));
						das_textFieldGen.setText(rs.getString(3));
						das_textFieldDura.setText(rs.getString(4));
						das_textFieldDir.setText(rs.getString(5));
						das_lblNose.setVisible(false);
					} else {
						das_btnSiguiente.setEnabled(false);
						das_lblNose.setVisible(true);
						das_textFieldNom.setText("");
						das_textFieldPais.setText("");
						das_textFieldGen.setText("");
						das_textFieldDura.setText("");
						das_textFieldDir.setText("");
					}
				// Si están seleccionados genero y director	
				} else {
					int numero;
					numero = Funciones.retornaNumDir(das_comboBoxDir.getSelectedItem());	
					query = "SELECT P.Titulo, P.Pais, P.Genero, P.Duracion, CONCAT(D.Nombre,' ',D.Apellidos) FROM DIRECTOR D INNER JOIN PELICULA P ON D.id_director=P.Director WHERE D.id_director="+ numero + " AND P.Genero='"+ (String)das_comboBoxGen.getSelectedItem() +"';";
					Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						     ResultSet.CONCUR_READ_ONLY);
					rs = stmt.executeQuery(query); 
					if (rs.next()) {
						das_btnSiguiente.setEnabled(true);
						das_textFieldNom.setText(rs.getString(1));
						das_textFieldPais.setText(rs.getString(2));
						das_textFieldGen.setText(rs.getString(3));
						das_textFieldDura.setText(rs.getString(4));
						das_textFieldDir.setText(rs.getString(5));
						das_lblNose.setVisible(false);
					} else {
						das_btnSiguiente.setEnabled(false);
						das_lblNose.setVisible(true);
						das_textFieldNom.setText("");
						das_textFieldPais.setText("");
						das_textFieldGen.setText("");
						das_textFieldDura.setText("");
						das_textFieldDir.setText("");
					}
				}	
			} catch (SQLException e1) {
				e1.printStackTrace();
				das_lblNose.setVisible(true);
			} 
		}
		});
		das_btnBuscar.setBounds(199, 54, 117, 29);
		contentPane.add(das_btnBuscar);
		
		// FUNCION BOTON ANTERIOR
		JButton das_btnAnterior = new JButton("Anterior");
		das_btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.previous()) {
						das_btnAnterior.setEnabled(true);
						das_btnSiguiente.setEnabled(true);
						das_textFieldNom.setText(rs.getString(1));
						das_textFieldPais.setText(rs.getString(2));
						das_textFieldGen.setText(rs.getString(3));
						das_textFieldDura.setText(rs.getString(4));
						das_textFieldDir.setText(rs.getString(5));
					} else {
						das_btnAnterior.setEnabled(false);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		das_btnAnterior.setEnabled(false);
		das_btnAnterior.setBounds(100, 277, 117, 29);
		contentPane.add(das_btnAnterior);
		
		// FUNCION BOTON SIGUIENTE
		das_btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.next()) {
						das_btnSiguiente.setEnabled(true);
						das_btnAnterior.setEnabled(true);
						das_textFieldNom.setText(rs.getString(1));
						das_textFieldPais.setText(rs.getString(2));
						das_textFieldGen.setText(rs.getString(3));
						das_textFieldDura.setText(rs.getString(4));
						das_textFieldDir.setText(rs.getString(5));
					} else {
						das_btnSiguiente.setEnabled(false);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});

	}
}
