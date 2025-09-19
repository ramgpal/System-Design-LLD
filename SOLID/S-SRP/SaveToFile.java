public class SaveToFile {
    private Report report;

    // constructor
    public SaveToFile(Report report) {
        this.report = report;
    }

    // logic to save report to file
    public void saveReportToFile(Report report) {
        System.out.println("Report saved: "+ report.getContent());
    }
}
