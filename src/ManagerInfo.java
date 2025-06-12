import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ManagerInfo extends JFrame implements ActionListener {
    JButton back;
    JTable table;
    ManagerInfo(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1=new JLabel("Name");
        l1.setBounds(48,10,75,20);
        add(l1);

        JLabel l2=new JLabel("Age");
        l2.setBounds(180,10,75,20);
        add(l2);

        JLabel l3=new JLabel("Job");
        l3.setBounds(307,10,75,20);
        add(l3);

        JLabel l4=new JLabel("Salary");
        l4.setBounds(424,10,75,20);
        add(l4);

        JLabel l5=new JLabel("Phone Number");
        l5.setBounds(526,10,75,20);
        add(l5);

        JLabel l6=new JLabel("Aadhar");
        l6.setBounds(658,10,75,20);
        add(l6);

        JLabel l7=new JLabel("Email");
        l7.setBounds(790,10,75,20);
        add(l7);

        JLabel l8=new JLabel("Gender");
        l8.setBounds(902,10,75,20);
        add(l8);

        table=new JTable();
        table.setBounds(0,40,1000,450);
        add(table);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from employee where job='Manager'");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(420,500,120,30);
        back.addActionListener(this);
        add(back);

        setBounds(400,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new ManagerInfo();
    }
    }
