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
		JButton btnSendRequests = new JButton("Send Logistics Requests");
		btnSendRequests.setBounds(192, 64, 180, 33);
        btnSendRequests.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnSendRequests);
        btnSendRequests.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter output=null;
                try {
                    output = new BufferedWriter(new FileWriter("Requests_logistics.txt", true));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if(output!=null){
                    try {
                        output.append("logistics request from Staff");
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
		
		JButton btnSendLeave = new JButton("Send Leave");
		btnSendLeave.setBounds(192, 108, 180, 37);
        btnSendLeave.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnSendLeave);
        btnSendLeave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BufferedWriter output=null;
                try {
                    output = new BufferedWriter(new FileWriter("LeaveRequests.txt", true));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if(output!=null){
                    try {
                        output.append("leave request from Staff");
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

        JButton btnUpdateStatusOf = new JButton("Update status of tasks");
		btnUpdateStatusOf.setBounds(192, 156, 180, 37);
        btnUpdateStatusOf.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnUpdateStatusOf);
        btnUpdateStatusOf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System.out.println("Here you are");
                JTextField fField = new JTextField(20);
                JTextField gField = new JTextField(20);
                Box b = Box.createVerticalBox();
                //System.out.println("Here you are");
                b.add(new JLabel("task_ID"));
                b.add(fField);
                b.add(Box.createVerticalStrut(10));
                b.add(new JLabel("status"));
                b.add(gField);
                b.add(Box.createVerticalStrut(20));
                int result = JOptionPane.showConfirmDialog(null, b,
                        "Please Enter these values", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            BufferedReader in_file = null;
            BufferedWriter out = null;
            try {
                in_file = new BufferedReader(new FileReader("Task_report.txt"));
                out = new BufferedWriter(new FileWriter("New_Task_report.txt", true));
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            String line, new_line;
            String id = fField.getText();

            LineNumberReader lnr = null;
            lnr = new LineNumberReader(in_file);
            try {
                while ((line = lnr.readLine()) != null) {
                    if (line.indexOf(id) != -1) {
                        new_line = line.replaceAll("ongoing", gField.getText());
                        out.append(new_line);
                        out.newLine();
                    }
                    else{
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
            boolean success = (new File("Task_report.txt")).delete();
            File oldFile = new File("New_Task_report.txt");
            File newFile = new File("Task_report.txt");

            if (oldFile.renameTo(newFile)) {
                //System.out.println("Rename succesful");
            } else {
                //System.out.println("Rename failed");
            }
        }
            }
        });
		JButton btnTaskReportGenerate = new JButton("Task report generate");
		btnTaskReportGenerate.setBounds(192, 206, 180, 37);
        btnTaskReportGenerate.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnTaskReportGenerate);
        btnTaskReportGenerate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String[] argss = {};
                DocumentViewer.main(argss);
            }
        });

        JButton btnViewStatus = new JButton("View Status");
		btnViewStatus.setBounds(192, 256, 180, 37);
        btnViewStatus.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(btnViewStatus);
        btnViewStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your status is available");

            }
        });
	}
}
		
