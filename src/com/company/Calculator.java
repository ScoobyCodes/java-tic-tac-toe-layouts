package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame{

    JTextField textField;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonAdd;
    JButton buttonSubtract;
    JButton buttonDivide;
    JButton buttonMultiply;
    JButton buttonReset;
    JButton buttonEqual;
    JButton buttonModulo;

    public Calculator(String st) {
        super(st);
        initComponents();
    }

    private void initComponents() {
        JPanel flowPane = new JPanel();
        flowPane.setLayout(new BoxLayout(flowPane,BoxLayout.PAGE_AXIS));

        textField = new JTextField("");
        textField.setSize(100,300);

        flowPane.add(textField);

        JPanel buttonPane = new JPanel();

        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonDivide = new JButton("/");
        buttonMultiply = new JButton("*");
        buttonReset = new JButton("AC");
        buttonEqual = new JButton("=");
        buttonModulo = new JButton("%");

        buttonPane.add(button1);
        buttonPane.add(button2);
        buttonPane.add(button3);
        buttonPane.add(button4);
        buttonPane.add(button5);
        buttonPane.add(button6);
        buttonPane.add(button7);
        buttonPane.add(button8);
        buttonPane.add(button9);
        buttonPane.add(buttonAdd);
        buttonPane.add(buttonSubtract);
        buttonPane.add(buttonDivide);
        buttonPane.add(buttonMultiply);
        buttonPane.add(buttonReset);
        buttonPane.add(buttonEqual);
        buttonPane.add(buttonModulo);


        buttonPane.setLayout(new GridLayout(4,4));
        buttonPane.setSize(500,500);

        this.setSize(300,300);
        Container contentPane = getContentPane();
        contentPane.add(flowPane, BorderLayout.PAGE_START);
        contentPane.add(buttonPane,BorderLayout.PAGE_END);

        addEventListeners();
    }

    public void addEventListeners() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "1");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "2");
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "3");
            }
        });

        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "4");
            }
        });

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "5");
            }
        });

        button6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "6");
            }
        });

        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "7");
            }
        });

        button8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "8");
            }
        });

        button9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(textField.getText() + "9");
            }
        });

        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();
                if(checkNumber(txt)) {
                    textField.setText(txt+"+");
                }
                else {
                    textField.setText("Invalid Expression");
                }
            }
        });

        buttonSubtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();
                if(checkNumber(txt)) {
                    textField.setText(txt+"-");
                }
                else {
                    textField.setText("Invalid Expression");
                }
            }
        });

        buttonDivide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();
                if(checkNumber(txt)) {
                    textField.setText(txt+"/");
                }
                else {
                    textField.setText("Invalid Expression");
                }
            }
        });

        buttonMultiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();
                if(checkNumber(txt)) {
                    textField.setText(txt+"*");
                }
                else {
                    textField.setText("Invalid Expression");
                }
            }
        });

        buttonReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
            }
        });

        buttonEqual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();
                int k = getIndex(txt);

                if(k == -1) {
                    textField.setText(textField.getText());
                }
                else {
                    Integer I1 = Integer.parseInt(txt.substring(0,k));
                    Integer I2 = Integer.parseInt(txt.substring(k+1,txt.length()));
                    Integer I3 = 0;
                    char operator = txt.charAt(k);
                    switch(operator) {
                        case '+' : I3 = I1 + I2 ; break;
                        case '-' : I3 = I1 - I2 ; break;
                        case '/' :
                                   if(I2 == 0) {
                                       I3 = -1;
                                       break;
                                   }
                                   I3 = I1 / I2 ;
                                   break;
                        case '*' : I3 = I1 * I2 ; break;
                        case '%' :
                                  if(I2 == 0) {
                                      I3 = -1;
                                      break;
                                  }
                                  I3 = I1 % I2 ;
                                  break;
                        default : I3 = I1 + I2 ; break;
                    }
                    textField.setText(I3.toString());
                }
            }
        });

        buttonModulo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String txt = textField.getText();
                if(checkNumber(txt)) {
                    textField.setText(txt+"%");
                }
                else {
                    textField.setText("Invalid Expression");
                }
            }
        });

    }

    public boolean checkNumber(String st)  {
        for(int i=0;i<st.length();i++) {
            int j = st.charAt(i) - '0';
            if(!(0 <= j && j <= 9)) {
                return false;
            }
        }
        return true;
    }

    public int getIndex(String st)  {
        for(int i=0;i<st.length();i++) {
            int j = st.charAt(i) - '0';
            if(!(0 <= j && j <= 9)) {
                return i;
            }
        }
        return -1;
    }
}
