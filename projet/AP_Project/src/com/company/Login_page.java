package com.company;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Login_page {
	private JFrame frmFmsSystem;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page window = new Login_page();
					window.frmFmsSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Login_page() {
		initialize();
	}
	private void initialize() {
		frmFmsSystem = new JFrame();
		frmFmsSystem.setTitle("      FMS SYSTEM");
		frmFmsSystem.setBounds(100, 100, 450, 300);
		frmFmsSystem.getContentPane().setBackground(Color.DARK_GRAY);
		frmFmsSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(174, 120, 88, 34);
		btnLogin.setBackground(Color.LIGHT_GRAY);
		btnLogin.setFont(new Font("Arial", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                String[] argss = {};
                If_login.main(argss);
            }
		});
		frmFmsSystem.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Register");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                String[] argss = {};
                if_register.main(argss);
            }
		});
		btnNewButton.setBounds(154, 70, 130, 34);
		frmFmsSystem.getContentPane().add(btnNewButton);
		frmFmsSystem.getContentPane().add(btnLogin);
	}
}