import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {
    JTextField tfname,tfage,tfphone,tfemail,tfsalary,tfaadhar;
    JRadioButton rbmale,rbfemale;
    JButton submit;
    JComboBox cbjob;
    AddEmployee()
    {
         setLayout(null);

         JLabel lblname=new JLabel("NAME");
         lblname.setBounds(60,30,120,30);
         lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lblname);

         tfname=new JTextField();
         tfname.setBounds(200,30,150,30);
         add(tfname);

         JLabel lblage=new JLabel("AGE");
         lblage.setBounds(60,80,120,30);
         lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lblage);

         tfage=new JTextField();
         tfage.setBounds(200,80,150,30);
         add(tfage);

         JLabel lblgender=new JLabel("GENDER");
         lblgender.setBounds(60,130,120,30);
         lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lblgender);

         rbmale=new JRadioButton("Male");
         rbmale.setBounds(200,130,70,30);
         rbmale.setFont(new Font("Tahoma",Font.PLAIN,14));
         rbmale.setBackground(Color.WHITE);
         add(rbmale);

         rbfemale=new JRadioButton("Female");
         rbfemale.setBounds(280,130,70,30);
         rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
         rbfemale.setBackground(Color.WHITE);
         add(rbfemale);

         ButtonGroup bg=new ButtonGroup();
         bg.add(rbmale);
         bg.add(rbfemale);

         JLabel lbljob=new JLabel("JOB");
         lbljob.setBounds(60,180,120,30);
         lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
         add(lbljob);

         String str[]={"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Chefs","Waiter/Waitress","Manager","Accountant"};
         cbjob=new JComboBox(str);
         cbjob.setBounds(200,180,150,30);
         cbjob.setBackground(Color.WHITE);
         add(cbjob);

        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblsalary);

        tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lblphone=new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblphone);

        tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        JLabel lblaadhar=new JLabel("AADHAR NO.");
        lblaadhar.setBounds(60,380,120,30);
        lblaadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(lblaadhar);

        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2=i1.getImage().getScaledInstance(450,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,60,450,370);
        add(image);

         getContentPane().setBackground(Color.WHITE);
         setBounds(350,200,850,550);
         setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        String name=tfname.getText();
        String age=tfage.getText();
        String salary=tfsalary.getText();
        String phone=tfphone.getText();
        String email=tfemail.getText();
        String aadhar=tfaadhar.getText();

        String gender=null;

        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Name cannot be empty");
            return;
        }
        if(age.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Age cannot be empty");
            return;
        }
        if(salary.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Salary cannot be empty");
            return;
        }
        if(phone.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Phone cannot be empty");
            return;
        }
        if(aadhar.equals(""))
        {
            JOptionPane.showMessageDialog(null,"Aadhar No. cannot be empty");
            return;
        }

        if(rbmale.isSelected())
        {
            gender="Male";
        } else if (rbfemale.isSelected()) {
            gender="Female";
        }
        String job=(String)cbjob.getSelectedItem();
        try{
            Conn conn=new Conn();
            String query="insert into employee values('"+name+"','"+age+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"','"+gender+"')";
            conn.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Employee added successfully");
            setVisible(false);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new AddEmployee();
    }
}
