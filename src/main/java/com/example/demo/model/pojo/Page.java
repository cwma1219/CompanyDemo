package com.example.demo.model.pojo;

import java.util.List;

public class Page {
    private Long total;
    private List data;

    @Override
    public String toString() {
        return "Page{" +
                "total=" + total +
                ", data=" + data +
                '}';
    }

    public Page() {
    }

    public Page(Long total, List data) {
        this.total = total;
        this.data = data;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
