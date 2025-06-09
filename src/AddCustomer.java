import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class AddCustomer extends JFrame implements ActionListener{
    JComboBox comboid;
    JTextField tfnumber,tfname,tfcountry,tfdeposit;
    Choice croom;
    JRadioButton rbmale,rbfemale;
    JLabel time;
    JButton add,back;
    AddCustomer(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text=new JLabel("NEW CUSTOMER FORM");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Raleway", Font.PLAIN,20));
        add(text);

        JLabel lblid=new JLabel("IDENTITY");
        lblid.setBounds(35,80,100,20);
        lblid.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblid);

        String options[]={"Aadhar Card","Passport","Driving License","Voter-ID Card","Ration Card"};
        comboid=new JComboBox<>(options);
        comboid.setBackground(Color.WHITE);
        comboid.setBounds(200,80,150,25);
        add(comboid);

        JLabel lblnumber=new JLabel("NUMBER");
        lblnumber.setBounds(35,120,100,20);
        lblnumber.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblnumber);

        tfnumber=new JTextField();
        tfnumber.setBounds(200,120,150,25);
        add(tfnumber);

        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(35,160,100,20);
        lblname.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);

        rbmale=new JRadioButton("Male");
        rbmale.setBackground(Color.WHITE);
        rbmale.setBounds(200,200,60,25);
        add(rbmale);

        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(270,200,100,25);
        rbfemale.setBackground(Color.WHITE);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(35,200,100,20);
        lblgender.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblgender);

        JLabel lblcountry=new JLabel("COUNTRY");
        lblcountry.setBounds(35,240,100,20);
        lblcountry.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblcountry);

        tfcountry=new JTextField();
        tfcountry.setBounds(200,240,150,25);
        add(tfcountry);

        JLabel lblroom=new JLabel("ROOM NO.");
        lblroom.setBounds(35,280,150,20);
        lblroom.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lblroom);

        croom=new Choice();
        croom.setBounds(200,280,150,25);

        try {
            Conn c=new Conn();
            String query="select * from rooms";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next()){
                croom.add(rs.getString("roomnumber"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add(croom);

        Date date=new Date();
        JLabel lbltime=new JLabel("CHECK-IN");
        lbltime.setBounds(35,320,150,20);
        lbltime.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lbltime);

        time=new JLabel(""+date);
        time.setBounds(200,320,150,25);
        time.setFont(new Font("Raleway",Font.PLAIN,17));
        add(time);

        JLabel lbldeposit=new JLabel("DEPOSIT");
        lbldeposit.setBounds(35,360,150,20);
        lbldeposit.setFont(new Font("Raleway", Font.PLAIN,20));
        add(lbldeposit);

        tfdeposit=new JTextField();
        tfdeposit.setBounds(200,360,150,25);
        add(tfdeposit);

        add=new JButton("ADD");
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setBounds(50,410,120,25);
        add.addActionListener(this);
        add(add);

        back=new JButton("BACK");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(220,410,120,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);

        setBounds(350,200,800,550);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String id=(String)comboid.getSelectedItem();
            String name=tfname.getText();
            String number=tfnumber.getText();
            String gender=null;

            if(rbmale.isSelected()){
                gender="Male";
            } else{
                gender="Female";
            }

            String country=tfcountry.getText();
            String room= croom.getSelectedItem();
            String samay=time.getText();
            String deposit=tfdeposit.getText();
            try {
                Conn c=new Conn();
                String query="insert into customer values('"+id+"','"+name+"','"+number+"','"+gender+"','"+country+"','"+room+"','"+samay+"','"+deposit+")'";
                String query2="update rooms set availability='Occupied' where roomnumber='"+room+"'";
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null,"New Customer Added Successfully");

                setVisible(false);
                new Reception();
            }catch (Exception e){
                e.printStackTrace();
            }
        } else if (ae.getSource()==back) {
            setVisible(false);
            new Reception();
        }
    }
    public static void main(String[] args) {
        new AddCustomer();
    }
}
