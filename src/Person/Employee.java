package Person;

public class Employee extends Person{
    private String jobTitle;
    private int salary;

    public Employee(String firstName, String lastName, String phoneNumber, String email,
                    String jobTitle, int salary) {
        super(firstName, lastName, phoneNumber, email);
        this.jobTitle = jobTitle;
        this.salary = salary;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
