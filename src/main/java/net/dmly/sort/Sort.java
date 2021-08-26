package net.dmly.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String[] args) {

        Customer[] customers = {
                new Customer(43423, "Elizabeth", "Mann"),
                new Customer(10503, "Phil", "Gruber"),
                new Customer(61157, "Patrick", "Sonnenberg"),
                new Customer(28378, "Marina", "Metz"),
                new Customer(57299, "Caroline", "Albers")
        };

        List<Customer> customerList = Arrays.asList(customers);
        Collections.sort(customerList);


        Arrays.sort(customers);
        System.out.println(Arrays.toString(customers));


        Comparator<Customer> customerComparator = Comparator
                .comparing(Customer::getLastName)
                .thenComparing(Customer::getFirstName);

        Arrays.sort(customers, customerComparator);
        System.out.println(Arrays.toString(customers));

        customerList.sort(customerComparator);
    }
}

class Customer implements Comparable<Customer> {
    private long id;
    private String firstName;
    private String lastName;

    public Customer(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return Long.compare(this.id, o.id);
    }
}
