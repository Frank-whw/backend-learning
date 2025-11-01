package bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//{"ID", "姓名", "部门", "职位", "薪资"}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private int id;
    private String name;
    private String department;
    private String position;
    private double salary;
}
