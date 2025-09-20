package Controller;

import Model.EnrollmentModel;
import Model.Student;
import Model.Subject;
import View.EnrollmentView;
import javax.swing.JOptionPane;

public class EnrollmentController {
    // Model และ View จะถูกประกาศเป็น Attribute เพื่อให้ Controller เข้าถึงได้
    private EnrollmentModel model;
    private EnrollmentView view;
    private Student currentStudent;
    private Subject selectedSubject;

    // Constructor รับ Model และ View เข้ามาเพื่อเชื่อมต่อเข้าด้วยกัน
    public EnrollmentController(EnrollmentModel model, EnrollmentView view) {
        this.model = model;
        this.view = view;
        initListeners();
    }

    // Methodสำหรับตั้งค่า Event Listener ให้กับปุ่มต่างๆ ในหน้าจอ View
    // เมื่อมีการกระทำใดๆ Listener จะเรียกเมทอด handle ที่เกี่ยวข้อง
    private void initListeners() {
        view.getLoginPage().setLoginAction(e -> handleLogin());
        view.getRegistrationPage().setViewDetailsAction(e -> handleViewDetails());
        view.getRegistrationPage().setBackAction(e -> handleBackFromRegistration());
        view.getSubjectDetailsPage().setEnrollAction(e -> handleEnrollment());
        view.getSubjectDetailsPage().setBackAction(e -> handleBackFromDetails());
        view.getStudentProfilePage().setBackToRegistrationAction(e -> handleBackFromProfile());
        view.getStudentProfilePage().setLogoutAction(e -> handleLogout());
    }

    //Method จัดการการเข้าสู่ระบบ
    private void handleLogin() {
        String studentId = view.getLoginPage().getStudentId();
        Student student = model.getStudent(studentId);
        if (student != null) {
            this.currentStudent = student;
            view.getStudentProfilePage().displayStudentInfo(currentStudent);
            view.getStudentProfilePage().displayEnrolledSubjects(model.getStudentGrades(currentStudent.getStudentId()),
                    model.getAllSubjects());
            view.showPanel("StudentProfile");
        } else {
            JOptionPane.showMessageDialog(view, "ไม่พบรหัสนักเรียน");
        }
    }
    
    //Method จัดการการดูรายละเอียดวิชา
    private void handleViewDetails() {
        selectedSubject = view.getRegistrationPage().getSelectedSubject();
        if (selectedSubject != null) {
            view.getSubjectDetailsPage().displaySubject(selectedSubject);
            view.showPanel("SubjectDetails");
        } else {
            JOptionPane.showMessageDialog(view, "กรุณาเลือกรายวิชาที่ต้องการ");
        }
    }

    //Method จัดการการลงทะเบียนเรียน
    private void handleEnrollment() {
        int result = model.enrollStudent(currentStudent.getStudentId(), selectedSubject.getSubjectId());

        if (result == EnrollmentModel.ENROLLMENT_SUCCESS) {
            JOptionPane.showMessageDialog(view, "ลงทะเบียนสำเร็จ!");
            view.getStudentProfilePage().displayEnrolledSubjects(model.getStudentGrades(currentStudent.getStudentId()),
                    model.getAllSubjects());
            view.showPanel("StudentProfile");
        } else if (result == EnrollmentModel.ERROR_AGE) {
            JOptionPane.showMessageDialog(view, "นักเรียนต้องมีอายุอย่างน้อย 15 ปี");
        } else if (result == EnrollmentModel.ERROR_FULL) {
            JOptionPane.showMessageDialog(view, "รายวิชานี้เต็มแล้ว");
        } else if (result == EnrollmentModel.ERROR_PREREQUISITE) {
            JOptionPane.showMessageDialog(view, "นักเรียนยังไม่ได้ลงทะเบียนในวิชาบังคับก่อน");
        } else {
            JOptionPane.showMessageDialog(view, "ไม่สามารถลงทะเบียนได้");
        }
    }
    
    //Method จัดการการย้อนกลับจากหน้า รายละเอียดวิชา
    private void handleBackFromDetails() {
        view.getRegistrationPage().displaySubjects(model.getAvailableSubjects(currentStudent.getStudentId()));
        view.showPanel("Registration");
    }

    // Method จัดการการย้อนกลับจากหน้า ลงทะเบียน
    private void handleBackFromRegistration() {
        view.getStudentProfilePage().displayEnrolledSubjects(model.getStudentGrades(currentStudent.getStudentId()),
                model.getAllSubjects());
        view.showPanel("StudentProfile");
    }

    //Method จัดการการย้อนกลับจากหน้า ประวัติ
    private void handleBackFromProfile() {
        view.getRegistrationPage().displaySubjects(model.getAvailableSubjects(currentStudent.getStudentId()));
        view.showPanel("Registration");
    }

    //Method สำหรับจัดการการออกจากระบบ
    private void handleLogout() {
        currentStudent = null; // ล้างข้อมูลนักเรียนที่เข้าสู่ระบบ
        view.showPanel("Login");
    }
}
