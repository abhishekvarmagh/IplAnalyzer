package iplanalyzer;

import analyzer.CSVBuilderFactory;
import analyzer.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IplAdapter {

    public abstract List<IplDTO> loadData(String csvFilePath);

    public <E> List<IplDTO> loadData(String csvFilePath, Class<E> csvclass) {
        List<IplDTO> list = new ArrayList<>();
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder icsvBuilder = CSVBuilderFactory.createBuilder();
            Iterator<E> iterator = icsvBuilder.getCSVFileIterator(reader, csvclass);
            Iterable<E> iterable = () -> iterator;
            if (csvclass.getName().equals("iplanalyzer.IplMostRunCsv")) {
                StreamSupport.stream(iterable.spliterator(), false).map(IplMostRunCsv.class::cast)
                        .forEach(analyzer -> list.add(new IplDTO(analyzer)));
            }else if (csvclass.getName().equals("iplanalyzer.IplMostWicketsCsv")) {
                StreamSupport.stream(iterable.spliterator(), false).map(IplMostWicketsCsv.class::cast)
                        .forEach(analyzer -> list.add(new IplDTO(analyzer)));
            }
            return list;
        } catch (IOException e) {
            throw new IplAnalyzerException(e.getMessage(), IplAnalyzerException.ExceptionType.NO_SUCH_FILE);
        }
    }

}
