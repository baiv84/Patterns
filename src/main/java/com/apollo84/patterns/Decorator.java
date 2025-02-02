package com.apollo84.patterns;

interface Employee {
    String doWork();
}

class EmployeeDecorator implements Employee {
    Employee employee;

    public EmployeeDecorator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String doWork() {
        return employee.doWork();
    }
}

class Manager implements Employee {
    @Override
    public String doWork() {
        return "Менеджер: выполняет  простые операции.\n";
    }
}

class Supervisor extends EmployeeDecorator {
    public Supervisor(Employee employee) {
        super(employee);
    }

    public String organisePeopleOfUnit() { return "Начальник отдела: организует работу сотрудников отдела.\n"; }

    @Override
    public String doWork() {
        return organisePeopleOfUnit() + super.doWork();
    }
}

class CompanyBoss extends EmployeeDecorator {
    public CompanyBoss(Employee employee) {
        super(employee);
    }

    public String controlCompany() { return "Директор: осуществляет общее руководство компанией.\n"; }

    @Override
    public String doWork() {
        return controlCompany() + super.doWork();
    }
}

final public class Decorator implements Demonstator {
    @Override
    public void demonstrate() {
        System.out.println("\n***********************\nПАТТЕРН - ДЕКОРАТОР\n***********************\n");
        Employee employee = new EmployeeDecorator(new CompanyBoss(new Supervisor(new Manager())));
        String message = employee.doWork();
        System.out.println(message);
    }
}
