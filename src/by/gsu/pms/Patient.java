package by.gsu.pms;

import java.io.Serializable;

public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;
    private String surname;
    private int age;
    private String sex;

    public String getSurname() {
        return surname;
    }

    public void setName(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Patient() {
        super();
    }

    public Patient(String surname, int age, String sex) {
        super();
        this.surname = surname;
        this.age = age;
        this.sex = sex;

    }

    @Override
    public String toString() {
        return surname + ", " + age + "," + sex;
    }

}