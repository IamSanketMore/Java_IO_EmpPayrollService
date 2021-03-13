public class EmployeePayrollData
{
    public int employeeID;
    public String employeeName;
    public double employeeSalary;

    public EmployeePayrollData(int employeeID, String employeeName, double employeeSalary)
    {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "employeeID=" + employeeID +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                '}';
    }
}
