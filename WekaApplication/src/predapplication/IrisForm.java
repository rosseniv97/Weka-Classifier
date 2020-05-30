/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package predapplication;

/**
 *
 * @author Rossen
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IrisForm
        extends JFrame
        implements ActionListener {

    // Components of the Form 
    private Container c;
    private JLabel title;
    private JLabel slength;
    private JTextField tslength;
    private JLabel plength;
    private JTextField tplength;
    private JLabel pwidth;
    private JTextField tpwidth;
    private JLabel swidth;
    private JTextField tswidth;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel add;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JTextArea tout;
    private JLabel res;
    private JTextArea resadd;

    // constructor, to initialize the components 
    // with default values. 
    public IrisForm() {
        setTitle("Iris Classifier");
        setBounds(300, 90, 900, 600);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Iris Classifier");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        slength = new JLabel("sLength");
        slength.setFont(new Font("Arial", Font.PLAIN, 20));
        slength.setSize(100, 20);
        slength.setLocation(100, 100);
        c.add(slength);

        tslength = new JTextField();
        tslength.setFont(new Font("Arial", Font.PLAIN, 15));
        tslength.setSize(190, 20);
        tslength.setLocation(170, 100);
        c.add(tslength);

        swidth = new JLabel("sWidth");
        swidth.setFont(new Font("Arial", Font.PLAIN, 20));
        swidth.setSize(100, 20);
        swidth.setLocation(100, 150);
        c.add(swidth);

        tswidth = new JTextField();
        tswidth.setFont(new Font("Arial", Font.PLAIN, 15));
        tswidth.setSize(190, 20);
        tswidth.setLocation(170, 150);
        c.add(tswidth);

        plength = new JLabel("pLength");
        plength.setFont(new Font("Arial", Font.PLAIN, 20));
        plength.setSize(100, 20);
        plength.setLocation(100, 200);
        c.add(plength);

        tplength = new JTextField();
        tplength.setFont(new Font("Arial", Font.PLAIN, 15));
        tplength.setSize(150, 20);
        tplength.setLocation(170, 200);
        c.add(tplength);

        pwidth = new JLabel("pWidth");
        pwidth.setFont(new Font("Arial", Font.PLAIN, 20));
        pwidth.setSize(100, 20);
        pwidth.setLocation(100, 250);
        c.add(pwidth);

        tpwidth = new JTextField();
        tpwidth.setFont(new Font("Arial", Font.PLAIN, 15));
        tpwidth.setSize(150, 20);
        tpwidth.setLocation(170, 250);
        c.add(tpwidth);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 400);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 450);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 450);
        reset.addActionListener(this);
        c.add(reset);

        tout = new JTextArea();
        tout.setFont(new Font("Arial", Font.PLAIN, 15));
        tout.setSize(300, 400);
        tout.setLocation(500, 100);
        tout.setLineWrap(true);
        tout.setEditable(false);
        c.add(tout);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 500);
        c.add(res);

        resadd = new JTextArea();
        resadd.setFont(new Font("Arial", Font.PLAIN, 15));
        resadd.setSize(200, 75);
        resadd.setLocation(580, 175);
        resadd.setLineWrap(true); 
        c.add(resadd);

        setVisible(true);
    }

    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sub) {
            try {
                if (term.isSelected()) {
                    double[] data = new double[4];
                    data[0] = Double.parseDouble(tslength.getText());
                    data[1] = Double.parseDouble(tswidth.getText());
                    data[2] = Double.parseDouble(tplength.getText());
                    data[3] = Double.parseDouble(tpwidth.getText());
                    Classifier classifier = new Classifier("nb");
                    String result = Classifier.Clasify(data);
                    res.setText("Classified Successfully");
                    resadd.setText("Classified as: " + result);
                    System.out.print(resadd.getText());

                } else {
                    tout.setText("");
                    resadd.setText("");
                    res.setText("Please accept the"
                            + " terms & conditions..");
                } 
            } catch(Exception ex) {
                if(ex instanceof NumberFormatException) {
                     res.setText("All fields must be filled!");
                }
            }

        } else if (e.getSource() == reset) {
            String def = "";
            tslength.setText(def);
            tplength.setText(def);
            tswidth.setText(def);
            tpwidth.setText(def);
            res.setText(def);
            tout.setText(def);
            term.setSelected(false);

            resadd.setText(def);
        }
    }

    /* public static void main(String[] args) throws Exception {
        MyFrame f = new MyFrame();
    }
     */
}
