package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Algebra extends JFrame{
    public Algebra(String st) {
        super(st);
        initComponents();
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Operation");
        JMenu menu2 = new JMenu("Exit");


        menuBar.add(menu1);
        menuBar.add(menu2);

        JMenuItem menuItem1 = new JMenuItem("Add");
        KeyStroke keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        menuItem1.setAccelerator(keyStrokeToOpen);

        JMenuItem menuItem2 = new JMenuItem("Subtract");
        keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        menuItem2.setAccelerator(keyStrokeToOpen);

        JMenuItem menuItem3 = new JMenuItem("Multiply");
        keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_DOWN_MASK);
        menuItem3.setAccelerator(keyStrokeToOpen);

        JMenuItem menuItem4 = new JMenuItem("Divide");
        keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_DOWN_MASK);
        menuItem4.setAccelerator(keyStrokeToOpen);

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.add(menuItem4);

        this.setSize(500,300);
        this.setJMenuBar(menuBar);

        TextField textField1 = new TextField();
        TextField textField2 = new TextField();
        TextField textField3 = new TextField();
        textField1.setColumns(5);
        textField2.setColumns(5);
        textField3.setColumns(5);

        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        startPanel.add(new JLabel("NUMBER1"));
        startPanel.add(textField1);
        startPanel.add(new JLabel("NUMBER2"));
        startPanel.add(textField2);
        startPanel.add(new JLabel("Result"));
        startPanel.add(textField3);

        JPanel endPanel = new JPanel();
        endPanel.setLayout(new FlowLayout());
        endPanel.add(new JButton("Add"));
        endPanel.add(new JButton("Subtract"));
        endPanel.add(new JButton("Multiply"));
        endPanel.add(new JButton("Divide"));

        Container panel = getContentPane();
        panel.add(startPanel,BorderLayout.CENTER);
        panel.add(endPanel,BorderLayout.PAGE_END);

    }

}