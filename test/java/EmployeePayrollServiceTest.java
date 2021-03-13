import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class EmployeePayRollServiceTest
{
    @Test
    void given3EmpWhenWrittenToFilesShouldMatchEmpEntries()
    {
        EmployeePayrollData[] arrayOfEmp= {
                new EmployeePayrollData(1,"Sanket",1235),
                new EmployeePayrollData(2,"Bill",1235),
                new EmployeePayrollData(3,"Mark",1235),
        };
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(Arrays.asList(arrayOfEmp));
        employeePayrollService.empWriteData(EmployeePayrollService.IOService.FILE_IO);
        employeePayrollService.printData(EmployeePayrollService.IOService.FILE_IO);
        long result = employeePayrollService.countEntries(EmployeePayrollService.IOService.FILE_IO);
        Assertions.assertEquals(3,result);
    }
}
