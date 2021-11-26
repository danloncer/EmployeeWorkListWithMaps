package pro.sky.EmployeeWorkListWithMaps;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<Integer, Employee> employeeMap = new HashMap<>();

    int id = -1;

    private Integer getId() {
        id++;
        return id;
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee worker = new Employee(firstName, lastName);
        if (employeeMap.containsValue(worker)) {
            throw new MapHasSimilarMeaning();
        } else {
            employeeMap.put(getId(), worker);
            return worker;
        }
    }

    public Employee removeEmployee(int id) {
        if (employeeMap.containsKey(id)) {
            Employee worker = employeeMap.get(id);
            employeeMap.remove(id);
            return worker;
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    public Employee findEmployeeWithKey(int id) {
        if (employeeMap.containsKey(id)) {
            return employeeMap.get(id);
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    public Employee findEmployeeWithValue(String firstname, String lastname) {
        Employee worker = new Employee(firstname, lastname);
        if (employeeMap.containsValue(worker)) {
            return employeeMap.get(id);
        } else {
            throw new NotFoundEmployeeException();
        }
    }

    public Map<Integer,Employee> getEmployeeMap() {
        return employeeMap;
    }
}

