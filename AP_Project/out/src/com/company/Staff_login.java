package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class Staff_login {

	private JFrame frame;
    String new_line;
	/**
	 * Launch the application.Setting the frame.
     * In the main function frame is being set as visible by using setVisible(true)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_login window = new Staff_login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Staff_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
     * Here in this function, we have created various JButtons for Staff member's usage.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 541, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setTitle("STAFF LOGIN");
		frame.getContentPane().setLayout(null);

        final JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Logout"}));
        comboBox.setBounds(445, 0, 80, 25);
        comboBox.setBackground(Color.LIGHT_GRAY);
        frame.getContentPane().add(comboBox);

        JButton btnUsername = new JButton("S");
		btnUsername.setBounds(370, 0, 70, 25);
		frame.getContentPane().add(btnUsername);
        btnUsername.setBorder(new RoundedBorder(20));
        btnUsername.setBackground(Color.LIGHT_GRAY);
        btnUsername.setForeground(Color.BLACK);
        btnUsername.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String arr = comboBox.getSelectedItem().toString();
                if(arr == "Logout"){
                    frame.dispose();
                }

            }
        });
