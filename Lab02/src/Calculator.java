import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Calculator extends WindowAdapter implements ActionListener {
    Frame f;
    Panel p1, p2;
    Label l1, l2;
    MenuBar menuBar;
    String[] btnName = {
            "MC", "MR", "MS", "M+", "M-",
            "<-", "CE", "C", "±", "√",
            "7", "8", "9", "/", "%",
            "4", "5", "6", "*", "1/x",
            "1", "2", "3", "-", "=",
            "0", ".", "+"
    };
    Button[] buttons = new Button[28];
    double num1 = 0, num2;
    boolean operatorCheck = false;
    ArrayList<Double> memoryList = new ArrayList<Double>();
    boolean memoryListIsEmpty = true;
    ArrayList<String> operatorQueue = new ArrayList<String>();

    Calculator() {
        f = new Frame("Calculator");
        f.setLayout(new BorderLayout(20, 15));

        p1 = new Panel(new BorderLayout());
        p1.setPreferredSize(new Dimension(400, 75));

        l1 = new Label("");
        l2 = new Label("");
        l1.setAlignment(Label.RIGHT);
        l2.setAlignment(Label.RIGHT);

        Font font = new Font("Arial", Font.BOLD, 40);
        l1.setPreferredSize(new Dimension(320, 20));

        l1.setFont(font);
        p1.add(l2, BorderLayout.NORTH);
        p1.add(l1, BorderLayout.CENTER);

        p2 = new Panel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        for (int i = 0; i < btnName.length; i++) {
            buttons[i] = new Button(btnName[i]);
            if (btnName[i].equals("0")) {

                c.fill = GridBagConstraints.BOTH;
                c.gridx = 0;
                c.gridy = 5;
                c.gridwidth = 2;
                c.gridheight = 1;
                c.weightx = 2;
                c.weighty = 1;

            } else if (btnName[i].equals("=")) {

                c.fill = GridBagConstraints.BOTH;
                c.gridx = 4;
                c.gridy = 4;
                c.gridwidth = 1;
                c.gridheight = 2;
                c.weightx = 1;
                c.weighty = 2;

            } else if (btnName[i].equals(".") || btnName[i].equals("+")) {

                c.fill = GridBagConstraints.BOTH;
                c.gridx = (i % 5) + 1;
                c.gridy = i / 5;
                c.gridwidth = 1;
                c.gridheight = 1;
                c.weightx = 1;
                c.weighty = 1;

            } else {

                c.fill = GridBagConstraints.BOTH;
                c.gridx = i % 5;
                c.gridy = i / 5;
                c.gridwidth = 1;
                c.gridheight = 1;
                c.weightx = 1;
                c.weighty = 1;

            }

            p2.add(buttons[i], c);
            buttons[i].addActionListener((ActionListener) this);
        }

        menuBar = new MenuBar();
        Menu viewMenu = new Menu("View");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        menuBar.add(editMenu);

        f.setMenuBar(menuBar);
        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.CENTER);

        f.setSize(350, 450);
        f.setVisible(true);
        f.setResizable(false);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String z, zt;
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("0")]) {
            zt = l1.getText();
            z = zt + "0";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("1")]) {
            zt = l1.getText();
            z = zt + "1";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("2")]) {
            zt = l1.getText();
            z = zt + "2";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("3")]) {
            zt = l1.getText();
            z = zt + "3";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("4")]) {
            zt = l1.getText();
            z = zt + "4";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("5")]) {
            zt = l1.getText();
            z = zt + "5";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("6")]) {
            zt = l1.getText();
            z = zt + "6";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("7")]) {
            zt = l1.getText();
            z = zt + "7";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("8")]) {
            zt = l1.getText();
            z = zt + "8";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("9")]) {
            zt = l1.getText();
            z = zt + "9";
            l1.setText(z);

        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf(".")]) {
            zt = l1.getText();
            z = zt + ".";
            l1.setText(z);
        }

        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("+")]) {
            if (operatorQueue.size() == 0) {
                operatorQueue.add(l1.getText());
                operatorQueue.add("+");
                l2.setText(l1.getText() + "+");
                l1.setText("");
            }
            if (operatorQueue.size() == 2) {
                num1 = Double.parseDouble(operatorQueue.get(0));
                num2 = Double.parseDouble(l1.getText());
                Double ans = operatorQueue.get(1).equals("+") ? num1 + num2
                            : operatorQueue.get(1).equals("-") ? num1 - num2
                            : operatorQueue.get(1).equals("*") ? num1 * num2 
                            : operatorQueue.get(1).equals("/") ? num1 / num2
                            : num1 % num2;
                l2.setText(ans + "+");
                l1.setText("");
                operatorQueue.clear();
                operatorQueue.add(ans.toString());
                operatorQueue.add("+");
            }
        }

        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("-")]) {
            if (operatorQueue.size() == 0) {
                operatorQueue.add(l1.getText());
                operatorQueue.add("-");
                l2.setText(l1.getText() + "-");
                l1.setText("");
            }
            if (operatorQueue.size() == 2) {
                num1 = Double.parseDouble(operatorQueue.get(0));
                num2 = Double.parseDouble(l1.getText());
                Double ans = operatorQueue.get(1).equals("+") ? num1 + num2
                            : operatorQueue.get(1).equals("-") ? num1 - num2
                            : operatorQueue.get(1).equals("*") ? num1 * num2 
                            : operatorQueue.get(1).equals("/") ? num1 / num2
                            : num1 % num2;
                l2.setText(ans + "-");
                l1.setText("");
                operatorQueue.clear();
                operatorQueue.add(ans.toString());
                operatorQueue.add("-");
            }
        }

        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("*")]) {
            if (operatorQueue.size() == 0) {
                operatorQueue.add(l1.getText());
                operatorQueue.add("*");
                l2.setText(l1.getText() + "*");
                l1.setText("");
            }
            if (operatorQueue.size() == 2) {
                num1 = Double.parseDouble(operatorQueue.get(0));
                num2 = Double.parseDouble(l1.getText());
                Double ans = operatorQueue.get(1).equals("+") ? num1 + num2
                            : operatorQueue.get(1).equals("-") ? num1 - num2
                            : operatorQueue.get(1).equals("*") ? num1 * num2 
                            : operatorQueue.get(1).equals("/") ? num1 / num2
                            : num1 % num2;
                l2.setText(ans + "*");
                l1.setText("");
                operatorQueue.clear();
                operatorQueue.add(ans.toString());
                operatorQueue.add("*");
            }
        }
        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("/")]) {
            if (operatorQueue.size() == 0) {
                operatorQueue.add(l1.getText());
                operatorQueue.add("/");
                l2.setText(l1.getText() + "/");
                l1.setText("");
            }
            if (operatorQueue.size() == 2) {
                num1 = Double.parseDouble(operatorQueue.get(0));
                num2 = Double.parseDouble(l1.getText());
                Double ans = operatorQueue.get(1).equals("+") ? num1 + num2
                            : operatorQueue.get(1).equals("-") ? num1 - num2
                            : operatorQueue.get(1).equals("*") ? num1 * num2 
                            : operatorQueue.get(1).equals("/") ? num1 / num2
                            : num1 % num2;
                l2.setText(ans + "/");
                l1.setText("");
                operatorQueue.clear();
                operatorQueue.add(ans.toString());
                operatorQueue.add("/");
            }
        }

        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("%")]) {
            if (operatorQueue.size() == 0) {
                operatorQueue.add(l1.getText());
                operatorQueue.add("%");
                l2.setText(l1.getText() + "%");
                l1.setText("");
            }
            if (operatorQueue.size() == 2) {
                num1 = Double.parseDouble(operatorQueue.get(0));
                num2 = Double.parseDouble(l1.getText());
                Double ans = operatorQueue.get(1).equals("+") ? num1 + num2
                            : operatorQueue.get(1).equals("-") ? num1 - num2
                            : operatorQueue.get(1).equals("*") ? num1 * num2 
                            : operatorQueue.get(1).equals("/") ? num1 / num2
                            : num1 % num2;
                l2.setText(ans + "%");
                l1.setText("");
                operatorQueue.clear();
                operatorQueue.add(ans.toString());
                operatorQueue.add("%");
            }
        }

        if (e.getSource() == buttons[Arrays.asList(btnName).indexOf("=")]) {
            if(operatorQueue.size() == 2) {
                num1 = Double.parseDouble(operatorQueue.get(0));
                num2 = Double.parseDouble(l1.getText());
                Double ans = operatorQueue.get(1).equals("+") ? num1 + num2
                            : operatorQueue.get(1).equals("-") ? num1 - num2
                            : operatorQueue.get(1).equals("*") ? num1 * num2 
                            : operatorQueue.get(1).equals("/") ? num1 / num2
                            : num1 % num2;
                l2.setText(num1 + operatorQueue.get(1) + num2 +  "=");
                l1.setText(ans.toString());
                operatorQueue.clear();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Calculator();
    }
}
