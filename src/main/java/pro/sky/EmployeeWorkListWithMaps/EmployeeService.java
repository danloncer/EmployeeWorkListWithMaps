package pro.sky.EmployeeWorkListWithMaps;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);
    Employee removeEmployee(int id);
    Employee findEmployeeWithValue(String firstName, String lastName);
    Employee findEmployeeWithKey(int id);
    Map<Integer,Employee> getEmployeeMap();
}

