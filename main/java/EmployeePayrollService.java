import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService
{
    public enum IOService { CONSOLE_TO,FILE_IO,DB_IO,REST_IO }
    private final List<EmployeePayrollData> employeePayrollList;

    public EmployeePayrollService(List<EmployeePayrollData> employeePayrollList)
    {
        this.employeePayrollList = employeePayrollList;
    }


    private void readEmployeePayrollData(Scanner consoleInputReader)
    {
        System.out.println("Enter Employee ID:- ");
        int empID = consoleInputReader.nextInt();

        System.out.println("Enter Employee Name:- ");
        String empName = consoleInputReader.next();

        System.out.println("Enter Employee salary");
        double empSalary = consoleInputReader.nextDouble();
        EmployeePayrollData adder = new EmployeePayrollData(empID,empName,empSalary);
        employeePayrollList.add(adder);
    }
    public void empWriteData(IOService ioService)
    {
        if (ioService.equals(IOService.CONSOLE_TO))
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
        //Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.empWriteData(IOService.FILE_IO);

    }
}
