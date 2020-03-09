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

    public IplAnalyzer(){
        list = new ArrayList<>();
    }

    public void loadIplData(String csvFilePath) {
        try(Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            CsvToBeanBuilder<IplMostRunCsv> csvToBeanBuilder = new CsvToBeanBuilder(reader);
            csvToBeanBuilder.withType(IplMostRunCsv.class);
            csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
            CsvToBean<IplMostRunCsv> csvToBean = csvToBeanBuilder.build();
            Iterator<IplMostRunCsv> iterator = csvToBean.iterator();
            while(iterator.hasNext()){
                IplMostRunCsv data = iterator.next();
                list.add(data);
            }
        } catch (IOException e) {
            throw new IplAnalyzerException(e.getMessage(),IplAnalyzerException.ExceptionType.NO_SUCH_FILE);
        }
    }

    public String sortDataAccordingToTheColumn() {
        if (list == null || list.size() == 0) {
            throw new IplAnalyzerException("No Data Found", IplAnalyzerException.ExceptionType.NO_DATA_FOUND);
        }
        Comparator<IplMostRunCsv> csvComparator = Comparator.comparing(analyzer -> analyzer.playerBattingAverage);
        this.sort(csvComparator.reversed());
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

