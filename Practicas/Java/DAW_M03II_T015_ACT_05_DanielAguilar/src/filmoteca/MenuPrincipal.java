package filmoteca;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal {

	public JFrame frame;

	public MenuPrincipal() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 540, 362);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null); 

		
		
		JButton das_btnNewFilm = new JButton("Insertar Pelicula");
		das_btnNewFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertPelicula ventanaInsertarPel = new InsertPelicula();
				ventanaInsertarPel.setVisible(true);
			}
		});
		das_btnNewFilm.setBounds(70, 39, 168, 45);
		frame.getContentPane().add(das_btnNewFilm);
		
		JButton das_btnNewDirec = new JButton("Insertar Director");
		das_btnNewDirec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					InsertDirector ventanaInserDir = new InsertDirector();
					ventanaInserDir.setVisible(true);
			}
		});
		das_btnNewDirec.setBounds(311, 39, 168, 45);
		frame.getContentPane().add(das_btnNewDirec);
		
		JButton das_btnModFilm = new JButton("Modificar Pelicula");
		das_btnModFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModPelicula ventanaModPel = new ModPelicula();
				ventanaModPel.setVisible(true);
			}
		});
		das_btnModFilm.setBounds(70, 108, 168, 45);
		frame.getContentPane().add(das_btnModFilm);
		
		JButton das_btnModDirect = new JButton("Modificar Director");
		das_btnModDirect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModDirector ventanaModDir = new ModDirector();
				ventanaModDir.setVisible(true);
			}
		});
		das_btnModDirect.setBounds(311, 108, 168, 45);
		frame.getContentPane().add(das_btnModDirect);
		
		JButton das_btnDelFilm = new JButton("Eliminar Pelicula");
		das_btnDelFilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DelPelicula ventanaDelPel = new DelPelicula();
				ventanaDelPel.setVisible(true);
			}
		});
		das_btnDelFilm.setBounds(70, 179, 168, 45);
		frame.getContentPane().add(das_btnDelFilm);
		
		JButton das_btnDelDirect = new JButton("Eliminar Director");
		das_btnDelDirect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EliminarDirector ventanaDelDir = new EliminarDirector();
				ventanaDelDir.setVisible(true);
			}
		});
		das_btnDelDirect.setBounds(311, 179, 168, 45);
		frame.getContentPane().add(das_btnDelDirect);
		
		JButton das_btnList = new JButton("Listados");
		das_btnList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Listados ventanaList = new Listados();
				ventanaList.setVisible(true);
			}
		});
		das_btnList.setBounds(191, 256, 168, 45);
		frame.getContentPane().add(das_btnList);
	}
}
