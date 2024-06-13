import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField l;
    String s1, s2, s3;

    Calculator() {
        s1 = s2 = s3 = "";
    }

    public static void main(String args[]) {
        f = new JFrame("CALCULATOR");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Calculator c = new Calculator();
        l = new JTextField(16);
        l.setEditable(false);
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;
        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        beq1 = new JButton("=");
        ba = new JButton("+");
        bs = new JButton("-");
        bm = new JButton("*");
        bd = new JButton("/");
        be = new JButton(".");
        beq = new JButton("C");

        JPanel p = new JPanel();

        bm.addActionListener(c);
        bd.addActionListener(c);
        bs.addActionListener(c);
        ba.addActionListener(c);
        b9.addActionListener(c);
        b8.addActionListener(c);
        b7.addActionListener(c);
        b6.addActionListener(c);
        b5.addActionListener(c);
        b4.addActionListener(c);
        b3.addActionListener(c);
        b2.addActionListener(c);
        b1.addActionListener(c);
        b0.addActionListener(c);
        be.addActionListener(c);
        beq.addActionListener(c);
        beq1.addActionListener(c);

        p.add(l);
        p.add(ba);
        p.add(bs);
        p.add(bm);
        p.add(bd);
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(be);
        p.add(b0);
        p.add(beq);
        p.add(beq1);

        p.setBackground(Color.pink);
        f.add(p);

        f.setSize(200, 220);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            if (!s2.equals("")) {
                s3 = s3 + s;
            } else {
                s1 = s1 + s;
            }
            l.setText(s1 + s2 + s3);
        } else if (s.charAt(0) == 'C') {
            s1 = s2 = s3 = "";
            l.setText(s1 + s2 + s3);
        } else if (s.charAt(0) == '=') {
            double result;

            if (s2.equals("+"))
                result = (Double.parseDouble(s1) + Double.parseDouble(s3));
            else if (s2.equals("-"))
                result = (Double.parseDouble(s1) - Double.parseDouble(s3));
            else if (s2.equals("/"))
                result = (Double.parseDouble(s1) / Double.parseDouble(s3));
            else
                result = (Double.parseDouble(s1) * Double.parseDouble(s3));

            l.setText(s1 + s2 + s3 + " = " + result);

            s1 = Double.toString(result);
            s2 = s3 = "";
        } else {
            if (!s1.equals("") && !s3.equals("")) {
                double result;

                if (s2.equals("+"))
                    result = (Double.parseDouble(s1) + Double.parseDouble(s3));
                else if (s2.equals("-"))
                    result = (Double.parseDouble(s1) - Double.parseDouble(s3));
                else if (s2.equals("/"))
                    result = (Double.parseDouble(s1) / Double.parseDouble(s3));
                else
                    result = (Double.parseDouble(s1) * Double.parseDouble(s3));

                s1 = Double.toString(result);
                s2 = s;
                s3 = "";
            } else if (!s1.equals("") && s2.equals("")) {
                s2 = s;
            }
            l.setText(s1 + s2 + s3);
        }
    }
}
