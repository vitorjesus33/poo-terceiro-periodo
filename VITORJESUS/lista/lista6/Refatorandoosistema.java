import java.util.ArrayList;
import java.util.List;

class Salesperson {
    private String name;
    private int age;
    private String store;
    private String city;
    private String neighborhood;
    private String street;
    private double baseSalary;
    private double[] salaryReceived;

    public Salesperson(String name, int age, String store, String city, String neighborhood, String street, double baseSalary) {
        this.name = name;
        this.age = age;
        this.store = store;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.baseSalary = baseSalary;
        this.salaryReceived = new double[3]; // Initialize salaryReceived array with 3 elements
    }

    public void presentse() {
        System.out.println("Name: " + name + ", Age: " + age + ", Store: " + store);
    }

    public double calculateMedia() {
        double sum = 0;
        for (double salary : salaryReceived) {
            sum += salary;
        }
        return sum / salaryReceived.length;
    }

    public double calculateBonus() {
        return baseSalary * 0.2;
    }

    public void setSalaryReceived(double[] salaryReceived) {
        this.salaryReceived = salaryReceived;
    }
}

class Customer {
    private String name;
    private int age;
    private String city;
    private String neighborhood;
    private String street;

    public Customer(String name, int age, String city, String neighborhood, String street) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
    }

    public void presentse() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Store {
    private String tradeName;
    private String companyName;
    private String cpnj;
    private String city;
    private String neighborhood;
    private String street;
    private List<Salesperson> sellers;
    private List<Customer> customers;

    public Store(String tradeName, String companyName, String cpnj, String city, String neighborhood, String street) {
        this.tradeName = tradeName;
        this.companyName = companyName;
        this.cpnj = cpnj;
        this.city = city;
        this.neighborhood = neighborhood;
        this.street = street;
        this.sellers = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void countCustomers() {
        System.out.println("Number of customers: " + customers.size());
    }

    public void countSellers() {
        System.out.println("Number of sellers: " + sellers.size());
    }

    public void presentse() {
        System.out.println("Trade Name: " + tradeName + ", CNPJ: " + cpnj + ", Address: " + city + ", " + neighborhood + ", " + street);
    }

    public void addSeller(Salesperson seller) {
        sellers.add(seller);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }
}

public class TestObjects {
    public static void main(String[] args) {
        Store store = createStore();
        Salesperson seller1 = createSalesperson("John", 25, "Myy Plant", "New York", "Manhattan", "5th Avenue", 5000);
        Salesperson seller2 = createSalesperson("Jane", 30, "Myy Plant", "New York", "Manhattan", "5th Avenue", 6000);
        Customer customer = createCustomer("Bob", 35, "New York", "Manhattan", "5th Avenue");

        store.addSeller(seller1);
        store.addSeller(seller2);
        store.addCustomer(customer);

        store.presentse();
        store.countSellers();
        store.countCustomers();

        seller1.presentse();
        seller1.setSalaryReceived(new double[]{4000, 5000, 6000});
        System.out.println("Average salary: " + seller1.calculateMedia());
        System.out.println("Bonus: " + seller1.calculateBonus());

        customer.presentse();
    }

    public static Store createStore() {
        return new Store("Myy Plant", "Myy Plant Company", "1234567890", "New York", "Manhattan", "5th Avenue");
    }

    public static Salesperson createSalesperson(String name, int age, String store, String city, String neighborhood, String street, double baseSalary) {
        return new Salesperson(name, age, store, city, neighborhood, street, baseSalary);
    }

    public static Customer createCustomer(String name, int age, String city, String neighborhood, String street) {
        return new Customer(name, age, city, neighborhood, street);
    }
}