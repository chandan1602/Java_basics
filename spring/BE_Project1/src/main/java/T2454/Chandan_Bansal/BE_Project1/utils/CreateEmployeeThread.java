package T2454.Chandan_Bansal.BE_Project1.utils;

import T2454.Chandan_Bansal.BE_Project1.adapter.EmployeePostRequestAdapter;
import T2454.Chandan_Bansal.BE_Project1.service.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateEmployeeThread implements Runnable{
    private final EmployeeServices employeeServices;
    private EmployeePostRequestAdapter employee;
    public CreateEmployeeThread(EmployeeServices employeeServices, EmployeePostRequestAdapter employee) {
        this.employeeServices = employeeServices;
        this.employee = employee;
    }

    @Override
    public void run() {
        employeeServices.createEmployee(employee);
    }
}
