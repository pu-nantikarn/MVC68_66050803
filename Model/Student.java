package Model;
import java.util.*;

public class Student {
    // Attributes ข้อมูลของนักเรียน
    private String studentId;
    private String prefix;//คำนำหน้า
    private String firstName;
    private String lastName;
    private Date dob;//วันเกิด
    private String currentSchool; //โรงเรียนที่เรียนอยู่
    private String email;

     // Constructor ของ Student
    public Student(String studentId, String prefix, String firstName, String lastName, Date dob, String currentSchool, String email) {
        this.studentId = studentId;
        this.prefix = prefix;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.currentSchool = currentSchool;
        this.email = email;
    }
    
    //กำหนดค่าให้ studentId
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    //ดึงค่า prefix
    public String getPrefix() {
        return prefix;
    }

    //กำหนดค่าให้ prefix
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    //ดึงค่า firstName
    public String getFirstName() {
        return firstName;
    }

    //กำหนดค่าให้ firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //ดึงค่า lastName
    public String getLastName() {
        return lastName;
    }

    //กำหนดค่าให้ lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //กำหนดค่าให้ dob
    public void setDob(Date dob) {
        this.dob = dob;
    }

    //ดึงค่า currentSchool
    public String getCurrentSchool() {
        return currentSchool;
    }

    //กำหนดค่าให้ currentSchool
    public void setCurrentSchool(String currentSchool) {
        this.currentSchool = currentSchool;
    }

    //ดึงค่า email
    public String getEmail() {
        return email;
    }

    //กำหนดค่าให้ email
    public void setEmail(String email) {
        this.email = email;
    }

    //ดึงค่า studentId
    public String getStudentId() { return studentId; }
    
    //ดึงค่า dob
    public Date getDob() { return dob; }
}
