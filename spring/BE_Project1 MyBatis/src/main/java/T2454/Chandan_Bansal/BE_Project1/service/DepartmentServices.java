package T2454.Chandan_Bansal.BE_Project1.service;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import T2454.Chandan_Bansal.BE_Project1.exception.ItemNotFoundException;
import T2454.Chandan_Bansal.BE_Project1.mappers.DepartmentMapper;
import T2454.Chandan_Bansal.BE_Project1.mappers.EmployeeMapper;
import T2454.Chandan_Bansal.BE_Project1.utils.CustomLogger;
import T2454.Chandan_Bansal.BE_Project1.repository.DepartmentRepository;
import T2454.Chandan_Bansal.BE_Project1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServices {
    private EmployeeMapper employeeMapper;
    private DepartmentMapper departmentMapper;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private RedisTemplate<String, Department> redisTemplate;
    private ListOperations listOperations;
    private static final String DEPKEY = "DEPS";

    @Autowired
    public DepartmentServices(EmployeeMapper employeeMapper,
                              DepartmentMapper departmentMapper,
                              DepartmentRepository departmentRepository,
                              EmployeeRepository employeeRepository,
                              RedisTemplate redisTemplate) {
        this.departmentMapper = departmentMapper;
        this.employeeMapper = employeeMapper;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.redisTemplate = redisTemplate;
        listOperations = redisTemplate.opsForList();
        initDepNameCache(listOperations);
    }

    public void initDepNameCache(ListOperations listOperations) {
        if(listOperations.size(DEPKEY)==0)
        for(Department dep: departmentMapper.findAll()) {
            listOperations.rightPush(DEPKEY,dep);
        }
    }


    public List<Department> getAllDepartments() {
        CustomLogger.logger.info("GET Request! All Departments Sent!");
        System.out.println(listOperations.range(DEPKEY,0,-1));
//        return departmentRepository.findAll();
        return (List<Department>) listOperations.range(DEPKEY,0,-1);
    }

    @Transactional(
            rollbackOn = Exception.class
    )
    public void createDepartment(Department department) {
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
            departmentMapper.save(department1);
            listOperations.rightPush(DEPKEY, department);
    }

    @Transactional
    public void updateDepartmentById(Department department, String departmentId) {
        Department department1 = departmentMapper.findById(departmentId)
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
            Optional<List<Employee>> employees = employeeMapper.findEmployeeByDepartmentId(departmentId);
            if(employees.isPresent()) {
                System.out.println("EMPLOYEES FOUND : " + employees.get());
                for(Employee employee: employees.get()) employee.setDepartment(null);
            }
//            employeeMapper.updateEmployeesDeleteForeignKeyById(departmentId);
            departmentMapper.deleteById(departmentId);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            CustomLogger.logger.info("DELETE Request Failed! Department with Id " + departmentId + " doesn't exist!");
            throw new ItemNotFoundException(
                    "Department with Id " + departmentId + " doesn't exist!"
            );
        }
        CustomLogger.logger.info("DELETE REQUEST! Department deleted!");
    }
}
