package org.example;
public class Main {
    public static Employee[] employees = new Employee[10];

    public static void main(String[] args) {

        employees[0] = new Employee("плотникова", "Александра", "Георгиевна", "scientific", 57000);
        employees[1] = new Employee("Минина", "Аглая", "Ивановна", "economic", 65990);
        employees[2] = new Employee("Гордеев", "лев", "Олегович", "scientific", 34200);
        employees[3] = new Employee("Фролов", "Петр", "Геннадьевич", "economic", 123440);
        employees[4] = new Employee("Титов", "Илья", "Семёнович", "scientific", 91001);
        employees[5] = new Employee("Воробьева", "Малика", "Дмитриевна", "economic", 73495);
        employees[6] = new Employee("Морозов", "Артём", "Васильевич", "scientific", 80800);
        employees[7] = new Employee("Носов", "Иван", "Иванович", "economic", 62870);
        employees[8] = new Employee("Пугачев", "Савелий", "Тимофеевич", "economic", 54000);
        employees[9] = new Employee("Новиков", "Евгений", "Владиславович", "economic", 102340);

        System.out.println("Зарплата проиндексирована на: " + indexSalary(10) + "%.");

        System.out.println("Список сотрудников : ");
        for (Employee element : employees) {
            if (element != null) {
                System.out.println(element);
            }
        }

        System.out.println("Сумму затрат на зарплату по отделу \"Экономика\": "
                + (float) sumSalaryDepartment("economic"));

        System.out.println("Среднее значение зарплат по отделу \"Экономика\": "
                + (float) averageSalaryDepartment("economic"));

        System.out.println("Сумму затрат на зарплату по отделу \"Наука\": "
                + (float) sumSalaryDepartment("scientific"));

        System.out.println("Среднее значение зарплат по отделу \"Наука\": "
                + (float) averageSalaryDepartment("scientific"));

        System.out.println("Сумма затрат на зарплаты: " + salaryAllEmployees());

        int amountOfEmployees = 0;
        for (Employee item : employees) {
            if (item != null) {
                amountOfEmployees++;
            }
        }

        double average = salaryAllEmployees() / amountOfEmployees;
        System.out.println("Среднее значение зарплат: " + (float) average);


        System.out.println("Минимальная зарплата: " + employees[numberEmployeeMinSalary()].getSalary() +
                " у сотрудника - " + employees[numberEmployeeMinSalary()].getFio() + ".");


        System.out.println("Максимальная зарплата: " + employees[numberEmployeeMaxSalary()].getSalary() +
                " у сотрудника - " + employees[numberEmployeeMaxSalary()].getFio() + ".");


        double getEmloyeesUnderSalary = 100_000;
        System.out.println("Список сотрудников с зарплатой меньше : " + getEmloyeesUnderSalary);
        for (Employee value : employees) {
            if ((value != null) && (getEmloyeesUnderSalary > value.getSalary())) {
                System.out.println(value.getFio() + " " + value.getSalary() + " id" + value.getId());

            }
        }

        double getEmloyeesSalaryHigher = 100_000;
        System.out.println("Список сотрудников с зарплатой больше : " + getEmloyeesSalaryHigher);
        for (Employee employee : employees) {
            if ((employee != null) && (getEmloyeesSalaryHigher < employee.getSalary())) {
                System.out.println(employee.getFio() + " " + employee.getSalary() + " id" + employee.getId());
            }
        }
    }

    public static int numberEmployeeMinSalary() {
        double min = Integer.MAX_VALUE;
        int numberEmployeeMinSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getSalary() < min)) {
                min = employees[i].getSalary();
                numberEmployeeMinSalary = i;
            }
        }
        return numberEmployeeMinSalary;
    }

    public static int numberEmployeeMaxSalary() {
        double max = 0;
        int numberEmployeeMaxSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if ((employees[i] != null) && (employees[i].getSalary() > max)) {
                max = employees[i].getSalary();
                numberEmployeeMaxSalary = i;
            }
        }
        return numberEmployeeMaxSalary;
    }

    public static double salaryAllEmployees() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum;
    }

    public static double sumSalaryDepartment(String department) {
        double sumSalaryDepartment = 0;
        for (Employee employee : employees) {
            if (employee.getDepartment().equals(department)) {
                sumSalaryDepartment += employee.getSalary();
            }
        }
        return sumSalaryDepartment;
    }

    public static double averageSalaryDepartment(String department) {
        double amountOfEmployeeDepartment = 0;
        double sumSalaryDepartment = 0;
        for (Employee employee : employees) {
            if ((employee != null) && (employee.getDepartment().equals(department))) {
                sumSalaryDepartment += employee.getSalary();
                amountOfEmployeeDepartment++;
            }
        }
        return sumSalaryDepartment / amountOfEmployeeDepartment;
    }

    public static double indexSalary(double percent) {
        for (Employee employee : employees) {
            employee.setSalary((employee.getSalary() * percent / 100) + employee.getSalary());
        }
        return percent;
    }
}



