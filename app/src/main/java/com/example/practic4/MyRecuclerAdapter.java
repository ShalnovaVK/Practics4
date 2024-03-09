package com.example.practic4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MyRecuclerAdapter  extends RecyclerView.Adapter< MyRecuclerAdapter.ViewHolder>{
    private final LayoutInflater inflater;
    private ArrayList<ListData> items;
    private static Context parent;
    private static final String TAG = "MyApp";
    MyRecuclerAdapter(Context context, ArrayList<ListData> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
        parent = context;
    }
    @NonNull
    @Override
    public MyRecuclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.frag_list, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyRecuclerAdapter.ViewHolder holder, int position) {
        ListData listData = items.get(position);

        holder.textView.setText(listData.name);
        holder.imageView.setImageResource(listData.image);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                    CharSequence text = "Эта диковинка живет только в 1 регионе";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(parent, text, duration);
                    toast.show();
                    Log.i(TAG, "Поздравляю, вы нашли диковину");
                }
            });
        }

    }
}
