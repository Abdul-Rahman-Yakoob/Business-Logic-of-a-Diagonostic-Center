import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1;
    public Login(){
        this.setTitle("Login Page");
        this.setBounds(300,300,500,500);
        this.setLayout(null);

        l1=new JLabel("Patient Id:");
        l1.setBounds(20,40,100,20);
        this.add(l1);

        t1=new JTextField();
        t1.setBounds(140,40,100,20);
        this.add(t1);

        l2=new JLabel("Phone No:");
        l2.setBounds(20,70,100,20);
        this.add(l2);

        t2=new JTextField();
        t2.setBounds(140,70,150,20);
        this.add(t2);

        b1=new JButton("Login");
        b1.setBounds(120,120,100,50);
        b1.addActionListener(this);
        this.add(b1);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id=Integer.parseInt(t1.getText());
        String phone=t2.getText();
        Database db=new Database();
        JFrame f=new JFrame();
        f.setBounds(500,500,200,100);
        if(db.patientExists(id,phone)){
            this.hide();
            new HomePage(id,phone);
        }
        else{
            f.setTitle("User Not Found");
            f.setVisible(true);
        }
    }
}

