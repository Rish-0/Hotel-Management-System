import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Department(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel l1=new JLabel("Department");
        l1.setBounds(100,10,100,20);
        add(l1);

        JLabel l2=new JLabel("Budget");
        l2.setBounds(370,10,100,20);
        add(l2);

        table=new JTable();
        table.setBounds(0,50,700,350);
        add(table);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from dept");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(280,400,120,30);
        back.addActionListener(this);
        add(back);

        setBounds(400,200,700,480);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae)
{
    if (ae.getSource()==back){
        setVisible(false);
        new Reception();
    }
}
    public static void main(String[] args) {
        new Department();
    }
}
