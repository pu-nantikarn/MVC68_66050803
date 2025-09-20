package Model;
import java.io.Serializable;

public class Subject implements Serializable {
    // Attributes สำหรับเก็บข้อมูลของรายวิชา
    private String subjectId;
    private String subjectName;
    private int credits;
    private String instructor;
    private String prerequisiteId;
    private int maxCapacity;
    private int currentEnrollment;

  // Constructors ของ Subject
    public Subject(String subjectId, String subjectName, int credits, String instructor, String prerequisiteId, int maxCapacity, int currentEnrollment) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.credits = credits;
        this.instructor = instructor;
        this.prerequisiteId = prerequisiteId;
        this.maxCapacity = maxCapacity;
        this.currentEnrollment = currentEnrollment;
    }
    
    // Getter และ Setter Methods สำหรับเข้าถึงและแก้ไขข้อมูลแต่ละ Attribute
    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setPrerequisiteId(String prerequisiteId) {
        this.prerequisiteId = prerequisiteId;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public String getPrerequisiteId() {
        return prerequisiteId;
    }

    public void setCurrentEnrollment(int currentEnrollment) {
        this.currentEnrollment = currentEnrollment;
    }

    @Override
    public String toString() {
        return "รหัสวิชา: " + subjectId + " - " + subjectName;
    }
}
