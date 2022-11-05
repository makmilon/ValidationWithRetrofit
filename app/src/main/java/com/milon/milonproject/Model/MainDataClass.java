package com.milon.milonproject.Model;

import java.util.List;

public class MainDataClass {

    List<ObjectDataClass> results;

    public MainDataClass() {
    }

    public MainDataClass(List<ObjectDataClass> data) {
        this.results = data;
    }

    public List<ObjectDataClass> getData() {
        return results;
    }

    public void setData(List<ObjectDataClass> data) {
        this.results = data;
    }
}
