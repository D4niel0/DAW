package gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import clases.Empleado;
import funciones.Funcs;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaAddTrab extends JFrame {

	private JPanel das_PanAddTrab;
	private JTextField das_textNomEmp;
	private final ButtonGroup das_buttonGroupSex = new ButtonGroup();
	


	public VentanaAddTrab(String titulo) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 433, 246);
		das_PanAddTrab = new JPanel();
		das_PanAddTrab.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(das_PanAddTrab);
		das_PanAddTrab.setLayout(null);
		
		setTitle("CREACIÓN DE EMPLEADO"); // TTITULO DE LA VENTANA
		setLocationRelativeTo(null); // CENTRAR VENTANA
		
		JLabel das_lblTitBienv = new JLabel("BIENVENIDO");
		das_lblTitBienv.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblTitBienv.setBounds(6, 6, 421, 16);
		das_PanAddTrab.add(das_lblTitBienv);
		
		
		JLabel das_lblTitUsu = new JLabel(titulo);
		das_lblTitUsu.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblTitUsu.setBounds(6, 26, 421, 16);
		das_PanAddTrab.add(das_lblTitUsu);
		
		JLabel das_lblTitNomEmp = new JLabel("Nombre");
		das_lblTitNomEmp.setBounds(50, 54, 61, 16);
		das_PanAddTrab.add(das_lblTitNomEmp);
		
		JLabel das_lblTitAffEmp = new JLabel("Aficiones");
		das_lblTitAffEmp.setBounds(50, 82, 72, 16);
		das_PanAddTrab.add(das_lblTitAffEmp);
		
		JLabel das_lblTitEdadEmp = new JLabel("Edad");
		das_lblTitEdadEmp.setBounds(50, 110, 61, 16);
		das_PanAddTrab.add(das_lblTitEdadEmp);
		
		JLabel das_lblTitSexEmp = new JLabel("Sexo");
		das_lblTitSexEmp.setBounds(50, 138, 61, 16);
		das_PanAddTrab.add(das_lblTitSexEmp);
		
		das_textNomEmp = new JTextField();
		das_textNomEmp.setBounds(135, 49, 222, 26);
		das_PanAddTrab.add(das_textNomEmp);
		das_textNomEmp.setColumns(10);
		
		JCheckBox das_chckbxProg = new JCheckBox("Programar");
		das_chckbxProg.setBounds(134, 78, 96, 23);
		das_PanAddTrab.add(das_chckbxProg);
		
		JCheckBox das_chckbxDeport = new JCheckBox("Deporte");
		das_chckbxDeport.setBounds(242, 78, 82, 23);
		das_PanAddTrab.add(das_chckbxDeport);
		
		JCheckBox das_chckbxCine = new JCheckBox("Cine");
		das_chckbxCine.setBounds(336, 78, 72, 23);
		das_PanAddTrab.add(das_chckbxCine);
		
		JRadioButton das_rdbtnHombre = new JRadioButton("Hombre");
		das_rdbtnHombre.setSelected(true);
		das_buttonGroupSex.add(das_rdbtnHombre);
		das_rdbtnHombre.setBounds(135, 134, 82, 23);
		das_PanAddTrab.add(das_rdbtnHombre);
		
		JRadioButton das_rdbtnMujer = new JRadioButton("Mujer");
		das_buttonGroupSex.add(das_rdbtnMujer);
		das_rdbtnMujer.setBounds(242, 134, 72, 23);
		das_PanAddTrab.add(das_rdbtnMujer);
		
		JComboBox das_comboBox = new JComboBox();
		das_comboBox.setModel(new DefaultComboBoxModel(new String[] {"10-15", "15-20", "20-25", "25-30", "30-35"}));
		das_comboBox.setBounds(135, 106, 95, 27);
		das_PanAddTrab.add(das_comboBox);
		
		JButton das_btnAddEmp = new JButton("Nuevo Empleado");
		das_btnAddEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ArrayList<Empleado> nuevosEmpleados = new ArrayList<Empleado>();
			// La declaracion del array para los empleados es global	
			// Comprobaciones previas campos vacios
			// Variables para controlar que las dos validaciones
			boolean comp1 = false;
			boolean comp2 = false;
			// Validacion de nombre
			if (das_textNomEmp.getText().isEmpty()) {
					JDialog das_sinNombre = new JDialog();
					JLabel das_mensajeSinNombre = new JLabel("Debes introducir un nombre");
					das_sinNombre.getContentPane().add(das_mensajeSinNombre);
					das_sinNombre.setSize(300, 100);
					das_sinNombre.setLocationRelativeTo(null);
					das_sinNombre.setVisible(true);
					comp1 = false;
			} else {
				comp1 = true;
			}

				
			// Validacion de los checkbox
			if (!das_chckbxProg.isSelected() && !das_chckbxDeport.isSelected() && !das_chckbxCine.isSelected()) {
					JDialog das_sinAficion = new JDialog();
					JLabel das_mensajeSinAficion = new JLabel("Debes introducir una aficion");
					das_sinAficion.getContentPane().add(das_mensajeSinAficion);
					das_sinAficion.setSize(300, 100);
					das_sinAficion.setLocationRelativeTo(null);
					das_sinAficion.setVisible(true);
					comp2 = false;
			} else {
				comp2 = true;
			}

			// Si las dos validaciones son correctas, crea los usuarios
			if (comp1 == true && comp2 == true) {					
				// Usa la funcion para comprobar si existen empleados, si existen crea un arrayList nuevosEmpleados donde añade los empleados del archivo donde estan ya almacenados
				try {
					if (Funcs.compruebaEmpleados()) {

						// Si se hace esto (Si existe ya un fichero, se pisa sobre si mismo y jamas habra mas empleados que 2 + 1), editar en el fichero de texto
						
						try {
							nuevosEmpleados = Funcs.creaArrayList();
							
							// TEST CASE System.out.println(nuevosEmpleados.toString());
						} catch (ClassNotFoundException | IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
					}} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
						// Creacion de nuevos empleados
						// Filtrado de los checkbox
						ArrayList<String> aficiones = new ArrayList<String>();
						if (das_chckbxProg.isSelected()) {
							aficiones.add("Programar");
						}
						if (das_chckbxDeport.isSelected()) {
							aficiones.add("Deporte");
						}
						if (das_chckbxCine.isSelected()) {
							aficiones.add("Cine");
						}
						// Filtrado sexo para creacion final
						if (das_rdbtnHombre.isSelected()) {
							Empleado empleadoNuevo = new Empleado(das_textNomEmp.getText(),(String)das_comboBox.getSelectedItem(),das_rdbtnHombre.getText(),aficiones);
							// Añadir al arrayList de empleados el empleado nuevo
							nuevosEmpleados.add(empleadoNuevo);
							// TEST CASE
							// System.out.println(empleadoNuevo.toString());
						} else {
							Empleado empleadoNuevo = new Empleado(das_textNomEmp.getText(),(String)das_comboBox.getSelectedItem(),das_rdbtnMujer.getText(),aficiones);
							// Añadir al arrayList de empleados el empleado nuevo
							nuevosEmpleados.add(empleadoNuevo);
							// TEST CASE
							// System.out.println(empleadoNuevo.toString());
						}

						// Serializar nuevos empleados
						try {
							Funcs.serializaEmpleados(nuevosEmpleados);
						} catch (IOException e1) {
							System.out.println("Error");
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}			
						
					
				
				// Dialogo una vez se han creado los usuarios
				JDialog das_gracias = new JDialog();
				JLabel das_mensajeGracias = new JLabel("Gracias por usar la aplicacion");
				das_gracias.getContentPane().add(das_mensajeGracias);
				das_gracias.setSize(300, 100);
				das_gracias.setLocationRelativeTo(null);
				das_gracias.setVisible(true);
				
			} else {
				// Mensaje que se muestra por consola cuando las validaciones no son correctas y no se está creando el usuario
				System.out.println("No se ha creado ningun usuario");
			}
			
			
			}
		});
		das_btnAddEmp.setBounds(60, 166, 137, 29);
		das_PanAddTrab.add(das_btnAddEmp);
		
		JButton das_btnShowEmp = new JButton("Mostrar Empleados");
		das_btnShowEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// ArrayList para almacenar los empleados
				ArrayList<Empleado> das_listadoEmpleados = new ArrayList<Empleado>();
				try {
					// Usa la funcion devuelveEmpleados() que recoge los empleados serializados en el archivo datos_empleados.txt, los almacena en el ArrayList
					das_listadoEmpleados = Funcs.creaArrayList();
				} catch (ClassNotFoundException | IOException e1) {
					// TODO Auto-generated catch block
					System.out.println("No existen empleados serializados");
				}
				// JDialog y JLabel del titulo mas propiedades
				JDialog das_listEmple = new JDialog();	
				das_listEmple.setTitle("LISTA DE EMPLEADOS");
				das_listEmple.setLocationRelativeTo(null);
				das_listEmple.setVisible(true);
	
				JLabel das_empList = new JLabel("");
				// Contenido para el JLabel
				String das_contenido = "";
				// For para crear el contenido
				for(int i=0; i<das_listadoEmpleados.size();i++) {
					das_contenido = das_contenido + "<br>" + das_listadoEmpleados.get(i);
				}
				// Insertar el contenido
				das_empList.setText("<html>" + das_contenido + "</html>");
				das_listEmple.getContentPane().add(das_empList);
				// Establecer un tamaño relativo según el contenido
				das_listEmple.pack();
			}
		});
		
		
		das_btnShowEmp.setBounds(236, 166, 147, 29);
		das_PanAddTrab.add(das_btnShowEmp);
	}

}
