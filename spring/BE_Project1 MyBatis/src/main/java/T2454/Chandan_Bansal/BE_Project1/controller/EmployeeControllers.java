package T2454.Chandan_Bansal.BE_Project1.controller;

import T2454.Chandan_Bansal.BE_Project1.adapter.EmployeePostRequestAdapter;
import T2454.Chandan_Bansal.BE_Project1.entity.Employee;
import T2454.Chandan_Bansal.BE_Project1.service.EmployeeServices;
import T2454.Chandan_Bansal.BE_Project1.utils.CustomThreadPoolExecutor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.*;

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
            BlockingQueue<Runnable> blockingQueue = new ArrayBlockingQueue<>(20);

            CustomThreadPoolExecutor executorService = new CustomThreadPoolExecutor(
                    MAX_THREAD_COUNT, MAX_THREAD_COUNT+10, 2000, TimeUnit.MILLISECONDS,
                    blockingQueue, new ThreadPoolExecutor.AbortPolicy());
            executorService.prestartAllCoreThreads();
            System.out.println(executorService.getActiveCount() + " :: " +  executorService.getPoolSize());

            for( Object e: employees) {
                blockingQueue.put(() -> {
                    JSONObject object1 = (JSONObject) e;
                    ObjectMapper objectMapper = new ObjectMapper();
                    System.out.println(Thread.currentThread().getId() + " is started + " + object1.getString("email") + executorService.getActiveCount());
                    try {
                          employeeServices.createEmployee(objectMapper.readValue(object1.toString(), EmployeePostRequestAdapter.class));
                    } catch (JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getId() + " is closed + " + object1.getString("email"));
                });
            }
            executorService.shutdown();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<Employee>(HttpStatus.CREATED);
    }

}
