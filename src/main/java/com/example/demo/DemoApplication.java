package com.example.demo;

import com.example.demo.dao.AppDAO;
import com.example.demo.entity.Instructor;
import com.example.demo.entity.InstructorDetails;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner->{

			//createInstructor(appDAO);

			//getAllInstructor(appDAO);

			//getSelectedInstructor(appDAO);

			//deleteSelectedInstructor(appDAO);

			updateSelectedInstructor(appDAO);
		};
	}

	private void updateSelectedInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor();

		instructor.setFirstName("paul");
		instructor.setLastName("heyman");
		instructor.setEmail("paul@gmail.com");

		appDAO.updateSelectInstructor(3,instructor);
	}

	private void deleteSelectedInstructor(AppDAO appDAO) {
		appDAO.deleteById(2);
	}

	private void getSelectedInstructor(AppDAO appDAO) {
		Instructor select_instructor = appDAO.findById(1);
		System.out.println("Selected Instructor: " + select_instructor);
	}

	private void getAllInstructor(AppDAO appDAO) {
		List<Instructor> all = appDAO.findAll();
		for (Instructor instructor : all) {
			System.out.println(instructor);
		}
	}

	private void createInstructor(AppDAO appDAO) {
		InstructorDetails details = new InstructorDetails();
		details.setYouTubeChannel("youtube.com/john");
		details.setHobby("Guitar");


		Instructor instructor = new Instructor();
		instructor.setFirstName("John");
		instructor.setLastName("Doe");
		instructor.setEmail("john.doe@example.com");
		instructor.setInstructorDetails(details);

		appDAO.save(instructor);

	}
}
