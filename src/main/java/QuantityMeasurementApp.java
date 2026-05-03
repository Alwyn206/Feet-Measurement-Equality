public class QuantityMeasurementApp {

    public static void main(String[] args) {
        QuantityLength yards = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength feet = new QuantityLength(3.0, LengthUnit.FEET);
        System.out.println("Input: " + yards + " and " + feet);
        System.out.println("Output: Equal (" + yards.equals(feet) + ")\n");

        QuantityLength yards2 = new QuantityLength(1.0, LengthUnit.YARDS);
        QuantityLength inches = new QuantityLength(36.0, LengthUnit.INCHES);
        System.out.println("Input: " + yards2 + " and " + inches);
        System.out.println("Output: Equal (" + yards2.equals(inches) + ")\n");

        QuantityLength yards3 = new QuantityLength(2.0, LengthUnit.YARDS);
        QuantityLength yards4 = new QuantityLength(2.0, LengthUnit.YARDS);
        System.out.println("Input: " + yards3 + " and " + yards4);
        System.out.println("Output: Equal (" + yards3.equals(yards4) + ")\n");

        QuantityLength cm1 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        QuantityLength cm2 = new QuantityLength(2.0, LengthUnit.CENTIMETERS);
        System.out.println("Input: " + cm1 + " and " + cm2);
        System.out.println("Output: Equal (" + cm1.equals(cm2) + ")\n");

        QuantityLength cm3 = new QuantityLength(1.0, LengthUnit.CENTIMETERS);
        QuantityLength inch3 = new QuantityLength(0.393701, LengthUnit.INCHES);
        System.out.println("Input: " + cm3 + " and " + inch3);
        System.out.println("Output: Equal (" + cm3.equals(inch3) + ")");
    }
}
