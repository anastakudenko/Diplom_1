import org.junit.Test;
import praktikum.IngredientType;
import static org.junit.Assert.assertNotNull;

public class TestIngredientType {
    @Test
    public void fillingNotNull() {
        assertNotNull("В ингредиентах нет начинки", IngredientType.valueOf("FILLING"));
    }

    @Test
    public void sauceNotNull() {
        assertNotNull("В ингредиентах нет соуса", IngredientType.valueOf("SAUCE"));
    }
}
