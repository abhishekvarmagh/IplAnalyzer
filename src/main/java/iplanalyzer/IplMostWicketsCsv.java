package iplanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IplMostWicketsCsv {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "avg", required = true)
    public double average;

    @CsvBindByName(column = "SR", required = true)
    public double strikeRate;

    @CsvBindByName(column = "Econ", required = true)
    public double economyRate;

    @CsvBindByName(column = "5w", required = true)
    public int fiveWicket;

    @CsvBindByName(column = "4w", required = true)
    public int fourWicket;
}
