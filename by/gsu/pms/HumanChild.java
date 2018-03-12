package by.gsu.pms;
public class HumanChild extends Human {
        private int kindergarten;

    public HumanChild(String fullName, char sex, int age, int kindergarten) {
        super(fullName, sex, age);
        this.kindergarten = kindergarten;
    }

    public HumanChild(String fullName, char sex, int kindergarten) {
        super(fullName, sex);
        this.kindergarten = kindergarten;
    }

    public int getKindergarten() {
        return kindergarten;
    }

    public void setKindergarten(int kindergarten) {
        this.kindergarten = kindergarten;
    }

    public HumanChild() {
    }
    @Override
    protected String WriterInfo() {
        return "Child";
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+kindergarten;
    }

    @Override
    public String toString() {
        return WriterInfo()+": "+fieldsToString();
    }

    }


