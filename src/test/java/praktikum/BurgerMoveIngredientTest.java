package praktikum;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Tests for ingredient movement functionality.
 */
public class BurgerMoveIngredientTest extends BaseBurgerTest {

    @Test
    public void testMoveIngredientFirstToLast() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.addIngredient(sausage);
        burger.moveIngredient(0, 2);
        List<Ingredient> expected = Arrays.asList(dinosaur, sausage, cutlet);
        assertEquals("Ingredients order is wrong after moving first to last",
                expected, burger.ingredients);
    }

    @Test
    public void testMoveIngredientLastToFirst() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.addIngredient(sausage);
        burger.moveIngredient(2, 0);
        List<Ingredient> expected = Arrays.asList(sausage, cutlet, dinosaur);
        assertEquals("Ingredients order is wrong after moving last to first",
                expected, burger.ingredients);
    }

    @Test
    public void testMoveIngredientMiddleToMiddle() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.addIngredient(sausage);
        burger.addIngredient(hotSauce);
        burger.moveIngredient(1, 2);
        List<Ingredient> expected = Arrays.asList(cutlet, sausage, dinosaur, hotSauce);
        assertEquals("Ingredients order is wrong after moving middle to middle",
                expected, burger.ingredients);
    }

    @Test
    public void testMoveIngredientSamePosition() {
        burger.addIngredient(cutlet);
        burger.addIngredient(dinosaur);
        burger.moveIngredient(0, 0);
        List<Ingredient> expected = Arrays.asList(cutlet, dinosaur);
        assertEquals("Ingredients order should not change when moving to same position",
                expected, burger.ingredients);
    }
}
