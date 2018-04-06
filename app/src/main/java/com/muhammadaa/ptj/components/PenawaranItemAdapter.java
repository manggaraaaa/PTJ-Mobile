package com.muhammadaa.ptj.components;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.muhammadaa.ptj.R;
import com.muhammadaa.ptj.models.ItemsModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by manggara on 04/05/2018.
 */

public class PenawaranItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ItemsModel item);
    }

    private Context context;
    private LayoutInflater inflater;
    private List<ItemsModel> data = Collections.emptyList();
    private final OnItemClickListener listener;

    public PenawaranItemAdapter(Context context, List<ItemsModel> data, OnItemClickListener listener) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.data = data;
        this.listener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.content_home_penawaran, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        myHolder.bind(data.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtDesc;

        public MyHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.title_item);
            txtDesc = (TextView) itemView.findViewById(R.id.desc_item);
        }

        public void bind(final ItemsModel item, final OnItemClickListener listener) {
            txtTitle.setText(item.getTitleItem());
            txtDesc.setText(item.getDescItem());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
