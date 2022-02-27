package pro.sky.EmployeeWorkListWithMaps;

import java.util.List;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(String firstName, String lastName);
    Employee findEmployeeWithKey(String firstName, String lastName);
    List<Employee> getEmployeeMap();
}

