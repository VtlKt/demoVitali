package pl.vitalikot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @PostMapping("/employee/endpoint")
    public boolean isEmployeePost(){
        return true;
    }

    @GetMapping("/employeeFN/{firstName}/employeeLN/{lastName}")
    public String myGetter(@PathVariable String firstName, @PathVariable String lastName) {
        return firstName + " " + lastName;
    }

    @DeleteMapping("/employeeFirstName/{firstName}")
    public String myDelete(@PathVariable String firstName, @RequestParam String department) {
        return firstName + " " + department;
    }

    @PutMapping("/details/{firstName}")
    public String myDetails(@PathVariable String firstName, @RequestParam String department, @RequestHeader double salary) {
        return "Name: " + firstName + ". Department: " + department + ", salary: " + salary;
    }

    @PostMapping("/employee")
    public String employee(@RequestBody EmployeeReq employee) {
        return employee.toString();
    }

    @GetMapping(value = "/test")
    public Iterable<Employee> employee2() {
        return employeeRepository.findAll();
    }

    @GetMapping(value = "/test/{id}")
    public Employee employee2(@PathVariable long id) {
        return employeeRepository.findById(id).get();
    }

    @PostMapping(value = "/test")
    public long example(@RequestBody EmployeeReq employeeReq) {
        Employee employee = new Employee(0, employeeReq.getName(), employeeReq.getAge());
        Employee save = employeeRepository.save(employee);
        return save.getId();
    }
}
