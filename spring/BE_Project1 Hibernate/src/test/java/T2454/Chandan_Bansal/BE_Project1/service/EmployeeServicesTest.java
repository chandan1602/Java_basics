package T2454.Chandan_Bansal.BE_Project1.service;

import T2454.Chandan_Bansal.BE_Project1.adapter.EmployeePostRequestAdapter;
import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import T2454.Chandan_Bansal.BE_Project1.exception.ItemNotFoundException;
import T2454.Chandan_Bansal.BE_Project1.repository.DepartmentRepository;
import T2454.Chandan_Bansal.BE_Project1.repository.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeServicesTest {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServicesTest(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public static EmployeePostRequestAdapter sampleEmployee() throws JSONException, JsonProcessingException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Demo Name");
        jsonObject.put("contact", "1010101010");
        jsonObject.put("email", "demo@ocltp.com");
        jsonObject.put("depName", "Travel");
        ObjectMapper objectMapper = new ObjectMapper();
        EmployeePostRequestAdapter employee = objectMapper.readValue(jsonObject.toString(), EmployeePostRequestAdapter.class);
        return employee;
    }

    public static String sampleEmployeeCode = "4028818c7e833366017e8335bde80000";

    @Test
    public void createEmployee() throws JSONException, JsonProcessingException {
        EmployeePostRequestAdapter employee = sampleEmployee();
        Optional<Department> dept = Optional.empty();
        if(employee.getDepName()!=null) {
            dept = departmentRepository.findDepartmentByTitle(employee.getDepName());
            if(dept.isEmpty()) {
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

    }

    @Test
    @Transactional
    public void updateEmployeeById() throws JSONException, JsonProcessingException {
        EmployeePostRequestAdapter employee = sampleEmployee();
        String employeeCode = sampleEmployeeCode;
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
    }

    @Test
    @Transactional
    public void deleteEmployeeById() {
        String employeeCode = sampleEmployeeCode;
        employeeRepository.deleteByEmployeeById(employeeCode);
    }

}