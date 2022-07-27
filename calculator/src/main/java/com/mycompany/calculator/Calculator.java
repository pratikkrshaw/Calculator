/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.calculator;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.Date;
import java.io.*;
import java.nio.file.Paths;
/**
 *
 * @author SHAW
 */
public class Calculator {

    public static void main(String[] args) {
        String str=Paths.get("").toAbsolutePath().toString();
        System.out.println(str);
        File fl=new File(str+"\\data\\data.txt");
        try{
            fl.createNewFile();
        }catch(Exception g){
            System.out.println(g);
        }
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int height=(int)dim.getHeight(),width=(int)dim.getWidth();
        Image icon=Toolkit.getDefaultToolkit().getImage(str+"\\img\\cal.png");
        JFrame f=new JFrame("Calculator");
        f.getContentPane().setBackground(new java.awt.Color(76,82,112));
        f.setSize(width/3-50,height*3/4-20);
        f.setLayout(null);
        f.setIconImage(icon);
        f.setResizable(false);
        
        
        
        JButton his=new JButton(new ImageIcon(str+"\\img\\his.png"));
        his.setFocusPainted(false);
        his.setBackground(new java.awt.Color(47,79,79));
        his.setForeground(Color.WHITE);
        his.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        his.setBounds(10,20,50,80);
        his.setBorder(null);
        his.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                history h=new history();
                h.historydetails();
            }
        });
        JTextField display=new JTextField();
        display.setBounds(60,20,width/3-135,80);
        display.setFont(new Font("SANS_SERIF",Font.PLAIN,23));
        display.setBorder(null);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        
        JPanel cont=new JPanel();
        cont.setBackground(new java.awt.Color(47,79,79));
        cont.setBounds(10,130,width/3-85,height*3/4-200);
        cont.setLayout(null);
        
        
        
        JButton clear=new JButton("C");
        clear.setFocusPainted(false);
        clear.setBackground(Color.WHITE);
        clear.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        clear.setBounds(10,10,80,60);
        cont.add(clear);
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                display.setText(null);
            }
        });
        JButton back=new JButton("<");
        back.setFocusPainted(false);
        back.setBackground(Color.WHITE);
        back.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        back.setBounds(100,10,80,60);
        cont.add(back);
        back.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp.substring(0,temp.length()-1));
            }
        });
        JButton per=new JButton("%");
        per.setFocusPainted(false);
        per.setBackground(Color.WHITE);
        per.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        per.setBounds(190,10,80,60);
        cont.add(per);
        per.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Date dat=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY[HH:mm] :");
                    String date=sdf.format(dat);      
                    BufferedWriter wf=new BufferedWriter(new FileWriter(str+"\\data\\data.txt",true));
                    double val=Double.valueOf(display.getText())/100;
                    wf.write(date+" "+display.getText()+"% = "+String.valueOf(val)+"\n");
                    wf.close();
                    display.setText(String.valueOf(val));
                }catch(Exception h){
                    display.setText("error");
                }
            }
        });
        JButton add=new JButton("+");
        add.setFocusPainted(false);
        add.setBackground(Color.WHITE);
        add.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        add.setBounds(280,10,80,60);
        cont.add(add);
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                if(temp.isEmpty())
                    display.setText("0+");
                else if(temp.charAt(temp.length()-1)=='/' || temp.charAt(temp.length()-1)=='*' || temp.charAt(temp.length()-1)=='+' || temp.charAt(temp.length()-1)=='-')
                    display.setText(temp);
                else
                    display.setText(temp+"+");
                
            }
        });
        
        JButton one=new JButton("1");
        one.setFocusPainted(false);
        one.setBackground(Color.WHITE);
        one.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        one.setBounds(10,80,80,60);
        cont.add(one);
        one.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"1");
            }
        });
        
        JButton two=new JButton("2");
        two.setFocusPainted(false);
        two.setBackground(Color.WHITE);
        two.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        two.setBounds(100,80,80,60);
        cont.add(two);
        two.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"2");
            }
        });
        JButton three=new JButton("3");
        three.setFocusPainted(false);
        three.setBackground(Color.WHITE);
        three.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        three.setBounds(190,80,80,60);
        cont.add(three);
        three.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"3");
            }
        });
        JButton sub=new JButton("-");
        sub.setFocusPainted(false);
        sub.setBackground(Color.WHITE);
        sub.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        sub.setBounds(280,80,80,60);
        cont.add(sub);
        sub.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                if(temp.isEmpty())
                    display.setText("0-");
                else if(temp.charAt(temp.length()-1)=='/' || temp.charAt(temp.length()-1)=='*' || temp.charAt(temp.length()-1)=='+' || temp.charAt(temp.length()-1)=='-')
                    display.setText(temp);
                else
                    display.setText(temp+"-");
            }
        });
        
        
        JButton four=new JButton("4");
        four.setFocusPainted(false);
        four.setBackground(Color.WHITE);
        four.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        four.setBounds(10,150,80,60);
        cont.add(four);
        four.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"4");
            }
        });
        JButton five=new JButton("5");
        five.setFocusPainted(false);
        five.setBackground(Color.WHITE);
        five.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        five.setBounds(100,150,80,60);
        cont.add(five);
        five.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"5");
            }
        });
        JButton six=new JButton("6");
        six.setFocusPainted(false);
        six.setBackground(Color.WHITE);
        six.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        six.setBounds(190,150,80,60);
        cont.add(six);
        six.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"6");
            }
        });
        JButton mul=new JButton("*");
        mul.setFocusPainted(false);
        mul.setBackground(Color.WHITE);
        mul.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        mul.setBounds(280,150,80,60);
        cont.add(mul);
        mul.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                if(temp.isEmpty())
                    display.setText("0*");
                else if(temp.charAt(temp.length()-1)=='/' || temp.charAt(temp.length()-1)=='*' || temp.charAt(temp.length()-1)=='+' || temp.charAt(temp.length()-1)=='-')
                    display.setText(temp);
                else
                    display.setText(temp+"*");
            }
        });
        
        
        JButton seven=new JButton("7");
        seven.setFocusPainted(false);
        seven.setBackground(Color.WHITE);
        seven.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        seven.setBounds(10,220,80,60);
        cont.add(seven);
        seven.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"7");
            }
        });
        JButton eight=new JButton("8");
        eight.setFocusPainted(false);
        eight.setBackground(Color.WHITE);
        eight.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        eight.setBounds(100,220,80,60);
        cont.add(eight);        
        eight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"8");
            }
        });
        JButton nine=new JButton("9");
        nine.setFocusPainted(false);
        nine.setBackground(Color.WHITE);
        nine.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        nine.setBounds(190,220,80,60);
        cont.add(nine);        
        nine.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"9");
            }
        });
        JButton div=new JButton("/");
        div.setFocusPainted(false);
        div.setBackground(Color.WHITE);
        div.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        div.setBounds(280,220,80,60);
        cont.add(div);        
        div.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                if(temp.isEmpty())
                    display.setText("0/");
                else if(temp.charAt(temp.length()-1)=='/' || temp.charAt(temp.length()-1)=='*' || temp.charAt(temp.length()-1)=='+' || temp.charAt(temp.length()-1)=='-')
                    display.setText(temp);
                else
                    display.setText(temp+"/");
            }
        });
        
        JButton dot=new JButton(".");
        dot.setFocusPainted(false);
        dot.setBackground(Color.WHITE);
        dot.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        dot.setBounds(10,290,80,60);
        cont.add(dot);
        dot.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                operation op=new operation();
                if(temp.isEmpty())
                    display.setText("0.");
                else if(op.checkdot(temp))
                    display.setText(temp);
                else
                    display.setText(temp+".");
            }
        });
        JButton zero=new JButton("0");
        zero.setFocusPainted(false);
        zero.setBackground(Color.WHITE);
        zero.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        zero.setBounds(100,290,80,60);
        cont.add(zero);
        zero.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                display.setText(temp+"0");
            }
        });
        JButton res=new JButton("=");
        res.setFocusPainted(false);
        res.setBackground(Color.RED);
        res.setForeground(Color.WHITE);
        res.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        res.setBounds(190,290,170,60);
        cont.add(res);
        res.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String temp=display.getText();
                Date dat=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY[HH:mm] :");
                String date=sdf.format(dat);
                operation op=new operation();
                double result=op.perform(temp);
                try{
                    BufferedWriter bf=new BufferedWriter(new FileWriter(str+"\\data\\data.txt",true));
                    bf.write(date+" "+temp+" = "+String.valueOf(result)+"\n");
                    bf.close();
                }catch(Exception g){
                    System.out.println(g);
                }
                display.setText(String.valueOf(result));
            }
        });
        
        
        
        f.add(his);
        f.add(display);
        f.add(cont);
        f.setVisible(true);
        f.setLocation(width/3,height/8);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
