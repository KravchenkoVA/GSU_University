package by.gsu.pms;

public abstract class Human implements Write  {
    private String fullName;
    private char sex;
    private int age;

    public Human(String fullName, char sex, int age) {
        super();
        this.fullName = fullName;
        this.sex = sex;
        this.age = age;
    }

    public Human(String fullName, char sex) {
        super();
        this.fullName = fullName;
        this.sex = sex;
    }

    public Human() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
    protected String fieldsToString() {
        return fullName+";"+sex+";"+age;
    }

    @Override
    public void writeInfo() {
         System.out.println("Human:"+fieldsToString());
    }




}
