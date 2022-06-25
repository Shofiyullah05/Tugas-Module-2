package com.example.fotoku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class KeranjangActivity extends AppCompatActivity {

    private RecyclerView rvOrderFoto;
    private OrderFotoAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keranjang);

        rvOrderFoto = findViewById(R.id.rv_order_foto);
            adapter = new OrderFotoAdapter(this);

        rvOrderFoto.setAdapter(adapter);
        rvOrderFoto.setLayoutManager(new LinearLayoutManager(this));

    }
}