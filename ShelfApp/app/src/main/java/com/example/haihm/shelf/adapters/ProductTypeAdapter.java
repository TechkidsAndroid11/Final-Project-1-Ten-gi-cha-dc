package com.example.haihm.shelf.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haihm.shelf.R;

/**
 * Created by Son Hoang on 1/9/2018.
 */

public class ProductTypeAdapter extends RecyclerView.Adapter<ProductTypeAdapter.ItemTypeViewHolder> {

    @Override
    public ItemTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_type, parent, false);

        return new ItemTypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemTypeViewHolder holder, int position) {
        holder.setData();
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ItemTypeViewHolder extends RecyclerView.ViewHolder{

        public ItemTypeViewHolder(View itemView) {
            super(itemView);
        }


        public void setData() {

        }
    }
}
