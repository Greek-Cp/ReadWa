package com.example.readwa.models;

public class PesananModel {
    private String namaPesanan;
    private int quantity;

    public PesananModel(String namaPesanan, int quantity) {
        this.namaPesanan = namaPesanan;
        this.quantity = quantity;
    }

    public String getNamaPesanan() {
        return namaPesanan;
    }

    public void setNamaPesanan(String namaPesanan) {
        this.namaPesanan = namaPesanan;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
