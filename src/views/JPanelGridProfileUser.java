package views;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

import controllers.Controller;
import models.User;

public class JPanelGridProfileUser extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelGridProfileUser(User user) {
		setBackground(Color.WHITE);
		add(new JPanelProfileUser(user));
	}

	public JPanelGridProfileUser() {
		setBackground(Color.WHITE);
	}

	public void refreshCardsProfile(User user, Controller controller){
		removeAll();
		updateUI(); 
		//System.out.println("Actualizar perfíl");
		add(new JPanelProfileUser(user));
		setLayout(new GridLayout(1, 1));
		revalidate();
	}
}