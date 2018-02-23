package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.xml.sax.SAXException;

import models.User;
import models.UserManager;
import persistence.FileManager;
import views.MainWindow;

public class Controller implements ActionListener{

	private MainWindow mainWindow;
	private UserManager userManager;
	private FileManager fileManager;

	public Controller() {
		fileManager = new FileManager();
		try {
			userManager = new UserManager(fileManager.read());
		} catch (SAXException | IOException | ParserConfigurationException e) {
			userManager = new UserManager();
		}
		mainWindow = new MainWindow(this, userManager.getUserList());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String option = e.getActionCommand();
		try{
			switch (Events.valueOf(option)) {
			case VIEW_ADD_USER:
				showDialogAddUser();
				break;
			case ADD_USER:
				addUser();
				writeReport();
				readListUser();
				getAgeUserJCalendar();
				break;
			case PERSON_IMAGE:
				addIMageController();
				break;
			case EXIT_APP:
				mainWindow.setVisible(false);
				System.exit(0);
				break;
			case SHOW_ABOUT:
				showAboutJOptionPane();
				break;
			default:
				break;
			}
		}catch (Exception p) {
			showDialogInformationUser(userManager.searchId(Integer.parseInt(option)));
			matchUser();
		}
	}
	
	public String getAgeUserJCalendar(){
		return mainWindow.getAgeUserJCalendar();
	}
	
	public void showAboutJOptionPane(){
		mainWindow.showAboutJOptionPane();
	}

	public void matchUser(){
		mainWindow.showAffinity(userManager.matchUser(mainWindow.userOne(), mainWindow.actualUser()));
	}

	private void addIMageController(){
		mainWindow.setVisibleFileChooser();
	}

	public void addUser(){
		User user = UserManager.createUser(mainWindow.getJTextNameUser(), mainWindow.checkJRaddioBtnGender(), mainWindow.getAgeUserJCalendar(), mainWindow.getJComboBoxFavoriteColor(), mainWindow.checkJRaddioBtnLoveAnimals(), mainWindow.getJComboBoxCityLive(), null);
		userManager.addUserToList(user);
		ocultDialogAddUser();
		mainWindow.refreshCards(userManager.getUserList(), this);
		mainWindow.refreshCardsProfile(mainWindow.getPersonToDialog(), this);
	}

	public void writeReport(){
		try {
			fileManager.write(userManager.getUserList());
		} catch (ParserConfigurationException | TransformerFactoryConfigurationError | TransformerException e) {
			e.printStackTrace();
		}
	}

	public void readListUser(){
		try {
			fileManager.read();
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void showDialogAddUser(){
		mainWindow.showDialogAddUser();
	}

	public void ocultDialogAddUser(){
		mainWindow.ocultDialogAddUser();
	}

	public void showDialogInformationUser(User user){
		mainWindow.showDialogInformationUser(user);
	}

	public void ocultDialogInformationUser(){
		mainWindow.ocultDialogInformationUser();
	}
}