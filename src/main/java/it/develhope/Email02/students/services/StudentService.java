package it.develhope.Email02.students.services;

import it.develhope.Email02.students.entities.Student;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Drumstyle92
 * Classroom used as a service to retrieve student information from a data source
 */
@Service
public class StudentService {

    /**
     * private field which is a list of Student objects
     */
    private final List<Student> students = new ArrayList<>(Arrays.asList(
            new Student("1", "Dino", "Petrucci", "YOUR_EMAIL"),
            new Student("2", "Luigi", "Verdi", "luigi.verdi@example.com"),
            new Student("3", "Giovanni", "Bianchi", "giovanni.bianchi@example.com"),
            new Student("4", "Giuseppe", "Neri", "giuseppe.neri@example.com")
    ));

    /**
     * @param id Parameter which takes the id of the selected student
     * @return Returns the selected student object
     * method that takes a parameter and returns a Student
     * object whose ID matches the one supplied, or returns
     * null if no student with that ID is found
     */
    public Student getStudentById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

}
