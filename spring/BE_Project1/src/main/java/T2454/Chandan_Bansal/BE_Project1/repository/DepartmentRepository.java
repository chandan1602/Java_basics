package T2454.Chandan_Bansal.BE_Project1.repository;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {

    @Query("SELECT d FROM Department d WHERE title=?1")
    Optional<Department> findDepartmentByTitle(String deptName);
}
