package com.riktamtech.spreadsheet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColumnPojo columnPojo = new ColumnPojo(getColumnNames());
        List<RowData> data = getData();
        String[] cNames = getColumnNames();
        BaseTableAdapter adapter = new SpreadSheetAdapter(this, cNames, data);
        TwoWayScroll tableFixHeaders = (TwoWayScroll) findViewById(R.id.table);
        tableFixHeaders.setAdapter(adapter);
    }

    private String[] getColumnNames() {
        String[] columnNames = new String[1000];
        for (int i = 0; i < 1000; i++) {
            columnNames[i] = i + "";
        }
        return columnNames;
    }

    private List<RowData> getData() {
        List<RowData> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            List<String> rowData = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                if (i == 0) {
                    rowData.add("Column " + j);
                } else {
                    rowData.add("row "+i);
                }

            }
            RowData d = new RowData(false, rowData);
            data.add(d);
        }
        return data;
    }
}
