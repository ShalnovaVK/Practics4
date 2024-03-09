package com.example.practic4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyAdapter extends ArrayAdapter<ListData> {
    private  LayoutInflater inflater;
    private  int layout;
    private ArrayList<ListData> items;

    public MyAdapter (@NonNull Context context, int resource, ArrayList<ListData> dataArrayList) {
        super(context, resource, dataArrayList);
        this.items = dataArrayList;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);

    }
    @NonNull
    @Override
    public View getView(int position, View view, @NonNull ViewGroup parent) {

        ListData listData = getItem(position);
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.frag_list, parent, false);
        }


        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);

        assert listData != null;
        textView.setText(listData.name);
        imageView.setImageResource(listData.image);


        return view;
    }
}
