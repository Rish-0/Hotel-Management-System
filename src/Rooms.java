import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
import java.awt.event.*;

public class Rooms extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Rooms()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);

        JLabel l1=new JLabel("Room number");
        l1.setBounds(6,10,100,20);;
        add(l1);

        JLabel l2=new JLabel("Availability");
        l2.setBounds(110,10,100,20);
        add(l2);

        JLabel l3=new JLabel("Status");
        l3.setBounds(230,10,100,20);;
        add(l3);

        JLabel l4=new JLabel("Price");
        l4.setBounds(340,10,100,20);;
        add(l4);

        JLabel l5=new JLabel("Bed Type");
        l5.setBounds(420,10,100,20);;
        add(l5);

        table=new JTable();
        table.setBounds(0,40,500,450);
        add(table);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from rooms");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(200,500,120,30);
        add(back);

        setBounds(300,200,1050,600);
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
        new Rooms();
    }
}
