import org.junit.Test;
import static org.junit.Assert.*;


public class CustomerTest {

    @Test
    public void testGetters() {
        Customer tommy = new Customer(1, "Tommy");
        assertEquals(tommy.getId(), 1);
        assertEquals(tommy.getName(), "Tommy");
    }

}
