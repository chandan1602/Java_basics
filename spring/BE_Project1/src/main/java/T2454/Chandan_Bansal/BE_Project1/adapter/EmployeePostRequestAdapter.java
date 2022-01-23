package T2454.Chandan_Bansal.BE_Project1.adapter;

import T2454.Chandan_Bansal.BE_Project1.entity.Employee;

public class EmployeePostRequestAdapter extends Employee {
    private String depName;

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "EmployeePostRequestAdapter{" +
                "depName='" + depName + '\'' +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", contact='" + getContact() + '\'' +
                ", department=" + getDepartment() +
                '}';
    }
}
