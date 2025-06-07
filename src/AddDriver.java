import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class AddDriver extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfname,tfage,tfcar,tfmodel,tflocation;
    JComboBox gendercombo,drivercombo;
    AddDriver(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading=new JLabel("Add Driver");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblname=new JLabel("Name");
        lblname.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblname.setBounds(60,80,120,30);
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);

        JLabel lblage=new JLabel("Age");
        lblage.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblage.setBounds(60,130,120,30);
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblgender.setBounds(60,180,120,30);
        add(lblgender);

        String genderOptions[]={"Male","Female"};
        gendercombo=new JComboBox(genderOptions);
        gendercombo.setBounds(200,180,150,30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblcar=new JLabel("Car Comapny");
        lblcar.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblcar.setBounds(60,230,120,30);
        add(lblcar);

        tfcar=new JTextField();
        tfcar.setBounds(200,230,150,30);
        add(tfcar);

        JLabel lblmodel=new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblmodel.setBounds(60,280,120,30);
        add(lblmodel);

        tfmodel=new JTextField();
        tfmodel.setBounds(200,280,150,30);
        add(tfmodel);

        JLabel lblavailable=new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailable.setBounds(60,330,120,30);
        add(lblavailable);

        String driverOptions[]={"Available","Busy"};
        drivercombo=new JComboBox(driverOptions);
        drivercombo.setBounds(200,330,150,30);
        drivercombo.setBackground(Color.WHITE);
        add(drivercombo);

        JLabel lbllocation=new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma",Font.PLAIN,18));
        lbllocation.setBounds(60,380,120,30);
        add(lbllocation);

        tflocation=new JTextField();
        tflocation.setBounds(200,380,150,30);
        add(tflocation);

        add=new JButton("Add Driver");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,430,130,30);
        add.addActionListener(this);
        add(add);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(230,430,130,30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,30,500,300);
        add(image);

        setBounds(300,200,980,550);
        setVisible(true);
    }
public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add){
            String name=tfname.getText();
            String age=tfage.getText();
            String gender=(String)gendercombo.getSelectedItem();
            String car=tfcar.getText();
            String model=tfmodel.getText();
            String available=(String)drivercombo.getSelectedItem();
            String location=tflocation.getText();

            try{
                Conn c=new Conn();
                String str="insert into drivers values('"+name+"','"+age+"','"+gender+"','"+car+"','"+model+"','"+available+"','"+location+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver Added Successfully");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource()==cancel) {
            setVisible(false);
        }
    }
    public static void main(String[] args) {
        new AddDriver();
    }
}
