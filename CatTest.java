import org.junit.Test;
import static org.junit.Assert.*;


public class CatTest {

    @Test
    public void testGetters() {
        Cat garfield = new Cat(2, "Garfield", 9.99);
        assertEquals(garfield.getId(), 2);
        assertEquals(garfield.getName(), "Garfield");
        assertEquals(garfield.getRentalRate(), 9.99, 1E-9);
        assertFalse(garfield.getRented());
        assertNull(garfield.getOwner());
    }

    @Test
    public void testRentOnce() {
         Cat garfield = new Cat(2, "Garfield", 9.99);
         assertTrue(garfield.rentCat("Tommy"));
         assertEquals(garfield.getOwner(), "Tommy");
         assertTrue(garfield.getRented());
    }

    @Test
    public void testRentTwice() {
         Cat garfield = new Cat(2, "Garfield", 9.99);
         garfield.rentCat("Tommy");
         assertFalse(garfield.rentCat("Billy"));
    }

    @Test
    public void testReturnOnce() {
        Cat garfield = new Cat(2, "Garfield", 9.99);
        garfield.rentCat("Tommy");
        assertTrue(garfield.returnCat());
        assertFalse(garfield.getRented());
        assertNull(garfield.getOwner());
    }

    @Test
    public void testReturnTwice() {
        Cat garfield = new Cat(2, "Garfield", 9.99);
        garfield.rentCat("Tommy");
        garfield.returnCat();
        assertFalse(garfield.returnCat());
    }

}
