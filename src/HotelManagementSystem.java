import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem() {
//        setSize(1366,565);
//        setLocation(100,100);
        setBounds(100,100,1366,565);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,1366,565);  //location_x,location_y,length,breadth
        add(image);

        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.YELLOW);
        text.setFont(new Font("serif",Font.PLAIN,50));
        image.add(text);

        JButton next=new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.YELLOW);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,18));
        image.add(next);

        setVisible(true);
        while(true){
            text.setVisible(false);
            try{
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }
            text.setVisible(true);
            try{
                Thread.sleep(400);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void actionPerformed(ActionEvent ac) {
        setVisible(false);
        new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
        }
    }
