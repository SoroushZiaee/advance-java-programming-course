package ir.ac.kntu;

class Person {
    protected String name;
    protected String address;
    protected String phoneNumber;
    protected String email;
    public final static int MAX_AGE = 120;

    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Person(String name, String address) {
        this(name, address, "0900-000-0000", "john@doe.com");
    }

    protected void eat() {
        System.out.println("monster num num!");
    }

    protected void drink() {
        System.out.println("cheers");
    }

    private void code() {
        System.out.println("code until die!");
    }

    public void die() {
        System.out.println("Rest In Piece!");
    }

    @Override
    public String toString() {
        return "Name: " + name + ", : " + address + ", Phone #: " + phoneNumber + ", Email: " + email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}