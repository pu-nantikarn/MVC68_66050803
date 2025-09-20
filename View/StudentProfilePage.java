package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;
import Model.Student;
import Model.Subject;

public class StudentProfilePage extends JPanel {
    private EnrollmentView parentFrame; // เก็บอ้างอิงถึง EnrollmentView
    private JLabel studentIdLabel = new JLabel(); // Label สำหรับแสดงรหัสนักเรียน
    private JLabel studentNameLabel = new JLabel(); // Label สำหรับแสดงชื่อ-สกุล
    private JLabel studentInfoLabel = new JLabel(); // Label สำหรับแสดงข้อมูลอื่นๆ
    private JButton backToRegistrationButton = new JButton("ลงทะเบียนเรียน"); // ปุ่มสำหรับไปหน้าลงทะเบียน
    private JButton logoutButton = new JButton("ออกจากระบบ"); //ปุ่มออกจากระบบ
    private JTable enrolledSubjectsTable; // Table สำหรับแสดงวิชาที่ลงทะเบียนแล้ว
    private DefaultTableModel tableModel;

    // Constructor
    public StudentProfilePage(EnrollmentView parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        add(new JLabel("ประวัตินักเรียน"));
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(studentIdLabel);
        add(studentNameLabel);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(studentInfoLabel);
        add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Table for enrolled subjects
        tableModel = new DefaultTableModel(new Object[]{"รหัสวิชา", "ชื่อวิชา", "หน่วยกิต", "เกรด"}, 0);
        enrolledSubjectsTable = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(enrolledSubjectsTable);
        add(tableScrollPane);
        
        add(Box.createRigidArea(new Dimension(0, 20)));
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(backToRegistrationButton);
        buttonPanel.add(logoutButton); 
        add(buttonPanel);
    }

    //Method นำข้อมูลนักเรียนมาแสดงผลใน Label
    public void displayStudentInfo(Student student) {
        studentIdLabel.setText("รหัสนักเรียน: " + student.getStudentId());
        studentNameLabel.setText("ชื่อ-สกุล: " + student.getPrefix() + " " + student.getFirstName() + " " + student.getLastName());
        studentInfoLabel.setText("<html><body><b>วันเกิด:</b> " + student.getDob() + "<br><b>โรงเรียน:</b> " + student.getCurrentSchool() + "<br><b>อีเมล:</b> " + student.getEmail() + "</body></html>");
    }
    
    //Method นำข้อมูลวิชาและเกรดมาแสดงใน Table
    public void displayEnrolledSubjects(Map<String, String> grades, Map<String, Subject> allSubjects) {
        tableModel.setRowCount(0); // Clear existing data
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            String subjectId = entry.getKey();
            String grade = entry.getValue();
            Subject subject = allSubjects.get(subjectId);
            if (subject != null) {
                tableModel.addRow(new Object[]{
                    subject.getSubjectId(),
                    subject.getSubjectName(),
                    subject.getCredits(),
                    grade
                });
            }
        }
    }

    //Action ของปุ่มลงทะเบียน
    public void setBackToRegistrationAction(java.awt.event.ActionListener listener) {
        backToRegistrationButton.addActionListener(listener);
    }

    //Action ของปุ่มออกจากระบบ
    public void setLogoutAction(java.awt.event.ActionListener listener) {
        logoutButton.addActionListener(listener);
    }
}