package iplanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IplMostRunCsv {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Runs", required = true)
    public int runs;

    @CsvBindByName(column = "Avg", required = true)
    public double average;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "6s", required = true)
    public int sixes;

    @CsvBindByName(column = "4s", required = true)
    public int fours;

}
