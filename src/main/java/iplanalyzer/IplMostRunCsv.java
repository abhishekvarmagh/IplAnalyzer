package iplanalyzer;

import com.opencsv.bean.CsvBindByName;

public class IplMostRunCsv {

    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByName(column = "Avg", required = true)
    public double playerBattingAverage;

}
