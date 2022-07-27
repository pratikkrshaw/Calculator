/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.calculator;

import java.util.ArrayList;

/**
 *
 * @author SHAW
 */
public class operation {
    public double perform(String temp){
        String regex="[^+|\\-|\\/|\\*]";
        int k=0;
        String[] operation=temp.split(regex);
        String[] operator=temp.split("\\+|\\-|\\/|\\*");
        double res=Double.valueOf(operator[0]);
        for (String operation1 : operation) {
            if (operation1.isEmpty()) {
                continue;
            }
            k+=1;
            switch (operation1) {
                case "+":
                    res+=Double.valueOf(operator[k]);
                    break;
                case "-":
                    res-=Double.valueOf(operator[k]);
                    break;
                case "*":
                    res*=Double.valueOf(operator[k]);
                    break;
                case "/":
                    res/=Double.valueOf(operator[k]);
                    break;
                default:
                    break;
            }
        }
        return res;
    }
    public boolean checkdot(String temp){
        boolean res=true;
        if(temp.indexOf('+')==-1 && temp.indexOf('/')==-1 && temp.indexOf('*')==-1 && temp.indexOf('-')==-1 && temp.indexOf('.')==-1)
            res=false;
        else{
            String regex="[^+|\\-|\\/|\\*]";
            String[] operation=temp.split(regex);
            ArrayList<String> val=new ArrayList<String>();
            for(int i=0;i<operation.length;i++){
                if(operation[i].isEmpty())  
                    continue;
                val.add(operation[i]);
            }
            if(temp.lastIndexOf(val.get(val.size()-1))>temp.lastIndexOf('.'))
                res=false;
        }
        return res;
        
    }
}
