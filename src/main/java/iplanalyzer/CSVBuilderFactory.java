package iplanalyzer;

public class CSVBuilderFactory {
    public static ICSVBuilder createBuilder(){
        return new OpenCSVBuilder();
    }
}
