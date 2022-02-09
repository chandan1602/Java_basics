package T2454.Chandan_Bansal.BE_Project1.service;

import T2454.Chandan_Bansal.BE_Project1.adapter.EmployeePostRequestAdapter;
import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import T2454.Chandan_Bansal.BE_Project1.exception.ItemNotFoundException;
import T2454.Chandan_Bansal.BE_Project1.mappers.DepartmentMapper;
import T2454.Chandan_Bansal.BE_Project1.mappers.EmployeeMapper;
import T2454.Chandan_Bansal.BE_Project1.utils.CustomLogger;
import T2454.Chandan_Bansal.BE_Project1.repository.DepartmentRepository;
import T2454.Chandan_Bansal.BE_Project1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServices {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeMapper employeeMapper;
    private final DepartmentMapper departmentMapper;
    private RedisTemplate<String, Department> redisTemplate;
    private ListOperations listOperations;
    private static final String DEPKEY = "DEPS";

    @Autowired
    public EmployeeServices(EmployeeMapper employeeMapper,
                            DepartmentMapper departmentMapper,
                            EmployeeRepository employeeRepository,
                            DepartmentRepository departmentRepository,
                            RedisTemplate redisTemplate) {
        this.employeeMapper = employeeMapper;
        this.departmentMapper = departmentMapper;
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
        this.redisTemplate = redisTemplate;
        listOperations = redisTemplate.opsForList();
    }

    public List<Employee> getAllEmployees() {
        return employeeMapper.findAll();
    }

    public void createEmployee(EmployeePostRequestAdapter employee) {
        Optional<Department> dept = Optional.empty();
        if(employee.getDepName()!=null) {
            dept = departmentMapper.findDepartmentByTitle(employee.getDepName());
            if(dept.isEmpty()) {
                CustomLogger.logger.error("POST Request failed! Department with name " + employee.getDepName() + " doesn't exist!");
                throw new ItemNotFoundException(
                        "Department with name " + employee.getDepName() + " doesn't exist!"
                );
            }
        }

        if(employeeMapper.findEmployeeByEmail(employee.getEmail()).isPresent()) {
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
            employeeMapper.save(employee1);

            CustomLogger.logger.info("POST Request made! Employee created!");
    }

    public Employee getEmployeeByEmail(String email) {
        Optional<Employee> employee = employeeMapper.findEmployeeByEmail(email);
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
        Employee employee1 = employeeMapper.findById(employeeCode)
                .orElseThrow(()->new ItemNotFoundException(
                        "Employee with Id " + employeeCode + " doesn't exist"
                ));
        if(employee.getDepName()!=null && employee.getDepName().length()>0) {
            Department department = departmentMapper.findDepartmentByTitle(employee.getDepName())
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
        employeeMapper.deleteEmployeeByEmployeeCode(employeeCode);
        CustomLogger.logger.info("DELETE request made! Employee deleted!");
    }

}
