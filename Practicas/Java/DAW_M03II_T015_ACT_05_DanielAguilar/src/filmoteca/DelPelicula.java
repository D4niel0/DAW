package filmoteca;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class DelPelicula extends JFrame {

	private JPanel contentPane;

	public DelPelicula() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setLocationRelativeTo(null); 
		
		// COMBOBOX
		// Extraccion de peliculas
		ArrayList<String> peliculas = new ArrayList<String>();
		try {
			peliculas = GestionBBDD.listarPeliculas();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Conversion a array String del ArrayList
		String[] arrayCombo = peliculas.toArray(new String[peliculas.size()]);	
		// Creacion del comboBox
		JComboBox das_comboBoxPel = new JComboBox(arrayCombo);
		das_comboBoxPel.setBounds(82, 71, 300, 27);
		contentPane.add(das_comboBoxPel);
		
		JLabel das_lblTit = new JLabel("Selecciona película");
		das_lblTit.setHorizontalAlignment(SwingConstants.CENTER);
		das_lblTit.setBounds(6, 43, 438, 16);
		contentPane.add(das_lblTit);
		
		JButton das_btnDel = new JButton("Eliminar");
		das_btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GestionBBDD.delPelicula((String)das_comboBoxPel.getSelectedItem());
					JDialog das_aviso = new JDialog();
					JLabel das_mensaje = new JLabel("Película eliminada");
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
		das_btnDel.setBounds(164, 154, 117, 29);
		contentPane.add(das_btnDel);
	}

}
