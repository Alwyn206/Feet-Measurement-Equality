public class QuantityMeasurementApp {

    public static class Feet {
        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Feet feet = (Feet) obj;
            return Double.compare(feet.value, value) == 0;
        }
    }

    public static class Inches {
        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Inches inches = (Inches) obj;
            return Double.compare(inches.value, value) == 0;
        }
    }

    public static void checkFeetEquality(double val1, double val2) {
        Feet feet1 = new Feet(val1);
        Feet feet2 = new Feet(val2);
        boolean result = feet1.equals(feet2);
        System.out.println("Input: " + val1 + " ft and " + val2 + " ft");
        System.out.println("Output: Equal (" + result + ")");
    }

    public static void checkInchesEquality(double val1, double val2) {
        Inches inches1 = new Inches(val1);
        Inches inches2 = new Inches(val2);
        boolean result = inches1.equals(inches2);
        System.out.println("Input: " + val1 + " inch and " + val2 + " inch");
        System.out.println("Output: Equal (" + result + ")");
    }

    public static void main(String[] args) {
        checkInchesEquality(1.0, 1.0);
        checkFeetEquality(1.0, 1.0);
    }
}
