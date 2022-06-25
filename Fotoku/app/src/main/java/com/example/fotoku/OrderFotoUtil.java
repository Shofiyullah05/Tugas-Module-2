package com.example.fotoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OrderFotoUtil {
    private  static List<OrderFoto> orderFotoList;
    private static HashMap<String, Double> hargaMap;

    private static List<KeranjangListener> kbListener;
    private static double totalHarga;


    public static void initHargaMap () {
        hargaMap = new HashMap<>();
        hargaMap.put("3R", 2000.0);
        hargaMap.put("4R", 5000.0);
        hargaMap.put("8R", 10000.0);
        hargaMap.put("10R", 12000.0);
    }
    public static void init() {
        orderFotoList = new ArrayList<>();
        initHargaMap();
        kbListener =  new ArrayList<>();
    }

    public static void addKbListener(KeranjangListener listener) {
        kbListener.add(listener);
    }

    public static int getOrderCount() {
        return orderFotoList.size();
    }

    public static OrderFoto getOrderFotoAt(int i) {
        return orderFotoList.get(i);
    }
    private static void updateKeranjang() {
        totalHarga=0.0;
        for(OrderFoto Order:orderFotoList) {
            totalHarga += Order.getHargaSubTotal();
        }
        for (KeranjangListener listener:kbListener) {
            listener.OrderChanged();
        }
    }

    public double getHargaTotal() {
        return totalHarga;
    }
    public static void addOrder (KatalogFoto foto, String ukuran) {
        Double hargaSatuan=hargaMap.get(ukuran);

        if (hargaMap.get(ukuran) == null) {
            hargaSatuan =0.0;

        }
        orderFotoList.add(new OrderFoto(foto,1, ukuran,hargaSatuan));
        updateKeranjang();
}
}
