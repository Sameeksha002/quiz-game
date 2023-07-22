package quiz_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Score extends JFrame implements ActionListener {
    String name;
    int score;

    Score(String name, int score) {
        this.name = name;
        this.score = score;
        JLabel heading2 = new JLabel("SCORE OF  " + name + " is " + score);
        add(heading2);
        heading2.setBounds(250, 100, 900, 40);
        heading2.setFont(new Font("Mongolian Baiti", Font.BOLD, 40));
        heading2.setForeground(Color.white);

        JButton submit = new JButton("Play Again");
        add(submit);
        submit.setBounds(700, 470, 150, 28);
        submit.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        submit.setForeground(Color.black);
        submit.setBackground(Color.blue);
        submit.setEnabled(true);
        submit.addActionListener(this);

        setLayout((null));
        getContentPane().setBackground(Color.black);
        setSize(1000, 600);
        setLocation(250, 100);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new login();
    }

    public static void main(String[] args) {
        new Score("user", 0);
    }
}
