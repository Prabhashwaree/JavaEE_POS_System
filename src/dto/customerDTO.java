package dto;

public class customerDTO {
    private String CustID;
    private String CustName;
    private String CustAddress;
    private String Salary;

    public customerDTO() {
    }

    public customerDTO(String custID, String custName, String custAddress, String salary) {
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

    public String getSalary() {
        return Salary;
    }

    public void setSalary(String salary) {
        Salary = salary;
    }

    @Override
    public String toString() {
        return "customerDTO{" +
                "CustID='" + CustID + '\'' +
                ", CustName='" + CustName + '\'' +
                ", CustAddress='" + CustAddress + '\'' +
                ", Salary='" + Salary + '\'' +
                '}';
    }
}
