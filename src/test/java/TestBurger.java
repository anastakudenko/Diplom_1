import org.junit.Test;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBurger {
    @Test
    public void testSetBun() {
        Burger blackBurger = new Burger();
        String nameBun = "беленькая";
        float priceBun = 22.8F;
        Bun whiteBun = new Bun(nameBun, priceBun);
        blackBurger.setBuns(whiteBun);
        assertEquals(whiteBun, blackBurger.bun);
    }

    @Test
    public void testAddIngredient() {
        Burger blackBurger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "жиденький", 0.1F);
        blackBurger.addIngredient(ingredient);
        assertTrue(blackBurger.ingredients.contains(ingredient));
    }

    @Test
    public void testRemoveIngredient() {
        Burger blackBurger = new Burger();
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "жиденький", 0.1F);
        blackBurger.addIngredient(ingredient);
        blackBurger.removeIngredient(0);
        assertFalse(blackBurger.ingredients.contains(ingredient));
    }

    @Test
    public void testMoveIngredient() {
        Burger blackBurger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "жиденький", 0.1F);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "тверденький", 1.5F);
        blackBurger.addIngredient(ingredient1);
        blackBurger.addIngredient(ingredient2);
        assertEquals(blackBurger.ingredients.get(0), ingredient1);
        assertEquals(blackBurger.ingredients.get(1), ingredient2);
        blackBurger.moveIngredient(0, 1);
        assertEquals(blackBurger.ingredients.get(0), ingredient2);
        assertEquals(blackBurger.ingredients.get(1), ingredient1);
    }
    @Test
    public void testGetPrice() {
        Burger blackBurger = new Burger();
        float priceIng1 = 0.1F;
        float priceIng2 = 1.5F;
        float priceBun = 22.8F;
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "жиденький",  priceIng1);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "тверденький", priceIng2);
        Bun whiteBun = new Bun("тепленькая", priceBun);
        blackBurger.setBuns(whiteBun);
        blackBurger.addIngredient(ingredient1);
        blackBurger.addIngredient(ingredient2);
        float expectedPrice = priceBun * 2 + priceIng2 + priceIng1;
        assertEquals(expectedPrice,blackBurger.getPrice(),0.0F);
    }

    @Test
    public void testGetReceipt() {
        Burger blackBurger = new Burger();
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "жиденький",  0.1F);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "тверденький", 1.1F);
        Bun whiteBun = new Bun("тепленькая", 0.5F);
        blackBurger.setBuns(whiteBun);
        blackBurger.addIngredient(ingredient1);
        blackBurger.addIngredient(ingredient2);
        System.out.println(blackBurger.getReceipt());
        String expectedReceipt = "(==== тепленькая ====)\n" +
                "= sauce жиденький =\n" +
                "= filling тверденький =\n" +
                "(==== тепленькая ====)\n" +
                "\n" +
                "Price: 2,200000\n";
        assertEquals(blackBurger.getReceipt(), expectedReceipt);
    }
}

