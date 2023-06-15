import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class TestIngredient {
    IngredientType type;
    String name;
    float price;

    public TestIngredient(IngredientType type, String name,float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{{IngredientType.SAUCE, "Тысяча островов", 5.5F}, {IngredientType.FILLING, "Рваная говядина", 66.6F}};
    }
        @Test
        public void testGetName() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals(name, ingredient.getName());
        }

        @Test
        public void testGetPrice() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals(price, ingredient.getPrice(), 0.0f);
        }
        @Test
        public void testGetType() {
            Ingredient ingredient = new Ingredient(type, name, price);
            assertEquals(type, ingredient.getType());
        }
}
