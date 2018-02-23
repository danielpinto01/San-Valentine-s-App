package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controllers.Controller;
import models.User;

public class JPanelUser extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private JLabel lbName;
	private JLabel lbGender;
	private JLabel lbAge;
	private JLabel lbCity;
	private JButton btnMatch;
	private ImageIcon imgUser;
	private JLabel lbImgUser;
	private JPanel pnlComponents;

	public JPanelUser(Controller controller, User user) {
		setBorder(BorderFactory.createEmptyBorder(10, 0,0, 0));
		setBackground(Color.WHITE);
		setLayout(new GridLayout(2, 1));
		
		imgUser = new ImageIcon(getClass().getResource("/images/one.png"));
		lbImgUser = new JLabel(imgUser);
		lbImgUser.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbImgUser);
		
		lbName = new JLabel(user.getNameUser());
		lbName.setFont(new Font("Century Gothic", 2, 14));
		
		lbGender = new JLabel(user.getGenderUser());
		lbGender.setFont(new Font("Century Gothic", 2, 14));

		lbAge = new JLabel(user.getAgeUser());
		lbAge.setFont(new Font("Century Gothic", 2, 14));

		lbCity = new JLabel(user.getCityLive());
		lbCity.setFont(new Font("Century Gothic", 2, 14));
		
		btnMatch = new JButton("Perfíl");
		btnMatch.addActionListener(controller);
		btnMatch.setActionCommand(user.getIdUser() + "");
		btnMatch.setForeground(Color.WHITE);
		btnMatch.setFont(new Font("Century Gothic", 1,14));
		btnMatch.setBackground(Color.RED);
		btnMatch.setBorder(BorderFactory.createEmptyBorder(0, 0,0, 0));
		btnMatch.setFocusable(false);
		add(btnMatch);
		
		pnlComponents = new JPanel();
		pnlComponents.setBackground(Color.WHITE);
		pnlComponents.setLayout(new GridLayout(5, 1));
		pnlComponents.setBorder((BorderFactory.createEmptyBorder(10, 0, 0, 0)));
		pnlComponents.add(lbName);
		pnlComponents.add(lbAge);
		pnlComponents.add(lbGender);
		pnlComponents.add(lbCity);
		pnlComponents.add(btnMatch);
		add(pnlComponents);
	}	
}