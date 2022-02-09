package T2454.Chandan_Bansal.BE_Project1.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(
        name="employees",
        uniqueConstraints = @UniqueConstraint(
                name="email_unique",
                columnNames = "email_address"
        )
)
public class Employee {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String employeeCode;
    @Column(
            name="full_name",
            nullable = false
    )
    private String name;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String email;
    @Column(
            name="Contact_Number",
            length = 10
    )
    private String contact;

    @ManyToOne(
            cascade = CascadeType.MERGE
    )
    @JoinColumn(
            name = "department_Id",
            referencedColumnName = "depId"
    )
    private Department department;

    public Employee() {
    }

    public Employee(String name, String email, String contact, Department department) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getContact() {
        return contact;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeCode='" + employeeCode + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", contact='" + contact + '\'' +
                ", department=" + department +
                '}';
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    public static class EmployeeBuilder {
        private String employeeCode;
        private String name;
        private String email;
        private String contact;
        private Department department;

        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public EmployeeBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public EmployeeBuilder setContact(String contact) {
            this.contact = contact;
            return this;
        }

        public EmployeeBuilder setDepartment(Department department) {
            this.department = department;
            return this;
        }

        public Employee getEmployee() {
            return new Employee(name, email, contact, department);
        }


    }

}
