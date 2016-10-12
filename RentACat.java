import java.util.*;

public class RentACat {

    private List<Cat> cats;
    private List<Customer> customers;

    public RentACat(List<Cat> cats, List<Customer> customers) {
        this.cats = cats;
        this.customers = customers;
    }

    public String getCatListString() {
        StringBuilder sb = new StringBuilder();
        for (Cat cat : cats) {
            if (!cat.getRented()) {
                sb.append(cat + "\n");
            }
        }
        return sb.toString();
    }

    public Cat getCat(int id) {
        for (Cat cat : cats) {
            if (cat.getId() == id) {
                return cat;
            }
        }
        return null;
    }

    public Customer getCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public Cat promptForCat(Scanner sc, String prompt) {
        Cat cat = null;
        while (cat == null) {
            System.out.print(prompt);
            try {
                cat = getCat(Integer.parseInt(sc.nextLine()));
            } catch (NumberFormatException nfe) {
                cat = null;
            }
            if (cat == null) {
                System.out.println("Invalid cat ID");
            }
        }
        return cat;
    }

    public Customer promptForCustomer(Scanner sc, String prompt) {
        Customer customer = null;
        while (customer == null) {
            System.out.print(prompt);
            try {
                customer = getCustomer(Integer.parseInt(sc.nextLine()));
            } catch (NumberFormatException nfe) {
                customer = null;
            }
            if (customer == null) {
                System.out.println("That customer doesn't exist");
            }
        }
        return customer;
    }

    public static void main(String[] args) {
        boolean keepRunning = true;
        Customer customer;
        Cat cat;
        int customerId;
        Scanner sc = new Scanner(System.in);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "Jennyanydots", 200));
        cats.add(new Cat(2, "Old Deuteronomy", 250));
        cats.add(new Cat(3, "Mistoffelees", 500));
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(200, "Lakshmi Singh"));
        customers.add(new Customer(201, "Ari Shapiro"));
        RentACat rac = new RentACat(cats, customers);


        while (keepRunning) {
            System.out.print("Option [1,2,3,4] > ");
            String input = sc.nextLine();

            switch (input) {
            case "1":
                System.out.println("Cats for Rent");
                System.out.println(rac.getCatListString());
                break;

            case "2":
                customer = rac.promptForCustomer(sc, "Customer ID > ");
                cat = rac.promptForCat(sc, "Rent which cat? > ");
                if (cat.rentCat(customer.getName())) {
                    System.out.printf("%s has been rented to Customer %s.%n", cat.getName(), customer.getName());
                } else {
                    System.out.printf("Sorry, %s is not here!%n", cat.getName());
                }
                break;

            case "3":
                cat = rac.promptForCat(sc, "Return which cat? > ");
                if (cat.returnCat()) {
                    System.out.printf("%s has paid $%.2f.%n", cat.getOwner(), cat.getRentalRate());
                    System.out.printf("Welcome back, %s!%n", cat.getName());
                } else {
                    System.out.printf("%s is not rented.%n", cat.getName());
                }
                break;

            case "4":
                keepRunning = false;
                break;
            }
        }
        System.out.println("Closing up shop for the day!");
    }
}