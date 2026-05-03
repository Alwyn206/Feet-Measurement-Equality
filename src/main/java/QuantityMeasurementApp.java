public class QuantityMeasurementApp {

    public static void demonstrateLengthConversion(double value, LengthUnit fromUnit, LengthUnit toUnit) {
        double result = QuantityLength.convert(value, fromUnit, toUnit);
        // Round to handle floating-point representation quirks for demonstration output
        result = Math.round(result * 1000000.0) / 1000000.0;
        System.out.println("Input: convert(" + value + ", " + fromUnit.name() + ", " + toUnit.name() + ") -> Output: " + result);
    }

    public static void demonstrateLengthConversion(QuantityLength quantity, LengthUnit toUnit) {
        QuantityLength result = quantity.convertTo(toUnit);
        System.out.println("Converted " + quantity + " to " + result);
    }

    public static void demonstrateLengthEquality(QuantityLength q1, QuantityLength q2) {
        System.out.println("Input: " + q1 + " and " + q2);
        System.out.println("Output: Equal (" + q1.equals(q2) + ")\n");
    }

    public static void demonstrateLengthComparison(double val1, LengthUnit unit1, double val2, LengthUnit unit2) {
        QuantityLength q1 = new QuantityLength(val1, unit1);
        QuantityLength q2 = new QuantityLength(val2, unit2);
        demonstrateLengthEquality(q1, q2);
    }

    public static void main(String[] args) {
        System.out.println("--- UC5 Conversion Demonstrations ---");
        demonstrateLengthConversion(1.0, LengthUnit.FEET, LengthUnit.INCHES);
        demonstrateLengthConversion(3.0, LengthUnit.YARDS, LengthUnit.FEET);
        demonstrateLengthConversion(36.0, LengthUnit.INCHES, LengthUnit.YARDS);
        demonstrateLengthConversion(1.0, LengthUnit.CENTIMETERS, LengthUnit.INCHES);
        demonstrateLengthConversion(0.0, LengthUnit.FEET, LengthUnit.INCHES);

        System.out.println("\n--- Equality Demonstrations ---");
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 3.0, LengthUnit.FEET);
        demonstrateLengthComparison(1.0, LengthUnit.YARDS, 36.0, LengthUnit.INCHES);
        demonstrateLengthComparison(1.0, LengthUnit.CENTIMETERS, 0.393701, LengthUnit.INCHES);
    }
}
