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

    /**
     * Private utility method for addition conversion on base unit value.
     */
    private QuantityLength addInternal(QuantityLength other, LengthUnit targetUnit) {
        if (other == null || targetUnit == null) {
            throw new IllegalArgumentException("Operand and target unit cannot be null");
        }
        double thisBase = this.value * this.unit.getBaseUnitConversionFactor();
        double otherBase = other.value * other.unit.getBaseUnitConversionFactor();
        double sumBase = thisBase + otherBase;
        double resultValue = sumBase / targetUnit.getBaseUnitConversionFactor();
        return new QuantityLength(resultValue, targetUnit);
    }

    /**
     * Adds another QuantityLength to this one and returns the result in this object's unit.
     */
    public QuantityLength add(QuantityLength other) {
        return addInternal(other, this.unit);
    }

    /**
     * Statically adds two quantities and returns the result in a specified target unit.
     */
    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {
        if (q1 == null) {
            throw new IllegalArgumentException("First operand cannot be null");
        }
        return q1.addInternal(q2, targetUnit);
    }

    /**
     * Statically adds two quantities defined by their values and units, returning the result in a target unit.
     */
    public static QuantityLength add(double val1, LengthUnit unit1, double val2, LengthUnit unit2, LengthUnit targetUnit) {
        return add(new QuantityLength(val1, unit1), new QuantityLength(val2, unit2), targetUnit);
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit.name() + ")";
    }
}
