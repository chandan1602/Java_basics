package T2454.Chandan_Bansal.BE_Project1.repository;

import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    Optional<Employee> findEmployeeByEmail(String email);

    @Modifying
    @Query(
            value = "update employees set department_id=null where department_id=?1",
            nativeQuery = true
    )
    void updateEmployeesDeleteForeignKeyById(String departmentId);

    @Modifying
    @Query(
            value = "delete from employees where employee_code=?1",
            nativeQuery = true
    )
    void deleteByEmployeeById(String employeeCode);
}
