package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BurgerReceiptParameterizedTest {

    private final String bunName;
    private final float bunPrice;
    private final String[] ingredientNames;
    private final IngredientType[] ingredientTypes;
    private final float[] ingredientPrices;
    private final float expectedPrice;

    @SuppressWarnings("unused")
    public BurgerReceiptParameterizedTest(String description, String bunName, float bunPrice,
                                          String[] ingredientNames, IngredientType[] ingredientTypes,
                                          float[] ingredientPrices, float expectedPrice) {
        this.bunName = bunName;
        this.bunPrice = bunPrice;
        this.ingredientNames = ingredientNames;
        this.ingredientTypes = ingredientTypes;
        this.ingredientPrices = ingredientPrices;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> getReceiptTestData() {
        return Arrays.asList(new Object[][] {
                {"No ingredients", "black bun", 100.0f,
                        new String[0], new IngredientType[0], new float[0], 200.0f},
                {"One filling", "black bun", 100.0f,
                        new String[]{"cutlet"}, new IngredientType[]{IngredientType.FILLING},
                        new float[]{100.0f}, 300.0f},
                {"Two fillings", "black bun", 100.0f,
                        new String[]{"cutlet", "dinosaur"},
                        new IngredientType[]{IngredientType.FILLING, IngredientType.FILLING},
                        new float[]{100.0f, 200.0f}, 500.0f},
                {"One sauce", "black bun", 100.0f,
                        new String[]{"hot sauce"},
                        new IngredientType[]{IngredientType.SAUCE},
                        new float[]{100.0f}, 300.0f}
        });
    }

    private Burger createBurgerWithIngredients() {
        Burger burger = new Burger();
        Bun bun = new Bun(bunName, bunPrice);
        burger.setBuns(bun);
        for (int i = 0; i < ingredientNames.length; i++) {
            Ingredient ingredient = new Ingredient(
                    ingredientTypes[i],
                    ingredientNames[i],
                    ingredientPrices[i]
            );
            burger.addIngredient(ingredient);
        }
        return burger;
    }

    @Test
    public void testReceiptContainsBunName() {
        Burger burger = createBurgerWithIngredients();
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain bun name", receipt.contains(bunName));
    }

    @Test
    public void testReceiptContainsPriceLabel() {
        Burger burger = createBurgerWithIngredients();
        String receipt = burger.getReceipt();
        assertTrue("Receipt should contain Price label", receipt.contains("Price:"));
    }

    @Test
    public void testReceiptPriceIsCorrect() {
        Burger burger = createBurgerWithIngredients();
        float calculatedPrice = burger.getPrice();
        assertEquals("Price should be correct", expectedPrice, calculatedPrice, 0.001f);
    }

    @Test
    public void testReceiptPriceMatchesExpected() {
        Burger burger = createBurgerWithIngredients();
        String receipt = burger.getReceipt();
        float extractedPrice = BaseBurgerTest.extractPriceFromReceipt(receipt);
        assertEquals("Price in receipt should match expected",
                expectedPrice, extractedPrice, 0.001f);
    }

    @Test
    public void testReceiptContainsIngredientNames() {
        if (ingredientNames.length == 0) {
            return;
        }

        Burger burger = createBurgerWithIngredients();
        String receipt = burger.getReceipt();

        for (String ingredientName : ingredientNames) {
            assertTrue("Receipt should contain " + ingredientName,
                    receipt.contains(ingredientName));
        }
    }
}