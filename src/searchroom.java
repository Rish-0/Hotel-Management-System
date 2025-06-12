import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class searchroom extends JFrame implements ActionListener {
    JTable table;
    JButton back,submit;
    JComboBox bedType;
    JCheckBox available;
    searchroom()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("Search for Room");
        text.setFont(new Font("Tahoma",Font.BOLD,23));
        text.setBounds(400,30,200,30);
        add(text);

        JLabel lblbed=new JLabel("Bed Type");
        lblbed.setBounds(50,100,100,20);
        add(lblbed);

        bedType=new JComboBox<>(new String[]{"Single Bed","Double Bed"});
        bedType.setBounds(150,100,150,25);
        bedType.setBackground(Color.WHITE);
        add(bedType);

        available=new JCheckBox("Only display Available");
        available.setBounds(650,100,200,25);
        available.setBackground(Color.WHITE);
        available.setFont(new Font("Tahoma",Font.BOLD,15));
        add(available);

        JLabel l1=new JLabel("Room number");
        l1.setBounds(55,160,100,20);;
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(270,160,100,20);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(480,160,100,20);;
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(700,160,100,20);;
        add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(870,160,100,20);;
        add(l5);

        table=new JTable();
        table.setBounds(0,200,1000,300);
        add(table);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from rooms");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setBounds(320,520,120,30);
        add(submit);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(520,520,120,30);
        add(back);

        setBounds(300,200,1000,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                String query1 = "select * from rooms where type='" + bedType.getSelectedItem() + "'";
                String query2 = "select * from rooms where availability='Available' AND type='" + bedType.getSelectedItem() + "'";
                Conn c = new Conn();
                ResultSet rs;
                if (available.isSelected()) {
                    rs = c.s.executeQuery(query2);
                } else
                {
                    rs = c.s.executeQuery(query1);
                }
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if
        (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }
        public static void main (String[]args){
            new searchroom();
        }
    }
