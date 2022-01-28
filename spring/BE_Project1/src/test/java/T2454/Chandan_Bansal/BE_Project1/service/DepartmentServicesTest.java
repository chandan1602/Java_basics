package T2454.Chandan_Bansal.BE_Project1.service;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.exception.ItemNotFoundException;
import T2454.Chandan_Bansal.BE_Project1.repository.DepartmentRepository;
import T2454.Chandan_Bansal.BE_Project1.repository.EmployeeRepository;
import T2454.Chandan_Bansal.BE_Project1.utils.CustomLogger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DepartmentServicesTest {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Autowired
    public DepartmentServicesTest(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public static Department sampleDepartment() {
        return  Department.builder()
                .setTitle("Demo")
                .getDepartment();
    }

    public static String sampleDepartmentId = "402881827e864834017e864937cf0001";

    @Test
    public void createDepartment() {
        Department department = sampleDepartment();
        if(departmentRepository.findDepartmentByTitle(department.getTitle()).isPresent()) {
            throw new IllegalStateException(
                    "Department with this name already exists!"
            );
        }
        departmentRepository.save(department);
    }

    @Test
    @Transactional
    public void updateDepartmentById() {
        Department department = sampleDepartment();
        String departmentId = "402881827e864834017e864937cf0001";
        Department department1 = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ItemNotFoundException(
                        "Department with id " + departmentId+" doesn't exist!"
                ));
        if(department.getTitle()!=null && department.getTitle().length()>0 && !Objects.equals(department.getTitle(), department1.getTitle())) {
            department1.setTitle(department.getTitle());
        }
    }

    @Test
    @Transactional
    public void deleteDepartmentById() {
        String departmentId = sampleDepartmentId;
        try {
            employeeRepository.updateEmployeesDeleteForeignKeyById(departmentId);
            departmentRepository.deleteById(departmentId);
        } catch (Exception e) {
            CustomLogger.logger.info("DELETE Request Failed! Department with Id " + departmentId + " doesn't exist!");
            throw new ItemNotFoundException(
                    "Department with Id " + departmentId + " doesn't exist!"
            );
        }
    }
}