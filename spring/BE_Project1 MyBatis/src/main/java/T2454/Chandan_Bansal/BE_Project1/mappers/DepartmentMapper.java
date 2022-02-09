package T2454.Chandan_Bansal.BE_Project1.mappers;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
public interface DepartmentMapper extends JpaRepository<Department, String> {

    @Select("SELECT * FROM department")
    List<Department> findAll();

//    @Insert(value = "INSERT into department(dep_id, title) values(#{depId}, #{title})")
////    @Options(useGeneratedKeys = true, keyProperty = "#{depId}", keyColumn = "dep_id")
//    void save(Department department1);

    @Select("SELECT * FROM department d where d.id=?1")
    Optional<Department> findById(String departmentId);

    @Select("SELECT * FROM department where title=?1")
    Optional<Department> findDepartmentByTitle(String depName);
}
