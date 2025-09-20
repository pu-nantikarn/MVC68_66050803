package View;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import Model.Subject;

public class RegistrationPage extends JPanel {
    private EnrollmentView parentFrame; // เก็บอ้างอิงถึง EnrollmentView
    private JList<Subject> subjectList; // Component สำหรับแสดงรายการวิชา
    private DefaultListModel<Subject> listModel = new DefaultListModel<>();
    private JButton viewDetailsButton = new JButton("ดูรายละเอียด"); // ปุ่มสำหรับดูรายละเอียดวิชา
    private JButton backButton = new JButton("กลับ");  // ปุ่มสำหรับกลับไปหน้าก่อนหน้า

    // Constructor
    public RegistrationPage(EnrollmentView parentFrame) {
        this.parentFrame = parentFrame;
        setLayout(new BorderLayout());
        
        // สร้าง JList และกำหนดให้เลือกได้ครั้งละ 1 รายการ
        subjectList = new JList<>(listModel);
        subjectList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // เพิ่ม JList ใน ScrollPane เพื่อให้เลื่อนดูรายการได้
        add(new JScrollPane(subjectList), BorderLayout.CENTER);
        
        //สร้างปุ่ม
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(viewDetailsButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    //Method นำข้อมูลวิชามาแสดงใน JList
    public void displaySubjects(List<Subject> subjects) {
        listModel.clear();
        for (Subject s : subjects) {
            listModel.addElement(s);
        }
    }

    //Method ดึงวิชาที่ผู้ใช้เลือกใน JList
    public Subject getSelectedSubject() {
        return subjectList.getSelectedValue();
    }

    //Action ของปุ่มดูรายละเอียดวิชา
    public void setViewDetailsAction(java.awt.event.ActionListener listener) {
        viewDetailsButton.addActionListener(listener);
    }

    //Action ของปุ่มกลับ
    public void setBackAction(java.awt.event.ActionListener listener) {
        backButton.addActionListener(listener);
    }
}
