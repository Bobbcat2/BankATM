package BankATMGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import BankATMDAO.*;

public class GUIChangeBankATMPassword extends GUIChangePassword {

	private String username;
	private JPanel contentPane;
	private JPasswordField passwordField_2;
	private JButton btnChange;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JPasswordField passwordField_1;
	
	/**
	 * Create the frame.
	 */
	public GUIChangeBankATMPassword(String username) {
		super();
		this.username = username;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblHeadline = new JLabel("<html>\r\nPlease enter your new password twice.\r\n</html>");
		lblHeadline.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		lblHeadline.setBounds(194, 28, 420, 100);
		contentPane.add(lblHeadline);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_2.setFont(new Font("Consolas", Font.PLAIN, 20));
		passwordField_2.setBounds(280, 322, 290, 60);
		contentPane.add(passwordField_2);
		
		JButton btnBack = new JButton("Back");
		BackListener bl = new BackListener();
		btnBack.addActionListener(bl);
		btnBack.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnBack.setBounds(459, 443, 270, 60);
		contentPane.add(btnBack);
		
		btnChange = new JButton("Change");
		SignInListener sil = new SignInListener();
		btnChange.addActionListener(sil);
		btnChange.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		btnChange.setBounds(81, 443, 270, 60);
		contentPane.add(btnChange);
		
		lblUsername = new JLabel("New password: ");
		lblUsername.setFont(new Font("Consolas", Font.BOLD, 20));
		lblUsername.setBounds(80, 206, 160, 40);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("New password: ");
		lblPassword.setFont(new Font("Consolas", Font.BOLD, 20));
		lblPassword.setBounds(80, 332, 160, 40);
		contentPane.add(lblPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField_1.setFont(new Font("Consolas", Font.PLAIN, 20));
		passwordField_1.setBounds(280, 196, 290, 60);
		contentPane.add(passwordField_1);
	}

	class BackListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			try {
				setVisible(false);
				GUICustomersInterface frame = new GUICustomersInterface(username);
				frame.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class SignInListener implements ActionListener {
		public void actionPerformed( ActionEvent e ) {
			try {
				String strPassword_1 = String.valueOf(passwordField_1.getPassword());
				String strPassword_2 = String.valueOf(passwordField_2.getPassword());
				if (strPassword_1.compareTo(strPassword_2) == 0 &&
						strPassword_1.length() != 0) {
					boolean invalid = false;
					for (int i = 0; i < strPassword_1.length(); i ++) {
						char c = strPassword_1.charAt(i);
						if (!Character.isLetterOrDigit(c)) {
							invalid = true;
							break;
						}
					}
					if (invalid) {
						JOptionPane.showMessageDialog(null, "Invalid character", 
								"ERROR OCCURS", JOptionPane.ERROR_MESSAGE);
					}
					else {
						Database.changePassword(username, strPassword_1);
						setVisible(false);
						GUICustomersInterface frame = new GUICustomersInterface(username);
						frame.setVisible(true);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "The passwords don't match", 
							"ERROR OCCURS", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}