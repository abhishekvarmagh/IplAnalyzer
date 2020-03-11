package iplanalyzer;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IplAnalyzerTest {

    private static String IPL_MOST_RUN_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";
    private static String IPL_MOST_WICKETS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostWkts.csv";
    private IplAnalyzer iplAnalyzer;

    @Before
    public void initialize() {
        iplAnalyzer = new IplAnalyzer();
    }

    @Test
    public void givenBattingCSVFilePath_WhenSortedOnAverage_ShouldReturnBestBattingAverage() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.BATTING_AVG);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_WhenSortedOnStrikeRate_ShouldReturnBestStrikeRate() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.STRIKE_RATE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_WhenSortedOnMaximumNumberOfSixesAndFour_ShouldReturnMaximumFoursAndSixes() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.MAXIMUM_FOUR_AND_SIXES);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_ShouldReturnMaximumHitsOfFoursAndSixesWithAvg() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.FOUR_AND_SIXES_WITH_AVG);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_ShouldReturnBestAverageAndStrikingRate() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.AVERAGE_WITH_STRIKE_RATE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData,IplMostRunCsv[].class);
        Assert.assertEquals("MS Dhoni",iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_ShouldReturnMaximumRunsWithBestAverage() {
        iplAnalyzer.loadIplData(IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.MAXIMUM_RUNS_WITH_BEST_AVERAGE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData,IplMostRunCsv[].class);
        Assert.assertEquals("David Warner ",iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenWicketsCSVFilePath_WhenSortedOnAverage_ShouldReturnBestBowlingAverage() {
        iplAnalyzer.loadIplBowlingData(IPL_MOST_WICKETS_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.BOWLING_AVG);
        IplMostWicketsCsv[] iplMostWicketsCsvs = new Gson().fromJson(sortedData, IplMostWicketsCsv[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWicketsCsvs[0].playerName);
    }
}
