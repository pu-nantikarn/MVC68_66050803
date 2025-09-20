package Model;

import java.util.*;

public class DatabaseManager {
    // fields สำหรับฐานข้อมูลจำลองในหน่วยความจำ
    private static final Map<String, Student> students = new HashMap<>();
    private static final Map<String, Subject> subjects = new HashMap<>();
    private static final Map<String, List<String>> studentEnrollments = new HashMap<>();
    private static final Map<String, Map<String, String>> studentGrades = new HashMap<>();

    public static void initializeData() {
        // กำหนดวันเกิดของนักเรียน
        Calendar cal0 = Calendar.getInstance();
        cal0.add(Calendar.YEAR, -14);// อายุ 14
        Date dob0 = cal0.getTime();

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.YEAR, -17);// อายุ 17
        Date dob1 = cal1.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.add(Calendar.YEAR, -18);// อายุ 18
        Date dob2 = cal2.getTime();

        Calendar cal3 = Calendar.getInstance();
        cal3.add(Calendar.YEAR, -19);// อายุ 19
        Date dob3 = cal3.getTime();

        // Sample 15 Students
        students.put("69000001",
                new Student("69000001", "นาย", "สมชาย", "ใจดี", dob1, "โรงเรียน ก", "somchai@mail.com"));
        students.put("69000002",
                new Student("69000002", "นางสาว", "สมศรี", "รักเรียน", dob2, "โรงเรียน ข", "somsri@mail.com"));
        students.put("69000003",
                new Student("69000003", "นาย", "วิชัย", "เก่งงาน", dob2, "โรงเรียน ค", "wichai@mail.com"));
        students.put("69000004",
                new Student("69000004", "นางสาว", "กาญจนา", "ขยันดี", dob0, "โรงเรียน ง", "kanjana@mail.com"));
        students.put("69000005",
                new Student("69000005", "นาย", "สมปอง", "สุขใจ", dob1, "โรงเรียน ก", "sompong@mail.com"));
        students.put("69000006",
                new Student("69000006", "นางสาว", "สุดารัตน์", "สดใส", dob3, "โรงเรียน ข", "sudarat@mail.com"));
        students.put("69000007",
                new Student("69000007", "นาย", "อนุชา", "เพียรดี", dob2, "โรงเรียน ค", "anucha@mail.com"));
        students.put("69000008",
                new Student("69000008", "นางสาว", "ปิยนุช", "ตั้งใจ", dob2, "โรงเรียน ง", "piyanuch@mail.com"));
        students.put("69000009",
                new Student("69000009", "นาย", "ศักดิ์ดา", "มั่นคง", dob1, "โรงเรียน ก", "sakda@mail.com"));
        students.put("69000010",
                new Student("69000010", "นางสาว", "อัมพร", "อบอุ่น", dob1, "โรงเรียน ข", "umphon@mail.com"));
        students.put("69000011",
                new Student("69000011", "นาย", "พงษ์เทพ", "จริงใจ", dob2, "โรงเรียน ค", "pongthep@mail.com"));
        students.put("69000012",
                new Student("69000012", "นางสาว", "อรอนงค์", "สดชื่น", dob2, "โรงเรียน ง", "oronong@mail.com"));
        students.put("69000013",
                new Student("69000013", "นาย", "จิรศักดิ์", "เข้มแข็ง", dob2, "โรงเรียน ก", "jirasak@mail.com"));
        students.put("69000014",
                new Student("69000014", "นางสาว", "วราพร", "อ่อนโยน", dob2, "โรงเรียน ข", "waraporn@mail.com"));
        students.put("69000015",
                new Student("69000015", "นาย", "เกรียงไกร", "กล้าหาญ", dob3, "โรงเรียน ค", "kriangkrai@mail.com"));

        // Sample 15 Subjects
        subjects.put("05501001", new Subject("05501001", "ภาษาอังกฤษ 1", 3, "อ.มานะ", null, 50, 45));
        subjects.put("05501002", new Subject("05501002", "คณิตศาสตร์เบื้องต้น", 3, "อ.นารี", null, 50, 42));
        subjects.put("90691001", new Subject("90691001", "ความรู้ทั่วไป", 2, "อ.วิทย์", null, -1, 100));//รับจำนวนไม่จำกัด
        subjects.put("05502001", new Subject("05502001", "ฟิสิกส์ 2", 3, "อ.สมชาย", "05501001", 30, 20));
        subjects.put("05501003", new Subject("05501003", "ภาษาอังกฤษ 2", 3, "อ.กมล", "05501001", 50, 35));
        subjects.put("05501004", new Subject("05501004", "คณิตศาสตร์ขั้นกลาง", 3, "อ.สุพจน์", "05501002", 40, 25));//ติดเงื่อนไข
        subjects.put("90691002", new Subject("90691002", "ทักษะชีวิต", 2, "อ.สุรีย์", null, -1, 80));
        subjects.put("05502002", new Subject("05502002", "เคมี 1", 3, "อ.บุญช่วย", null, 45, 40));
        subjects.put("05502003", new Subject("05502003", "ชีววิทยา 1", 3, "อ.สมใจ", null, 40, 40));
        subjects.put("90691003", new Subject("90691003", "มนุษย์กับสิ่งแวดล้อม", 2, "อ.ธนพร", null, 60, 60));//วิชาเต็ม
        subjects.put("05503001", new Subject("05503001", "โครงสร้างข้อมูล", 3, "อ.วิทยา", "05501002", 35, 28));
        subjects.put("05503002", new Subject("05503002", "การเขียนโปรแกรมเชิงวัตถุ", 3, "อ.ดวงพร", "05501002", 40, 32));
        subjects.put("90691004", new Subject("90691004", "สุขภาพและการออกกำลังกาย", 2, "อ.ณรงค์", null, -1, 70));
        subjects.put("05504001", new Subject("05504001", "ฐานข้อมูลเบื้องต้น", 3, "อ.ประเสริฐ", "05503001", 30, 22));
        subjects.put("05504002", new Subject("05504002", "ระบบปฏิบัติการ", 3, "อ.มณี", "05503001", 30, 18));

        // สร้างข้อมูลตัวอย่างสำหรับนักศึกษาทั้ง 15 คน โดยแต่ละคนมี 5
        // วิชาและเกรดของแต่ละวิชา
        String[] subjectIds = subjects.keySet().toArray(new String[0]);
        String[] grades = { "A", "B+", "B", "C+", "C", "D+", "D" };
        Random rand = new Random();

        
        // loop เพื่อกำหนดข้อมูลให้แต่ละนักเรียน
        for (int i = 1; i <= 15; i++) {
            String studentId = String.format("690000%02d", i);
            List<String> enrolled = new ArrayList<>();
            Map<String, String> gradesMap = new HashMap<>();

            // เพิ่มวิชาแบบสุ่ม 5 วิชา (รวมถึงวิชาบังคับก่อนด้วย)
            while (enrolled.size() < 5) {
                String randomSubjectId = subjectIds[rand.nextInt(subjectIds.length)];
                if (!enrolled.contains(randomSubjectId)) {
                    enrolled.add(randomSubjectId);
                    gradesMap.put(randomSubjectId, grades[rand.nextInt(grades.length)]);
                }
            }
            studentEnrollments.put(studentId, enrolled);
            studentGrades.put(studentId, gradesMap);
        }
    }

    // ข้อมูลนักเรียนจาก feild
    public static Student getStudent(String studentId) {
        return students.get(studentId);
    }

    // ดึงรายวิชาที่นักเรียนยังไม่เคยเรียน
    public static List<Subject> getAvailableSubjects(String studentId) {
        List<String> registeredSubjectIds = studentEnrollments.getOrDefault(studentId, new ArrayList<>());
        List<Subject> availableSubjects = new ArrayList<>();
        for (Subject subject : subjects.values()) {
            if (!registeredSubjectIds.contains(subject.getSubjectId())) {
                availableSubjects.add(subject);
            }
        }
        return availableSubjects;
    }

    // ดึงข้อมูลรายวิชาจากรหัสวิชา
    public static Subject getSubject(String subjectId) {
        return subjects.get(subjectId);
    }

    // ลงทะเบียนวิชาให้นักเรียน
    public static void enrollStudent(String studentId, String subjectId) {
        Subject subject = subjects.get(subjectId);
        if (subject != null) {
            subject.setCurrentEnrollment(subject.getCurrentEnrollment() + 1);
            studentEnrollments.computeIfAbsent(studentId, k -> new ArrayList<>()).add(subjectId);
            studentGrades.computeIfAbsent(studentId, k -> new HashMap<>()).put(subjectId, "P"); // P for "Pass"
        }
    }

    // ตรวจสอบว่านักเรียนเคยลงทะเบียนวิชาที่กำหนดไว้หรือไม่ (สำหรับวิชาบังคับก่อน)
    public static boolean hasTakenSubject(String studentId, String subjectId) {
        Map<String, String> studentGradeMap = studentGrades.getOrDefault(studentId, new HashMap<>());
        return studentGradeMap.containsKey(subjectId);
    }

    // ดึงข้อมูลเกรดของนักเรียน
    public static Map<String, String> getStudentGrades(String studentId) {
        return studentGrades.getOrDefault(studentId, new HashMap<>());
    }

    // ดึงข้อมูลรายวิชาทั้งหมด
    public static Map<String, Subject> getAllSubjects() {
        return subjects;
    }
}