package com.example.fotoku;

public class OrderFoto {
    private KatalogFoto katalogFoto;
    private int numOrder;
    private String ukuran;
    private double hargaSubTotal;
    public  OrderFoto(KatalogFoto _katalogFoto, int _numOrder, String _ukuran, double _hargaSubTotal) {
        katalogFoto = _katalogFoto;
        numOrder = _numOrder;
        ukuran = _ukuran;
        hargaSubTotal = _hargaSubTotal;
    }

    public KatalogFoto getKatalogFoto() {
        return katalogFoto;
    }

    public int getNumOrder() {
        return numOrder;
    }

    public void setNumOrder(int numOrder) {
        this.numOrder = numOrder;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public int getHargaSubTotal() {
        return hargaSubTotal;
    }

    public void setHargaSubTotal(double hargaSubTotal) {
        this.hargaSubTotal = hargaSubTotal;
    }
}
