public class ReportGeneration {
    private Report report;

    // constructor
    public ReportGeneration(Report report) {
        this.report = report;
    }
    // logic to generate report
    public void generateReport(Report report) {
        System.out.println("Report generated: " + report.getContent());
    }
}
