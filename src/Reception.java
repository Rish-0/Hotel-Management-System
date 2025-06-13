import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JFrame implements ActionListener{
    JButton newCustomer,rooms,dept,allEmployees,customers,manager,checkout,update,updateroom,pickup,searchroom,logout;
    Reception(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        newCustomer=new JButton("New Customer Form");
        newCustomer.setBounds(10,30,200,30);
        newCustomer.setBackground(Color.BLACK);
        newCustomer.setForeground(Color.WHITE);
        newCustomer.addActionListener(this);
        add(newCustomer);

        rooms=new JButton("Room");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);

        dept=new JButton("Department");
        dept.setBounds(10,110,200,30);
        dept.setBackground(Color.BLACK);
        dept.setForeground(Color.WHITE);
        dept.addActionListener(this);
        add(dept);

        allEmployees=new JButton("All Employees");
        allEmployees.setBounds(10,150,200,30);
        allEmployees.setBackground(Color.BLACK);
        allEmployees.setForeground(Color.WHITE);
        allEmployees.addActionListener(this);
        add(allEmployees);

        customers=new JButton("Customer Info");
        customers.setBounds(10,190,200,30);
        customers.setBackground(Color.BLACK);
        customers.setForeground(Color.WHITE);
        customers.addActionListener(this);
        add(customers);

        manager=new JButton("Manager Info");
        manager.setBounds(10,230,200,30);
        manager.setBackground(Color.BLACK);
        manager.setForeground(Color.WHITE);
        manager.addActionListener(this);
        add(manager);

        checkout=new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        update=new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        updateroom=new JButton("Update Room Status");
        updateroom.setBounds(10,350,200,30);
        updateroom.setBackground(Color.BLACK);
        updateroom.setForeground(Color.WHITE);
        updateroom.addActionListener(this);
        add(updateroom);

        pickup=new JButton("Pickup Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(Color.BLACK);
        pickup.setForeground(Color.WHITE);
        pickup.addActionListener(this);
        add(pickup);

        searchroom=new JButton("Search Room");
        searchroom.setBounds(10,430,200,30);
        searchroom.setBackground(Color.BLACK);
        searchroom.setForeground(Color.WHITE);
        searchroom.addActionListener(this);
        add(searchroom);

        logout=new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.BLACK);
        logout.setForeground(Color.RED);
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(250,30,500,470);
        add(image);

        setBounds(350,200,800,580);;
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==newCustomer){
            setVisible(false);
            new AddCustomer();
        } else if (ae.getSource()==logout) {
            setVisible(false);
        } else if (ae.getSource()==rooms) {
            setVisible(false);
            new Rooms();
        } else if (ae.getSource()==dept) {
            setVisible(false);
            new Department();
        } else if (ae.getSource()==allEmployees) {
            setVisible(false);
            new EmployeeInfo();
        } else if (ae.getSource()==customers) {
            setVisible(false);
            new CustomerInfo();
        } else if (ae.getSource()==manager) {
            setVisible(false);
            new ManagerInfo();
        } else if (ae.getSource()==checkout) {
            setVisible(false);
            new Checkout();
        } else if (ae.getSource()==updateroom) {
            setVisible(false);
            new UpdateRoom();
        } else if (ae.getSource()==update) {
            setVisible(false);
            new UpdateCheck();
        } else if (ae.getSource()==pickup) {
            setVisible(false);
            new Pickup();
        } else if (ae.getSource()==searchroom) {
            setVisible(false);
            new searchroom();
        }

    }

    public static void main(String[] args) {
        new Reception();
    }
}
