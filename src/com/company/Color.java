package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Color extends JFrame {
    public Color(String st) {
        super(st);
        initComponents();
    }

    private void initComponents() {
        JLabel label = new JLabel("COLOR",SwingConstants.CENTER);

        //label.setHorizontalTextPosition(JLabel.CENTER);
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new BoxLayout(colorPanel,BoxLayout.PAGE_AXIS));

        JLabel redLbl = new JLabel("Red");
        JLabel greenLbl = new JLabel("Blue");
        JLabel blueLbl = new JLabel("Green");

        JSlider slider1 = new JSlider(JSlider.HORIZONTAL,0,30,15);
        JSlider slider2 = new JSlider(JSlider.HORIZONTAL,0,30,10);
        JSlider slider3 = new JSlider(JSlider.HORIZONTAL,0,30,18);

        JPanel redPanel = new JPanel();
        redPanel.setLayout(new FlowLayout());
        redPanel.add(redLbl);
        redPanel.add(slider1);

        JPanel greenPanel = new JPanel();
        greenPanel.setLayout(new FlowLayout());
        greenPanel.add(greenLbl);
        greenPanel.add(slider2);

        JPanel bluePanel = new JPanel();
        bluePanel.setLayout(new FlowLayout());
        bluePanel.add(blueLbl);
        bluePanel.add(slider3);

        colorPanel.add(redPanel);
        colorPanel.add(bluePanel);
        colorPanel.add(greenPanel);

        this.setSize(300,300);

        Container panel = getContentPane();
        panel.add(label,BorderLayout.CENTER);
        panel.add(colorPanel, BorderLayout.PAGE_END);
    }
}
