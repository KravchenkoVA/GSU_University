package by.gsu.pms;

public class CountClass implements Comparable<CountClass>{

    private String keyWord;
    private int units;

    public CountClass(String keyWord) {
        this.keyWord = keyWord;
    }

    public CountClass() {
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return (keyWord+"; "+units);
    }
    public int compareTo(CountClass p){
        return p.getUnits()-units;
    }
}