package Exam;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {

    private static final Scanner sc = new Scanner(System.in);

    private static List<Employee> employeeList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = new HashMap<>();

    public static void main(String[] args) {

        while (true) {
            try {
                menu();
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> removeEmployee();
                    case 3 -> showAllEmployees();
                    case 4 -> sortEmployees();
                    case 5 -> searchEmployee();
                    case 6 -> salaryAnalytics();
                    case 7 -> {
                        System.out.println("Program finished.");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: Program is not true.");
            }
        }
    }

    private static void menu() {
        System.out.println("""
                
                1. Add employee
                2. Remove employee
                3. Show all employees
                4. Sort employees
                5. Search employee
                6. Salary analytics
                7. Exit
                """);
        System.out.print("Choose: ");
    }

    private static void addEmployee() {
        System.out.print("ID: ");
        int id = sc.nextInt();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Department: ");
        String department = sc.nextLine();

        System.out.print("Salary: ");
        double salary = Double.parseDouble(sc.nextLine());

        Employee emp = new Employee(id, name, department, salary);

        employeeList.add(emp);
        employeeMap.put(id, emp);

        System.out.println("Employee added successfully.");
    }

    private static void removeEmployee() {
        System.out.print("Enter ID to remove: ");
        int id = sc.nextInt();

        employeeMap.remove(id);

        System.out.println("Employee removed.");
    }

    private static void showAllEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees.");
            return;
        }
        employeeList.forEach(System.out::println);
    }

    private static void sortEmployees() {
        System.out.println("""
                1. By name (ASC)
                2. By salary (DESC)
                3. By department, then name (ASC)
                """);
        System.out.print("Choose: ");
        int choice = sc.nextInt();

        Comparator<Employee> comparator;

        switch (choice) {
            case 1 ->
                    comparator = Comparator.comparing(Employee::getName);
            case 2 ->
                    comparator = Comparator.comparing(Employee::getSalary).reversed();
            case 3 ->
                    comparator = Comparator
                            .comparing(Employee::getDepartment)
                            .thenComparing(Employee::getName);
            default -> {
                System.out.println("Invalid option.");
                return;
            }
        }

        employeeList.sort(comparator);
        System.out.println("Employees sorted.");
    }

    private static void searchEmployee() {
        System.out.println("""
            1. Search by ID
            2. Search by name (partial)
            """);
        System.out.print("Choose: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1 -> {
                System.out.print("ID: ");
                int id = Integer.parseInt(sc.nextLine());

                Employee emp = employeeMap.get(id);
                if (emp != null) {
                    System.out.println(emp);
                } else {
                    System.out.println("Employee not found.");
                }
            }

            case 2 -> {
                System.out.print("Name contains: ");
                String keyword = sc.nextLine().toLowerCase();
                boolean found = false;

                for (Employee e : employeeList) {
                    if (e.getName().toLowerCase().contains(keyword)) {
                        System.out.println(e);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No employees found.");
                }
            }

            default -> System.out.println("Invalid option.");
        }
    }


    private static void salaryAnalytics() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees.");
            return;
        }

        double sum = 0;
        double maxSalary = employeeList.get(0).getSalary();

        for (Employee e : employeeList) {
            double salary = e.getSalary();
            sum += salary;

            if (salary > maxSalary) {
                maxSalary = salary;
            }
        }

        double averageSalary = sum / employeeList.size();

        List<Employee> sorted = new ArrayList<>(employeeList);
        sorted.sort(Comparator.comparing(Employee::getSalary).reversed());

        System.out.println("Average salary: " + averageSalary);
        System.out.println("Highest salary: " + maxSalary);
        System.out.println("Top 3 salaries:");
    }
}

