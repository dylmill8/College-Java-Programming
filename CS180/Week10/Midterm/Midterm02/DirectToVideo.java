public class DirectToVideo extends Movie {
    private int releaseFormatCount;
    private double sales;

    public DirectToVideo(String projectName, int employeeCount, boolean priority, int releaseFormatCount, double sales) {
        super(projectName, employeeCount, priority);
        if (releaseFormatCount < 0) { throw new IllegalArgumentException(); }
        this.releaseFormatCount = releaseFormatCount;
        this.sales = sales;
    }

    public int getReleaseFormatCount() {
        return releaseFormatCount;
    }

    public double getSales() {
        return sales;
    }

    public double calculateAverageFormatSales() {
        return (sales/releaseFormatCount);
    }

    public double calculateReturnOnInvestment(double averageSalary, int months) {
        return (sales - super.calculateCostEstimate(averageSalary, months));
    }
}
