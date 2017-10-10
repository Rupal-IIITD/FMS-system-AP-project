package com.company;

import java.awt.EventQueue;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;


public class If_login {

	public String s=null;
	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	String value, values;
	int counter = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					If_login window = new If_login();
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
	public If_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
        frame.setTitle("LOGIN");
        frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(29, 11, 60, 24);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));
        lblUsername.setLocation(60,20);
        lblUsername.setForeground(Color.WHITE);
		frame.getContentPane().add(lblUsername);
		//System.out.println(lblUsername);

		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBounds(29, 46, 60, 24);
        lblNewLabel.setLocation(60,50);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
        lblNewLabel.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel);
		//System.out.println(lblNewLabel);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(29, 76, 70, 24);
        lblDesignation.setLocation(57,80);
        lblDesignation.setFont(new Font("Arial", Font.BOLD, 12));
        lblDesignation.setForeground(Color.WHITE);
		frame.getContentPane().add(lblDesignation);

		JLabel lblNewLabel_1 = new JLabel("Department");
		lblNewLabel_1.setBounds(29, 103, 76, 24);
        lblNewLabel_1.setLocation(57,110);
        lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
        lblNewLabel_1.setForeground(Color.WHITE);
		frame.getContentPane().add(lblNewLabel_1);

		username = new JTextField();
		username.setBounds(180, 25, 127, 20);
        username.setLocation(210,20);
		frame.getContentPane().add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setBounds(180, 25, 127, 20);
        password.setLocation(210, 50);
		frame.getContentPane().add(password);

		final JComboBox post = new JComboBox();
        post.setBounds(180, 85, 127, 20);
        post.setLocation(210,82);
		post.setModel(new DefaultComboBoxModel(new String[] {"Select", "GM", "Supervisor", "Staff"}));
		post.setToolTipText("");
		frame.getContentPane().add(post);

//		DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"foo", "bar"});
//		JComboBox box = new JComboBox(model);

		final DefaultComboBoxModel model = new DefaultComboBoxModel(new String[] {"Select", "Electricity", "HVAC", "Audio/Video", "Security", "Housekeeping"});
		final JComboBox dept = new JComboBox(model);
		dept.setBounds(180, 110, 127, 20);
        dept.setLocation(210, 112);
		frame.getContentPane().add(dept);
		final int[] count = {0};


		dept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				values = dept.getSelectedItem().toString();
				if(values.equals("Select"))
					JOptionPane.showMessageDialog(null, "Choose option properly");
			}
		});


		post.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e)
			{
				value = post.getSelectedItem().toString();


				if(value.equals("Select"))
					JOptionPane.showMessageDialog(null, "Choose option properly");
				else {

					if (value.equals("GM")) {
						int index1 = model.getIndexOf("HVAC");
						dept.removeItemAt(index1);
						index1 = model.getIndexOf("Security");
						dept.removeItemAt(index1);
						index1 = model.getIndexOf("Electricity");
						dept.removeItemAt(index1);
						index1 = model.getIndexOf("Audio/Video");
						dept.removeItemAt(index1);
						index1 = model.getIndexOf("Housekeeping");
						dept.removeItemAt(index1);
						dept.addItem("NA");
						count[0] = 1;
					}
					if (count[0] == 1 && value.equals("GM") == false) {
						int index1 = model.getIndexOf("NA");
						dept.removeItemAt(index1);
						dept.addItem("HVAC");
						dept.addItem("Security");
						dept.addItem("Electricity");
						dept.addItem("Audio/Video");
						dept.addItem("Housekeeping");
						count[0] = 0;
					}
				}
			}
		});

		JButton btnNewButton = new JButton("login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
				}
				else if (password.getPassword().length==0) {
					JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
				}
				else if (post.getSelectedItem().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
				}
				else if (dept.getSelectedItem().toString().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
				}

			else {
					String file_name = null;
					if (post.getSelectedItem().toString() == "GM") {
						if (username.getText() == "rupal@123")
							JOptionPane.showMessageDialog(null, "Oops!!! Apparently you entered wrong username \nReenter your correct details");
						else if (Arrays.equals(password.getPassword(), new char[]{'a', 'b', 'c', 'd'}) == false)
							JOptionPane.showMessageDialog(null, "Oops!!! Apparently you entered wrong password \nReenter your correct details");
                        String[] argss = {};
                        GM_login.main(argss);
                        frame.dispose();

					}
					else{
						if (post.getSelectedItem().toString() == "Staff")
							file_name = "Staff.txt";
						else if (post.getSelectedItem().toString() == "Supervisor")
							file_name = "Supervisor.txt";
						BufferedReader in_file = null;
						try {
							in_file = new BufferedReader(new FileReader(file_name));
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
						LineNumberReader lnr = null;
						lnr = new LineNumberReader(in_file);
						String line;
						try {
							while ((line = lnr.readLine()) != null) {
								String[] values = line.split(":");
//								System.out.println(username.getText());
//								System.out.println(values[2]);
//								System.out.println(Arrays.toString(password.getPassword()));
//								System.out.println(values[4]);
//								System.out.println(values[2].equals(username.getText()));
//								System.out.println(Arrays.toString(password.getPassword()).equals(values[4]));
								if (values[3].equals(username.getText()) && Arrays.toString(password.getPassword()).equals(values[5]) && dept.getSelectedItem().toString().equals(values[1])){
									counter = 1;
								}
								System.out.println(counter);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}

						if (counter == 0) {
							JOptionPane.showMessageDialog(null, "Oooooops!!! There are some errors while entering the data. \nOr may be no such user exists in the system");
							int selectedOption = JOptionPane.showConfirmDialog(null,
									"Do you wanna try again to log in or continue with signing up as a new member?\nChoose \"Yes\" for register\nChoose \"No\" for login",
									"\nChoose",
									JOptionPane.YES_NO_OPTION);
							if(selectedOption == JOptionPane.YES_OPTION) {
								String[] argss = {};
								if_register.main(argss);
								frame.dispose();
							}
							try {
								in_file.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						else{
							JOptionPane.showMessageDialog(null, "Signing in...");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
							}
							value = post.getSelectedItem().toString();
							s = username.getText();
							//System.out.println(s);
							if (value.equals("GM")) {
								String[] argss = {};
								GM_login.main(argss);
								//System.out.println(value);
							} else if (value.equals("Supervisor")) {
								String[] argss = {};
								Supervisor_login.main(argss);
							} else if (value.equals("Staff")) {
								String[] argss = {};
								Staff_login.main(argss);
							}
							frame.dispose();
						}
					}
				}
				//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		btnNewButton.setBounds(160, 200, 100, 25);
        btnNewButton.setLocation(140, 170);
		frame.getContentPane().add(btnNewButton);
	}
}
