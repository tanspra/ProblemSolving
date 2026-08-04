package org.test;

import org.test.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        //Q1 Return employee names earning more than ₹1,00,000 sorted by salary descending.

       /* List<Employee> employees = List.of(
                new Employee(1L, "John", 120000, "IT"),
                new Employee(2L, "Alice", 90000, "HR"),
                new Employee(3L, "Bob", 150000, "IT"),
                new Employee(4L, "David", 80000, "Finance"),
                new Employee(5L, "Emma", 110000, "HR")
        );
        List<String> result = employees.stream()
                .filter(employee -> employee.getSalary() > 100000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(employee -> employee.getName())
                .toList();
        System.out.println(Arrays.toString(result.toArray()));*/

        //Q2 Return the highest-paid employee in every department.

  /*      List<Employee> employees = List.of(
                new Employee(1L, "John", 120000, "IT"),
                new Employee(2L, "Alice", 90000, "HR"),
                new Employee(3L, "Bob", 150000, "IT"),
                new Employee(4L, "David", 80000, "Finance"),
                new Employee(5L, "Emma", 110000, "HR"),
                new Employee(6L, "Sam", 95000, "Finance")
        );

       *//* Map<String, Employee> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                Optional::get)));
        result.forEach((key, value) -> System.out.println(key + "-> " + value.getName()));*//*

        //Return average salary of each department.
        Map<String, Double> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(result);*/

       /* List<Employee> employees = List.of(

                new Employee(1L, "John", 120000, "IT"),
                new Employee(2L, "Alice", 90000, "HR"),
                new Employee(3L, "John", 110000, "IT"),
                new Employee(4L, "Bob", 100000, "Finance"),
                new Employee(5L, "Alice", 95000, "HR")

        );

        Set<String> set = new HashSet<>();
        //Find Duplicate Employee Names
        List<String> result = employees.stream()
                .map(Employee::getName)
                .filter(name -> !set.add(name))
                .distinct()
                .collect(Collectors.toUnmodifiableList());
        System.out.println(result);*/

      /*  List<Employee> employees = List.of(
                new Employee(1, "John", 90000, "IT"),
                new Employee(2, "Alice", 70000, "HR"),
                new Employee(3, "Bob", 120000, "IT"),
                new Employee(4, "David", 95000, "Finance"),
                new Employee(5, "Emma", 120000, "IT"),
                new Employee(6, "Chris", 75000, "HR")
        );

        //If two employees have the same highest salary, choose the employee whose name comes first alphabetically.
        Map<String, Employee> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary).thenComparing(Comparator.comparing(Employee::getName)).reversed()),
                                Optional::get)));
        result.forEach((key, value) -> System.out.println(key + ": " + value.getName()));
*/

      /*  List<Employee> employees = List.of(
                new Employee(1, "John", 90000, "IT"),
                new Employee(2, "Alice", 70000, "HR"),
                new Employee(3, "Bob", 120000, "IT"),
                new Employee(4, "David", 95000, "Finance"),
                new Employee(5, "Emma", 120000, "IT"),
                new Employee(6, "Chris", 75000, "HR"),
                new Employee(7, "Tom", 110000, "Finance"),
                new Employee(8, "Jerry", 110000, "Finance")
        );*/
       /* Key = Department
        Value = Top 2 highest-paid employee names
        Sort by:
        1. Salary descending
        2. If salaries are equal, name ascending
        Return only employee names.*/

        /* employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                 .forEach((department, employee) -> {
                     List<String> names = employee.stream()
                             .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                                     .thenComparing(Comparator.comparing(Employee::getName)))
                             .limit(2)
                             .map(Employee::getName)
                             .collect(Collectors.toUnmodifiableList());
                     System.out.println(department+"->"+names.toString());
                 });*/

      /*  employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                                                        .thenComparing(Comparator.comparing(Employee::getName)))
                                                .limit(2)
                                                .map(Employee::getName)
                                                .collect(Collectors.toUnmodifiableList())

                                )
                        )
                );*/

       /* List<Employee> employees = List.of(
                new Employee(1, "John", 90000, "IT"),
                new Employee(2, "Alice", 70000, "HR"),
                new Employee(3, "Bob", 120000, "IT"),
                new Employee(4, "David", 95000, "Finance"),
                new Employee(5, "Emma", 120000, "IT"),
                new Employee(6, "Chris", 75000, "HR"),
                new Employee(7, "Tom", 110000, "Finance"),
                new Employee(8, "Jerry", 110000, "Finance"),
                new Employee(9, "Mike", 105000, "Finance")
        );

       *//* Key = Department
        Value = Average salary of the top 3 highest-paid employees in that department.
        If a department has fewer than 3 employees, average all available employees.
                Round the average to 2 decimal places.
        Use Java Streams only.
        Avoid unnecessary traversals.*//*

        Map<String, Double> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors.toList(),
                                        list -> Math.round(
                                                list.stream()
                                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                                        .limit(3)
                                                        .collect(Collectors.averagingDouble(Employee::getSalary))
                                                *100.0
                                        )/100.0

                                )

                        )
                );

        result.forEach((k, v) -> System.out.println(k + ": " + v));*/

      /*  List<Employee> employees = List.of(
                new Employee(1, "John", 90000, "IT"),
                new Employee(2, "Alice", 70000, "HR"),
                new Employee(3, "Bob", 120000, "IT"),
                new Employee(4, "David", 95000, "Finance"),
                new Employee(5, "Emma", 120000, "IT"),
                new Employee(6, "Chris", 75000, "HR"),
                new Employee(7, "Tom", 110000, "Finance"),
                new Employee(8, "Jerry", 110000, "Finance"),
                new Employee(9, "Mike", 105000, "Finance"),
                new Employee(10, "Alex", 120000, "IT")
        );*/

        /*Key = Department
        Value = Number of employees whose salary is greater than the average salary of their own department.*/

       /* Map<String, Long> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> {
                                            double averageSalary = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
                                            return list.stream()
                                                    .filter(employee -> employee.getSalary() > averageSalary)
                                                    .count();
                                        }
                                )
                        )
                );

        result.forEach((key, value) -> System.out.println(key + ": " + value));
*/
       /* Key = Department
        Value = Second highest-paid employee in that department.
        If two employees have the same salary:
        Choose the one whose name comes first alphabetically.
        If a department has only one employee, return Optional.empty() for that department.*/

     /*   Map<String, Optional<Employee>> result = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.toList(),
                                list -> {
                                    Optional<Employee> first = list.stream()
                                            .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                                                    .thenComparing(Employee::getName))
                                            .skip(1)
                                            .findFirst();
                                    return first;
                                }
                        )
                ));*/

        List<Employee> employees = List.of(
                new Employee(1, "John", 90000, "IT"),
                new Employee(2, "Alice", 70000, "HR"),
                new Employee(3, "Bob", 120000, "IT"),
                new Employee(4, "David", 95000, "Finance"),
                new Employee(5, "Emma", 120000, "IT"),
                new Employee(6, "Chris", 75000, "HR"),
                new Employee(7, "Tom", 110000, "Finance"),
                new Employee(8, "Jerry", 110000, "Finance"),
                new Employee(9, "Mike", 105000, "Finance"),
                new Employee(10, "Alex", 120000, "IT")
        );

      /*  Return:

        Map<Boolean, Map<String, List<String>>>

        Where:

        First Level

        Partition employees into:

        true → Salary >= 100000
        false → Salary < 100000
        Second Level

        Within each partition:

        Group by department.
                Value

        For each department:

        Return employee names sorted alphabetically.*/

        Map<Boolean, Map<String, List<String>>> result = employees.stream()
                .collect(Collectors.partitioningBy(emp -> emp.getSalary() >= 100000,
                                Collectors.groupingBy(Employee::getDepartment,
                                        Collectors.mapping(Employee::getName,
                                                Collectors.collectingAndThen(Collectors.toList(),
                                                        list -> {
                                                            list.sort(String::compareTo);
                                                            return list;
                                                        }
                                                )
                                        )

                                )
                        )
                );

    }
}
