package com.example.readwa.message;

import java.util.ArrayList;
import java.util.List;

public class UtilsMessage {

    public enum responeMessage{
        YA,
        TIDAK
    }

    public static final  String INTRO_REP = "Selamat Datang Di Resto Enak !!!\n Apakah anda ingin memesan? \n (jawab dengan angka saja) \n1.YA \n 2.TIDAK";
    public static final  String FILLDATADIRI_REP = "Silahkan mengisi data diri untuk proses pengiriman. \n \n Nama Pemesanan: \n Alamat Lengkap: \n Nomor Hp: \n";
    public static final String WARNING_INPUT_PESANAN = "Harap inputkan angka 1 dan 2.";

    List<String> listConversationCustomer(){
        List<String> customerConversation = new ArrayList<>();
        customerConversation.add("Selamat Siang, Saya ingin memesan makanan");
        return customerConversation;
    }
    String showWarningWhenCustomerWrongInputPesanan(){
        return this.WARNING_INPUT_PESANAN;
    };

}
