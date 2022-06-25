package com.example.fotoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements KeranjangListener {

    private RecyclerView rvKatalogFoto;
    private KatalogFotoAdapter adapter;
    private Button btnKeranjangBelanja;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        KatalogFotoUtil.init();
        OrderFotoUtil.init();
        rvKatalogFoto = findViewById(R.id.rv_katalog_foto);
        adapter = new KatalogFotoAdapter(this);

        rvKatalogFoto.setAdapter(adapter);
        rvKatalogFoto.setLayoutManager(new LinearLayoutManager(this));
        btnKeranjangBelanja = findViewById(R.id.btn_keranjang);
        OrderChanged();
        btnKeranjangBelanja.setOnClickListener(view -> {

                    Intent intent = new Intent(this, KeranjangActivity.class);
                    startActivity(intent);
        });

        OrderFotoUtil.addKbListener(this);
            };

    @Override
    public void OrderChanged() {
        String kbCountStr = "Keranjang Belanja" + OrderFotoUtil.getOrderCount();
        btnKeranjangBelanja.setText(kbCountStr);

    }
}