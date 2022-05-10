package filmoteca;

import java.awt.EventQueue;

public class Main {
	
	public static GestionBBDD baseDatos = new GestionBBDD();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
