package com.ecsolutions.entity;

import java.util.List;

/**
 * Created by Administrator on 2017/3/27.
 */
public class DatatableResponse_Entity {
    private Integer draw;
    private long recordsTotal;
    private long recordsFiltered;
    private List<List<Object>> data;

    public DatatableResponse_Entity() {
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public long getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(long recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public long getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(long recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<List<Object>> getData() {
        return data;
    }

    public void setData(List<List<Object>> data) {
        this.data = data;
    }

}
