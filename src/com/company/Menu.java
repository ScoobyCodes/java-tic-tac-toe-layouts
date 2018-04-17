package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Menu extends JFrame{
    public Menu(String st) {
        super(st);
        initComponents();
    }

    private void initComponents() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("File");
        JMenu menu2 = new JMenu("Edit");
        JMenu menu3 = new JMenu("Format");
        JMenu menu4 = new JMenu("View");

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);
        menuBar.add(menu4);

        JMenuItem menuItem1 = new JMenuItem("New");
        KeyStroke keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK);
        menuItem1.setAccelerator(keyStrokeToOpen);

        JMenuItem menuItem2 = new JMenuItem("Open..");
        keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK);
        menuItem2.setAccelerator(keyStrokeToOpen);

        JMenuItem menuItem3 = new JMenuItem("Save");
        keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK);
        menuItem3.setAccelerator(keyStrokeToOpen);

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);
        menu1.addSeparator();

        JMenuItem menuItem4 = new JMenuItem("Print");
        keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK);
        menuItem4.setAccelerator(keyStrokeToOpen);
        menu1.add(menuItem4);
        menu1.addSeparator();

        JMenuItem menuItem5 = new JMenuItem("Exit");
        keyStrokeToOpen
                = KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK);
        menuItem5.setAccelerator(keyStrokeToOpen);
        menu1.add(menuItem5);

        this.setSize(300,300);
        this.setJMenuBar(menuBar);
    }

}
