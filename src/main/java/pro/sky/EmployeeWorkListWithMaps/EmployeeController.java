package pro.sky.EmployeeWorkListWithMaps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;


@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeServiceImpl;

    public EmployeeController(EmployeeService employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return "Сотрудник " + employeeServiceImpl.addEmployee(firstName, lastName) + " добавлен!";
    }

    @GetMapping("/remove")
    public String removeEmployee(@RequestParam int id) {
        return "Сотрудник " + employeeServiceImpl.removeEmployee(id) + " удален!";
    }

    @GetMapping("/find/value")
    public Employee findEmployeeWithValue(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.findEmployeeWithValue(firstName, lastName);
    }

    @GetMapping("/find/id")
    public Employee findEmployeeWithId(@RequestParam int id) {
        return employeeServiceImpl.findEmployeeWithKey(id);
    }

    @GetMapping("/get/map")
    public Map<Integer, Employee> getEmployeeMap() {
        return employeeServiceImpl.getEmployeeMap();
    }


}
