package by.gsu.pms;

public class Patient {
    private String surname;
    private char sex;
    private int age;

    public Patient(String surname, char sex, int age) {
        this.surname = surname;
        this.sex = sex;
        this.age = age;
    }

    public Patient(String surname, char sex) {
        this.surname = surname;
        this.sex = sex;
    }

    public Patient() {
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return surname+';'+sex+';'+age;
    }
}
