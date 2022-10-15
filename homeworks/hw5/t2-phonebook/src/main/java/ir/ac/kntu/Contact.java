package ir.ac.kntu;

import java.util.Objects;

enum PhoneType {
    COMPANY, PHONE, HOME
}

public class Contact {

    private final int id;

    private String name;

    private String phoneNumber;

    private String email;

    private PhoneType phoneType;

    static int idTemp = 0;

    public Contact(String name, String phoneNumber, String email, PhoneType phoneType) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
        setPhoneType(phoneType);
        this.id = idTemp++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Contact contact = (Contact) o;
        return id == contact.id && name.equals(contact.name) && phoneNumber.equals(contact.phoneNumber) && phoneType == contact.phoneType && email.equals(contact.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber, email);
    }
}
