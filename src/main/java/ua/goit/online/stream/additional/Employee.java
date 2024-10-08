package ua.goit.online.stream.additional;

public class Employee {
    private String name;
    private int age;
    private String country;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Employee(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
