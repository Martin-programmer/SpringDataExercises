package jpaintro;

import jpaintro.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaIntroMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-jpa");

        EntityManager entityManager = emf.createEntityManager();

        Student student = new Student("Martin Pankov");
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        Student foundedStudent = entityManager.find(Student.class, 1L);
        System.out.println(foundedStudent.getName());
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        entityManager.createQuery("SELECT s FROM Student s WHERE s.name LIKE ?1")
                        .setParameter(1,"M%")
                                .getResultList().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManager.getTransaction().begin();
        entityManager.remove(foundedStudent);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager.getTransaction().begin();
        entityManager.createQuery("SELECT s FROM Student s WHERE s.name LIKE ?1")
                .setParameter(1,"M%")
                .getResultList().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
