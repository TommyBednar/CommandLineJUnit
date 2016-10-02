import java.util.*;

public class RentACat {

    private static Scanner sc = new Scanner(System.in);

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

    private void listCats() {
        System.out.println("Cats for Rent");
        System.out.println(getCatListString());
    }

    private void rentCat() {
        int customerId, catId;
        Customer customer;
        Cat cat;

        while (true) {
            System.out.print("Customer ID > ");
            try {
                customerId = Integer.parseInt(sc.nextLine());
                customer = getCustomer(customerId);
                if (customer != null) {
                    break;
                } else {
                    System.out.println("That customer doesn't exist");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("That customer doesn't exist");
            }
        }
        while (true) {
            System.out.println("Rent which cat? > ");
            try {
                catId = Integer.parseInt(sc.nextLine());
                cat = getCat(catId);
                if (cat != null) {
                    if (cat.rentCat(customer.getName())) {
                        System.out.printf("%s has been rented to Customer %s.",
                            cat.getName(), customer.getName());
                        break;
                    } else {
                        System.out.printf("Sorry, %s is not here!%n", cat.getName());
                    }
                } else {
                    System.out.println("Invalid cat ID");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid cat ID");
            }
        }
    }

    private void returnCat() {
        int catId;
        Cat cat;

        while (true) {
            System.out.println("Return which cat? > ");
            try {
                catId = Integer.parseInt(sc.nextLine());
                cat = getCat(catId);
                if (cat != null) {
                    if (cat.returnCat()) {
                        System.out.printf("%s has paid $%.2f.%n",
                            cat.getOwner(), cat.getRentalRate());
                        System.out.printf("Welcome back, %s!%n",
                            cat.getName());
                        break;
                    } else {
                        System.out.printf("%s is not rented.%n", cat.getName());
                    }
                } else {
                    System.out.println("Invalid cat ID");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid cat ID");
            }
        }
    }


    private void quit() {
        System.out.println("Closing up shop for the day!");
        System.exit(0);
    }

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "Jennyanydots", 200));
        cats.add(new Cat(2, "Old Deuteronomy", 250));
        cats.add(new Cat(3, "Mistoffelees", 500));
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(200, "Lakshmi Singh"));
        customers.add(new Customer(201, "Ari Shapiro"));
        RentACat rac = new RentACat(cats, customers);


        while (true) {
            System.out.print("Option [1,2,3,4] > ");
            String input = sc.nextLine();

            switch (input) {
            case "1":
                rac.listCats();
                break;
            case "2":
                rac.rentCat();
                break;
            case "3":
                rac.returnCat();
                break;
            case "4":
                rac.quit();
                break
;           }
        }
    }
}