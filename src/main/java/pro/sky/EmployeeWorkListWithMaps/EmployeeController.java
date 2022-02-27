package pro.sky.EmployeeWorkListWithMaps;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
    public String removeEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return "Сотрудник " + employeeServiceImpl.removeEmployee(firstName, lastName) + " удален!";
    }

    @GetMapping("/find/key")
    public Employee findEmployeeWithId(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.findEmployeeWithKey(firstName, lastName);
    }

    @GetMapping("/all")
    public List<Employee> getEmployeeMap() {
        return employeeServiceImpl.getEmployeeMap();
    }


}
