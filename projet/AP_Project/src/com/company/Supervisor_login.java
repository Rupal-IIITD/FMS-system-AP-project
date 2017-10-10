package com.company;

import java.awt.*;
import javax.swing.*;
import javax.xml.stream.events.StartDocument;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class Supervisor_login {

	private JFrame frame;
	String values;

	/**
	 * Launch the application.Setting the frame.
	 * In the main function frame is being set as visible by using setVisible(true)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supervisor_login window = new Supervisor_login();
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
	public Supervisor_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * Here in this function, we have created various JButtons like ADD, DELETE and VIEW to add, view and delete staff.
	 * Here in this function, we also have created some JComboBoxes to ask for User's choices.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 473);
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("SUPERVISOR LOGIN");
		frame.getContentPane().setLayout(null);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Logout"}));
		comboBox.setBounds(365, 10, 70, 26);
		comboBox.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(comboBox);

		JButton username = new JButton("U");
		username.setBounds(300, 9, 60, 30);
		frame.getContentPane().add(username);
		username.setBorder(new RoundedBorder(20));
        username.setBackground(Color.LIGHT_GRAY);
		username.setForeground(Color.BLACK);
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String arr = comboBox.getSelectedItem().toString();
				if(arr == "Logout"){
					frame.dispose();
				}

			}
		});
		

		JLabel lblAssignTaskTo = new JLabel("Assign task to Staff");
		lblAssignTaskTo.setBounds(85, 181, 139, 20);
        lblAssignTaskTo.setForeground(Color.WHITE);
		lblAssignTaskTo.setLocation(80, 185);
		frame.getContentPane().add(lblAssignTaskTo);

		JButton lblAddStaff = new JButton("Add Staff");
		lblAddStaff.setBounds(85, 100, 95, 20);
		lblAddStaff.setLocation(150, 80);
		lblAddStaff.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(lblAddStaff);
		lblAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> list_staff = new ArrayList<String>();
				BufferedReader in_file = null;
				try {
					in_file = new BufferedReader(new FileReader("Staff_Reg_Requests.txt"));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				LineNumberReader lnr = null;
				lnr = new LineNumberReader(in_file);
				String line;
				try {
					while ((line = lnr.readLine()) != null) {
						int selectedOption = JOptionPane.showConfirmDialog(null,
								"Do you wanna add the following staff member to the system or not?\n"+line,
								"\nChoose",
								JOptionPane.YES_NO_OPTION);
						if(selectedOption == JOptionPane.YES_OPTION) {
								list_staff.add(line);
						}
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				finally {
					try {
						in_file.close();
						int x=list_staff.size();
						//System.out.println(x);
						if(x>0) {
							BufferedWriter output = new BufferedWriter(new FileWriter("Staff.txt", true));
							while (x > 0) {
								output.newLine();
								output.append(list_staff.get(x - 1));
								//System.out.println("Here you are");
								System.out.println(list_staff.get(x - 1));
								x--;
							}
							output.close();
						}
					}
					catch (IOException e1) {
						e1.printStackTrace();
					}
					boolean success = (new File("Staff_Reg_Requests.txt")).delete();
					File f = new File("Staff_Reg_Requests.txt");
					try {
						f.createNewFile();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});


		JButton lblDeleteStaff = new JButton("Delete Staff");
		lblDeleteStaff.setBounds(85, 100, 95, 20);
		lblDeleteStaff.setLocation(150, 110);
		lblDeleteStaff.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(lblDeleteStaff);
		lblDeleteStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JTextField uField = new JTextField(20);
				JTextField dField = new JTextField(20);
				Box b = Box.createVerticalBox();
				b.add(new JLabel("username: "));
				b.add(uField);
				b.add(Box.createVerticalStrut(5));
				b.add(new JLabel("Department: "));
				b.add(dField);
				b.add(Box.createVerticalStrut(5));
				int result = JOptionPane.showConfirmDialog(null, b,
						"Enter this value for the staff member", JOptionPane.OK_CANCEL_OPTION);
				if (result == JOptionPane.OK_OPTION) {
					BufferedReader in_file = null;
					BufferedWriter out = null;
					try {
						in_file = new BufferedReader(new FileReader("Staff.txt"));
						out = new BufferedWriter(new FileWriter("New_Staff.txt", true));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					String line, new_line;
					String x = uField.getText();
					String y = dField.getText();
					LineNumberReader lnr = null;
					lnr = new LineNumberReader(in_file);
					try {
						while ((line = lnr.readLine()) != null) {
							String[] values = line.split(":");
							if(values[3].equals(x)==false || values[1].equals(y)==false){
								out.append(line);
								out.newLine();
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						in_file.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						out.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					boolean success = (new File("Staff.txt")).delete();
					File oldFile = new File("New_Staff.txt");
					File newFile = new File("Staff.txt");

					if (oldFile.renameTo(newFile)) {
						//System.out.println("Rename succesful");
					} else {
						//System.out.println("Rename failed");
					}
				}
			}
		});

		JButton lblViewStaff = new JButton("View Staff");
		lblViewStaff.setBounds(85, 150, 95, 20);
		lblViewStaff.setBackground(Color.LIGHT_GRAY);
		lblViewStaff.setLocation(150, 140);
		frame.getContentPane().add(lblViewStaff);
		lblViewStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] argss = {};
				DocumentViewer.main(argss);
			}
		});

		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Select", "Electricity", "HVAC", "Audio/Video", "Security", "Housekeeping"}));
		comboBox_4.setBounds(234, 350, 150, 20);
        comboBox_4.setLocation(210, 185);
		comboBox_4.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				values = comboBox_4.getSelectedItem().toString();
				if(values.equals("Select"))
					JOptionPane.showMessageDialog(null, "Choose option properly");
				else{
//					String test1= JOptionPane.showInputDialog("Please input mark for test 1: ");
//					System.out.println(test1);
					JTextField yField = new JTextField(40);
					JTextField aField = new JTextField(40);
					JTextField bField = new JTextField(40);
					JTextField cField = new JTextField(40);
					JTextField dField = new JTextField(40);
					JTextField eField = new JTextField(40);
					JTextField fField = new JTextField(40);

					Box b = Box.createVerticalBox();
					b.add(new JLabel("taskID:"));
					b.add(yField);
					b.add(Box.createVerticalStrut(10));
					b.add(new JLabel("ID:"));
					b.add(aField);
					b.add(Box.createVerticalStrut(15));
					b.add(new JLabel("description:(use _ as a spacer)"));
					b.add(bField);
					b.add(Box.createVerticalStrut(20));
					b.add(new JLabel("item:"));
					b.add(cField);
					b.add(Box.createVerticalStrut(25));
					b.add(new JLabel("time_taken:"));
					b.add(dField);
					b.add(Box.createVerticalStrut(30));
					b.add(new JLabel("comments:"));
					b.add(eField);
					b.add(Box.createVerticalStrut(35));
					b.add(new JLabel("status:"));
					b.add(fField);
					b.add(Box.createVerticalStrut(40));
					int result = JOptionPane.showConfirmDialog(null, b,
							"Please these values", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
//						System.out.println("x value:\n" + xField.getText());
//						System.out.println("y value: " + yField.getText());
						BufferedWriter output=null;
						try {
							output = new BufferedWriter(new FileWriter("Task_report.txt", true));
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							output.newLine();
							output.append(values+" "+yField.getText()+" "+aField.getText()+" "+bField.getText()+" "+cField.getText()+" "+dField.getText()+" "+eField.getText()+" "+fField.getText());
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						try {
							output.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}

					}

				}
			}
		});

		JButton btnSendLeaveTo = new JButton("Send leave to GM");
		btnSendLeaveTo.setBounds(115, 240, 185, 23);
		btnSendLeaveTo.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnSendLeaveTo);
		btnSendLeaveTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter output=null;
				try {
					output = new BufferedWriter(new FileWriter("LeaveRequests.txt", true));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(output!=null){
					try {
						output.append("leave request from Supervisor");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						output.newLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				try {
					output.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		JButton btnLogisticsReuqestTo = new JButton("Logistics request to GM");
		btnLogisticsReuqestTo.setBounds(116, 274, 184, 23);
		btnLogisticsReuqestTo.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnLogisticsReuqestTo);
		btnLogisticsReuqestTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedWriter output=null;
				try {
					output = new BufferedWriter(new FileWriter("Requests_logistics.txt", true));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(output!=null){
					try {
						output.append("logistics request from Supervisor");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					try {
						output.newLine();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				try {
					output.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel lab = new JLabel("Respond to requests");
		lab.setBounds(100, 340, 184, 23);
		lab.setLocation(70, 320);
        lab.setForeground(Color.WHITE);
		frame.getContentPane().add(lab);

		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Select", "LeaveRequests", "Requests_logistics"}));
		comboBox_5.setBounds(120, 342, 150, 23);
		comboBox_5.setLocation(210, 320);
		comboBox_5.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(comboBox_5);
		comboBox_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				values = comboBox_5.getSelectedItem().toString();
				if(values.equals("Select")) {
					JOptionPane.showMessageDialog(null, "Choose option properly");
				}
				else if(values.equals("LeaveRequests")){
					BufferedReader in_file = null;
					try {
						in_file = new BufferedReader(new FileReader("LeaveRequests.txt"));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					LineNumberReader lnr = null;
					lnr = new LineNumberReader(in_file);
					String line;
					try {
						while ((line = lnr.readLine()) != null) {
							int selectedOption = JOptionPane.showConfirmDialog(null,
									"Do you want to grant leave to this user or not?\n"+line,
									"\nChoose",
									JOptionPane.YES_NO_OPTION);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					finally {
						try {
							in_file.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						boolean success = (new File("LeaveRequests.txt")).delete();
						File f = new File("LeaveRequests.txt");
						try {
							f.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
				else{
					BufferedReader in_file = null;
					try {
						in_file = new BufferedReader(new FileReader("Requests_logistics.txt"));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					LineNumberReader lnr = null;
					lnr = new LineNumberReader(in_file);
					String line;
					try {
						while ((line = lnr.readLine()) != null) {
							int selectedOption = JOptionPane.showConfirmDialog(null,
									"Do you want to approve this logistics request from this user or not?\n"+line,
									"\nChoose",
									JOptionPane.YES_NO_OPTION);
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					finally {
						try {
							in_file.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						boolean success = (new File("Requests_logistics.txt")).delete();
						File f = new File("Requests_logistics.txt");
						try {
							f.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		
		JButton btnViewTasks = new JButton("View Tasks");
		btnViewTasks.setBounds(151, 377, 111, 23);
		btnViewTasks.setBackground(Color.LIGHT_GRAY);
		btnViewTasks.setLocation(140,360);
		frame.getContentPane().add(btnViewTasks);
		btnViewTasks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String[] argss = {};
				DocumentViewer.main(argss);
			}
		});

	}
}
