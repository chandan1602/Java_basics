package T2454.Chandan_Bansal.BE_Project1.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(
        name="department",
        uniqueConstraints = @UniqueConstraint(
                name = "depTitle_unique",
                columnNames = "title"
        )
)
public class Department {
    @Id @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String depId;
    @Column(
            name = "title",
            nullable = false
    )
    private String title;

    public Department() {}
    public Department(String title) {
        this.title=title;
    }

    public String getTitle() {
        return title;
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

        public DepartmentBuilder setTitle(String title) {
            this.title = title;
            return this;
        }
        public Department getDepartment() {
            return new Department(title);
        }
    }
}
