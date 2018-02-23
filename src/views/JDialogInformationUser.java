package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import models.User;

public class JDialogInformationUser extends JDialog{

	private static final long serialVersionUID = 1L;
	private JPanel pnlInformation;
	private User user;
	private User actualUser;
	private JLabel lbName;
	private JLabel lbAge;
	private JLabel lbAffinity;
	private JPanel pnlComponents;
	private JProgressBar jProgressBar;
	private JPanel pnlProBar;

	public JDialogInformationUser(MainWindow mainWindow, User user, User actualUser) {
		super(mainWindow);
		this.user = user;
		this.actualUser = actualUser;

		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 1));
		setTitle("Perfíl");
		setSize(400, 200);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		setLocationRelativeTo(mainWindow);

		pnlInformation = new JPanel();
		pnlInformation.setBackground(Color.WHITE);
		showInformationMatch();
	}

	public void showInformationMatch(){
		lbName = new JLabel(user.getNameUser());
		lbName.setFont(new Font("Century Gothic", 1, 20));
		lbName.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbName);

		lbAge = new JLabel(user.getAgeUser());
		lbAge.setFont(new Font("Century Gothic", 1, 20));
		lbAge.setHorizontalAlignment(SwingConstants.CENTER);
		add(lbAge);

		pnlComponents = new JPanel();
		pnlComponents.setBackground(Color.WHITE);
		pnlComponents.setLayout(new GridLayout(2, 1));
		pnlComponents.setBorder((BorderFactory.createEmptyBorder(10, 0, 0, 0)));
		pnlComponents.add(lbName);
		pnlComponents.add(lbAge);
		add(pnlComponents);
	}

	public User userOne(){
		return user;
	}

	public User actualUser(){
		return actualUser;
	}

	public void showDialogInformationUser(){
		setVisible(true);
	}

	public void ocultDialogInformationUser(){
		setVisible(false);
	}

	public void showaffinity(double value){

		jProgressBar = new JProgressBar(0,100);
		jProgressBar.setBackground(Color.WHITE);
		jProgressBar.setForeground(Color.RED);
		jProgressBar.setValue((int)value);

		DecimalFormat format = new DecimalFormat("#.00");
		lbAffinity = new JLabel(format.format(value) + " % - Afinidad");
		lbAffinity.setFont(new Font("Century Gothic", 1,16));
		lbAffinity.setForeground(Color.RED);

		pnlProBar = new JPanel();
		if(value <= 34) {
			jProgressBar.setForeground(Color.RED);
		}else if ( value > 34 && value <= 67) {
			jProgressBar.setForeground(Color.YELLOW);
		}else {
			jProgressBar.setForeground(Color.GREEN);
		}
		pnlProBar.setBackground(Color.WHITE);
		pnlProBar.setBorder((BorderFactory.createEmptyBorder(60, 0, 0, 0)));
		pnlProBar.add(jProgressBar);
		pnlProBar.add(lbAffinity);
		add(pnlProBar);
	}
}