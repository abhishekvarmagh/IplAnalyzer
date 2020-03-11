package iplanalyzer;

import java.util.List;

public class IplAdapterFactory {

    public static List<IplDTO> getIplAdapter(IplAnalyzer.Ipl ipl, String csvFilePath) {
        if (ipl.equals(IplAnalyzer.Ipl.BATTING))
            return new IplBattingAdapter().loadData(csvFilePath);
        else if (ipl.equals(IplAnalyzer.Ipl.BOWLING))
            return new IplBowlingAdapter().loadData(csvFilePath);
        else
            throw new IplAnalyzerException("No Such Field", IplAnalyzerException.ExceptionType.NO_SUCH_FIELD);
    }
}
