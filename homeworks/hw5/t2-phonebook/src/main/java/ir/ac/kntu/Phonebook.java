package ir.ac.kntu;


import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    private final HashMap<Integer, Contact> contactInfo;

    public Phonebook() {
        this.contactInfo = new HashMap<Integer, Contact>();
    }

    public HashMap<Integer, Contact> getContactInfo() {
        return new HashMap<>(contactInfo);
    }

    public void setContactInfo(HashMap<Integer, Contact> contactInfo) {
        this.contactInfo.putAll(contactInfo);
    }

    public void addContact(Contact c) {
        this.contactInfo.put(c.getId(), c);
    }

    public void editContact(Integer id, String name, String phoneNumber, String email, PhoneType phoneType) {
        Contact editContact = this.contactInfo.get(id);
        if (name != null) {
            editContact.setName(name);
        }

        if (phoneNumber != null) {
            editContact.setPhoneNumber(phoneNumber);
        }

        if (email != null) {
            editContact.setEmail(email);
        }

        if (phoneNumber != null) {
            editContact.setPhoneType(phoneType);
        }
        this.contactInfo.remove(id);
        this.contactInfo.put(id, editContact);
    }

    public void removeContact(Integer id) {
        this.contactInfo.remove(id);
    }

    public Contact findByNumber(String number) {
        for (Map.Entry<Integer, Contact> set : this.contactInfo.entrySet()) {
            if (number.equals(set.getValue().getPhoneNumber())) {
                return set.getValue();
            }
        }
        return null;
    }

    public Contact findByName(String name) {
        for (Map.Entry<Integer, Contact> set : this.contactInfo.entrySet()) {
            if (name.equals(set.getValue().getName())) {
                return set.getValue();
            }
        }
        return null;
    }

    public void toStringPhoneType(PhoneType type) {
        for (Map.Entry<Integer, Contact> set : this.contactInfo.entrySet()) {
            if (set.getValue().getPhoneType().equals(type)) {
                System.out.println("\t - " + "name : " + set.getValue().getName() + " number : " + set.getValue().getPhoneNumber() + " email : " + set.getValue().getEmail() + " type : " + set.getValue().getPhoneType() + "\n");
            }
        }
    }

    @Override
    public String toString() {
        String[] phonebook = new String[this.contactInfo.size()];
        int counter = 0;
        for (Map.Entry<Integer, Contact> set : this.contactInfo.entrySet()) {
            phonebook[counter++] = "\t - " + "name : " + set.getValue().getName() + " number : " + set.getValue().getPhoneNumber() + " email : " + set.getValue().getEmail() + " type : " + set.getValue().getPhoneType() + "\n";
        }

        String output = "";
        for (int i = 0; i < phonebook.length; i++) {
            output += phonebook[i];
        }

        return output;
    }
}
