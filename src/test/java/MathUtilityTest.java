import org.example.Utility.MathUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathUtilityTest {
    @Test
    @DisplayName("Test với giá trị biên dưới (n=1)")
    void testSumOddNumbers_WithLowerBoundary() {
        Assertions.assertEquals(1, MathUtility.sumOddNumbers(1));
    }

    @Test
    @DisplayName("Test với giá trị gần biên dưới (n=2)")
    void testSumOddNumbers_WithNearLowerBoundary() {
        Assertions.assertEquals(1, MathUtility.sumOddNumbers(2));
    }

    @Test
    @DisplayName("Test với một giá trị chẵn trong khoảng (n=10)")
    void testSumOddNumbers_WithEvenNumberInRange() {
        Assertions.assertEquals(25, MathUtility.sumOddNumbers(10));
    }

    @Test
    @DisplayName("Test với giá trị biên trên (n=1000)")
    void testSumOddNumbers_WithUpperBoundary() {
        Assertions.assertEquals(250000, MathUtility.sumOddNumbers(1000));
    }

    @Test
    @DisplayName("Test với đầu vào không hợp lệ (n=0)")
    void testSumOddNumbers_WithInvalidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            MathUtility.sumOddNumbers(0);
        });
    }
}
