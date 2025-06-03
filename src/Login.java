import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setBounds(500,200,600,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Login();
    }
}

