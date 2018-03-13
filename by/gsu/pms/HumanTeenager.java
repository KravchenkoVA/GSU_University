package by.gsu.pms;
public class HumanTeenager extends Human {
    private int schoolNumber;
    private double schoolResult;

    public HumanTeenager(String fullName, char sex, int age, int schoolNumber, double schoolResult) {
        super(fullName, sex, age);
        this.schoolNumber = schoolNumber;
        this.schoolResult = schoolResult;
    }

    public HumanTeenager(String fullName, char sex, int age, int schoolNumber) {
        super(fullName, sex, age);
        this.schoolNumber = schoolNumber;
    }

    public HumanTeenager() {
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public double getSchoolResult() {
        return schoolResult;
    }

    public void setSchoolResult(double schoolResult) {
        this.schoolResult = schoolResult;
    }


    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+schoolNumber+';'+schoolResult;
    }

    @Override
    public void writeInfo() {
        System.out.println("Teenager:"+fieldsToString());
    }

}

