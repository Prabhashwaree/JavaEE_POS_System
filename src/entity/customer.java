package entity;

public class customer {
    private String CustID;
    private String CustName;
    private String CustAddress;
    private double Salary;

    public customer() {
    }

    public customer(String custID, String custName, String custAddress, double salary) {
        setCustID(custID);
        setCustName(custName);
        setCustAddress(custAddress);
        setSalary(salary);
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String custID) {
        CustID = custID;
    }

    public String getCustName() {
        return CustName;
    }

    public void setCustName(String custName) {
        CustName = custName;
    }

    public String getCustAddress() {
        return CustAddress;
    }

    public void setCustAddress(String custAddress) {
        CustAddress = custAddress;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}
