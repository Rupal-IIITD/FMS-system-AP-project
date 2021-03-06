package com.company;
import java.awt.*; 
import javax.swing.JFrame; 
import java.text.SimpleDateFormat; 
import java.util.Random;
import java.io.*; 
import java.util.*; 
import java.io.BufferedWriter; 
import java.io.FileWriter; 
import javax.swing.JOptionPane;
import javax.swing.JLabel; 
import javax.swing.JButton; 
import java.awt.event.ActionListener; 
import java.awt.event.ActionEvent;
import javax.swing.JTextField; 
import javax.swing.JPasswordField; 
import javax.swing.JComboBox; 
import javax.swing.DefaultComboBoxModel;
import java.io.IOException;
public class if_register {

    private JFrame frame;      private JTextField username;
    private JPasswordField password;     private JTextField name;
    private JTextField dob;     private JTextField address;
    Date date2=null;     int counter=0;
    String arr1, arr2, arr3, arr4, arr7;
    int arr5;     char[] arr6;

    /**
     * Launching the application. Setting the frame.
     * In the main function frame is being set as visible by using setVisible(true)
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    if_register window = new if_register();
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
    public if_register() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * In this function, we have created various Jbuttons, JLabels, JComboBoxes to enter the values of username, password, department, DOB etc.
     */
    private void initialize() {
        frame = new JFrame();         frame.setBounds(500, 100, 408, 327);
        frame.setTitle("REGISTER");
        frame.getContentPane().setBackground(Color.DARK_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username");         lblUsername.setBounds(78, 21, 59, 31);
        lblUsername.setFont(new Font("Arial", Font.BOLD, 12));         lblUsername.setForeground(Color.WHITE);
        frame.getContentPane().add(lblUsername);

        JLabel lblPassword = new JLabel("Password");         lblPassword.setBounds(78, 57, 59, 21);
        lblPassword.setFont(new Font("Arial", Font.BOLD, 12));         lblPassword.setForeground(Color.WHITE);
        frame.getContentPane().add(lblPassword);

        JLabel lblDepartment = new JLabel("Department");         lblDepartment.setBounds(78, 89,70, 21);
        lblDepartment.setFont(new Font("Arial", Font.BOLD, 12));         lblDepartment.setForeground(Color.WHITE);
        frame.getContentPane().add(lblDepartment);

        JLabel lblName = new JLabel("Name");         lblName.setBounds(78, 121, 59, 21);
        lblName.setFont(new Font("Arial", Font.BOLD, 12));         lblName.setForeground(Color.WHITE);
        frame.getContentPane().add(lblName);

        JLabel lblDob = new JLabel("DOB");         lblDob.setBounds(78, 153, 35, 21);
        lblDob.setFont(new Font("Arial", Font.BOLD, 12));         lblDob.setForeground(Color.WHITE);
        frame.getContentPane().add(lblDob);

        JLabel lblAddress = new JLabel("Address");         lblAddress.setBounds(78, 183, 59, 21);
        lblAddress.setFont(new Font("Arial", Font.BOLD, 12));         lblAddress.setForeground(Color.WHITE);
        frame.getContentPane().add(lblAddress);

        JLabel lblDesignation = new JLabel("Designation");         lblDesignation.setBounds(78, 215, 79, 21);
        lblDesignation.setFont(new Font("Arial", Font.BOLD, 12));          lblDesignation.setForeground(Color.WHITE);
        frame.getContentPane().add(lblDesignation);

        username = new JTextField();         username.setBounds(212, 30, 100, 20);
        frame.getContentPane().add(username);          username.setColumns(10);

        password = new JPasswordField();         password.setBounds(212, 60, 100, 21);
        frame.getContentPane().add(password);

        name = new JTextField();         name.setBounds(212, 121, 100, 20);
        frame.getContentPane().add(name);           name.setColumns(10);

        dob = new JTextField();          dob.setBounds(212, 153, 100, 20);
        frame.getContentPane().add(dob);          dob.setColumns(10);
        dob.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String date=dob.getText();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                try {
                    //Parsing the String
                    date2 = dateFormat.parse(date);
                }  catch (java.text.ParseException e1) {
                    e1.printStackTrace();
                }
            }
        });

        address = new JTextField();          address.setBounds(212, 183, 100, 20);
        frame.getContentPane().add(address);
        address.setColumns(10);

        final JComboBox dept = new JComboBox();
        dept.setModel(new DefaultComboBoxModel(new String[] {"Select", "Electricity", "HVAC", "Audio/Video", "Security", "Housekeeping"}));
        dept.setBounds(212, 89, 100, 20);          frame.getContentPane().add(dept);

        final JComboBox post = new JComboBox();
        post.setModel(new DefaultComboBoxModel(new String[] {"Select","Supervisor", "Staff"}));
        post.setBounds(212, 215, 100, 20);
        frame.getContentPane().add(post);

        JButton btnRegister = new JButton("Register");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                if (username.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
                }
                else if (password.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
                }
                else if (dept.getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
                }
                else if (name.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
                }
                else if (dob.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
                }
                else if (address.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
                }
                else if (post.getSelectedItem().toString().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Oops!!! Apparently you forgot to fill some entry");
                }
                else {

                    String file_name = null;
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
                            if (values[3].equals(username.getText()) && dept.getSelectedItem().toString().equals(values[1])) {
                                counter = 1;
                            }
                            if(file_name.equals("Supervisor.txt") && dept.getSelectedItem().toString().equals(values[1])){
                                counter=1;
                                JOptionPane.showMessageDialog(null, "Supervisor for this department already exists");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    if (counter == 1) {
                        JOptionPane.showMessageDialog(null, "Heyyy!! You're an old member. You don't need to register, You should simply proceed by signing in");
                        int selectedOption = JOptionPane.showConfirmDialog(null,
                                "Do you wanna try again to register as a different user or continue with signing in being an old member?\nChoose \"Yes\" for login\nChoose \"No\" for register",
                                "\nChoose",
                                JOptionPane.YES_NO_OPTION);
                        if (selectedOption == JOptionPane.YES_OPTION) {
                            String[] argss = {};
                            If_login.main(argss);
                            frame.dispose();
                        }
                        else
                            counter=0;
                        try {
                            in_file.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Your request is pending...");

                        BufferedWriter output = null;
                        try {
                            output = new BufferedWriter(new FileWriter("Registration_requests.txt", true));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            arr1 = post.getSelectedItem().toString();
                            arr2 = dept.getSelectedItem().toString();
                            arr3 = name.getText();
                            arr4 = username.getText();
                            Random rand = new Random();

                            arr5 = rand.nextInt(1000);
                            arr6 = password.getPassword();
                            arr7 = "Available";
                            if (output != null) {
                                output.append(arr1+ ":" +arr2 + ":" + arr3 + ":" + arr4 + ":" + arr5 + ":"+Arrays.toString(arr6) + ":" + arr7);
                                output.newLine();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            output.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                        }
                        frame.dispose();

                    }    //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    if(arr1.equals("Staff")){
                        BufferedWriter output = null;
                        try {
                            output = new BufferedWriter(new FileWriter("Staff_Reg_Requests.txt", true));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if (output != null) {
                            try {
                                output.append(arr1+ ":" +arr2 + ":" + arr3 + ":" + arr4 + ":" + arr5 + ":"+Arrays.toString(arr6) + ":" + arr7);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                output.newLine();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            output.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        btnRegister.setBounds(145, 250, 100, 30);
        frame.getContentPane().add(btnRegister);
    }

//    JsonFactory jsonFactory = new JacksonFactory();
//    HttpTransport httpTransport = new NetHttpTransport();
//
//    GoogleTokenResponse tokenResponse = new GoogleAuthorizationCodeTokenRequest(
//            httpTransport, jsonFactory,
//    /* Client ID and Secret */
//            ,
//            code, "postmessage").execute();
//
//    GoogleCredential credential = new GoogleCredential.Builder()
//            .setJsonFactory(jsonFactory)
//            .setTransport(httpTransport)
//            .setClientSecrets( /* Client ID and Secret */ ).build()
//            .setFromTokenResponse(tokenResponse);
//
//    Oauth2 oauth2 = new Oauth2.Builder(httpTransport, jsonFactory, credential).setApplicationName("YourAppName").build();
//    Tokeninfo tokenInfo = oauth2.tokeninfo().setAccessToken(credential.getAccessToken()).execute();
//
//    return oauth2.userinfo().get().execute();

}
