package com.rameshracharla.data_mvvm.model;

import java.util.ArrayList;

public class DataModel {
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    private ArrayList<DataList> data;

    public ArrayList<DataList> getData() {
        return data;
    }

    public void setData(ArrayList<DataList> data) {
        this.data = data;
    }
}
