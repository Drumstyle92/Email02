package it.develhope.Email02.students.entities;

/**
 * @author Drumstyle92
 * Classroom used as the basis for a student management system for a roster
 */
public class Student {

    /**
     * Student id field
     */
    private String id;

    /**
     * Student name field
     */
    private String name;

    /**
     * Student last name field
     */
    private String surname;

    /**
     * Student email field
     */
    private String email;


    /**
     * Default constructor
     */
    public Student(){}

    /**
     * @param id      the id
     * @param name    the name
     * @param surname the surname
     * @param email   the email
     * Parameterized constructor
     */
    public Student(String id, String name, String surname, String email) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;

    }

    /**
     * @return the id
     * Method for encapsulation
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id
     * Method for encapsulation
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     * Method for encapsulation
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name
     * Method for encapsulation
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     * Method for encapsulation
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname
     * Method for encapsulation
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the email
     * Method for encapsulation
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email
     * Method for encapsulation
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
