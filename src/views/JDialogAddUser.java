package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.toedter.calendar.JDateChooser;

import controllers.Controller;
import controllers.Events;
import models.CityLive;
import models.FavoriteColor;
import models.Gender;
import models.LoveAnimals;
import models.User;
import models.UserManager;

public class JDialogAddUser extends JDialog{

	private static final long serialVersionUID = 1L;

	private JLabel lbFirstNameUser;
	private JTextField jTextFirstNameUser;
	private JLabel lbAgeUser;
	private JTextField jTextAgeUser;
	private JButton jBtnAddUser;
	private JLabel lbFavoriteColor;
	private JComboBox<FavoriteColor> jComboBoxFavoriteColor;
	private JLabel lbLoveAnimals;
	private JComboBox<LoveAnimals> jComboBoxLoveAnimals;
	private JLabel lbCityLive;
	private JComboBox<CityLive> jComboBoxCityLive;
	private JFileChooser jfileChosser;
	private JLabel lbGender;
	private JComboBox<Gender> jComboBoxGender;
	private JLabel lbEmpty;
	private JRadioButton jRadioButtonMen;
	private JRadioButton jRadioButtonWomen;
	private ButtonGroup buttonGroupGender;
	private JRadioButton jRadioButtonLoveAnimalsYes;
	private JRadioButton jRadioButtonLoveAnimalsNo;
	private ButtonGroup buttonGroupLoveAnimals;
	private JDateChooser jDateChooser;

	public JDialogAddUser(Controller controller, MainWindow mainWindow) {
		super(mainWindow, true);
		setLayout(new GridLayout(16, 1));
		setTitle("Agregar Usuario");
		setSize(330, 540);
		getContentPane().setBackground(Color.GRAY);
		setLocationRelativeTo(mainWindow);

		jfileChosser = new JFileChooser();
		
		lbFirstNameUser = new JLabel("Nombre: ");
		lbFirstNameUser.setFont(new Font("Century Gothic", 2, 14));
		lbFirstNameUser.setForeground(Color.WHITE);
		lbFirstNameUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		lbFirstNameUser.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbFirstNameUser);

		jTextFirstNameUser = new JTextField(12);
		jTextFirstNameUser.setFont(new Font("Century Gothic", 2, 14));
		jTextFirstNameUser.setText("Daniel");
		jTextFirstNameUser.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		add(jTextFirstNameUser);

		lbGender = new JLabel("Género:");
		lbGender.setFont(new Font("Century Gothic", 2, 14));
		lbGender.setForeground(Color.WHITE);
		lbGender.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		lbGender.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbGender);

		jComboBoxGender = new JComboBox<>(Gender.values());
		jComboBoxGender.setFont(new Font("Century Gothic", 2, 14));
		jComboBoxGender.setBackground(Color.WHITE);
		
		jRadioButtonMen = new JRadioButton("Hombre");
		jRadioButtonMen.setBackground(Color.GRAY);
		jRadioButtonMen.setForeground(Color.WHITE);
		jRadioButtonMen.setSelected(true);
		jRadioButtonMen.setFont(new Font("Century Gothic", 2, 14));
		add(jRadioButtonMen);
		
		jRadioButtonWomen = new JRadioButton("Mujer");
		jRadioButtonWomen.setBackground(Color.GRAY);
		jRadioButtonWomen.setForeground(Color.WHITE);
		jRadioButtonWomen.setFont(new Font("Century Gothic", 2, 14));
		add(jRadioButtonWomen);
		
		buttonGroupGender = new ButtonGroup();
		buttonGroupGender.add(jRadioButtonMen);
		buttonGroupGender.add(jRadioButtonWomen);
		
		lbAgeUser = new JLabel("Fecha de Nacimiento:");
		lbAgeUser.setFont(new Font("Century Gothic", 2, 14));
		lbAgeUser.setForeground(Color.WHITE);
		lbAgeUser.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		lbAgeUser.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbAgeUser);
		
		jDateChooser = new JDateChooser();
		jDateChooser.setFont(new Font("Century Gothic", 2, 14));
		add(jDateChooser);

		lbFavoriteColor = new JLabel("Color Favorito:");
		lbFavoriteColor.setFont(new Font("Century Gothic", 2, 14));
		lbFavoriteColor.setForeground(Color.WHITE);
		lbFavoriteColor.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		lbFavoriteColor.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbFavoriteColor);

		jComboBoxFavoriteColor = new JComboBox<>(FavoriteColor.values());
		jComboBoxFavoriteColor.setFont(new Font("Century Gothic", 2, 14));
		jComboBoxFavoriteColor.setBackground(Color.WHITE);
		jComboBoxFavoriteColor.setBorder(BorderFactory.createEmptyBorder(0, 0,0, 0));
		add(jComboBoxFavoriteColor);

		lbLoveAnimals = new JLabel("¿Te gustan los animales?");
		lbLoveAnimals.setFont(new Font("Century Gothic", 2, 14));
		lbLoveAnimals.setForeground(Color.WHITE);
		lbLoveAnimals.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		lbLoveAnimals.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbLoveAnimals);

		jRadioButtonLoveAnimalsYes = new JRadioButton("Si");
		jRadioButtonLoveAnimalsYes.setBackground(Color.GRAY);
		jRadioButtonLoveAnimalsYes.setForeground(Color.WHITE);
		jRadioButtonLoveAnimalsYes.setSelected(true);
		jRadioButtonLoveAnimalsYes.setFont(new Font("Century Gothic", 2, 14));
		add(jRadioButtonLoveAnimalsYes);
		
		jRadioButtonLoveAnimalsNo = new JRadioButton("No");
		jRadioButtonLoveAnimalsNo.setBackground(Color.GRAY);
		jRadioButtonLoveAnimalsNo.setForeground(Color.WHITE);
		jRadioButtonLoveAnimalsNo.setFont(new Font("Century Gothic", 2, 14));
		add(jRadioButtonLoveAnimalsNo);
		
		buttonGroupLoveAnimals = new ButtonGroup();
		buttonGroupLoveAnimals.add(jRadioButtonLoveAnimalsYes);
		buttonGroupLoveAnimals.add(jRadioButtonLoveAnimalsNo);

		lbCityLive = new JLabel("Ciudad:");
		lbCityLive.setFont(new Font("Century Gothic", 2, 14));
		lbCityLive.setForeground(Color.WHITE);
		lbCityLive.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		lbCityLive.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbCityLive);

		jComboBoxCityLive = new JComboBox<>(CityLive.values());
		jComboBoxCityLive.setFont(new Font("Century Gothic", 2, 14));
		jComboBoxCityLive.setBackground(Color.WHITE);
		jComboBoxCityLive.setBorder(BorderFactory.createEmptyBorder(0, 0,0, 0));
		add(jComboBoxCityLive);

		JButton btnImage = new JButton("Imágen");
		btnImage.setFont(new Font("Century Gothic", 2, 14));
		btnImage.setActionCommand(Events.PERSON_IMAGE.toString());
		btnImage.addActionListener(controller);
		btnImage.setForeground(Color.WHITE);
		btnImage.setFont(new Font("Arial", 1,12));
		btnImage.setBackground(Color.BLACK);
		btnImage.setFocusable(false);

		lbEmpty = new JLabel();
		add(lbEmpty);

		jBtnAddUser = new JButton("Agregar Usuario");
		jBtnAddUser.addActionListener(controller);
		jBtnAddUser.setActionCommand(Events.ADD_USER.toString());
		jBtnAddUser.setForeground(Color.WHITE);
		jBtnAddUser.setFont(new Font("Century Gothic", 2,14));
		jBtnAddUser.setBackground(Color.RED);
		add(jBtnAddUser);
		
	}
	
	public String getAgeUserJCalendar(){
		SimpleDateFormat dateBirth = new  SimpleDateFormat("dd/MM/yyyy");
		return dateBirth.format(jDateChooser.getDate());
	}
	
	public String checkJRaddioBtnGender(){
		if (jRadioButtonMen.isSelected()) {
			return "Hombre";
		}else if(jRadioButtonWomen.isSelected()){
			return "Mujer";
		}else{
			return "";
		}
	}
	
	public String checkJRaddioBtnLoveAnimals(){
		if (jRadioButtonLoveAnimalsYes.isSelected()) {
			return "Si";
		}else if(jRadioButtonLoveAnimalsNo.isSelected()){
			return "No";
		}else{
			return "";
		}
	}
	
	public String getLoveAnimalToUser(){
		return String.valueOf(checkJRaddioBtnLoveAnimals());
	}
	
	public String getGenderToUser(){
		return String.valueOf(checkJRaddioBtnGender());
	}

	public String contactImage(){
		String path = "";
		FileNameExtensionFilter formatImages = new FileNameExtensionFilter("Only JPG or PNG format", "jpg", "png", "jpeg");
		jfileChosser.setFileFilter(formatImages);
		int resultImage = jfileChosser.showOpenDialog(this);
		if (resultImage == JFileChooser.APPROVE_OPTION) {
			File file = jfileChosser.getSelectedFile();
			path = file.getPath();
		}
		return path;
	}

	public void showDialogAddUser(){
		setVisible(true);
	}

	public void ocultDialogAddUser(){
		setVisible(false);
	}

	public String getJTextNameUser(){
		return jTextFirstNameUser.getText();
	}

	public String getJTextAgeUser(){
		return jTextAgeUser.getText();
	}

	public String getJComboBoxFavoriteColor(){
		return String.valueOf(jComboBoxFavoriteColor.getSelectedItem());
	}

	public String getJComboBoxLoveAnimals(){
		return String.valueOf(jComboBoxLoveAnimals.getSelectedItem());
	}

	public String getJComboBoxCityLive(){
		return String.valueOf(jComboBoxCityLive.getSelectedItem());
	}

	public User getPersonToDialog(){
		checkJRaddioBtnGender();
		return UserManager.createUser(getJTextNameUser(), getGenderToUser(), getAgeUserJCalendar(), getJComboBoxFavoriteColor(), getLoveAnimalToUser(), getJComboBoxCityLive(), null);
	}
}