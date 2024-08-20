public class Student extends Contact{

    String dateOfBirth;

    public Student(String name, String phone, String email, String dateOfBirth) {
        super(name, phone, email);
        this.dateOfBirth = dateOfBirth;
    }


    @Override
    public String toString() {
        return "Student {" +
                " ID: " + id +
                ", Name: '" + name + '\'' +
                ", Phone number: '" + phone + '\'' +
                ", Date Of Birth: '" + dateOfBirth + '\'' +
                ", Email: '" + email + '\'' +
                " }";
    }
}
