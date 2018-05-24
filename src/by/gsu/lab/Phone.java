package by.gsu.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Phone implements Comparable<Phone> {

    private UUID id;
    private String firstName;
    private String secondName;
    private String address;
    private int numberOfCard;
    private double debit;
    private double credit;
    private int timeOfCityCalls;
    private int timeOfInternationalCalls;


    public Phone(String firstName, String secondName, String address, int numberOfCard, double debit, double credit, int timeOfCityCalls, int timeOfInternationalCalls) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.numberOfCard = numberOfCard;
        this.debit = debit;
        this.credit = credit;
        this.timeOfCityCalls = timeOfCityCalls;
        this.timeOfInternationalCalls = timeOfInternationalCalls;
        this.setid(UUID.randomUUID());
    }

    public Phone(UUID id, String firstName, String secondName, String address, int numberOfCard, double debit, double credit, int timeOfCityCalls, int timeOfInternationalCalls) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.numberOfCard = numberOfCard;
        this.debit = debit;
        this.credit = credit;
        this.timeOfCityCalls = timeOfCityCalls;
        this.timeOfInternationalCalls = timeOfInternationalCalls;
        this.setid(id);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public double getDebit() {
        return debit;
    }

    public void setDebit(double debit) {
        this.debit = debit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public int getTimeOfCityCalls() {
        return timeOfCityCalls;
    }

    public void setTimeOfCityCalls(int timeOfCityCalls) {
        this.timeOfCityCalls = timeOfCityCalls;
    }

    public int getTimeOfInternationalCalls() {
        return timeOfInternationalCalls;
    }

    public void setTimeOfInternationalCalls(int timeOfInternationalCalls) {
        this.timeOfInternationalCalls = timeOfInternationalCalls;
    }

    public UUID getid() {
        return id;
    }

    private void setid(UUID id) {
        this.id = id;
    }

    @Override
    public int compareTo(Phone o) {
        // TODO Auto-generated method stub
        return this.secondName.compareTo(o.secondName);
    }

    @Override
    public String toString() {
        return id + "; " + firstName + "; " + secondName + "; " + address + "; " + numberOfCard + "; " + debit + "; " + credit + "; " + timeOfCityCalls + "; " + timeOfInternationalCalls+"; " ;
    }


    public static List<Phone> saysMorethanNorm(List<Phone> ph, int norm) {
        List<Phone> phone = new ArrayList<Phone>();
        for (int i = 0; i < ph.size(); i++) {
            if (ph.get(i).timeOfCityCalls > norm) {
                phone.add(ph.get(i));
            }
        }
        return phone;
    }

    public static List<Phone> enjoyedInternationalCommunication(List<Phone> ph) {
        List<Phone> phone = new ArrayList<Phone>();
        for (int i = 0; i < ph.size(); i++) {
            if (ph.get(i).timeOfInternationalCalls > 0) {
                phone.add(ph.get(i));
            }
        }
        return phone;
    }


}
