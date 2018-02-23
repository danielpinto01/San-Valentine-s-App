package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import models.User;

public class JPanelProfileUser extends JPanel{

	private static final long serialVersionUID = 1L;

	private JLabel lbName;
	private JLabel lbAge;
	@SuppressWarnings("unused")
	private JLabel lbImage;
	private JLabel lbGender;
	private JLabel lbFavoriteColor;
	private JLabel lbLoveAnimals;
	private JLabel lbCity;
	private ImageIcon imgUser;
	private JLabel lbImgUser;
	private JPanel pnlComponents;

	public JPanelProfileUser(User user) {
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 1));

		imgUser = new ImageIcon(getClass().getResource("/images/two.png"));
		lbImgUser = new JLabel(imgUser);
		lbImgUser.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbImgUser);

		lbName = new JLabel(user.getNameUser());
		lbName.setFont(new Font("Century Gothic", 1, 20));
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		
		lbAge = new JLabel(user.getAgeUser());
		lbAge.setHorizontalAlignment(SwingConstants.CENTER);
		lbAge.setFont(new Font("Century Gothic", 1, 20));
		
		lbGender = new JLabel("Sexo:   " + user.getGenderUser());
		lbGender.setHorizontalAlignment(SwingConstants.CENTER);
		lbGender.setFont(new Font("Century Gothic", 0, 15));
		
		lbFavoriteColor = new JLabel("Color Favorito:   " + user.getFavoriteColor());
		lbFavoriteColor.setHorizontalAlignment(SwingConstants.CENTER);
		lbFavoriteColor.setFont(new Font("Century Gothic", 0, 15));

		lbLoveAnimals = new JLabel("¿Te gustan los animales?   " + user.getLoveAnimals());
		lbLoveAnimals.setHorizontalAlignment(SwingConstants.CENTER);
		lbLoveAnimals.setFont(new Font("Century Gothic", 0, 15));

		lbCity = new JLabel("Ciudad:  " + user.getCityLive());
		lbCity.setHorizontalAlignment(SwingConstants.CENTER);
		lbCity.setFont(new Font("Century Gothic", 0, 15));

		pnlComponents = new JPanel();
		pnlComponents.setBackground(Color.WHITE);
		pnlComponents.setLayout(new GridLayout(3, 2));
		pnlComponents.setBorder((BorderFactory.createEmptyBorder(10, 0, 0, 0)));
		pnlComponents.add(lbName);
		pnlComponents.add(lbAge);
		pnlComponents.add(lbGender);
		pnlComponents.add(lbFavoriteColor);
		pnlComponents.add(lbLoveAnimals);
		pnlComponents.add(lbCity);
		add(pnlComponents);
	}	
}