package com.riktamtech.spreadsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by admin1 on 18/4/17.
 */

public class SpreadSheetAdapter extends BaseTableAdapter {
    private final float density;
    private String[] columnNames;
    private List<RowData> data;

    public SpreadSheetAdapter(Context context, String[] columnNames, List<RowData> data) {
        density = context.getResources().getDisplayMetrics().density;
        this.columnNames = columnNames;
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size()-1;
    }

    @Override
    public int getColumnCount() {
        return data.get(0).getData().size()-1;
    }

    @Override
    public View getView(int row, int column, View convertView, ViewGroup parent) {
        final View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_table, parent, false);

        try {
            ((TextView) view.findViewById(android.R.id.text1))
                    .setText(data.get(row + 1).getData().get(column + 1));
            return view;
        } catch (Exception e) {
            e.printStackTrace();

            return view;
        }
    }

    @Override
    public int getWidth(int column) {
        return Math.round(140 * density);
    }

    @Override
    public int getHeight(int row) {
        final int height;
        // if (row == -1) {
        //     height = 35;
        // } else if (isFamily(row)) {
        //    height = 25;
        // } else {
        height = 45;
        //}
        return Math.round(height * density);
    }

    @Override
    public int getItemViewType(int row, int column) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 5;
    }
}
