package lk.ijse.onetomanyunidirectional;

import lk.ijse.onetomanyunidirectional.dao.AppDAO;
import lk.ijse.onetomanyunidirectional.entity.Course;
import lk.ijse.onetomanyunidirectional.entity.Instructor;
import lk.ijse.onetomanyunidirectional.entity.InstructorDetails;
import lk.ijse.onetomanyunidirectional.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.smartcardio.CommandAPDU;

@SpringBootApplication
public class OneToManyUniDirectionalApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneToManyUniDirectionalApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(AppDAO appDAO) {
        return runner -> {
            //createCourse(appDAO);
            //findCourseAndReview(appDAO);
            //deleteCourseById(appDAO);
        };
    }

    private void deleteCourseById(AppDAO appDAO) {
        int courseId = 11;
        appDAO.deleteCourseAndReviewByCourseId(courseId);
        System.out.println("done !!!");
    }

    private void findCourseAndReview(AppDAO appDAO) {
        int courseId = 11;
        Course course = appDAO.findCourseAndReviewById(courseId);
        System.out.println(course);
        System.out.println(course.getReviews());
    }

    private void createCourse(AppDAO appDAO) {

        Course course = new Course("pacman-how to score one million dollars");
        course.AddReview(new Review("great course ....loved it"));
        course.AddReview(new Review("cool course ....well done"));
        course.AddReview(new Review("what a dumb course you are idiot"));

        appDAO.saveCourse(course);


    }


}
