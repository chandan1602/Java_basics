package T2454.Chandan_Bansal.BE_Project1.controller;

import T2454.Chandan_Bansal.BE_Project1.adapter.EmployeePostRequestAdapter;
import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import T2454.Chandan_Bansal.BE_Project1.service.EmployeeServices;
import T2454.Chandan_Bansal.BE_Project1.utils.CreateEmployeeThread;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeControllers {
    private final EmployeeServices employeeServices;
    private static int MAX_THREAD_COUNT = 10;
    @Autowired
    public EmployeeControllers(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> list = employeeServices.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @GetMapping("/{employeeEmail}")
    @ResponseBody
    public ResponseEntity<Employee> getEmployeeByEmail(@PathVariable("employeeEmail") String email) {
        Employee employee = employeeServices.getEmployeeByEmail(email);
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Employee> createEmployee(
            @RequestBody EmployeePostRequestAdapter employee
            ){
        employeeServices.createEmployee(employee);
        return new ResponseEntity<Employee>(HttpStatus.CREATED);
    }



    @PutMapping("/{employeeCode}")
    @ResponseBody
    public ResponseEntity<Employee> updateEmployee(
            @RequestBody EmployeePostRequestAdapter employee,
            @PathVariable String employeeCode
    ) {
        employeeServices.updateEmployeeById(employee, employeeCode);
        return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{employeeCode}")
    @ResponseBody
    public ResponseEntity<Employee> deleteEmployee(@PathVariable String employeeCode) {
        employeeServices.deleteEmployeeById(employeeCode);
        return new ResponseEntity<Employee>(HttpStatus.OK);
    }


    //Bulk
    @PostMapping("/bulk")
    @ResponseBody
    public ResponseEntity<Employee> createMultipleEmployees(
            @RequestParam("employees") MultipartFile document
    ) throws IOException {
        InputStream inputStream = document.getInputStream();
        try {
            JSONTokener jsonTokener = new JSONTokener(inputStream);
            JSONObject object = new JSONObject(jsonTokener);

            JSONArray employees = object.getJSONArray("employees");
            ExecutorService executorService = Executors.newFixedThreadPool(MAX_THREAD_COUNT);
            for( Object e: employees) {
                JSONObject object1 = (JSONObject) e;
                ObjectMapper objectMapper = new ObjectMapper();
                Runnable task = new CreateEmployeeThread(employeeServices, objectMapper.readValue(object1.toString(), EmployeePostRequestAdapter.class));
                executorService.execute(task);
            }
            executorService.shutdown();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Employee>(HttpStatus.CREATED);
    }

}
