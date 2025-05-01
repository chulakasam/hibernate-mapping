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
            createCousesAndStudents(appDAO);
        };
    }

    private void createCousesAndStudents(AppDAO appDAO) {
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
