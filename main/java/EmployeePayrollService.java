import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService
{
    public enum IOService { CONSOLE_IO,FILE_IO}
    private final List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
    {
        this.employeePayrollList = employeePayrollList;
    }

    public void readData(IOService ioService){
        if (ioService.equals(IOService.CONSOLE_IO)) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Employee Name");
            String empName = scan.next();
            System.out.println("Enter Employee ID");
            int empID = scan.nextInt();
            System.out.println("Enter Employee Salary");
            int empSalary = scan.nextInt();

            EmployeePayrollData adder = new EmployeePayrollData( empID,empName, empSalary);
            employeePayrollList.add(adder);
        }
        else if (ioService.equals(IOService.FILE_IO)){
            new EmployeePayrollFileIOService().readData();
        }
    }
    public void empWriteData(IOService ioService)
    {
        if (ioService.equals(IOService.CONSOLE_IO))
            System.out.println("OutPut\n"+employeePayrollList);
        else if (ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().writeData(employeePayrollList);
    }
    public void printData(IOService ioService)
    {
        if(ioService.equals(IOService.FILE_IO))
            new EmployeePayrollFileIOService().printData();
        else
            System.out.println("Chose File_IO");
    }
    public long countEntries(IOService ioService)
    {
        if (ioService.equals(IOService.FILE_IO))
            return new EmployeePayrollFileIOService().countEntries();
        return 0;
    }
    //Main method
    public static void main(String [] args)
    {
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);

        employeePayrollService.readData(IOService.FILE_IO);
        employeePayrollService.empWriteData(IOService.FILE_IO);

    }
}
