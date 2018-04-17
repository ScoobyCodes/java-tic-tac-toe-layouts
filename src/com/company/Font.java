package com.company;

import javax.swing.*;
import java.awt.*;

public class Font extends JFrame{
    public Font(String st) {
        super(st);
        initComponents();
    }

    private void initComponents() {
        Container panel = this.getContentPane();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        JRadioButton redBtn = new JRadioButton("Red");
        JRadioButton blueBtn = new JRadioButton("Blue");
        JRadioButton greenBtn = new JRadioButton("Green");
        JRadioButton centerBtn = new JRadioButton("Center");
        JRadioButton leftBtn = new JRadioButton("Left");
        JRadioButton rightBtn = new JRadioButton("Right");
        JLabel label = new JLabel("GOOD MORNING");

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(label)
                .addGroup(layout.createSequentialGroup().
                        addComponent(redBtn).addComponent(greenBtn).addComponent(blueBtn))
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(centerBtn).addComponent(leftBtn).addComponent(rightBtn))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(centerBtn)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(label)
                        .addComponent(leftBtn))
                .addComponent(rightBtn)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(redBtn)
                        .addComponent(greenBtn)
                        .addComponent(blueBtn))

        );

        this.setSize(300,300);
    }
}
