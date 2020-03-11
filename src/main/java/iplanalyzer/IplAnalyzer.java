package iplanalyzer;

import analyzer.CSVBuilderFactory;
import analyzer.ICSVBuilder;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.StreamSupport;

public class IplAnalyzer {

    public enum Ipl {
        BATTING, BOWLING;
    }

    List<IplDTO> list;
    Map<SortField, Comparator<IplDTO>> sortMap;

    public IplAnalyzer() {
        list = new ArrayList<>();
        sortMap = new HashMap<>();
        this.sortMap.put(SortField.BATTING_AVG, Comparator.comparing(analyzer -> analyzer.average));
        this.sortMap.put(SortField.STRIKE_RATE, Comparator.comparing(analyzer -> analyzer.strikeRate));
        this.sortMap.put(SortField.MAXIMUM_FOUR_AND_SIXES, Comparator.comparing(analyzer -> analyzer.fours + analyzer.sixes));
        Comparator<IplDTO> fourSixAverage = Comparator.comparing(analyzer -> analyzer.fours + analyzer.sixes);
        this.sortMap.put(SortField.FOUR_AND_SIXES_WITH_AVG, fourSixAverage.thenComparing(analyzer -> analyzer.strikeRate));
        Comparator<IplDTO> bestAverageWithStrikeRate = Comparator.comparing(analyzer -> analyzer.average);
        this.sortMap.put(SortField.AVERAGE_WITH_STRIKE_RATE, bestAverageWithStrikeRate.thenComparing(analyzer -> analyzer.strikeRate));
        Comparator<IplDTO> maxRunsWithBestAverage = Comparator.comparing(analyzer -> analyzer.runs);
        this.sortMap.put(SortField.MAXIMUM_RUNS_WITH_BEST_AVERAGE, maxRunsWithBestAverage.thenComparing(analyzer -> analyzer.average));
        this.sortMap.put(SortField.BOWLING_AVG, Comparator.comparing(analyzer -> analyzer.average));
    }

    public void loadData(Ipl ipl, String csvFilePath) {
        list = IplAdapterFactory.getIplAdapter(ipl, csvFilePath);
    }



    public String sortDataAccordingToTheColumn(SortField sortField) {
        if (list == null || list.size() == 0) {
            throw new IplAnalyzerException("No Data Found", IplAnalyzerException.ExceptionType.NO_DATA_FOUND);
        }
        this.sort(sortMap.get(sortField).reversed());
        String sortedStateCensus = new Gson().toJson(list);
        return sortedStateCensus;
    }

    private void sort(Comparator<IplDTO> censusCSVComparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                IplDTO iplDTO = list.get(j);
                IplDTO iplDTO1 = list.get(j + 1);
                if (censusCSVComparator.compare(iplDTO, iplDTO1) > 0) {
                    list.set(j, iplDTO1);
                    list.set(j + 1, iplDTO);
                }
            }
        }
    }

}

