package com.example.haihm.shelf.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.haihm.shelf.R;
import com.example.haihm.shelf.adapters.ProductTypeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {
    RecyclerView rvItemTypeList;

    public ShoppingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_shopping, container, false);
        setupUI(view);

        return view;
    }

    private void setupUI(View view) {
        rvItemTypeList = view.findViewById(R.id.rv_list_product);
        ProductTypeAdapter productTypeAdapter = new ProductTypeAdapter();
        rvItemTypeList.setAdapter(productTypeAdapter);
        rvItemTypeList.setLayoutManager(new LinearLayoutManager(view.getContext()));
    }

}
