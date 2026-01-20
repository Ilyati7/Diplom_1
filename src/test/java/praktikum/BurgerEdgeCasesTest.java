package praktikum;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

/**
 * Tests for edge cases and error handling.
 */
public class BurgerEdgeCasesTest extends BaseBurgerTest {

    @Test
    public void testGetReceiptWithEmptyBurgerIsNotNull() {
        burger.setBuns(blackBun);
        String receipt = burger.getReceipt();
        assertNotNull("Receipt should not be null", receipt);
    }

    @Test
    public void testGetReceiptWithEmptyBurgerIsNotEmpty() {
        burger.setBuns(blackBun);
        String receipt = burger.getReceipt();
        assertFalse("Receipt should not be empty", receipt.isEmpty());
    }

    @Test
    public void testReceiptWithEmptyBurgerContainsBunName() {
        burger.setBuns(blackBun);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain bun name", receipt.contains("black bun"));
    }

    @Test
    public void testReceiptWithEmptyBurgerPriceIsCorrect() {
        burger.setBuns(blackBun);
        String receipt = burger.getReceipt();
        float extractedPrice = extractPriceFromReceipt(receipt);
        assertEquals("Price should be 200 for bun only", 200.0f, extractedPrice, 0.001f);
    }

    @Test
    public void testMoveIngredientWithSingleElement() {
        burger.addIngredient(cutlet);
        burger.moveIngredient(0, 0);
        assertEquals("Should remain one element", 1, burger.ingredients.size());
        assertEquals("Element should stay in place", cutlet, burger.ingredients.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientWithInvalidFromIndex() {
        burger.addIngredient(cutlet);
        burger.moveIngredient(2, 0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testMoveIngredientWithInvalidToIndex() {
        burger.addIngredient(cutlet);
        burger.moveIngredient(0, 2);
    }

    @Test
    public void testPriceCalculationAccuracy() {
        burger.setBuns(whiteBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(sourCream);
        float calculatedPrice = burger.getPrice();
        float expectedPrice = 700.0f;
        assertEquals("Price should be calculated accurately",
                expectedPrice, calculatedPrice, 0.000001f);
    }

    @Test
    public void testReceiptLineSeparatorConsistency() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain line separators",
                receipt.contains("\n") || receipt.contains("\r\n"));
    }

    @Test
    public void testAddMultipleIngredientsAndVerifyOrder() {
        burger.setBuns(blackBun);
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.addIngredient(hotSauce);

        String receipt = burger.getReceipt();
        List<String> ingredientLines = extractIngredientLinesFromReceipt(receipt);

        List<String> expected = Arrays.asList(
                "= filling cutlet =",
                "= filling dinosaur =",
                "= sauce hot sauce ="
        );

        assertEquals("Ingredient lines in receipt are not in expected order",
                expected, ingredientLines);
    }
}
