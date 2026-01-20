package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

/**
 * Parameterized tests for price calculation.
 * Tests different ingredient combinations.
 */
@RunWith(Parameterized.class)
public class BurgerPriceParameterizedTest {

    private final String description;
    private final List<Ingredient> ingredients;
    private final Bun bun;
    private final float expectedPrice;

    @SuppressWarnings("unused")
    public BurgerPriceParameterizedTest(String description, List<Ingredient> ingredients,
                                        Bun bun, float expectedPrice) {
        this.description = description;
        this.ingredients = ingredients;
        this.bun = bun;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> getPriceTestData() {
        return Arrays.asList(new Object[][] {
                {"Bun only",
                        Collections.emptyList(),
                        new Bun("black bun", 100.0f),
                        200.0f},
                {"Bun + cutlet",
                        Collections.singletonList(new Ingredient(IngredientType.FILLING, "cutlet", 100.0f)),
                        new Bun("black bun", 100.0f),
                        300.0f},
                {"Bun + cutlet + dinosaur",
                        Arrays.asList(
                                new Ingredient(IngredientType.FILLING, "cutlet", 100.0f),
                                new Ingredient(IngredientType.FILLING, "dinosaur", 200.0f)
                        ),
                        new Bun("black bun", 100.0f),
                        500.0f},
                {"Bun + cutlet + dinosaur + sausage",
                        Arrays.asList(
                                new Ingredient(IngredientType.FILLING, "cutlet", 100.0f),
                                new Ingredient(IngredientType.FILLING, "dinosaur", 200.0f),
                                new Ingredient(IngredientType.FILLING, "sausage", 300.0f)
                        ),
                        new Bun("black bun", 100.0f),
                        800.0f},
                {"Bun + cutlet + dinosaur + sausage + sour cream",
                        Arrays.asList(
                                new Ingredient(IngredientType.FILLING, "cutlet", 100.0f),
                                new Ingredient(IngredientType.FILLING, "dinosaur", 200.0f),
                                new Ingredient(IngredientType.FILLING, "sausage", 300.0f),
                                new Ingredient(IngredientType.SAUCE, "sour cream", 200.0f)
                        ),
                        new Bun("black bun", 100.0f),
                        1000.0f}
        });
    }

    @Test
    public void testPriceCalculationForDifferentIngredientCombinations() {
        Burger burger = new Burger();
        burger.setBuns(bun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        assertEquals("Price calculation is incorrect for: " + description,
                expectedPrice, burger.getPrice(), 0.001f);
    }
}