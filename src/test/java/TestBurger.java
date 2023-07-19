import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class TestBurger {
    private Burger blackBurger;

    public Bun getBunMock() {
        Bun createdBunMock = Mockito.mock(Bun.class);
        Mockito.when(createdBunMock.getPrice()).thenReturn(0.5f);
        Mockito.when(createdBunMock.getName()).thenReturn("беленькая");
        return createdBunMock;
    }

    public Ingredient getFirstIngredientMock() {
        Ingredient createdIngredientMock = Mockito.mock(Ingredient.class);
        Mockito.when(createdIngredientMock.getName()).thenReturn("мягкая");
        Mockito.when(createdIngredientMock.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(createdIngredientMock.getPrice()).thenReturn(10.43f);
        return createdIngredientMock;
    }

    public Ingredient getSecondIngredientMock() {
        Ingredient createdIngredientMock = Mockito.mock(Ingredient.class);
        Mockito.when(createdIngredientMock.getName()).thenReturn("жиденький");
        Mockito.when(createdIngredientMock.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(createdIngredientMock.getPrice()).thenReturn(0.88f);
        return createdIngredientMock;
    }

    @Before
    public void setUp() {
        blackBurger = new Burger();
    }

    @Test
    public void testSetBun() {
        Bun whiteBun = getBunMock();
        blackBurger.setBuns(whiteBun);
        assertEquals("Булочки не сопадают", whiteBun, blackBurger.bun);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredient = getFirstIngredientMock();
        blackBurger.addIngredient(ingredient);
        assertTrue("Ингредиент не добавлен", blackBurger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredient = getFirstIngredientMock();
        blackBurger.addIngredient(ingredient);
        blackBurger.removeIngredient(0);
        assertFalse("Ингредиент не удален", blackBurger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = getFirstIngredientMock();
        Ingredient ingredient2 = getSecondIngredientMock();
        blackBurger.addIngredient(ingredient1);
        blackBurger.addIngredient(ingredient1);
        blackBurger.moveIngredient(0, 1);
        assertEquals("Ингредиент не переместился", ingredient1, blackBurger.ingredients.get(1));

    }
    @Test
    public void testGetPrice() {
        Bun whiteBun = getBunMock();
        Ingredient ingredient1 = getFirstIngredientMock();
        Ingredient ingredient2 = getSecondIngredientMock();
        blackBurger.setBuns(whiteBun);
        blackBurger.addIngredient(ingredient1);
        blackBurger.addIngredient(ingredient2);
        float expectedPrice = whiteBun.getPrice() * 2 + ingredient1.getPrice() + ingredient2.getPrice();
        assertEquals("Стоимость не совпадает",expectedPrice,blackBurger.getPrice(),0.0F);
    }

    @Test
    public void testGetReceipt() {
        Bun whiteBun = getBunMock();
        Ingredient ingredient1 = getFirstIngredientMock();
        Ingredient ingredient2 = getSecondIngredientMock();
        blackBurger.setBuns(whiteBun);
        blackBurger.addIngredient(ingredient1);
        blackBurger.addIngredient(ingredient2);
        String expectedReceipt = "(==== беленькая ====)\n" +
                "= filling мягкая =\n" +
                "= sauce жиденький =\n" +
                "(==== беленькая ====)\n" +
                "\n" +
                "Price: 12,310000\n";
        assertEquals(blackBurger.getReceipt(), expectedReceipt);
    }
}

