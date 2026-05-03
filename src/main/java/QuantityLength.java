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
     * Adds another QuantityLength to this one and returns the result in this object's unit.
     *
     * @param other the other QuantityLength to add
     * @return a new QuantityLength representing the sum
     */
    public QuantityLength add(QuantityLength other) {
        if (other == null) {
            throw new IllegalArgumentException("Cannot add a null quantity");
        }
        double convertedValue = other.convertTo(this.unit).value;
        return new QuantityLength(this.value + convertedValue, this.unit);
    }

    /**
     * Statically adds two quantities and returns the result in a specified target unit.
     * 
     * @param q1 the first quantity
     * @param q2 the second quantity
     * @param targetUnit the target unit for the result
     * @return a new QuantityLength representing the sum
     */
    public static QuantityLength add(QuantityLength q1, QuantityLength q2, LengthUnit targetUnit) {
        if (q1 == null || q2 == null || targetUnit == null) {
            throw new IllegalArgumentException("Operands and target unit cannot be null");
        }
        double sum = q1.convertTo(targetUnit).value + q2.convertTo(targetUnit).value;
        return new QuantityLength(sum, targetUnit);
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
