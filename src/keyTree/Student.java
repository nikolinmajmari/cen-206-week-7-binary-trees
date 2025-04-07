package keyTree;

public class Student {
    private String fullName;
    private int age;
    private String city;
    private String cgpa;

    Student(String fullName, int age, String city, String cgpa) {
        this.fullName = fullName;
        this.age = age;
        this.city = city;
        this.cgpa = cgpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
