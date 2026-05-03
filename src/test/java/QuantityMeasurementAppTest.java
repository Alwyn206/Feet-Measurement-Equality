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

    @Test
    public void testEquality_YardToYard_SameValue() {
        QuantityLength yards1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength yards2 = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(yards1.equals(yards2), "1.0 yard should be equal to 1.0 yard");
    }

    @Test
    public void testEquality_YardToYard_DifferentValue() {
        QuantityLength yards1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength yards2 = new QuantityLength(2.0, LengthUnit.YARDS);
        assertFalse(yards1.equals(yards2), "1.0 yard should not be equal to 2.0 yards");
    }

    @Test
    public void testEquality_YardToFeet_EquivalentValue() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(yards.equals(feet), "1.0 yard should be equal to 3.0 feet");
    }

    @Test
    public void testEquality_FeetToYard_EquivalentValue() {
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(feet.equals(yards), "3.0 feet should be equal to 1.0 yard");
    }

    @Test
    public void testEquality_YardToInches_EquivalentValue() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        assertTrue(yards.equals(inches), "1.0 yard should be equal to 36.0 inches");
    }

    @Test
    public void testEquality_InchesToYard_EquivalentValue() {
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(inches.equals(yards), "36.0 inches should be equal to 1.0 yard");
    }

    @Test
    public void testEquality_YardToFeet_NonEquivalentValue() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(2.0, LengthUnit.FEET);
        assertFalse(yards.equals(feet), "1.0 yard should not be equal to 2.0 feet");
    }

    @Test
    public void testEquality_centimetersToInches_EquivalentValue() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength inches = new QuantityLength(0.393701, LengthUnit.INCHES);
        assertTrue(cm.equals(inches), "1.0 cm should be equal to 0.393701 inches");
    }

    @Test
    public void testEquality_centimetersToFeet_NonEquivalentValue() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        assertFalse(cm.equals(feet), "1.0 cm should not be equal to 1.0 feet");
    }

    @Test
    public void testEquality_MultiUnit_TransitiveProperty() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        
        assertTrue(yards.equals(feet), "1 yard should equal 3 feet");
        assertTrue(feet.equals(inches), "3 feet should equal 36 inches");
        assertTrue(yards.equals(inches), "1 yard should equal 36 inches by transitive property");
    }

    @Test
    public void testEquality_YardWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        }, "Null unit should throw IllegalArgumentException");
    }

    @Test
    public void testEquality_YardSameReference() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        assertTrue(yards.equals(yards), "A yard object should be equal to itself");
    }

    @Test
    public void testEquality_YardNullComparison() {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        assertFalse(yards.equals(null), "A yard object should not be equal to null");
    }

    @Test
    public void testEquality_CentimetersWithNullUnit() {
        assertThrows(IllegalArgumentException.class, () -> {
            new QuantityLength(1.0, null);
        }, "Null unit should throw IllegalArgumentException");
    }

    @Test
    public void testEquality_CentimetersSameReference() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        assertTrue(cm.equals(cm), "A cm object should be equal to itself");
    }

    @Test
    public void testEquality_CentimetersNullComparison() {
        QuantityLength cm = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        assertFalse(cm.equals(null), "A cm object should not be equal to null");
    }

    @Test
    public void testEquality_AllUnits_ComplexScenario() {
        QuantityLength yards = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(6.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(72.0, LengthUnit.INCHES);
        
        assertTrue(yards.equals(feet), "2.0 yards should equal 6.0 feet");
        assertTrue(feet.equals(inches), "6.0 feet should equal 72.0 inches");
        assertTrue(yards.equals(inches), "2.0 yards should equal 72.0 inches");
    }

    @Test
    public void testConversion_FeetToInches() {
        assertEquals(12.0, QuantityLength.convert(1.0, LengthUnit.FEET, LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_InchesToFeet() {
        assertEquals(2.0, QuantityLength.convert(24.0, LengthUnit.INCHES, LengthUnit.FEET), 1e-6);
    }

    @Test
    public void testConversion_YardsToInches() {
        assertEquals(36.0, QuantityLength.convert(1.0, LengthUnit.YARDS, LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_InchesToYards() {
        assertEquals(2.0, QuantityLength.convert(72.0, LengthUnit.INCHES, LengthUnit.YARDS), 1e-6);
    }

    @Test
    public void testConversion_CentimetersToInches() {
        assertEquals(0.393701, QuantityLength.convert(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_FeetToYards() {
        assertEquals(2.0, QuantityLength.convert(6.0, LengthUnit.FEET, LengthUnit.YARDS), 1e-6);
    }

    @Test
    public void testConversion_RoundTrip_PreservesValue() {
        double originalValue = 5.5;
        double convertedToInches = QuantityLength.convert(originalValue, LengthUnit.FEET, LengthUnit.INCHES);
        double convertedBackToFeet = QuantityLength.convert(convertedToInches, LengthUnit.INCHES, LengthUnit.FEET);
        assertEquals(originalValue, convertedBackToFeet, 1e-6);
    }

    @Test
    public void testConversion_ZeroValue() {
        assertEquals(0.0, QuantityLength.convert(0.0, LengthUnit.FEET, LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_NegativeValue() {
        assertEquals(-12.0, QuantityLength.convert(-1.0, LengthUnit.FEET, LengthUnit.INCHES), 1e-6);
    }

    @Test
    public void testConversion_InvalidUnit_Throws() {
        assertThrows(IllegalArgumentException.class, () -> QuantityLength.convert(1.0, null, LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class, () -> QuantityLength.convert(1.0, LengthUnit.FEET, null));
    }

    @Test
    public void testConversion_NaNOrInfinite_Throws() {
        assertThrows(IllegalArgumentException.class, () -> QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
        assertThrows(IllegalArgumentException.class, () -> QuantityLength.convert(Double.POSITIVE_INFINITY, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    public void testConversion_PrecisionTolerance() {
        // Checking epsilon tolerance behavior via math comparison
        double result = QuantityLength.convert(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        assertTrue(Math.abs(result - 0.393701) < 1e-6);
    }
}
