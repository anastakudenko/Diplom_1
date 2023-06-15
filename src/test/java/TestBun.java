import org.junit.Test;
import praktikum.Bun;
import static org.junit.Assert.assertEquals;

public class TestBun {
    String name = "whiteBun";
    float price = 10.2F;
    @Test
    public void testGetName() {
        Bun bun = new Bun(name, price);
        assertEquals(name, bun.getName());
    }

    @Test
    public void testGetPrice() {
        Bun bun = new Bun(name, price);
        assertEquals(price, bun.getPrice(), 0.0f);
    }
}


