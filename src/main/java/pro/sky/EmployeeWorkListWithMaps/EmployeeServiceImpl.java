package pro.sky.EmployeeWorkListWithMaps;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap = new HashMap<>();


    private String getKey (String firstName, String lastName) {
        String key = (firstName + " " + lastName).toLowerCase(Locale.ROOT);
        return key;
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        String key = getKey(firstName, lastName);
        employeeMap.put(key, worker);
        return worker;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.remove(key);
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    public Employee findEmployeeWithKey(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        } else {
            throw new NotFoundEmployeeException();
        }
    }


    public List<Employee> getEmployeeMap() {
        return new ArrayList<>(employeeMap.values());
    }
}

