package iplanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IplMostWicketsCsv {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "avg", required = true)
    public double average;
}
