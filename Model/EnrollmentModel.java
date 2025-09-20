package Model;

import java.time.*;
import java.util.*;

public class EnrollmentModel {
    //Constant สำหรับสถานะผลลัพธ์ของการลงทะเบียน
    public static final int ENROLLMENT_SUCCESS = 0; //ลงทะเบียนสำเร็จ
    public static final int ERROR_AGE = 1; //ลงทะเบียนไม่สำเร็จ เมื่ออายุน้อยกว่า 15 
    public static final int ERROR_FULL = 2; //ลงทะเบียนไม่สำเร็จ เมื่อจำนวนคนลงเต็มแล้ว
    public static final int ERROR_PREREQUISITE = 3; //ลงทะเบียนไม่สำเร็จ เมื่อไม่ได้ลงทะเบียนในวิชาบังคับก่อน
    public static final int ERROR_UNKNOWN = 4; // ลงทะเบียนไม่สำเร็จ

    // Constructor: ของ EnrollmentModel 
    public EnrollmentModel() {
        DatabaseManager.initializeData(); //เตรียมข้อมูลเริ่มต้น จาก DatabaseManager
    }

    //ดึงข้อมูลนักเรียนจาก DatabaseManager
    public Student getStudent(String studentId) {
        return DatabaseManager.getStudent(studentId);
    }

    //ดึงข้อมูลวิชาจาก DatabaseManager
    public Subject getSubject(String subjectId) {
        return DatabaseManager.getSubject(subjectId);
    }

    //ดึงรายวิชาที่นักเรียนยังไม่ได้ลงทะเบียนจาก DatabaseManager
    public List<Subject> getAvailableSubjects(String studentId) {
        return DatabaseManager.getAvailableSubjects(studentId);
    }

    //ดึงเกรดของนักเรียนจาก DatabaseManager
    public Map<String, String> getStudentGrades(String studentId) {
        return DatabaseManager.getStudentGrades(studentId);
    }

    //ดึงข้อมูลรายวิชาทั้งหมดจาก DatabaseManager
    public Map<String, Subject> getAllSubjects() {
        return DatabaseManager.getAllSubjects();
    }

    // Method หลักสำหรับลงทะเบียนนักเรียนเข้าเรียนในวิชา
    public int enrollStudent(String studentId, String subjectId) {
        Student student = getStudent(studentId);
        Subject subject = getSubject(subjectId);
        if (student == null || subject == null) {
            System.err.println("ไม่พบข้อมูลนักเรียนหรือวิชา");
            return ERROR_UNKNOWN;
        }

        // Check age (>= 15 years old)
        LocalDate birthDate = student.getDob().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        if (age < 15) {
            System.err.println("นักเรียนต้องมีอายุอย่างน้อย 15 ปี");
            return ERROR_AGE;
        }

        // Check enrollment capacity
        if (subject.getMaxCapacity() != -1 && subject.getCurrentEnrollment() >= subject.getMaxCapacity()) {
            System.err.println("รายวิชานี้เต็มแล้ว");
            return ERROR_FULL;
        }

        // Check prerequisite
        if (subject.getPrerequisiteId() != null) {
            if (!DatabaseManager.hasTakenSubject(studentId, subject.getPrerequisiteId())) {
                System.err.println("นักเรียนยังไม่ได้ลงทะเบียนในวิชาบังคับก่อน");
                return ERROR_PREREQUISITE;
            }
        }
        //ทำการลงทะเบียน
        DatabaseManager.enrollStudent(studentId, subjectId);
        return ENROLLMENT_SUCCESS;
    }
}
