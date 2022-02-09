package T2454.Chandan_Bansal.BE_Project1.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Entity
@Table(
        name="employees",
        uniqueConstraints = @UniqueConstraint(
                name="email_unique",
                columnNames = "email_address"
        )
)
public class Employee {
    @Id
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

    public Employee(String id, String name, String email, String contact, Department department) {
        this.employeeCode = id;
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

        public static String toHexString(byte[] hash) {
            BigInteger num  = new BigInteger(1, hash);
            StringBuilder hexString  = new StringBuilder(num.toString(16));
            while (hexString.length() < 32)
            {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        }

        public Employee getEmployee() {
            try {
            return new Employee(toHexString(
                    MessageDigest.getInstance("SHA-256").
                            digest(this.email.getBytes(StandardCharsets.UTF_8))),
                    name, email, contact, department);
            } catch(Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }


    }

}
