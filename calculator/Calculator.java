package minicalculator;

import java.awt.*;
import javax.swing.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.awt.event.*;

public class Calculator extends JFrame{
    private JButton add;
    private JButton sub;
    private JButton mul;
    private JButton div;
    private JButton posNeg;
    private JButton percent;
    private JButton allClear;
    private JButton equals;
    private JButton point;
    private JButton numbers[];
    private JTextArea area;
    private BigDecimal decInput1;
    private BigDecimal decInput2;
    private BigInteger intInput1;
    private BigInteger intInput2;
    private String operation;
    private int temp;
    private static final int MAX_INPUT = 20; 
    private JPanel btns;




    public Calculator(){
      btns = new JPanel();
      btns.setLayout(new GridLayout(5, 4));
      btns.setVisible(true);
      
      
        allClear = new JButton("AC");
        
        posNeg = new JButton("+/-");
        
        percent = new JButton("%");
        
        div = new JButton("\u00F7");        
        
        mul = new JButton("\u00D7");
        
        sub = new JButton("-");
        
        add = new JButton("+");
        
        point = new JButton(".");

        equals = new JButton("=");
        
        numbers = new JButton[11];
        
        for(int temp = 0; temp <= 10; temp++){
          if(temp!=10){
            numbers[temp] = new JButton(String.valueOf(temp));
            numbers[temp].setBackground(Color.WHITE);
            numbers[temp].setFont(new Font("Times New Roman", Font.PLAIN, 24));
          } else {
            numbers[temp] = new JButton("");
            numbers[temp].setBackground(Color.WHITE);
          }
        }
        
        area = new JTextArea();
        area.setPreferredSize(new Dimension(1, 100));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setForeground(Color.WHITE);
        area.setBackground(Color.GRAY);
        area.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        area.setFont(new Font("Arial", Font.PLAIN, 36));


        //AC Button
        allClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                area.setText("");
                temp = 0;
            }
            
        });

        // +/- button
        posNeg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BigDecimal negative = new BigDecimal(area.getText());
                area.setText(negative.negate().toString());
                temp = 0;
            }
        });

        // % button
        percent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                decInput1 = new BigDecimal(area.getText());
                intInput1 = new BigInteger(area.getText());
                BigDecimal decOnes = new BigDecimal(01);
                BigDecimal decHundred = new BigDecimal(1001);
                decOnes = decInput1.divide(decHundred);
                area.setText(decOnes.toString());
                temp = 0;
            }
        });
        
        // divide button
        div.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                decInput1 = new BigDecimal(area.getText());
                intInput1 = new BigInteger(area.getText());
                area.setText("");
                operation = "division";
                temp = 0;
            }
        });
        
        //number 7 button
        numbers[7].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("7");
                    temp++;
                }
            }
        });
        
        // number 8 button
        numbers[8].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("8");
                    temp++;
                }
            }
        });
        
        // number 9 button
        numbers[9].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("9");
                    temp++;
                }
            }
        });
        
        // multiplication button
        mul.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                decInput1 = new BigDecimal(area.getText());
                intInput1 = new BigInteger(area.getText());
                area.setText("");
                operation = "multiplication";
                temp = 0;
            }
        });
        
        // number 4 button
        numbers[4].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("4");
                    temp++;
                }
            }
        });
        
        // number 5 button
        numbers[5].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("5");
                    temp++;
                }
            }
        });
        
        //number 6 button
        numbers[6].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("6");
                    temp++;
                }
            }
        });
        
        // subtraction button
        sub.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                decInput1 = new BigDecimal(area.getText());
                area.setText("");
                operation = "subtraction";
                temp = 0;
            }
        });
        
        // number 1 button
        numbers[1].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("1");
                    temp++;
                }
            }
        });
        
        // number 2 button
        numbers[2].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("2");
                    temp++;
                }
            }
        });
        
        // number 3 button
        numbers[3].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("3");
                    temp++;
                }
            }
        });
        
        // addition button
        add.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                decInput1 = new BigDecimal(area.getText());
                area.setText("");
                operation = "addition";
                temp = 0;
            }
        });
        
        // number 0 button
        numbers[0].addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(temp < MAX_INPUT){
                    area.append("0");
                    temp++;
                }
            }
        });
        
        // decimal point button
        point.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!area.getText().contains(".")){
                    area.append(".");
                }
            }
        });
        
        // equality button
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                BigDecimal decOnes = new BigDecimal(01);
                decInput2 = new BigDecimal(area.getText());
                if(operation == "division"){
                    decOnes = decInput1.divide(decInput2, 10, BigDecimal.ROUND_HALF_UP);
                } else if(operation == "multiplication"){
                    decOnes = decInput1.multiply(decInput2);
                } else if(operation == "subtraction"){
                    decOnes = decInput1.subtract(decInput1);
                } else if(operation == "addition"){
                    decOnes = decInput1.add(decInput2);
                }
                
                area.setText(decOnes.toString());
                operation = "";
                temp = 0;
            }
        });
        
        btns.add(allClear);
        allClear.setBackground(Color.lightGray);
        allClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        btns.add(posNeg);
        posNeg.setBackground(Color.lightGray);
        allClear.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        btns.add(percent);
        percent.setBackground(Color.lightGray);
        percent.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        btns.add(div);
        div.setBackground(Color.ORANGE);
        div.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        btns.add(numbers[7]);
        numbers[7].setBackground(Color.WHITE);
        numbers[7].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(numbers[8]);
        numbers[8].setBackground(Color.WHITE);
        numbers[9].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(numbers[9]);
        numbers[9].setBackground(Color.WHITE);
        numbers[9].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(mul);
        mul.setBackground(Color.ORANGE);
        mul.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        btns.add(numbers[4]);
        numbers[4].setBackground(Color.WHITE);
        numbers[4].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(numbers[5]);
        numbers[5].setBackground(Color.WHITE);
        numbers[5].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(numbers[6]);
        numbers[6].setBackground(Color.WHITE);
        numbers[6].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(sub);
        sub.setBackground(Color.ORANGE);
        sub.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        btns.add(numbers[1]);
        numbers[1].setBackground(Color.WHITE);
        numbers[1].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(numbers[2]);
        numbers[2].setBackground(Color.WHITE);
        numbers[2].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(numbers[3]);
        numbers[3].setBackground(Color.WHITE);
        numbers[3].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(add);
        add.setBackground(Color.ORANGE);
        add.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        btns.add(numbers[0]);
        numbers[0].setBackground(Color.WHITE);
        numbers[0].setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        btns.add(numbers[10]);
        
        btns.add(point);
        point.setBackground(Color.lightGray);
        point.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        
        btns.add(equals);
        equals.setBackground(Color.ORANGE);
        equals.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        
        add(btns, BorderLayout.CENTER);
        add(area, BorderLayout.NORTH);
        
        
        
        setTitle("Mini Calculator");
        setSize(300, 400);
        setVisible(true);



        
    }

    public static void main(String[] args) {
        new Calculator();
    }

}
