package com.Syn.action;

import com.Syn.entity.details;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class process {

    private details detail;
    private JFrame frame;
    private JLabel L_user_id,L_unit,L_current_date,L_month, Total;
    private JPanel panel;
    private Font font = new Font("Serif", Font.PLAIN, 20);
    private  ActionListener payment;
    public process(details detail) {
        this.detail = detail;
    }

    public void nextPage() {

        frame = new JFrame("Electricity Bill");
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        //User ID
        L_user_id=new JLabel("User ID  : " + detail.getUserid() );
        L_user_id.setBounds(300,150,200,20);
        L_user_id.setFont(font);
        panel.add(L_user_id);
       
        //Current Date
        L_current_date=new JLabel("Present Date : " + detail.getDate());
        L_current_date.setBounds(650,150,250,20);
        L_current_date.setFont(font);
        panel.add(L_current_date);
        
        //Unit 
        L_unit=new JLabel("Unit : " + detail.getUnit());
        L_unit.setBounds(300,250,200,20);
        L_unit.setFont(font);
        panel.add(L_unit);
        
        //Month
         L_month=new JLabel(" Bill Month : " + detail.getMonth());
        L_month.setBounds(650,250,200,20);
        L_month.setFont(font);
        panel.add(L_month);
        
        //total
        int total = detail.getUnit() * 10;
        Total = new JLabel("Total : " + total);
        Total.setBounds(300, 350, 200, 20);
        Total.setFont(font);
        panel.add(Total);
        
        //pay
        JButton pay =new JButton("Pay");
        pay.setBounds(550, 400, 100, 30);
        pay.setForeground(Color.white);
        pay.setFont(font);
        pay.setBackground(Color.green);
        payment=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                 try
                {
                   JOptionPane.showMessageDialog(panel, "Transaction successful");
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        };
        pay.addActionListener(payment);
        panel.add(pay);
      
        
        frame.setVisible(true);
        frame.setSize(1280, 1400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
