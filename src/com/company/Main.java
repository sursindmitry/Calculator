package com.company;


import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Калькулятор");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(600,300,400,480);
        CalcPanel panel = new CalcPanel();
        frame.add(panel);
        frame.setVisible(true);

    }
}
