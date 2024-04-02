package learnjava_17;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Tom", 23, 5600));
        list.add(new Employee("Jerry", 13, 3600));
        list.add(new Employee("Mike", 43, 4600));
        list.add(new Employee("Jack", 33, 7600));
        list.add(new Employee("Lily", 53, 9600));
        list.add(new Employee("Lucy", 63, 2600));
        list.add(new Employee("Lily", 53, 9600));
        return list;
    }
}
