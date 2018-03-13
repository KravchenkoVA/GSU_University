package by.gsu.pms;
public class HumanParent extends Human {
    private int childrenCount;
    private String placeOfWork;

    public HumanParent(String fullName, char sex, int age, int childrenCount, String placeOfWork) {
        super(fullName, sex, age);
        this.childrenCount = childrenCount;
        this.placeOfWork = placeOfWork;
    }

    public HumanParent(String fullName, char sex, int age, int childrenCount) {
        super(fullName, sex, age);
        this.childrenCount = childrenCount;
    }

    public HumanParent() {
    }

    public int getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(int childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getPlaceOfWork() {
        return placeOfWork;
    }

    public void setPlaceOfWork(String placeOfWork) {
        this.placeOfWork = placeOfWork;
    }

    @Override
    protected String fieldsToString() {
        return super.fieldsToString()+";"+childrenCount+';'+placeOfWork;
    }
    @Override
    public void writeInfo() {
        System.out.println("Parent:"+fieldsToString());
    }

}

