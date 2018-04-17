package com.company;

import javax.swing.*;
import java.awt.*;

public class State extends JFrame {
    public State(String st) {
        super(st);
        initComponents();
    }

    Object[] data ={"California,", "Alabama,",
            "Arkansas,", "Arizona,", "Alaska,", "Colorado,",
            "Connecticut,", "Delaware,", "Florida,", "Georgia,", "Hawaii,", "Idaho,",
            "Illinois,", "Indiana,",
            "Iowa,", "Kansas,", "Kentucky,", "Louisiana,", "Maine,", "Maryland,",
            "Massachusetts,", "Michigan,", "Minnesota,", "Mississippi,", "Missouri,",
            "Montana,", "Nebraska,", "Nevada,", "New Hampshire,", "New Jersey,", "New Mexico,", "New York,", "North Carolina,", "North Dakota,",
            "Ohio,", "Oklahoma,", "Oregon,", "Pennsylvania,", "Rhode Island,", "South Carolina,", "South Dakota,", "Tennessee,", "Texas,", "Utah,",
            "Vermont,", "Virginia,", "Washington,", "West Virginia,", "Wisconsin,", "Wyoming" };

    String entries[] = {"SINGLE_INTERVAL_SELECTION","SINGLE","DUAL","SINGLE_PARTY"};

    private void initComponents() {
        JPanel startPanel = new JPanel();
        startPanel.setLayout(new FlowLayout());
        startPanel.add(new JLabel("Mode"));

        JComboBox cb = new JComboBox(entries);
        startPanel.add(cb);

        JList list = new JList(data);
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setPreferredSize(new Dimension(250, 80));
        JLabel label = new JLabel("GUJRAT_MAHARASHTRA");

        this.setSize(300,300);
        Container panel = getContentPane();
        panel.add(startPanel,BorderLayout.PAGE_START);
        panel.add(scrollPane,BorderLayout.CENTER);
        panel.add(label,BorderLayout.PAGE_END);
    }
}
