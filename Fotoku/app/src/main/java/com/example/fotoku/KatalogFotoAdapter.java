package com.example.fotoku;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class KatalogFotoAdapter extends RecyclerView.Adapter<KatalogFotoAdapter.KatalogFotoViewHolder>{
    private LayoutInflater mInflater;
    public KatalogFotoAdapter (Context context) {
        mInflater = LayoutInflater.from(context);

    }

    @NonNull
    @Override
    public KatalogFotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.katalog_foto_item,parent, false);
        return new KatalogFotoAdapter.KatalogFotoViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull KatalogFotoViewHolder holder, int position) {
        KatalogFoto katalogFoto = KatalogFotoUtil.getKatalogFotoAt(position);
        holder.ivKatalogFoto.setImageResource(katalogFoto.getResId());
        holder.tvFilenameKatalogFoto.setText(katalogFoto.getFilename());


    }

    @Override
    public int getItemCount() {
        return KatalogFotoUtil.getKatalogFotoList().size();
    }

    class KatalogFotoViewHolder extends RecyclerView.ViewHolder {

        final Button btnCetak;
        final Button[] btnUkuranArray;
        final ImageView ivKatalogFoto;
        final TextView tvFilenameKatalogFoto;

        private KatalogFotoAdapter mAdapter;

        private int[] resBtnUkuranArray = {
                R.id.btn_3r,
                R.id.btn_4r,
                R.id.btn_8r,
                R.id.btn_10r
        };
        public KatalogFotoViewHolder(@NonNull View itemView, KatalogFotoAdapter _mAdapter) {

            super(itemView);
            mAdapter = _mAdapter;

            btnCetak = itemView.findViewById(R.id.btn_cetak);
            ivKatalogFoto = itemView.findViewById(R.id.iv_katalog_foto);
            tvFilenameKatalogFoto = itemView.findViewById(R.id.tv_katalog_filename);

            btnUkuranArray = new Button[resBtnUkuranArray.length];

            for(int i=0; i<resBtnUkuranArray.length; i++) {
                btnUkuranArray [i] = itemView.findViewById(resBtnUkuranArray[i]);

                btnUkuranArray[i].setOnClickListener(view -> {
                    Button btn = (Button) view;
                    int itemPos = getLayoutPosition();
                    OrderFotoUtil.addOrder(KatalogFotoUtil.getKatalogFotoAt(itemPos),btn.getText().toString() );
                }) ;

            }


        }
    }

}
