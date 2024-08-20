public class Faculty extends Contact{

    String subject;

    public Faculty(String name, String phone, String email, String subject) {
        super(name, phone, email);
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Faculty {" +
                " ID: " + id +
                ", Name: '" + name + '\'' +
                ", Phone number: '" + phone + '\'' +
                ", Subject: '" + subject + '\'' +
                ", Email: '" + email + '\'' +
                " }";
    }
}
