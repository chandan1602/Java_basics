package T2454.Chandan_Bansal.BE_Project1.service;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.exception.ItemNotFoundException;
import T2454.Chandan_Bansal.BE_Project1.utils.CustomLogger;
import T2454.Chandan_Bansal.BE_Project1.repository.DepartmentRepository;
import T2454.Chandan_Bansal.BE_Project1.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServices {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public DepartmentServices(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Department> getAllDepartments() {
        CustomLogger.logger.info("GET Request! All Departments Sent!");
        return departmentRepository.findAll();
    }

    public void createDepartment(Department department) throws Exception {
            if(departmentRepository.findDepartmentByTitle(department.getTitle()).isPresent()) {
                CustomLogger.logger.error("Department creation Error! This name already exists!");
                throw new IllegalStateException(
                        "Department with this name already exists!"
                );
            }
            Department department1 = Department.builder()
                    .setTitle(department.getTitle())
                    .getDepartment();
            CustomLogger.logger.info("POST Request! New Department created");
            departmentRepository.save(department1);
    }

    @Transactional
    public void updateDepartmentById(Department department, String departmentId) {
        Department department1 = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ItemNotFoundException(
                        "Department with id " + departmentId+" doesn't exist!"
                ));
        if(department.getTitle()!=null && department.getTitle().length()>0 && !Objects.equals(department.getTitle(), department1.getTitle())) {
            department1.setTitle(department.getTitle());
        }
        CustomLogger.logger.info("PUT Request! Department name Updated");
    }

    @Transactional
    public void deleteDepartmentById(String departmentId) {
        try {
            employeeRepository.updateEmployeesDeleteForeignKeyById(departmentId);
            departmentRepository.deleteById(departmentId);
        } catch (Exception e) {
            CustomLogger.logger.info("DELETE Request Failed! Department with Id " + departmentId + " doesn't exist!");
            throw new ItemNotFoundException(
                    "Department with Id " + departmentId + " doesn't exist!"
            );
        }
        CustomLogger.logger.info("DELETE REQUEST! Department deleted!");
    }
}
