package T2454.Chandan_Bansal.BE_Project1.service;

import T2454.Chandan_Bansal.BE_Project1.adapter.EmployeePostRequestAdapter;
import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import T2454.Chandan_Bansal.BE_Project1.exception.ItemNotFoundException;
import T2454.Chandan_Bansal.BE_Project1.utils.CreateEmployeeThread;
import T2454.Chandan_Bansal.BE_Project1.utils.CustomLogger;
import T2454.Chandan_Bansal.BE_Project1.repository.DepartmentRepository;
import T2454.Chandan_Bansal.BE_Project1.repository.EmployeeRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    @Autowired
    public EmployeeServices(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void createEmployee(EmployeePostRequestAdapter employee) {
        Optional<Department> dept = Optional.empty();
        if(employee.getDepName()!=null) {
            dept = departmentRepository.findDepartmentByTitle(employee.getDepName());
            if(dept.isEmpty()) {
                CustomLogger.logger.error("POST Request failed! Department with name " + employee.getDepName() + " doesn't exist!");
                throw new ItemNotFoundException(
                        "Department with name " + employee.getDepName() + " doesn't exist!"
                );
            }
        }

        if(employeeRepository.findEmployeeByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalStateException(
                    "This email Id already Exists! Kindly use a new one!"
            );
        }

        Employee employee1 = Employee.builder()
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setContact(employee.getContact())
                .setDepartment(dept.isPresent() ? dept.get() : null)
                .getEmployee();
            employeeRepository.save(employee1);

            CustomLogger.logger.info("POST Request made! Employee created!");
    }

    public Employee getEmployeeByEmail(String email) {
        Optional<Employee> employee = employeeRepository.findEmployeeByEmail(email);
        if(employee.isPresent()) {
            return employee.get();
        } else
        {
            throw new ItemNotFoundException(
                    "Employee with email " + email + " doesn't exist!"
            );
        }
    }

    @Transactional
    public void updateEmployeeById(EmployeePostRequestAdapter employee, String employeeCode) {
        Employee employee1 = employeeRepository.findById(employeeCode)
                .orElseThrow(()->new ItemNotFoundException(
                        "Employee with Id " + employeeCode + " doesn't exist"
                ));
        if(employee.getDepName()!=null && employee.getDepName().length()>0) {
            Department department = departmentRepository.findDepartmentByTitle(employee.getDepName())
                    .orElseThrow(()->new ItemNotFoundException(
                            "Department " + employee.getDepName() +" incorrect! Doesnt exist!"
                    ));
            employee1.setDepartment(department);
        }
        employee1.setName(employee.getName()!=null ? employee.getName() : employee1.getName());
        employee1.setContact(employee.getContact()!=null ? employee.getContact() : employee1.getContact());
        try {
            employee1.setEmail(employee.getEmail()!=null ? employee.getEmail() : employee1.getEmail());
        } catch(Exception e) {
            throw new IllegalStateException(
                    "Email id is incorrect/already exists!"
            );
        }
        CustomLogger.logger.info("PUT request made! Employee update Success!");
    }

    @Transactional
    public void deleteEmployeeById(String employeeCode) {
        employeeRepository.deleteByEmployeeById(employeeCode);
        CustomLogger.logger.info("DELETE request made! Employee deleted!");
    }


    //ADVANCED
    private static int MAX_THREAD_COUNT =10;
    public void createMultipleEmployees(JSONObject object) {

    }
}
