
package com.Syn.GUI;

import com.Syn.action.process;
import com.Syn.entity.details;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class welcome  {
    private static JFrame mainframe; 
    private static JPanel panel;
    private static JLabel heading,L_user_id,L_unit,L_current_date,L_month;
    private static Font font1,font=new Font("Serif",Font.PLAIN,20);;
    private static JTextField I_user_id,I_unit,I_month,I_current_date;
    private static JButton submit;
    private static ActionListener t;
    
    public static void main(String agrs[]){
        
        
        mainframe=new JFrame("Electricity Bill");
        panel=new JPanel();
        mainframe.add(panel);
        panel.setLayout(null);
        
        //heading 
        heading =new JLabel("Electricity Bill");
        heading.setBounds(550,10,500, 100);
        font1=new Font("Arial",Font.BOLD,20);
        heading.setFont(font1);
        panel.add(heading);
        
        //User id
        L_user_id=new JLabel("User ID");
        L_user_id.setBounds(300,150,80,20);
          L_user_id.setFont(font);
        panel.add(L_user_id);
        I_user_id=new JTextField();
        I_user_id.setBounds(400, 150,200,25);
        I_user_id.setFont(font);
        I_user_id.setText("");
        panel.add(I_user_id);
        
        //current date
        L_current_date=new JLabel("Present Date");
        L_current_date.setBounds(650,150,150,20);
        L_current_date.setFont(font);
        panel.add(L_current_date);
        I_current_date=new JTextField();
        I_current_date.setBounds(760, 150,200,25);
        Date date=new Date(System.currentTimeMillis());
        Format formatter=new SimpleDateFormat("dd-MM-yyyy ");
        String temp=formatter.format(date);
        I_current_date.setText(temp);
        I_current_date.setFont(font);
        panel.add(I_current_date);
        
        //Unit Consume
         L_unit=new JLabel("Unit Cons");
        L_unit.setBounds(300,250,80,20);
        L_unit.setFont(font);
        panel.add(L_unit);
        I_unit=new JTextField();
        I_unit.setBounds(400, 250,200,25);
        I_unit.setFont(font);
        panel.add(I_unit);
        
        //Month 
        L_month=new JLabel(" Bill Month ");
        L_month.setBounds(650,250,150,20);
       
        L_month.setFont(font);
        panel.add(L_month);
        I_month=new JTextField();
        I_month.setBounds(760, 250,200,25);
        I_month.setFont(font);
        panel.add(I_month);
        
        submit =new JButton("Proceed");
        submit.setBounds(550, 350, 100, 30);
        submit.setForeground(Color.white);
        font=new Font("Serif",Font.PLAIN,10);
        submit.setBackground(Color.green);
        panel.add(submit);
    
      ActionListener request=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    details d=new details(I_user_id.getText(),I_month.getText(),I_current_date.getText(),Integer.parseInt(I_unit.getText()));
                    process p=new process(d);
                    p.nextPage();
                    
                }
                catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        };
     
      submit.addActionListener(request);
        
        mainframe.setVisible(true);
        mainframe.setSize(1280, 1400);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

  
}
