package pro.sky.EmployeeWorkListWithMaps;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeMap = new HashMap<>();


    public Employee addEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        String key = (firstName + " " + lastName).toLowerCase(Locale.ROOT);
        employeeMap.put(key, worker);
        return worker;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String key = (firstName + " " + lastName).toLowerCase(Locale.ROOT);
        if (employeeMap.containsKey(key)) {
            Employee worker = employeeMap.get(key);
            employeeMap.remove(key);
            return worker;
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    public Employee findEmployeeWithKey(String firstName, String lastName) {
        String key = (firstName + " " + lastName).toLowerCase(Locale.ROOT);
        if (employeeMap.containsKey(key)) {
            return employeeMap.get(key);
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    public Employee findEmployeeWithValue(String firstName, String lastName) {
        String key = (firstName + " " + lastName).toLowerCase(Locale.ROOT);
        Employee worker = new Employee(firstName, lastName);
        if (employeeMap.containsValue(worker)) {
            return employeeMap.get(key);
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    public List<Employee> getEmployeeMap() {
        return new ArrayList<>(employeeMap.values());
    }
}

