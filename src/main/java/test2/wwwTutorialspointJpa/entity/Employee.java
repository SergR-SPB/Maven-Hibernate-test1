package test2.wwwTutorialspointJpa.entity;

import javax.persistence.*;

@Entity
@Table


public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int eId;
    private String eName;
    private double eSalary;
    //designation
    private String eDeg;

    public Employee(int eId, String eName, double eSalary, String eDeg) {
        super();
        this.eId = eId;
        this.eName = eName;
        this.eSalary = eSalary;
        this.eDeg = eDeg;
    }

    public Employee() {  super(); }

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public double geteSalary() {
        return eSalary;
    }

    public void seteSalary(double eSalary) {
        this.eSalary = eSalary;
    }

    public String geteDeg() {
        return eDeg;
    }

    public void seteDeg(String eDeg) {
        this.eDeg = eDeg;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", eSalary=" + eSalary +
                ", eDeg='" + eDeg + '\'' +
                '}';
    }
}
