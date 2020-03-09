package iplanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IplMostRunCsv {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double playerBattingAverage;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

}
