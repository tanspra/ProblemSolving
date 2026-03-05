package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableTest {
    public static void main(String[] args) {
//        Employee shyam= new Employee(1,"shyam");
//        Employee ram= new Employee(2,"ram");
//        System.out.println(shyam.compareTo(ram));
        List<Employee> employeeList = new ArrayList<>();
        Employee shyam = new Employee(10, "shyam");
        Employee ram = new Employee(2, "ram");
        Employee ramesh = new Employee(5, "ramesh");
        employeeList.add(shyam);
        employeeList.add(ram);
        employeeList.add(ramesh);

        Collections.sort(employeeList);

        employeeList.forEach(System.out::println);

    }

    private static class Employee implements Comparable<Employee> {
        private final int empId;
        private final String empName;

        private Employee(int empId, String empName) {
            this.empId = empId;
            this.empName = empName;
        }

        public int getEmpId() {
            return empId;
        }

        public String getEmpName() {
            return empName;
        }

        @Override
        public int compareTo(Employee employee) {
            return this.empId - employee.getEmpId();
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", empName='" + empName + '\'' +
                    '}';
        }
    }
}
