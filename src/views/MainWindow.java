package views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import controllers.Controller;
import models.User;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JDialogAddUser jDialogAddUser;
	private JPanelGridUser jPanelGridUser;
	private JScrollPane jScrollPane;
	private JPanelGridProfileUser jPanelGridProfileUser;
	private JDialogInformationUser jDialogInformationUser;
	private User actualUser;

	public MainWindow(Controller controller, ArrayList<User> users) {
		setBackground(Color.WHITE);
		setTitle("Amodebu v1.0");
		setSize(460,720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
		setLayout(new GridLayout(2, 1));

		setJMenuBar(new JMenuBarInit(controller));

		jDialogAddUser = new JDialogAddUser(controller, this);

		if(users.size() != 0){
			actualUser = users.get(users.size()- 1);
			
			jPanelGridProfileUser = new JPanelGridProfileUser(actualUser);
			add(jPanelGridProfileUser);

			jPanelGridUser = new JPanelGridUser(controller, users, actualUser);

			jScrollPane = new JScrollPane(jPanelGridUser);
			add(jScrollPane);
		}else{
			jPanelGridProfileUser = new JPanelGridProfileUser();
			add(jPanelGridProfileUser);
			jPanelGridUser = new JPanelGridUser(controller, users);

			jScrollPane = new JScrollPane(jPanelGridUser);
			add(jScrollPane);
		}
		setVisible(true);
	}

	public MainWindow(Controller controller) {
		setBackground(Color.WHITE);
		setTitle("Buscar Personas v1.0");
		setSize(460,720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());

		setLayout(new GridLayout(2, 1));

		setJMenuBar(new JMenuBarInit(controller));

		jDialogAddUser = new JDialogAddUser(controller, this);

		
		setVisible(true);
	}

	public String getAgeUserJCalendar(){
		return jDialogAddUser.getAgeUserJCalendar();
	}
	
	public void showAboutJOptionPane(){
		ImageIcon imgIcon = new ImageIcon(getClass().getResource("/images/icon.png"));
		JOptionPane.showMessageDialog(null, "Daniel Pinto Corporation Inc :v", "Acerca de", 1, imgIcon);
	}

	public void showDialogAddUser(){
		jDialogAddUser.showDialogAddUser();
	}

	public void ocultDialogAddUser(){
		jDialogAddUser.ocultDialogAddUser();
	}

	public String getJTextNameUser(){
		return jDialogAddUser.getJTextNameUser();
	}

	public String checkJRaddioBtnGender(){
		return jDialogAddUser.checkJRaddioBtnGender();
	}

	public String getJTextAgeUser(){
		return jDialogAddUser.getJTextAgeUser();
	}

	public User getPersonToDialog(){
		return jDialogAddUser.getPersonToDialog();
	}

	public String getJComboBoxFavoriteColor(){
		return (String)jDialogAddUser.getJComboBoxFavoriteColor();
	}
	
	public String checkJRaddioBtnLoveAnimals(){
		return jDialogAddUser.checkJRaddioBtnLoveAnimals();
	}

	public String getJComboBoxCityLive(){
		return (String)jDialogAddUser.getJComboBoxCityLive();
	}

	public void refreshCards(ArrayList<User> users, Controller controller){
		actualUser = users.get(users.size()-1);
		jPanelGridUser.refreshCards(users,actualUser, controller);
	}

	public void refreshCardsProfile(User user, Controller controller){
		jPanelGridProfileUser.refreshCardsProfile(user, controller);
		jPanelGridProfileUser.setBackground(Color.blue);
	}

	public void showDialogInformationUser(User user){
		jDialogInformationUser = new JDialogInformationUser(this, user, actualUser);
		jDialogInformationUser.setVisible(true);
	}
	
	public void showAffinity(double value){
		jDialogInformationUser.showaffinity(value);
	}

	public void ocultDialogInformationUser(){
		jDialogInformationUser.setVisible(false);
	}

	public User userOne(){
		return jDialogInformationUser.userOne();
	}
	
	public User actualUser(){
		return jDialogInformationUser.actualUser();
	}
	
	public void setVisibleFileChooser(){
		jDialogAddUser.contactImage();
	}
}