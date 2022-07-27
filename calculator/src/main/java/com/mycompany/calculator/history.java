/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.nio.file.Paths;

/**
 *
 * @author SHAW
 */
public class history {
    public void historydetails(){
        String str=Paths.get("").toAbsolutePath().toString();
        Dimension dim=Toolkit.getDefaultToolkit().getScreenSize();
        int height=(int)dim.getHeight(),width=(int)dim.getWidth();
        Image icon=Toolkit.getDefaultToolkit().getImage(str+"\\img\\cal.png");
        JFrame f=new JFrame("History");
        f.getContentPane().setBackground(Color.WHITE);
        f.setSize(width/3-50,height*3/4-20);
        f.getContentPane().setLayout(null); 
        f.setIconImage(icon);
        f.setResizable(false);
        GridBagLayout layout = new GridBagLayout();
        f.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints(); 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.weighty = 1.0; 
        gbc.gridx = 0;  
        gbc.gridy = 0;  
        gbc.gridwidth=2;

        JLabel det=new JLabel("HISTORY",JLabel.CENTER);
        det.setForeground(Color.BLACK);
        det.setFont(new Font("SANS_SERIF",Font.BOLD,26));
        JTextArea jt=new JTextArea(18,25);
        jt.setEditable(false);
        jt.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        JScrollPane scroll=new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(null);
        f.add(det,gbc);
        
        gbc.gridx = 0;  
        gbc.gridy = 1;
        gbc.gridwidth=2;
        f.add(scroll,gbc);
        JButton clear=new JButton("Clear");
        clear.setBackground(new java.awt.Color(47,79,79));
        clear.setForeground(Color.white);
        clear.setFocusPainted(false);
        clear.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        clear.setBorder(null);
        gbc.ipady = 20;
        gbc.ipadx=45;
        gbc.insets = new Insets(0,30,10,0);
        gbc.fill=GridBagConstraints.RELATIVE;
        gbc.gridx = 0;  
        gbc.gridy = 2;
        gbc.gridwidth=1;
        clear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    BufferedWriter bw=new BufferedWriter(new FileWriter(str+"\\data\\data.txt"));
                    String val="";
                    bw.write(val);
                    bw.close();
                    JOptionPane.showMessageDialog(f,"History Cleared Successfully!","Success",0,new ImageIcon(str+"\\img\\accept.png"));
                    f.dispose();
                }catch(Exception g){
                    System.out.println(g);
                }
            }
        });
        f.add(clear,gbc);
        JButton close=new JButton("Close");
        close.setBackground(Color.RED);
        close.setForeground(Color.BLACK);
        close.setFocusPainted(false);
        close.setFont(new Font("SANS_SERIF",Font.BOLD,15));
        close.setBorder(null);
        gbc.ipady = 20;
        gbc.ipadx=45;
        gbc.insets = new Insets(0,0,10,30);
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.gridx = 1;  
        gbc.gridy = 2;
        gbc.gridwidth=1;
        close.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                f.dispose();
            }
        });
        f.add(close,gbc);
        String history="";
        try{
            BufferedReader br=new BufferedReader(new FileReader(str+"\\data\\data.txt"));
            int i;
            while((i=br.read())!=-1){
                history+=(char)i;
            }
        }catch(Exception g){
            System.out.println(g);
        }
        if(history.isEmpty())
            jt.setText("No History Found!");
        else
            jt.setText(history);
        f.setVisible(true);
        f.setLocation(width/3,height/8);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
}
