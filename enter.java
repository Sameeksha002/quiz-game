package quiz_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class enter extends JFrame implements ActionListener {

    JButton enter, exit;

    enter() {
        // image component color,size
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/logo1.jpg"));
        JLabel image1 = new JLabel(i1);
        add(image1);
        image1.setBounds(250, 15, 500, 450);

        // heading component color,size,font
        JLabel heading = new JLabel("LET'S GET STARTED");
        add(heading);
        heading.setBounds(365, 380, 400, 30);
        heading.setFont(new Font("Mongolian Baiti", Font.BOLD, 26));
        heading.setForeground(Color.white);

        // enter button
        enter = new JButton("Enter");
        add(enter);
        enter.setBounds(420, 420, 150, 30);
        enter.setFont(new Font("Mongolian Baiti", Font.BOLD, 26));
        enter.setForeground(Color.white);
        enter.setBackground(new Color(251, 72, 196));
        enter.addActionListener(this);

        // exit button
        exit = new JButton("Exit");
        add(exit);
        exit.setBounds(0, 530, 100, 30);
        exit.setFont(new Font("Mongolian Baiti", Font.BOLD, 26));
        exit.setForeground(Color.white);
        exit.setBackground(new Color(64, 164, 255));
        exit.addActionListener(this);

        setLayout((null));
        getContentPane().setBackground(Color.black);
        setSize(1000, 600);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == enter) {
            setVisible(false);
            new login();
        } else if (ae.getSource() == exit) {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new enter();
    }
}
