package it.develhope.Email02.api.entities;

/**
 * @author Drumstyle92
 * DTO class that is used to represent the data of an email notification
 */
public class NotificationDTO {

    /**
     * Contact student id field
     */
    private String contactId;

    /**
     * Notification title field
     */
    private String title;

    /**
     * Notification text field
     */
    private String text;

    /**
     * Default constructor
     */
    public NotificationDTO(){}

    /**
     * @param contactId the contact id
     * @param title     the title
     * @param text      the text
     * Parameterized constructor
     */
    public NotificationDTO(String contactId, String title, String text) {
        this.contactId = contactId;
        this.title = title;
        this.text = text;
    }

    /**
     * @return the contact id
     * Method for encapsulation
     */
    public String getContactId() {
        return contactId;
    }

    /**
     * @param contactId the contact id
     * Method for encapsulation
     */
    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    /**
     * @return the title
     * Method for encapsulation
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title
     * Method for encapsulation
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the text
     * Method for encapsulation
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text
     * Method for encapsulation
     */
    public void setText(String text) {
        this.text = text;
    }

}
