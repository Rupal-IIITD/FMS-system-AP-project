package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

public class GM_login{

	public String arr=null, values=null;
	private JFrame frame;
	String postt, file_name=null;
	/**
	 * Launching the application. Setting the frame.
     * In the main function frame is being set as visible by using setVisible(true)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GM_login window = new GM_login();
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
	public GM_login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
     * In this function, we have created various JButtons through which user GM can add, delete, view the users in the system.
     * We have also created JComboBoxes through which it can select which department supervisor to assign task to.
     * It can also respond to various requests.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 452, 437);
		frame.setTitle("GM LOGIN");
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "Profile", "Logout"}));
		comboBox.setBounds(365, 10, 70, 26);
        comboBox.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(comboBox);

		JButton username = new JButton("RJ");
		username.setBounds(300, 9, 60, 30);
		username.setBorder(new RoundedBorder(20));
        username.setFont(new Font("Arial", Font.BOLD, 12));
		username.setForeground(Color.BLACK);
		frame.getContentPane().add(username);
		username.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arr = comboBox.getSelectedItem().toString();
				if(arr =="Profile"){
					JOptionPane.showMessageDialog(null, "1.Name: Rupal Jain \n2.DOB: 21st January \n3.Designation: Admin \n4.Username: RJ", "Profile", JOptionPane.INFORMATION_MESSAGE);
				}
				else if(arr == "Logout"){
					frame.dispose();
				}

			}
		});

		JLabel lblAssignTaskTo = new JLabel("Assign task to Supervisor");
		lblAssignTaskTo.setBounds(70, 227, 155, 20);
        lblAssignTaskTo.setLocation(60, 210);
        lblAssignTaskTo.setForeground(Color.WHITE);
        lblAssignTaskTo.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(lblAssignTaskTo);

		JLabel lblTaskTo = new JLabel("Respond to Requests");
		lblTaskTo.setBounds(70, 270, 159, 23);
        lblTaskTo.setForeground(Color.WHITE);
        lblTaskTo.setLocation(70,250);
        lblTaskTo.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(lblTaskTo);
		
//		JButton btnRespondToRequests = new JButton("Respond to requests");
//		btnRespondToRequests.setBounds(70, 280, 159, 23);
//		frame.getContentPane().add(btnRespondToRequests);
		
		final JButton comboBox_1 = new JButton("ADD");
		comboBox_1.setBounds(150, 150, 139, 20);
        comboBox_1.setBackground(Color.LIGHT_GRAY);
        comboBox_1.setLocation(130,80);
        comboBox_1.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> list_staff = new ArrayList<String>();
				ArrayList<String> list_supervisor = new ArrayList<String>();

					BufferedReader in_file = null;
					try {
						in_file = new BufferedReader(new FileReader("Registration_requests.txt"));
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					LineNumberReader lnr = null;
					lnr = new LineNumberReader(in_file);
					String line;
					try {
						while ((line = lnr.readLine()) != null) {
                            int selectedOption = JOptionPane.showConfirmDialog(null,
                                    "Do you wanna add the following user to the system or not?\n"+line,
                                    "\nChoose",
                                    JOptionPane.YES_NO_OPTION);
                            if(selectedOption == JOptionPane.YES_OPTION) {
								String[] values = line.split(":");
								//System.out.println(line);
								if(values[0].equals("Staff")){
									list_staff.add(line);
									//System.out.println("In Staff brackets");
								}
								else if(values[0].equals("Supervisor")){
									list_supervisor.add(line);
									//System.out.println("In Supervisor brackets");
								}
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
							x=list_supervisor.size();
							//System.out.println(x);
							if(x>0) {
								BufferedWriter output = new BufferedWriter(new FileWriter("Supervisor.txt", true));
								while (x > 0) {
									output.append(list_supervisor.get(x - 1));
                                    output.newLine();
                                    //System.out.println("Here you are");
									System.out.println(list_supervisor.get(x - 1));
									x--;
								}
								output.close();
							}
						}
						catch (IOException e1) {
							e1.printStackTrace();
						}
						boolean success = (new File("Registration_requests.txt")).delete();
						File f = new File("Registration_requests.txt");
						try {
							f.createNewFile();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
			}
		});
		
		final JButton comboBox_2 = new JButton("VIEW");
		comboBox_2.setBounds(150, 170, 139, 20);
        comboBox_2.setBackground(Color.LIGHT_GRAY);
        comboBox_2.setLocation(130, 160);
        comboBox_2.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					String[] argss = {};
					DocumentViewer.main(argss);
			}
		});
		
		final JButton comboBox_3 = new JButton("DELETE");
		comboBox_3.setBounds(150, 170, 139, 20);
        comboBox_3.setBackground(Color.LIGHT_GRAY);
        comboBox_3.setLocation(130,120);
        comboBox_3.setFont(new Font("Arial", Font.BOLD, 12));
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

                JTextField trys = new JTextField(5);
                Box b = Box.createVerticalBox();
                b.add(new JLabel("Designation of the member to be deleted: "));
                b.add(trys);
                b.add(Box.createVerticalStrut(5));
                int result = JOptionPane.showConfirmDialog(null, b,
                        "Enter the value", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    if (trys.getText().equals("Staff")) {

                        JTextField uField = new JTextField(20);
                        JTextField dField = new JTextField(20);
                        Box b1 = Box.createVerticalBox();
                        b1.add(new JLabel("username: "));
                        b1.add(uField);
                        b1.add(Box.createVerticalStrut(5));
                        b1.add(new JLabel("Department: "));
                        b1.add(dField);
                        b1.add(Box.createVerticalStrut(5));
                        int results = JOptionPane.showConfirmDialog(null, b1,
                                "Enter this value for the staff member", JOptionPane.OK_CANCEL_OPTION);
                        if (results == JOptionPane.OK_OPTION) {
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
                                    if (values[3].equals(x) == false || values[1].equals(y) == false) {
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
                    else if(trys.getText().equals("Supervisor")){
                        JTextField uField = new JTextField(20);
                        JTextField dField = new JTextField(20);
                        Box b2 = Box.createVerticalBox();
                        b2.add(new JLabel("username: "));
                        b2.add(uField);
                        b2.add(Box.createVerticalStrut(5));
                        b2.add(new JLabel("Department: "));
                        b2.add(dField);
                        b2.add(Box.createVerticalStrut(5));
                        int results = JOptionPane.showConfirmDialog(null, b2,
                                "Enter this value for the supervisor", JOptionPane.OK_CANCEL_OPTION);
                        if (results == JOptionPane.OK_OPTION) {
                            BufferedReader in_file = null;
                            BufferedWriter out = null;
                            try {
                                in_file = new BufferedReader(new FileReader("Supervisor.txt"));
                                out = new BufferedWriter(new FileWriter("New_Supervisor.txt", true));
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
                                    if (values[3].equals(x) == false || values[1].equals(y) == false) {
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
                            boolean success = (new File("Supervisor.txt")).delete();
                            File oldFile = new File("New_Supervisor.txt");
                            File newFile = new File("Supervisor.txt");

                            if (oldFile.renameTo(newFile)) {
                                //System.out.println("Rename succesful");
                            } else {
                                //System.out.println("Rename failed");
                            }
                        }
                    }
                }
            }
		});
		
		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Select", "Electricity", "HVAC", "Audio/Video", "Security", "Housekeeping"}));
		comboBox_4.setBounds(249, 227, 139, 20);
        comboBox_4.setLocation(230, 210);
        comboBox_4.setBackground(Color.LIGHT_GRAY);
        comboBox_4.setFont(new Font("Arial", Font.BOLD, 12));
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
							"Please Enter these values", JOptionPane.OK_CANCEL_OPTION);
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
							output.append(values+" "+yField.getText()+" "+aField.getText()+" "+bField.getText()+" "+cField.getText()+" "+dField.getText()+" "+eField.getText()+" "+fField.getText());
                            output.newLine();
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

		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"Select", "LeaveRequests", "Requests_logistics"}));
		comboBox_5.setBounds(249, 270, 139, 20);
        comboBox_5.setLocation(230,250);
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
	}
}