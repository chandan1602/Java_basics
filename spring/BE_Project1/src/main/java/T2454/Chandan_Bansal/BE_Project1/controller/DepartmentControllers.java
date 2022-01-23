package T2454.Chandan_Bansal.BE_Project1.controller;

import T2454.Chandan_Bansal.BE_Project1.entity.Department;
import T2454.Chandan_Bansal.BE_Project1.service.DepartmentServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentControllers {
    private final DepartmentServices departmentServices;
    public DepartmentControllers(DepartmentServices departmentServices) {
        this.departmentServices = departmentServices;
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Department>> getDepartments() {
        List<Department> list = departmentServices.getAllDepartments();
        return new ResponseEntity<List<Department>>(list, HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Department> createDepartment(
            @RequestBody Department department) throws Exception {
        departmentServices.createDepartment(department);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{departmentId}")
    @ResponseBody
    public ResponseEntity<Department> updateDepartment(
            @RequestBody Department department,
            @PathVariable String departmentId
            ) {
        departmentServices.updateDepartmentById(department, departmentId);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{departmentId}")
    @ResponseBody
    public ResponseEntity<Department> deleteDepartment(
            @PathVariable String departmentId
    ) {
        departmentServices.deleteDepartmentById(departmentId);
        return new ResponseEntity<Department>(HttpStatus.OK);
    }

}
