package T2454.Chandan_Bansal.BE_Project1.service;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.exception.ItemNotFoundException;
import T2454.Chandan_Bansal.BE_Project1.utils.CustomLogger;
import T2454.Chandan_Bansal.BE_Project1.repository.DepartmentRepository;
import T2454.Chandan_Bansal.BE_Project1.repository.EmployeeRepository;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServices {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private RedisTemplate<String, Department> redisTemplate;
    private ListOperations listOperations;
    private static final String DEPKEY = "DEPS";

    public DepartmentServices(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, RedisTemplate redisTemplate) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.redisTemplate = redisTemplate;
        listOperations = redisTemplate.opsForList();
        initDepNameCache(listOperations);
    }

    public void initDepNameCache(ListOperations listOperations) {
        if(listOperations.size(DEPKEY)==0)
        for(Department dep: departmentRepository.findAll()) {
            listOperations.rightPush(DEPKEY,dep);
        }
    }


    public List<Department> getAllDepartments() {
        CustomLogger.logger.info("GET Request! All Departments Sent!");
        System.out.println(listOperations.range(DEPKEY,0,-1));
//        return departmentRepository.findAll();
        return (List<Department>) listOperations.range(DEPKEY,0,-1);
    }

    public void createDepartment(Department department) throws Exception {
//            if(departmentRepository.findDepartmentByTitle(department.getTitle()).isPresent()) {
//                CustomLogger.logger.error("Department creation Error! This name already exists!");
//                throw new IllegalStateException(
//                        "Department with this name already exists!"
//                );
//            }
            boolean found = false;
            for(Object dep: listOperations.range(DEPKEY,0,-1)) {
                if(((Department) dep).getTitle().equals(department.getTitle())) {
                    found = true;
                    break;
                }
                }
            if(found) {
                CustomLogger.logger.error("Department creation Error! This name already exists!");
                throw new IllegalStateException(
                        "Department with this name already exists!"
                );
            }
            Department department1 = Department.builder()
                    .setTitle(department.getTitle())
                    .getDepartment();
            CustomLogger.logger.info("POST Request! New Department created");
            listOperations.rightPush(DEPKEY, department);
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
