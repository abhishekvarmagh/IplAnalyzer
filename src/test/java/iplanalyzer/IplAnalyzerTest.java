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
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.AVERAGE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("MS Dhoni", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_WhenSortedOnStrikeRate_ShouldReturnBestStrikeRate() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.STRIKE_RATE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("Ishant Sharma", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_WhenSortedOnMaximumNumberOfSixesAndFour_ShouldReturnMaximumFoursAndSixes() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.MAXIMUM_FOUR_AND_SIXES);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_ShouldReturnMaximumHitsOfFoursAndSixesWithAvg() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.FOUR_AND_SIXES_WITH_AVG);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData, IplMostRunCsv[].class);
        Assert.assertEquals("Andre Russell", iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_ShouldReturnBestAverageAndStrikingRate() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.AVERAGE_WITH_STRIKE_RATE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData,IplMostRunCsv[].class);
        Assert.assertEquals("MS Dhoni",iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenBattingCSVFilePath_ShouldReturnMaximumRunWithBestAverage() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BATTING, IPL_MOST_RUN_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.MAXIMUM_RUNS_WITH_BEST_AVERAGE);
        IplMostRunCsv[] iplMostRunCsv = new Gson().fromJson(sortedData,IplMostRunCsv[].class);
        Assert.assertEquals("David Warner ",iplMostRunCsv[0].playerName);
    }

    @Test
    public void givenWicketCSVFilePath_WhenSortedOnAverage_ShouldReturnBestBowlingAverage() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.AVERAGE);
        IplMostWicketsCsv[] iplMostWicketsCsv = new Gson().fromJson(sortedData, IplMostWicketsCsv[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWicketsCsv[0].playerName);
    }

    @Test
    public void givenBowlingCSVFilePath_WhenSortedOnStrikeRate_ShouldReturnBestStrikeRate() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.STRIKE_RATE);
        IplMostWicketsCsv[] iplMostWicketsCsv = new Gson().fromJson(sortedData, IplMostWicketsCsv[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWicketsCsv[0].playerName);
    }

    @Test
    public void givenBowlingCSVFilePath_WhenSortedOnEconomyRate_ShouldReturnBestEconomyRate() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.ECONOMY_RATE);
        IplMostWicketsCsv[] iplMostWicketsCsv = new Gson().fromJson(sortedData, IplMostWicketsCsv[].class);
        Assert.assertEquals("Ben Cutting", iplMostWicketsCsv[0].playerName);
    }

    @Test
    public void givenBowlingCSVFilePath_ShouldReturnBestStrikeRateWithBestFigures() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.BEST_STRIKE_RATE_WITH_BEST_FIGURES);
        IplMostWicketsCsv[] iplMostWicketsCsv = new Gson().fromJson(sortedData, IplMostWicketsCsv[].class);
        Assert.assertEquals("Lasith Malinga", iplMostWicketsCsv[0].playerName);
    }

    @Test
    public void givenBowlingCSVFilePath_ShouldReturnBestAverageAndStrikeRate() {
        iplAnalyzer.loadData(IplAnalyzer.Ipl.BOWLING, IPL_MOST_WICKETS_CSV_FILE_PATH);
        String sortedData = iplAnalyzer.sortDataAccordingToTheColumn(SortField.AVERAGE_WITH_STRIKE_RATE);
        IplMostWicketsCsv[] iplMostWicketsCsv = new Gson().fromJson(sortedData, IplMostWicketsCsv[].class);
        Assert.assertEquals("Krishnappa Gowtham", iplMostWicketsCsv[0].playerName);
    }


}
