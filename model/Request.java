package com.example.lenovo.letseat.model;

import java.util.List;

public class Request {
    private String phone;
    private String name;
    private String total;
    private List<Order> items;

    public Request() {
    }

    public Request(String phone, String name, String total, List<Order> items) {
        this.phone = phone;
        this.name = name;
        this.total = total;
        this.items = items;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getItems() {
        return items;
    }

    public void setItems(List<Order> items) {
        this.items = items;
    }
}
