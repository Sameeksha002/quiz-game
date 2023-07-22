package quiz_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class login extends JFrame implements ActionListener {

    JButton start;
    JTextField jname, jemail;

    login() {
        // login component
        JLabel heading1 = new JLabel("STUDENT LOGIN");
        add(heading1);
        heading1.setBounds(346, 145, 400, 30);
        heading1.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading1.setForeground(Color.white);

        // name component
        JLabel name = new JLabel("Enter your name");
        add(name);
        name.setBounds(425, 195, 350, 50);
        name.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        name.setForeground(Color.white);

        // email component
        JLabel email = new JLabel("Enter your email");
        add(email);
        email.setBounds(425, 295, 350, 50);
        email.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        email.setForeground(Color.white);

        // enter information
        jname = new JTextField();
        add(jname);
        jname.setBounds(365, 240, 285, 35);
        jname.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));

        jemail = new JTextField();
        add(jemail);
        jemail.setFont(new Font("Mongolian Baiti", Font.BOLD, 24));
        jemail.setBounds(365, 340, 285, 35);

        // start button
        start = new JButton("Start");
        add(start);
        start.setBounds(424, 420, 150, 30);
        start.setFont(new Font("Mongolian Baiti", Font.BOLD, 26));
        start.setForeground(Color.white);
        start.setBackground(new Color(251, 72, 196));
        start.addActionListener(this);

        setLayout((null));
        getContentPane().setBackground(Color.black);
        setSize(1000, 600);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        String name = jname.getText();
        new quiz(name);
        setVisible(false);
    }

    public static void main(String[] args) {
        new login();
    }
}
