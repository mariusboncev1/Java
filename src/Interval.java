public class Interval {
    private double lower;
    private double upper;
    private int totalNumbers;
    private int containedNumbers;

    public Interval(double lower, double upper) {
        this.lower = lower;
        this.upper = upper;
        this.totalNumbers = 0;
        this.containedNumbers = 0;
    }

    public void testNumber(Double number) {
        totalNumbers++;
        if (number >= lower && number <= upper) {
            containedNumbers++;
        }
    }

    public String getResult() {
        double procent = (totalNumbers == 0) ? 0 : ((double) containedNumbers / totalNumbers) * 100;
        return String.format("Interval [%.2f, %.2f]: %.2f%%", lower, upper, procent);
    }
}
