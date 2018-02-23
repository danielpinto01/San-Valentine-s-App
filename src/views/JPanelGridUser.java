package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import controllers.Controller;
import models.User;

public class JPanelGridUser extends JPanel {

	private static final long serialVersionUID = 1L;

	public JPanelGridUser(Controller controller, ArrayList<User> users, User actualUser) {
		setBackground(Color.WHITE);
		for (User user : users) {
			if (user != actualUser) {
				add(new JPanelUser(controller, user));
			}
		}
	}

	public JPanelGridUser(Controller controller, ArrayList<User> users) {
		setBackground(Color.WHITE);
		for (User user : users) {
			add(new JPanelUser(controller, user));
		}
	}

	public void refreshCards(ArrayList<User> users, User actualUser, Controller controller){
		removeAll();
		updateUI();
		setLayout(new GridLayout(1, 1));
		for (User user : users) {
			if (user != actualUser) {
				if (actualUser.getGenderUser() != user.getGenderUser() ) {
					add(new JPanelUser(controller, user));
				}
			}
		}
		revalidate();
	}

	public void addFirstUser( User user, Controller controller) {
		add(new JPanelUser(controller, user));
	}
}