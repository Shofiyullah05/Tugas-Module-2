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

import java.util.zip.Inflater;

public class OrderFotoAdapter extends RecyclerView.Adapter <OrderFotoAdapter.OrderFotoViewHolder> {

    private LayoutInflater mInflater;

    public OrderFotoAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public OrderFotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.order_foto_item,parent, false);
        return new OrderFotoViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderFotoViewHolder holder, int position) {
        OrderFoto order = OrderFotoUtil.getOrderFotoAt(position);
        KatalogFoto katalogFoto = order.getKatalogFoto();
        holder.IvOrderFoto.setImageResource(KatalogFoto.getResId());
        holder.tvFilenameOrderFoto.setText(katalogFoto.getFilename());
        holder.tvNumOrder.setText(order.getNumOrder()+ "");
        holder.tvUkuran.setText(order.getUkuran() );
        holder.tvSubtotal.setText(order.getHargaSubTotal() );
        holder.tvSubtotal.setText(rupiahFormatter.FormatIdr(order.getHargaSubTotal()));


    }

    @Override
    public int getItemCount() {
        return OrderFotoUtil.getOrderCount();
    }

    class OrderFotoViewHolder extends RecyclerView {
        final TextView tvFilenameOrderFoto, tvUkuran, tvNumOrder, tvSubtotal;
        final Button btnDel, btnIncOrder, btnDecOrder;
        final ImageView IvOrderFoto;

        OrderFotoAdapter mAdapter;
        public OrderFotoViewHolder(@NonNull View itemView, OrderFotoAdapter _mAdapter) {
            super(itemView);
            mAdapter = _mAdapter;
            tvFilenameOrderFoto = itemView.findViewById(R.id.tv_foto_filename);
            tvUkuran = itemView.findViewById(R.id.tv_foto_order_ukuran);
            tvNumOrder = itemView.findViewById(R.id.tv_foto_num);
            tvSubtotal = itemView.findViewById(R.id.tv_sub_price);
            btnDel = itemView.findViewById(R.id.btn_del_foto_order);
            btnIncOrder = itemView.findViewById(R.id.btn_inc_foto_num);
            btnDecOrder = itemView.findViewById(R.id.btn_dec_foto_num);

            IvOrderFoto = itemView.findViewById(R.id.iv_foto_order);
        }
    }
}
