package com.company;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class DocumentViewer {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final JFrame f = new JFrame();
                f.setTitle("DOCUMENT VIEWER");
                f.setBackground(Color.DARK_GRAY);
                f.dispose();
                final JFileChooser fileChooser = new JFileChooser();

                JPanel gui = new JPanel(new BorderLayout());

                final JEditorPane document = new JEditorPane();
                gui.add(new JScrollPane(document), BorderLayout.CENTER);

                JButton open = new JButton("Open");
                open.setBounds(5,10,100,30);
                open.setFont(new Font("Arial", Font.BOLD, 12));
                open.setLocation(10,10);
                open.setBackground(Color.LIGHT_GRAY);
                open.addActionListener( new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        int result = fileChooser.showOpenDialog(f);
                        if (result==JFileChooser.APPROVE_OPTION) {
                            File file = fileChooser.getSelectedFile();
                            try {
                                document.setPage(file.toURI().toURL());
                            } catch(Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                gui.add(open, BorderLayout.NORTH);

                f.setContentPane(gui);
                f.pack();
                f.setSize(400,400);
                f.setBackground(Color.DARK_GRAY);
                f.setLocation(30, 40);
                f.setLocationByPlatform(true);

                f.setVisible(true);
            }
        });
    }
}
