public class Person {
    private String firstName;
    private String lastName;
    public Person() {}
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String toString() {
        StringBuffer personString = new StringBuffer();
        personString.append(firstName);
        personString.append(",");
        personString.append(lastName + "\n");

        return personString.toString();
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
