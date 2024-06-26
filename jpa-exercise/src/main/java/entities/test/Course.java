//package entities.test;
//
//
//import entities.BaseEntity;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity
//@Table(name = "courses")
//public class Course extends BaseEntity {
//    private String name;
//
//    private Set<Student> students;
//
//    private Teacher teacher;
//
//    @ManyToOne
//    @JoinColumn(name = "teacher_id",referencedColumnName = "id")
//    public Teacher getTeacher() {
//        return teacher;
//    }
//
//    public void setTeacher(Teacher teacher) {
//        this.teacher = teacher;
//    }
//
//    public Course() {
//    }
//
//    @Column(name = "name", unique = true, nullable = false)
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    @ManyToMany
//    @JoinTable(name = "courses_students",
//    joinColumns = @JoinColumn(name = "course_id",referencedColumnName = "id"),
//    inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"))
//    public Set<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(Set<Student> students) {
//        this.students = students;
//    }
//}
