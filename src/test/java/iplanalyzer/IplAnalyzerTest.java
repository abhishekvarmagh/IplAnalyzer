package iplanalyzer;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IplAnalyzerTest {

    private static String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private IplAnalyzer iplAnalyzer;

    @Before
    public void initialize() {
        iplAnalyzer = new IplAnalyzer();
    }

    @Test
    public void givenCSVFilePath_ShouldReturnBestBattingAverage() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.BATTING_AVG);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenCSVFilePath_ShouldReturnBestStrikeRate() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.STRIKE_RATE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCsv[0].playerName);
    }


}
