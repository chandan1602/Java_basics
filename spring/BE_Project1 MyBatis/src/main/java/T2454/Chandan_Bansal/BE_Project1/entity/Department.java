package T2454.Chandan_Bansal.BE_Project1.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Entity
@Table(
        name="department",
        uniqueConstraints = @UniqueConstraint(
                name = "depTitle_unique",
                columnNames = "title"
        )
)
public class Department implements Serializable {
    @Id
    private String depId;
    @Column(
            name = "title",
            nullable = false
    )
    private String title;

    public Department() {}
    public Department(String depId, String title) {
        this.depId = depId;
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public String getDepId() {
        return depId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId='" + depId + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static DepartmentBuilder builder() {
        return new DepartmentBuilder();
    }

    public static class DepartmentBuilder {
        private String title;
        private String depId;

        public static String toHexString(byte[] hash) {
            BigInteger num  = new BigInteger(1, hash);
            StringBuilder hexString  = new StringBuilder(num.toString(16));
            while (hexString.length() < 32)
            {
                hexString.insert(0, '0');
            }
            return hexString.toString();
        }

        public DepartmentBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        public Department getDepartment(){
            try {
                return new Department(toHexString(
                        MessageDigest.getInstance("SHA-256").
                        digest(this.title.getBytes(StandardCharsets.UTF_8))),
                        title);
//                return new Department(
//                        "D-",
//                        title
//                );
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
    }
}
