package praktikum;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Tests for basic Burger class methods.
 * Tests basic functionality without parameterization.
 */
public class BurgerCoreTest extends BaseBurgerTest {

    @Test
    public void testSetBunsIsNotNull() {
        burger.setBuns(blackBun);
        assertNotNull("Bun should be set", burger.bun);
    }

    @Test
    public void testSetBunsNameMatches() {
        burger.setBuns(blackBun);
        assertEquals("Bun name should match", "black bun", burger.bun.getName());
    }

    @Test
    public void testAddIngredientIncreasesListSize() {
        int initialSize = burger.ingredients.size();
        burger.addIngredient(cutlet);
        assertEquals("Ingredients list size should increase by 1",
                initialSize + 1, burger.ingredients.size());
    }

    @Test
    public void testAddIngredientContainsAddedIngredient() {
        burger.addIngredient(cutlet);
        assertTrue("List should contain added ingredient",
                burger.ingredients.contains(cutlet));
    }

    @Test
    public void testRemoveIngredientDecreasesListSize() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        int initialSize = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals("After removal should decrease by 1",
                initialSize - 1, burger.ingredients.size());
    }

    @Test
    public void testRemoveIngredientRemovesCorrectIngredient() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.removeIngredient(0);
        assertFalse("Removed ingredient should not be present",
                burger.ingredients.contains(cutlet));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveIngredientWithInvalidIndexThrowsException() {
        burger.addIngredient(cutlet);
        burger.removeIngredient(5);
    }

    @Test
    public void testMoveIngredientChangesPositionsCorrectly() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.addIngredient(sausage);
        burger.moveIngredient(2, 0);
        List<Ingredient> expected = Arrays.asList(sausage, cutlet, dinosaur);
        assertEquals("Ingredients order is wrong", expected, burger.ingredients);
    }

    @Test
    public void testGetPriceWithMultipleIngredients() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.addIngredient(hotSauce);
        float expectedPrice = 100.0f * 2 + 100.0f + 200.0f + 100.0f;
        assertEquals("Price should be calculated correctly",
                expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test(expected = NullPointerException.class)
    public void testGetPriceWithoutBunThrowsException() {
        burger.getPrice();
    }

    @Test
    public void testGetReceiptContainsBunName() {
        burger.setBuns(blackBun);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain bun name", receipt.contains("black bun"));
    }

    @Test
    public void testGetReceiptContainsCutletName() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain cutlet", receipt.contains("cutlet"));
    }

    @Test
    public void testGetReceiptContainsHotSauceName() {
        burger.setBuns(blackBun);
        burger.addIngredient(hotSauce);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain hot sauce", receipt.contains("hot sauce"));
    }

    @Test
    public void testGetReceiptContainsPriceLabel() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain Price label", receipt.contains("Price:"));
    }

    @Test
    public void testGetReceiptPriceIsCorrect() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(hotSauce);
        String receipt = burger.getReceipt();
        float extractedPrice = extractPriceFromReceipt(receipt);
        float expectedPrice = 400.0f;
        assertEquals("Price in receipt should be correct",
                expectedPrice, extractedPrice, 0.001f);
    }

    @Test
    public void testReceiptStructureWithTopBun() {
        burger.setBuns(blackBun);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should start with top bun",
                receipt.startsWith("(==== black bun ====)"));
    }

    @Test
    public void testReceiptContainsFillingTypeLowerCase() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain filling type in lowercase",
                receipt.contains("filling"));
    }

    @Test
    public void testReceiptContainsSauceTypeLowerCase() {
        burger.setBuns(blackBun);
        burger.addIngredient(hotSauce);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain sauce type in lowercase",
                receipt.contains("sauce"));
    }

    @Test(expected = NullPointerException.class)
    public void testGetReceiptWithoutBunThrowsException() {
        burger.getReceipt();
    }
}