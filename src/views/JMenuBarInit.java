package views;

import java.awt.Font;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controllers.Controller;
import controllers.Events;

public class JMenuBarInit extends JMenuBar{

	private static final long serialVersionUID = 1L;
	
	public JMenuBarInit(Controller controller) {
		
		JMenu menuPerson = new JMenu("Inicio");	
		menuPerson.setFont(new Font("Century Gothic", 0, 14));

		JMenuItem menuAddPerson = new JMenuItem("Agregar Usuario");
		menuAddPerson.setFont(new Font("Century Gothic", 1, 14));
		menuAddPerson.addActionListener(controller);
		menuAddPerson.setActionCommand(Events.VIEW_ADD_USER.toString());
		menuPerson.add(menuAddPerson);
		
		JMenuItem menuAbout = new JMenuItem("Acerca de ");
		menuAbout.setFont(new Font("Century Gothic", 1, 14));
		menuAbout.addActionListener(controller);
		menuAbout.setActionCommand(Events.SHOW_ABOUT.toString());
		menuPerson.add(menuAbout);

		JMenuItem menuExitApp = new JMenuItem("Salir de la App");
		menuExitApp.setFont(new Font("Century Gothic", 1, 14));
		menuExitApp.addActionListener(controller);
		menuExitApp.setActionCommand(Events.EXIT_APP.toString());
		menuPerson.add(menuExitApp);
		add(menuPerson);

	}
}