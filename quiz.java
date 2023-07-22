package quiz_game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class quiz extends JFrame implements ActionListener {

    String questions[][] = new String[10][5];
    String answers[][] = new String[10][2];
    String userans[][] = new String[10][1];
    String name;

    JLabel qno, qutn;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;

    public static int timer = 30;
    public static int ansgiven = 0; // flag to call if times up
    public static int count = 0;
    public static int sp = 0;
    public static int score = 0;

    JButton skip, next, submit, previous;

    quiz(String name) {
        this.name = name;
        // image component color,size
        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("images/quiz12.jpg"));
        JLabel image2 = new JLabel(i2);
        add(image2);
        image2.setBounds(0, 0, 1000, 230);

        // question number component
        qno = new JLabel();
        add(qno);
        qno.setBounds(100, 250, 350, 40);
        qno.setFont(new Font("Mongolian Baiti", Font.PLAIN, 24));
        qno.setForeground(Color.white);

        // question component
        qutn = new JLabel();
        add(qutn);
        qutn.setBounds(130, 250, 600, 40);
        qutn.setFont(new Font("Mongolian Baiti", Font.PLAIN, 24));
        qutn.setForeground(Color.white);

        // entering questions and answers array
        questions[0][0] = "Who is the Father of the Computer?";
        questions[0][1] = "Charles Babbage";
        questions[0][2] = "Thomas Edison";
        questions[0][3] = "Albert Einstein";
        questions[0][4] = "Isaac Newton";

        questions[1][0] = "What is the full form of E-Mail?";
        questions[1][1] = "Electric Mail";
        questions[1][2] = "Exchange Mail";
        questions[1][3] = "Electronic Mail";
        questions[1][4] = "Engagement Mail";

        questions[2][0] = "In the virtual world, WWW stands for ___________________________.";
        questions[2][1] = "World Without Windows";
        questions[2][2] = "World Wide Web";
        questions[2][3] = "World Wide Web Applications";
        questions[2][4] = "World Wide Warehouse";

        questions[3][0] = "What do you call a person who uses the internet to explore and communicate?";
        questions[3][1] = "Citizen";
        questions[3][2] = "Resident";
        questions[3][3] = "Cybernaut";
        questions[3][4] = "None of the above";

        questions[4][0] = "Who invented Compact Disc?";
        questions[4][1] = "James T. Russell";
        questions[4][2] = "Fujio Masuoka";
        questions[4][3] = "Thomas Edison";
        questions[4][4] = "Martin Cooper";

        questions[5][0] = "Which one of the following is not an Operating System (OS)?";
        questions[5][1] = "Windows 10";
        questions[5][2] = "Linux";
        questions[5][3] = "DOS";
        questions[5][4] = "MS Excel";

        questions[6][0] = "What do you need to use to connect to the internet?";
        questions[6][1] = "Mouse";
        questions[6][2] = "Modem";
        questions[6][3] = "CPU";
        questions[6][4] = "Keyboard";

        questions[7][0] = "What is also known as a portable computer?";
        questions[7][1] = "Laptop";
        questions[7][2] = "CPU";
        questions[7][3] = "Monitor";
        questions[7][4] = "Desktop";

        questions[8][0] = "Name the device that is used to take a printout of a document from a computer.";
        questions[8][1] = "CPU";
        questions[8][2] = "Mouse";
        questions[8][3] = "Keyboard";
        questions[8][4] = "Printer";

        questions[9][0] = "How much is a byte equal to?";
        questions[9][1] = "8 bits";
        questions[9][2] = "16 bits";
        questions[9][3] = "32 bits";
        questions[9][4] = "64 bits";

        answers[0][1] = "Charles Babbage";
        answers[1][1] = "Electronic Mail";
        answers[2][1] = "World Wide Web";
        answers[3][1] = "Cybernaut";
        answers[4][1] = "James T. Russell";
        answers[5][1] = "MS Excel";
        answers[6][1] = " Modem";
        answers[7][1] = "Laptop";
        answers[8][1] = "Printer";
        answers[9][1] = "8 bits";

        // radio buttons
        opt1 = new JRadioButton();
        add(opt1);
        opt1.setBounds(130, 310, 400, 20);
        opt1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        opt1.setForeground(Color.white);
        opt1.setBackground(Color.black);

        opt2 = new JRadioButton();
        add(opt2);
        opt2.setBounds(130, 350, 400, 20);
        opt2.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        opt2.setForeground(Color.white);
        opt2.setBackground(Color.black);

        opt3 = new JRadioButton();
        add(opt3);
        opt3.setBounds(130, 390, 400, 20);
        opt3.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        opt3.setForeground(Color.white);
        opt3.setBackground(Color.black);

        opt4 = new JRadioButton();
        add(opt4);
        opt4.setBounds(130, 430, 400, 20);
        opt4.setFont(new Font("Mongolian Baiti", Font.PLAIN, 16));
        opt4.setForeground(Color.white);
        opt4.setBackground(Color.black);

        // selecting only one option
        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        // skip button
        skip = new JButton("Skip");
        add(skip);
        skip.setBounds(130, 490, 100, 28);
        skip.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        skip.setForeground(Color.black);
        skip.setBackground(new Color(68, 214, 44));
        skip.addActionListener(this);
        skip.setEnabled(true);

        // previous button
        previous = new JButton("Previous");
        add(previous);
        previous.setBounds(270, 490, 120, 28);
        previous.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        previous.setForeground(Color.black);
        previous.setBackground(new Color(68, 214, 44));
        previous.addActionListener(this);
        previous.setEnabled(true);

        // next button
        next = new JButton("Next");
        add(next);
        next.setBounds(400, 490, 100, 28);
        next.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        next.setForeground(Color.black);
        next.setBackground(new Color(68, 214, 44));
        next.addActionListener(this);

        // submit button
        submit = new JButton("Submit");
        add(submit);
        submit.setBounds(740, 490, 110, 28);
        submit.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
        submit.setForeground(Color.black);
        submit.setBackground(Color.blue);
        submit.setEnabled(false);
        submit.addActionListener(this);

        setBounds(250, 80, 1000, 650);
        getContentPane().setBackground(Color.black);
        setLayout(null);
        setVisible(true);

        started(count);
    }

    // timer
    public void paint(Graphics g) {
        super.paint(g);

        String time = "Time Left: " + timer + "seconds";// timer display
        g.setColor(Color.red);
        g.setFont(new Font("Mongolian Baiti", Font.BOLD, 20));

        if (timer > 0) {
            g.drawString(time, 700, 400);
        } else {
            g.drawString("Times Up!!", 700, 400);// timer display
        }
        timer--;// timer decreasing

        // timer count down
        try {
            Thread.sleep(1000); // repaint method call after one 1seconds
            repaint(); // paint method only called once since called repaint
        } catch (Exception e) {
            e.printStackTrace();
        }

        // move to next if ans given
        if (ansgiven == 1) {
            ansgiven = 0;
            timer = 30;
        }
        // time finish ans or not
        else if (timer < 0) {
            timer = 30;
            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            if (count == 9) {// submit button case
                if (groupoptions.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = groupoptions.getSelection().getActionCommand(); // getselection give selected
                                                                                        // option and getactioncommand
                                                                                        // give value of selected
                                                                                        // option.
                }
                for (int i = 0; i < userans.length; i++) {
                    if (userans[i][0].equals(answers[i][0])) {
                        score = 10 + score;
                    }
                }
                setVisible(false);
                new Score(name, score);
            } else {// next button case
                    // whether user give ans or not
                if (groupoptions.getSelection() == null) {
                    userans[count][0] = "";
                } else {
                    userans[count][0] = groupoptions.getSelection().getActionCommand(); // getselection give selected
                                                                                        // option and getactioncommand
                                                                                        // give value of selected
                                                                                        // option.
                }
            }
            count++;
            started(count);
        }

    }

    // dynamic questions declaration
    public void started(int count) {
        qno.setText("" + (count + 1) + ". ");
        qutn.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);

        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);

        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);

        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection();
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == skip) {
            skip.setEnabled(false);
            sp = count;
            count++;
            started(count);
            repaint();
            ansgiven = 1;
        } else if (ae.getSource() == next) {
            repaint();
            ansgiven = 1;
            if (groupoptions.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = groupoptions.getSelection().getActionCommand(); // getselection give selected option
                                                                                    // and getactioncommand give value
                                                                                    // of selected option.
            }

            if (count == 8) {
                next.setEnabled(false);
                submit.setEnabled(true);
            }
            count++;
            started(count);
        } else if (ae.getSource() == submit) {
            ansgiven = 1;
            if (groupoptions.getSelection() == null) {
                userans[count][0] = "";
            } else {
                userans[count][0] = groupoptions.getSelection().getActionCommand(); // getselection give selected option
                                                                                    // and getactioncommand give value
                                                                                    // of selected option.
            }
            for (int i = 0; i < userans.length; i++) {
                if (userans[i][0].equals(answers[i][1])) {
                    score = 10 + score;
                }
            }
            setVisible(false);
            new Score(name, score);
        } else {
            started(sp);
            ansgiven = 1;
            repaint();
            previous.setEnabled(false);
            count--;
        }
    }

    public static void main(String[] args) {
        new quiz("user");
    }
}
