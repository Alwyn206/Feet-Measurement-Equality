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
    public void testAddition_SameUnit_FeetPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(2.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(3.0, LengthUnit.FEET).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_SameUnit_InchPlusInch() {
        QuantityLength q1 = new QuantityLength(6.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(6.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(12.0, LengthUnit.INCHES).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_CrossUnit_FeetPlusInches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(2.0, LengthUnit.FEET).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_CrossUnit_InchPlusFeet() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(24.0, LengthUnit.INCHES).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_CrossUnit_YardPlusFeet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(2.0, LengthUnit.YARDS).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_CrossUnit_CentimeterPlusInch() {
        QuantityLength q1 = new QuantityLength(2.54, LengthUnit.CENTIMETERS);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(5.08, LengthUnit.CENTIMETERS).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result1 = QuantityLength.add(q1, q2, LengthUnit.INCHES);
        QuantityLength result2 = QuantityLength.add(q2, q1, LengthUnit.INCHES);
        assertTrue(result1.equals(result2));
    }

    @Test
    public void testAddition_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(5.0, LengthUnit.FEET).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(3.0, LengthUnit.FEET).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_NullSecondOperand() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        assertThrows(IllegalArgumentException.class, () -> q1.add(null));
    }

    @Test
    public void testAddition_LargeValues() {
        QuantityLength q1 = new QuantityLength(1e6, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1e6, LengthUnit.FEET);
        assertTrue(new QuantityLength(2e6, LengthUnit.FEET).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_SmallValues() {
        QuantityLength q1 = new QuantityLength(0.001, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.002, LengthUnit.FEET);
        assertTrue(new QuantityLength(0.003, LengthUnit.FEET).equals(q1.add(q2)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Feet() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(2.0, LengthUnit.FEET).equals(QuantityLength.add(q1, q2, LengthUnit.FEET)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Inches() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(24.0, LengthUnit.INCHES).equals(QuantityLength.add(q1, q2, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Yards() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(0.666667, LengthUnit.YARDS).equals(QuantityLength.add(q1, q2, LengthUnit.YARDS)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Centimeters() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(5.08, LengthUnit.CENTIMETERS).equals(QuantityLength.add(q1, q2, LengthUnit.CENTIMETERS)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsFirstOperand() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(3.0, LengthUnit.YARDS).equals(QuantityLength.add(q1, q2, LengthUnit.YARDS)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SameAsSecondOperand() {
        QuantityLength q1 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(3.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(9.0, LengthUnit.FEET).equals(QuantityLength.add(q1, q2, LengthUnit.FEET)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_Commutativity() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result1 = QuantityLength.add(q1, q2, LengthUnit.YARDS);
        QuantityLength result2 = QuantityLength.add(q2, q1, LengthUnit.YARDS);
        assertTrue(result1.equals(result2));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_WithZero() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(0.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(1.666667, LengthUnit.YARDS).equals(QuantityLength.add(q1, q2, LengthUnit.YARDS)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NegativeValues() {
        QuantityLength q1 = new QuantityLength(5.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(-2.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(36.0, LengthUnit.INCHES).equals(QuantityLength.add(q1, q2, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_NullTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertThrows(IllegalArgumentException.class, () -> QuantityLength.add(q1, q2, null));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_LargeToSmallScale() {
        QuantityLength q1 = new QuantityLength(1000.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(500.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(18000.0, LengthUnit.INCHES).equals(QuantityLength.add(q1, q2, LengthUnit.INCHES)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_SmallToLargeScale() {
        QuantityLength q1 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(0.666667, LengthUnit.YARDS).equals(QuantityLength.add(q1, q2, LengthUnit.YARDS)));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_AllUnitCombinations() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.FEET);
        assertTrue(new QuantityLength(4.0, LengthUnit.FEET).equals(result));
    }

    @Test
    public void testAddition_ExplicitTargetUnit_PrecisionTolerance() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength result = QuantityLength.add(q1, q2, LengthUnit.CENTIMETERS);
        double cmValue = QuantityLength.convert(2.0, LengthUnit.FEET, LengthUnit.CENTIMETERS);
        assertTrue(new QuantityLength(cmValue, LengthUnit.CENTIMETERS).equals(result));
    }

    @Test
    public void testLengthUnitEnum_FeetConstant() {
        assertEquals(1.0, LengthUnit.FEET.getConversionFactor(), 1e-6);
    }

    @Test
    public void testLengthUnitEnum_InchesConstant() {
        assertEquals(1.0 / 12.0, LengthUnit.INCHES.getConversionFactor(), 1e-6);
    }

    @Test
    public void testLengthUnitEnum_YardsConstant() {
        assertEquals(3.0, LengthUnit.YARDS.getConversionFactor(), 1e-6);
    }

    @Test
    public void testLengthUnitEnum_CentimetersConstant() {
        assertEquals(0.393701 / 12.0, LengthUnit.CENTIMETERS.getConversionFactor(), 1e-6);
    }

    @Test
    public void testConvertToBaseUnit_FeetToFeet() {
        assertEquals(5.0, LengthUnit.FEET.convertToBaseUnit(5.0), 1e-6);
    }

    @Test
    public void testConvertToBaseUnit_InchesToFeet() {
        assertEquals(1.0, LengthUnit.INCHES.convertToBaseUnit(12.0), 1e-6);
    }

    @Test
    public void testConvertToBaseUnit_YardsToFeet() {
        assertEquals(3.0, LengthUnit.YARDS.convertToBaseUnit(1.0), 1e-6);
    }

    @Test
    public void testConvertToBaseUnit_CentimetersToFeet() {
        assertEquals(1.0, LengthUnit.CENTIMETERS.convertToBaseUnit(30.48), 1e-2);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToFeet() {
        assertEquals(2.0, LengthUnit.FEET.convertFromBaseUnit(2.0), 1e-6);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToInches() {
        assertEquals(12.0, LengthUnit.INCHES.convertFromBaseUnit(1.0), 1e-6);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToYards() {
        assertEquals(1.0, LengthUnit.YARDS.convertFromBaseUnit(3.0), 1e-6);
    }

    @Test
    public void testConvertFromBaseUnit_FeetToCentimeters() {
        assertEquals(30.48, LengthUnit.CENTIMETERS.convertFromBaseUnit(1.0), 1e-2);
    }

    @Test
    public void testQuantityLengthRefactored_Equality() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(q1.equals(q2));
    }

    @Test
    public void testQuantityLengthRefactored_ConvertTo() {
        QuantityLength q = new QuantityLength(1.0, LengthUnit.FEET);
        assertTrue(new QuantityLength(12.0, LengthUnit.INCHES).equals(q.convertTo(LengthUnit.INCHES)));
    }

    @Test
    public void testQuantityLengthRefactored_Add() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(2.0, LengthUnit.FEET).equals(q1.add(q2)));
    }

    @Test
    public void testQuantityLengthRefactored_AddWithTargetUnit() {
        QuantityLength q1 = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength q2 = new QuantityLength(12.0, LengthUnit.INCHES);
        assertTrue(new QuantityLength(0.666667, LengthUnit.YARDS).equals(QuantityLength.add(q1, q2, LengthUnit.YARDS)));
    }

    @Test
    public void testQuantityLengthRefactored_NullUnit() {
        assertThrows(IllegalArgumentException.class, () -> new QuantityLength(1.0, null));
    }

    @Test
    public void testQuantityLengthRefactored_InvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> QuantityLength.convert(Double.NaN, LengthUnit.FEET, LengthUnit.INCHES));
    }

    @Test
    public void testRoundTripConversion_RefactoredDesign() {
        double originalValue = 5.0;
        double feetToInches = LengthUnit.FEET.convertToBaseUnit(originalValue);
        double inchesToFeet = LengthUnit.INCHES.convertFromBaseUnit(feetToInches);
        double roundTrip = LengthUnit.INCHES.convertToBaseUnit(inchesToFeet);
        double backToOriginal = LengthUnit.FEET.convertFromBaseUnit(roundTrip);
        assertEquals(originalValue, backToOriginal, 1e-6);
    }

    @Test
    public void testUnitImmutability() {
        double factor1 = LengthUnit.FEET.getConversionFactor();
        double factor2 = LengthUnit.FEET.getConversionFactor();
        assertEquals(factor1, factor2, 1e-6);
    }
}
