package pagination;

public class EmployeeQuery {
    private String name;
    private String gender;
    private String email;
    private String position;
    private double beginSalary;
    private double endSalary;
    private int dpID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getBeginSalary() {
        return beginSalary;
    }

    public void setBeginSalary(double beginSalary) {
        this.beginSalary = beginSalary;
    }

    public double getEndSalary() {
        return endSalary;
    }

    public void setEndSalary(double endSalary) {
        this.endSalary = endSalary;
    }

    public int getDpID() {
        return dpID;
    }

    public void setDpID(int dpID) {
        this.dpID = dpID;
    }
}
