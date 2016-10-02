import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class RentACatTest {

    public RentACat setup() {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat(1, "Jennyanydots", 200));
        cats.add(new Cat(2, "Old Deuteronomy", 250));
        cats.add(new Cat(3, "Mistoffelees", 500));
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer(200, "Lakshmi Singh"));
        customers.add(new Customer(201, "Ari Shapiro"));
        RentACat rac = new RentACat(cats, customers);
        return new RentACat(cats, customers);
    }

    @Test
    public void testCatListString() {
        RentACat rac = setup();
        assertEquals(rac.getCatListString(), "ID 1. Jennyanydots: $200.00 / day\n"
            + "ID 2. Old Deuteronomy: $250.00 / day\n"
            + "ID 3. Mistoffelees: $500.00 / day\n");
    }

    @Test
    public void testGetCat_validId() {
        RentACat rac = setup();
        assertNotNull(rac.getCat(1));
    }

    @Test
    public void testGetCat_invalidId() {
        RentACat rac = setup();
        assertNull(rac.getCat(7));
    }

    @Test
    public void testGetCustomer_validId() {
        RentACat rac = setup();
        assertNotNull(rac.getCustomer(200));
    }

    @Test
    public void testGetCustomer_invalidId() {
        RentACat rac = setup();
        assertNull(rac.getCustomer(100));
    }
}
