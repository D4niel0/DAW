package filmoteca;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EliminarDirector extends JFrame {

	private JPanel contentPane;


	public EliminarDirector() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		JLabel das_lblSelec = new JLabel("Selecciona director");
		das_lblSelec.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblSelec.setBounds(6, 26, 438, 16);
		contentPane.add(das_lblSelec);
		
		JLabel das_lbltit2 = new JLabel("Solo se muestran directores que no tienen peliculas");
		das_lbltit2.setHorizontalAlignment(SwingConstants.CENTER);
		das_lbltit2.setBounds(6, 54, 438, 16);
		contentPane.add(das_lbltit2);
		
		
		// COMBOBOX DIRECTORES
		// Extraccion de directores
		ArrayList<String> directores = new ArrayList<String>();
		try {
			directores = GestionBBDD.listarDirectoresSinPeliculas();
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		// Conversion a array String del ArrayList
		String[] arrayComboDirectores = directores.toArray(new String[directores.size()]);
		// Creacion del combobox
		JComboBox das_comboBox = new JComboBox(arrayComboDirectores);
		das_comboBox.setBounds(114, 82, 213, 27);
		contentPane.add(das_comboBox);
		
		
		JButton das_btn = new JButton("Eliminar");
		das_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Seleccion primer caracter director	
				int numero;
				numero = Funciones.retornaNumDir(das_comboBox.getSelectedItem());
				try {
					GestionBBDD.delDirector(numero);
					JDialog das_aviso = new JDialog();
					JLabel das_mensaje = new JLabel("Director eliminado");
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
		das_btn.setBounds(161, 143, 117, 39);
		contentPane.add(das_btn);
	}

}
