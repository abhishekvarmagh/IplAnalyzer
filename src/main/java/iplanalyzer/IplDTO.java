package iplanalyzer;

public class IplDTO {

    public String playerName;
    public int runs;
    public double average;
    public double strikeRate;
    public int sixes;
    public int fours;
    public double economyRate;

    public IplDTO(IplMostRunCsv data) {
        playerName = data.playerName;
        runs = data.runs;
        average  = data.average;
        strikeRate = data.strikeRate;
        sixes = data.sixes;
        fours = data.fours;
    }

    public IplDTO(IplMostWicketsCsv data) {
        playerName =data.playerName;
        average = data.average;
        strikeRate = data.strikeRate;
        economyRate = data.economyRate;
    }
}
