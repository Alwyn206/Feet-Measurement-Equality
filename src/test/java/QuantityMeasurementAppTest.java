import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testEquality_FeetToFeet_SameValue() {
        QuantityLength feet1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(feet1.equals(feet2), "1.0 ft should be equal to 1.0 ft");
    }

    @Test
    public void testEquality_InchToInch_SameValue() {
        QuantityLength inches1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength inches2 = new QuantityLength(1.0, LengthUnit.INCHES);
        assertTrue(inches1.equals(inches2), "1.0 inch should be equal to 1.0 inch");
    }

    @Test
    public void testEquality_FeetToInch_EquivalentValue() {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(feet.equals(inches), "1.0 ft should be equal to 12.0 inches");
    }

    @Test
    public void testEquality_InchToFeet_EquivalentValue() {
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(inches.equals(feet), "12.0 inches should be equal to 1.0 ft");
    }

    @Test
    public void testEquality_FeetToFeet_DifferentValue() {
        QuantityLength feet1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength feet2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(feet1.equals(feet2), "1.0 ft should not be equal to 2.0 ft");
    }

    @Test
    public void testEquality_InchToInch_DifferentValue() {
        QuantityLength inches1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength inches2 = new QuantityLength(2.0, LengthUnit.INCHES);
        assertFalse(inches1.equals(inches2), "1.0 inch should not be equal to 2.0 inch");
    }

    @Test
    public void testEquality_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        }, "Null unit should throw IllegalArgumentException");
    }

    @Test
    public void testEquality_SameReference() {
        QuantityLength quantity = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(quantity.equals(quantity), "A Quantity object should be equal to itself");
    }

    @Test
    public void testEquality_NullComparison() {
        QuantityLength quantity = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(quantity.equals(null), "A Quantity object should not be equal to null");
    }

    @Test
    public void testEquality_NonNumericInput() {
        QuantityLength quantity = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(quantity.equals("1.0"), "A Quantity object should not be equal to a String");
    }
}
