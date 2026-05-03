public enum LengthUnit {
    FEET(1.0),
    INCHES(1.0 / 12.0);

    private final double baseUnitConversionFactor;

    LengthUnit(double baseUnitConversionFactor) {
        this.baseUnitConversionFactor = baseUnitConversionFactor;
    }

    public double getBaseUnitConversionFactor() {
        return baseUnitConversionFactor;
    }
}
