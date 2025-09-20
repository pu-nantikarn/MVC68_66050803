package View;

import javax.swing.*;
import java.awt.*;
import Model.Subject;

public class SubjectDetailsPage extends JPanel {
    private EnrollmentView parentFrame; // เก็บอ้างอิงถึง EnrollmentView
    private JLabel subjectIdLabel = new JLabel(); // Label สำหรับแสดงรหัสวิชา
    private JLabel subjectNameLabel = new JLabel(); // Label สำหรับแสดงชื่อวิชา
    private JLabel maxCapacityLabel = new JLabel(); // Label สำหรับแสดงจำนวนคนสูงสุดที่รับ
    private JLabel currentEnrollmentLabel = new JLabel(); // Label สำหรับแสดงจำนวนคนปัจจุบัน
    private JButton enrollButton = new JButton("ลงทะเบียน"); // ปุ่มสำหรับลงทะเบียน
    private JButton backButton = new JButton("กลับ"); // ปุ่มสำหรับกลับไปหน้าก่อนหน้า

    // Constructor
    public SubjectDetailsPage(EnrollmentView parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // เพิ่ม Component ลง Panel
        add(subjectIdLabel);
        add(subjectNameLabel);
        add(maxCapacityLabel);
        add(currentEnrollmentLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));

        //สร้างปุ่ม
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(enrollButton);
        buttonPanel.add(backButton); 
        add(buttonPanel);
    }

    //Method แสดงข้อมูลวิชา
    public void displaySubject(Subject subject) {
        subjectIdLabel.setText("รหัสวิชา: " + subject.getSubjectId());
        subjectNameLabel.setText("ชื่อวิชา: " + subject.getSubjectName());
        maxCapacityLabel.setText(
                "จำนวนคนสูงสุดที่รับ: " + (subject.getMaxCapacity() == -1 ? "ไม่จำกัด" : subject.getMaxCapacity()));
        currentEnrollmentLabel.setText("จำนวนคนปัจจุบัน: " + subject.getCurrentEnrollment());
    }

    //Action ของ ปุ่มลงทะเบียน    
    public void setEnrollAction(java.awt.event.ActionListener listener) {
        enrollButton.addActionListener(listener);
    }

    //Action ของ ปุ่มกลับ
    public void setBackAction(java.awt.event.ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
