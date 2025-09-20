package View;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JPanel {
    private EnrollmentView parentFrame; // เก็บอ้างอิงถึง EnrollmentView เพื่อให้เข้าถึงเมทอดต่างๆ ได้
    private JTextField studentIdField = new JTextField(10); // ช่องสำหรับกรอกรหัสนักเรียน
    private JButton loginButton = new JButton("เข้าสู่ระบบ"); // ปุ่มเข้าสู่ระบบ

    // Constructor 
    public LoginPage(EnrollmentView parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new FlowLayout());
        add(new JLabel("รหัสนักเรียน:"));
        add(studentIdField);
        add(loginButton);

        loginButton.addActionListener(e -> {
            // Logic to call controller
        });
    }

    //ดึงค่ารหัสนักเรียนที่ผู้ใช้กรอก
    public String getStudentId() {
        return studentIdField.getText();
    }

    //ปุ่ม Login ทำงาน
    public void setLoginAction(java.awt.event.ActionListener listener) {
        loginButton.addActionListener(listener);
    }
}
