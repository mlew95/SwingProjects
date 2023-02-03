package com.textEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem save;
    private JMenuItem open;


    public Frame() {
        menuBar = new JMenuBar();
        file = new JMenu("File");
        save = new JMenuItem("Save");
        open = new JMenuItem("Open");
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);

        menuBar.add(file);
        file.add(save);
        file.add(open);
        save.addActionListener(this);
        open.addActionListener(this);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));

        scrollPane.setPreferredSize(new Dimension(480, 450));
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        this.setTitle("Text Editor");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setJMenuBar(menuBar);
        this.add(scrollPane);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
