package lk.ijse.mappingonetomany.dao;
import jakarta.persistence.EntityManager;
import lk.ijse.mappingonetomany.entity.Instructor;
import lk.ijse.mappingonetomany.entity.InstructorDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AppDAOImpl implements AppDAO {
    private EntityManager entityManager;
    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public List<Instructor> findAll() {
        List<Instructor> instructorList = entityManager.createQuery(" from Instructor", Instructor.class).getResultList();
        return instructorList;
    }

    @Override
    public Instructor findById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        return instructor;

    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(entityManager.find(Instructor.class, id));
    }

    @Override
    public void updateSelectInstructor(int id,Instructor instructor) {
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());

    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id) {
        return entityManager.find(InstructorDetails.class, id);
    }

    @Override
    public void deleteInstructorDetailsById(int id) {
        InstructorDetails instructorDetails = entityManager.find(InstructorDetails.class, id);
        entityManager.remove(instructorDetails);
    }
}
