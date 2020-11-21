package ru.geekbrains.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Notepad extends JFrame {
    public Notepad() {
        setTitle("Блокнот");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Файл");
        menuBar.add(menu);

        JPanel panel = new JPanel();
        JLabel statusBarLabel = new JLabel();
        panel.add(statusBarLabel);

        JMenuItem menuChild = new JMenuItem("Сохранить как");
        menuChild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileForSaveChooser = new JFileChooser();
                fileForSaveChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                if (fileForSaveChooser.showSaveDialog(menuChild) == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileForSaveChooser.getSelectedFile();
                    statusBarLabel.setText("Выбран файл: " + selectedFile.getAbsolutePath());
                }
            }
        });
        menu.add(menuChild);

        JTextArea area = new JTextArea();
        area.setLineWrap(true);

        add(menuBar, BorderLayout.PAGE_START);
        add(area, BorderLayout.CENTER);
        add(panel, BorderLayout.PAGE_END);
        setVisible(true);
    }
}
