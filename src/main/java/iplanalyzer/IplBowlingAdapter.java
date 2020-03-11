package iplanalyzer;

import java.util.List;

public class IplBowlingAdapter extends IplAdapter {

    public List<IplDTO> list;

    @Override
    public List<IplDTO> loadData(String csvFilePath) {
        list = super.loadData(csvFilePath, IplMostWicketsCsv.class);
        return list;
    }
}
