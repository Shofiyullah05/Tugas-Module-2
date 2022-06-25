package com.example.fotoku;

import java.util.ArrayList;
import java.util.List;

public class KatalogFotoUtil {
    private static int[] ridArray = {
            R.drawable.foto1,
            R.drawable.foto2,
            R.drawable.foto3,
            R.drawable.foto4,
            R.drawable.foto5,
            R.drawable.foto6
    };
    private static String[] filenameArray = {
            "Foto pertama",
            "Foto Kedua",
            "Foto ketiga",
            "Foto keempat",
            "Foto kelima",
            "Foto Ke enam"
    };

    private static List<KatalogFoto> katalogFotoList;

    public static void init() {
        katalogFotoList = new ArrayList<>();
        int nArray = ridArray.length;

        for (int i=0; i<nArray; i++) {
            katalogFotoList.add(new KatalogFoto(ridArray[i], filenameArray[i] ));

        }
    }

    public static List<KatalogFoto> getKatalogFotoList() {
        return katalogFotoList;
    }

    public static KatalogFoto getKatalogFotoAt(int i) {
        return katalogFotoList.get(i);
    }
}
