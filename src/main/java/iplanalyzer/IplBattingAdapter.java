package iplanalyzer;

import java.util.List;


public class IplBattingAdapter extends IplAdapter{

    public List<IplDTO> list;

    @Override
    public List<IplDTO> loadData(String csvFilePath) {
        list = super.loadData(csvFilePath, IplMostRunCsv.class);
        return list;
    }
}
