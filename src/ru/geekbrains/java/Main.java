package ru.geekbrains.java;

public class Main {

    static Employee[] employees = new Employee[5];

    public static void main(String[] args) {
        initEmployees();

        printEmployeesFortyYearsOld(40);
    }

    private static void initEmployees() {
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "89231231233", 30000, 30);
        employees[1] = new Employee("Petrov Petr", "Developer", "petrp@mailbox.com", "89211231242", 25000, 29);
        employees[2] = new Employee("Sidorov Piter", "Director", "sid@mailbox.com", "89230031233", 29000, 42);
        employees[3] = new Employee("Rykov Paul", "Engineer", "prykov@mailbox.com", "8923231233", 31000, 43);
        employees[4] = new Employee("Osadchya Marina", "Designer", "osad@mailbox.com", "89232231233", 34000, 24);
    }

    private static void printEmployeesFortyYearsOld(int minAge) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > minAge) {
                employees[i].printInfo();
            }
        }
    }


}
