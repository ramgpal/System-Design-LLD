public class Main {
    public static void main(String[] args) {
        Report report = new Report("Hi, This is the report.");

        ReportGeneration reportGeneration = new ReportGeneration(report);
        reportGeneration.generateReport(report);

        SaveToFile saveToFile = new SaveToFile(report);
        saveToFile.saveReportToFile(report);
    }
}
