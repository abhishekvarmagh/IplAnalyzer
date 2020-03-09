package iplanalyzer;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class IplAnalyzer {

    List<IplMostRunCsv> list;
    Map<SortField, Comparator<IplMostRunCsv>> sortMap;

    public IplAnalyzer() {
        list = new ArrayList<>();
        sortMap = new HashMap<>();
        this.sortMap.put(SortField.BATTING_AVG, Comparator.comparing(analyzer -> analyzer.playerBattingAverage));
        this.sortMap.put(SortField.STRIKE_RATE, Comparator.comparing(analyzer -> analyzer.strikeRate));
        this.sortMap.put(SortField.MAXIMUM_FOUR_AND_SIXES, Comparator.comparing(analyzer -> analyzer.fours + analyzer.sixes));
    }

    public void loadIplData(String csvFilePath) {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<IplMostRunCsv> csvToBeanBuilder = new CsvToBeanBuilder(reader);
            csvToBeanBuilder.withType(IplMostRunCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IplMostRunCsv> csvToBean = csvToBeanBuilder.build();
            Iterator<IplMostRunCsv> iterator = csvToBean.iterator();
            while (iterator.hasNext()) {
                IplMostRunCsv data = iterator.next();
                list.add(data);
            }
        } catch (IOException e) {
            throw new IplAnalyzerException(e.getMessage(), IplAnalyzerException.ExceptionType.NO_SUCH_FILE);
        }
    }

    public String sortDataAccordingToTheColumn(SortField sortField) {
        if (list == null || list.size() == 0) {
            throw new IplAnalyzerException("No Data Found", IplAnalyzerException.ExceptionType.NO_DATA_FOUND);
        }
        this.sort(sortMap.get(sortField).reversed());
        String sortedStateCensus = new Gson().toJson(list);
        return sortedStateCensus;
    }

    private void sort(Comparator<IplMostRunCsv> censusCSVComparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                IplMostRunCsv mostRunCsv = list.get(j);
                IplMostRunCsv mostRunCsv1 = list.get(j + 1);
                if (censusCSVComparator.compare(mostRunCsv, mostRunCsv1) > 0) {
                    list.set(j, mostRunCsv1);
                    list.set(j + 1, mostRunCsv);
                }
            }
        }
    }

}

