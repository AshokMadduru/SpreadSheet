package com.riktamtech.spreadsheet;

import java.util.List;

/**
 * Created by admin1 on 18/4/17.
 */

public class RowData {
    private boolean isHeader;
    private List<String> data;

    public RowData(boolean isHeader, List<String> data) {
        this.data = data;
        this.isHeader = isHeader;
    }

    public List<String> getData() {
        return data;
    }

    public boolean isHeader() {
        return isHeader;
    }
}
