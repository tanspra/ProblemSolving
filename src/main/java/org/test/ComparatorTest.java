package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorTest {
    public static void main(String[] args) {
        List<Employee> employeeList  = new ArrayList<>();
       Employee shyam= new Employee(10,"shyam");
       Employee ram= new Employee(2,"ram");
       Employee ramesh = new Employee(5, "ramesh");
       employeeList.add(shyam);
       employeeList.add(ram);
       employeeList.add(ramesh);

       Collections.sort(employeeList, (e1,e2)->{
           return e1.empId- e2.empId;
       });
       employeeList.forEach(System.out::println);
    }

    private static class Employee{
        private int empId;
        private String empName;

        private Employee(int empId, String empName){
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
        public String toString() {
            return "Employee{" +
                    "empId=" + empId +
                    ", empName='" + empName + '\'' +
                    '}';
        }
    }
}
