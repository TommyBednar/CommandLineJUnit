public class Cat {

    private int id;
    private String name;
    private String owner;
    private double rentalRate;
    private boolean rented;


    public Cat(int id, String name, double rentalRate) {
        this.id = id;
        this.name = name;
        this.rentalRate = rentalRate;
        this.rented = false;
        this.owner = null;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getRented() {
        return rented;
    }

    public String getOwner() {
        return owner;
    }

    public boolean rentCat(String customerName) {
        if (rented) {
            return false;
        } else {
            owner = customerName;
            rented = true;
            return true;
        }
    }

    public boolean returnCat() {
        if (rented) {
            rented = false;
            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        return String.format("ID %d. %s: $%.2f / day", id, name, rentalRate);
    }
}