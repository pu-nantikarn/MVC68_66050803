import Controller.EnrollmentController;
import Model.EnrollmentModel;
import View.EnrollmentView;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import java.awt.Font;
import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {
        Font thaiFont = new Font("Tahoma", Font.PLAIN, 14);

        // วนลูปเพื่อนำ Font ไปใช้กับ UI Components ทั้งหมดในโปรแกรม
        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, new FontUIResource(thaiFont));
            }
        }
        EnrollmentModel model = new EnrollmentModel();//จัดการข้อมูลและ logic
        EnrollmentView view = new EnrollmentView();//จัดการหน้าจอแสดงผลและรับ Input
        new EnrollmentController(model, view);//เชื่อม Model และ View เพื่อจัดการ Flow การทำงานของโปรแกรม
    }
}