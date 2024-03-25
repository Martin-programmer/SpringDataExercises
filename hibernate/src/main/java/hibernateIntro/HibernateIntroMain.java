package hibernateIntro;

import hibernateIntro.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateIntroMain {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Student student = new Student("Martin Pankov");
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();

        session.beginTransaction();
        Student currentStudent = session.get(Student.class,1L);
        System.out.println(currentStudent.getRegistrationDate());
        session.getTransaction().commit();


        session.beginTransaction();
        session.createQuery("FROM Student ",Student.class).stream()
                .forEach(s -> System.out.println(s.getName()));
        session.getTransaction().commit();
        session.close();
    }
}
