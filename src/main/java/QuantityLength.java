public class QuantityLength {
    private final double value;
    private final LengthUnit unit;

    public QuantityLength(double value, LengthUnit unit) {
        if (unit == null) {
            throw new IllegalArgumentException("Unit cannot be null");
        }
        this.value = value;
        this.unit = unit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        QuantityLength that = (QuantityLength) obj;
        
        double thisBaseValue = this.value * this.unit.getBaseUnitConversionFactor();
        double thatBaseValue = that.value * that.unit.getBaseUnitConversionFactor();
        
        // Use Math.round to handle double precision issues gracefully
        thisBaseValue = Math.round(thisBaseValue * 10000.0) / 10000.0;
        thatBaseValue = Math.round(thatBaseValue * 10000.0) / 10000.0;
        
        return Double.compare(thisBaseValue, thatBaseValue) == 0;
    }

    /**
     * Converts a numeric value from a source unit to a target unit.
     *
     * @param value the numeric value to convert
     * @param sourceUnit the unit of the input value
     * @param targetUnit the unit to convert to
     * @return the converted numeric value
     * @throws IllegalArgumentException if units are null or value is not finite
     */
    public static double convert(double value, LengthUnit sourceUnit, LengthUnit targetUnit) {
        if (sourceUnit == null || targetUnit == null) {
            throw new IllegalArgumentException("Units cannot be null");
        }
        if (!Double.isFinite(value)) {
            throw new IllegalArgumentException("Value must be a finite number");
        }
        double baseValue = value * sourceUnit.getBaseUnitConversionFactor();
        return baseValue / targetUnit.getBaseUnitConversionFactor();
    }

    /**
     * Converts this quantity to a new quantity with the target unit.
     *
     * @param targetUnit the unit to convert to
     * @return a new QuantityLength instance representing the converted value
     */
    public QuantityLength convertTo(LengthUnit targetUnit) {
        if (targetUnit == null) {
            throw new IllegalArgumentException("Target unit cannot be null");
        }
        double convertedValue = convert(this.value, this.unit, targetUnit);
        return new QuantityLength(convertedValue, targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.name() + ")";
    }
}
