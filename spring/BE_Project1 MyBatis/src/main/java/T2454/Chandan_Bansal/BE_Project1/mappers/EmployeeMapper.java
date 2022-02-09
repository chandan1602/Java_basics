package T2454.Chandan_Bansal.BE_Project1.mappers;

import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface EmployeeMapper extends JpaRepository<Employee, String> {

    @Select("SELECT * FROM employees")
    List<Employee> findAll();

    @Select(value = "SELECT * FROM employees WHERE email=?1")
    Optional<Employee> findEmployeeByEmail(String email);

    @Delete(value = "delete from employees where employee_code=?1")
    void deleteEmployeeByEmployeeCode(String employeeCode);

//    @Update(value = "update employees set department_id=null where department_id=?1")
//    void updateEmployeesDeleteForeignKeyById(String departmentId);

    @Select(value = "SELECT * FROM employees WHERE department_id=?1")
    Optional<List<Employee>> findEmployeeByDepartmentId(String departmentId);

//    @Insert(value = "INSERT into employees values(#{employeeCode}, #{name}, #{email}, #{contact}, #{department}.depId)")
//    void save(Employee employee1);
}
