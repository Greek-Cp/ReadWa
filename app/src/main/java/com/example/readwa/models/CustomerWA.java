package com.example.readwa.models;

import java.util.List;

public class CustomerWA {
    private String namaCustomer;
    private List<String> chatCustomer;
    private List<PesananModel> pesanan;

    public CustomerWA(String namaCustomer ,List<PesananModel> pesanan,List<String> chatCustomer) {
        this.namaCustomer = namaCustomer;
        this.pesanan = pesanan;
        this.chatCustomer = chatCustomer;
    }

    public List<String> getChatCustomer() {
        return chatCustomer;
    }

    public void setChatCustomer(List<String> chatCustomer) {
        this.chatCustomer = chatCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }




    public List<PesananModel> getPesanan() {
        return pesanan;
    }

    public void setPesanan(List<PesananModel> pesanan) {
        this.pesanan = pesanan;
    }
}
