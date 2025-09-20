package View;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import Model.Student;
import Model.Subject;

public class EnrollmentView extends JFrame {
    private CardLayout cardLayout = new CardLayout(); //จัดการการสลับหน้าจอ (panel) ต่างๆ ใน JFrame เดียวกัน
    private JPanel mainPanel = new JPanel(cardLayout);

    //ประกาศ JPanel ของแต่ละหน้า
    private JPanel loginPage;
    private JPanel registrationPage;
    private JPanel subjectDetailsPage;
    private JPanel studentProfilePage;

    // Constructor
    public EnrollmentView() {
        setTitle("ระบบลงทะเบียนเรียนล่วงหน้า");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Initialize all pages
        loginPage = new LoginPage(this);
        registrationPage = new RegistrationPage(this);
        subjectDetailsPage = new SubjectDetailsPage(this);
        studentProfilePage = new StudentProfilePage(this);

        // นำแต่ละหน้าจอ (panel) ไปใส่ใน mainPanel และตั้งชื่อกำกับ
        mainPanel.add(loginPage, "Login");
        mainPanel.add(registrationPage, "Registration");
        mainPanel.add(subjectDetailsPage, "SubjectDetails");
        mainPanel.add(studentProfilePage, "StudentProfile");

        add(mainPanel); // เพิ่ม mainPanel เข้าไปใน JFrame
        cardLayout.show(mainPanel, "Login");  // แสดงหน้าจอ "Login" เป็นหน้าจอแรก
        setVisible(true); // ทำให้หน้าต่างแสดงผล
    }

    //Method สั่งให้ CardLayout สลับไปแสดงหน้าจอที่ต้องการ
    public void showPanel(String panelName) {
        cardLayout.show(mainPanel, panelName); 
    }

    // Getters for specific pages
    public LoginPage getLoginPage() { return (LoginPage) loginPage; }
    public RegistrationPage getRegistrationPage() { return (RegistrationPage) registrationPage; }
    public SubjectDetailsPage getSubjectDetailsPage() { return (SubjectDetailsPage) subjectDetailsPage; }
    public StudentProfilePage getStudentProfilePage() { return (StudentProfilePage) studentProfilePage; }
}
