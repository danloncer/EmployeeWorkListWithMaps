package pro.sky.EmployeeWorkListWithMaps;

import java.util.Objects;

public class Employee {

    //Fields


    private final String firstName;
    private final String lastName;

    //Constructor

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    //Getters


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    //Override


    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}