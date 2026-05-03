public class QuantityMeasurementApp {

    public static void main(String[] args) {
        QuantityLength feet = new QuantityLength(1.0, LengthUnit.FEET);
        QuantityLength inches = new QuantityLength(12.0, LengthUnit.INCHES);
        boolean result1 = feet.equals(inches);
        System.out.println("Input: " + feet + " and " + inches);
        System.out.println("Output: Equal (" + result1 + ")");

        QuantityLength inch1 = new QuantityLength(1.0, LengthUnit.INCHES);
        QuantityLength inch2 = new QuantityLength(1.0, LengthUnit.INCHES);
        boolean result2 = inch1.equals(inch2);
        System.out.println("Input: " + inch1 + " and " + inch2);
        System.out.println("Output: Equal (" + result2 + ")");
    }
}
