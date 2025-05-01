package lk.ijse.manytomany;

import lk.ijse.manytomany.dao.AppDAO;
import lk.ijse.manytomany.entity.Course;
import lk.ijse.manytomany.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManyToManyApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManyToManyApplication.class, args);
    }
    @Bean
    public CommandLineRunner init(AppDAO appDAO) {
        return runner -> {
             // createCoursesAndStudents(appDAO);
             // findCourseAndStudentByCourseId(appDAO);
             //findCourseAndStudentByStudentId(appDAO);
            //addMorecoursesToStudent(appDAO);
            //deleteCourse(appDAO);
            deleteStudent(appDAO);
        };
    }

    private void deleteStudent(AppDAO appDAO) {
        int studentId = 5;
        appDAO.deleteStudentByStudentId(studentId);
    }

    private void deleteCourse(AppDAO appDAO) {
        int id=10;
        appDAO.deleteCourseById(id);
    }


    private void addMorecoursesToStudent(AppDAO appDAO) {
        int stu_id=2;
        Student temp_stu = appDAO.findStudentAndCourseByStudentId(stu_id);
        Course course1 = new Course("rubik cube-how to speed cube");
        Course course2 = new Course("game development");
        temp_stu.addCourse(course1);
        temp_stu.addCourse(course2);
        appDAO.updateStudent(temp_stu);

    }

    private void findCourseAndStudentByStudentId(AppDAO appDAO) {
        int studentId = 1;
        Student student= appDAO.findStudentAndCourseByStudentId(studentId);
            System.out.println(student);
            System.out.println(student.getCourses());

    }

    private void findCourseAndStudentByCourseId(AppDAO appDAO) {
        int courseId =10;
        Course courseAndStudentByCourseId = appDAO.findCourseAndStudentByCourseId(courseId);
        System.out.println(courseAndStudentByCourseId);
        System.out.println(courseAndStudentByCourseId.getStudents());

    }

    private void createCoursesAndStudents(AppDAO appDAO) {
        //create course
        Course course = new Course("pacman-how to score one milion");

        //create student
        Student student1 = new Student("john", "doe", "john@gmail.com");
        Student student2 = new Student("paul", "walker", "paul@gmail.com");
        Student student3 = new Student("simon", "david", "simon@gmail.com");

        course.AddStudent(student1);
        course.AddStudent(student2);
        course.AddStudent(student3);
        System.out.println("saving course :"+course);
        System.out.println("saving student :"+course.getStudents());

        appDAO.createStudentAndCourse(course);
    }
}
