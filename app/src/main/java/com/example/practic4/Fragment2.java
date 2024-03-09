package com.example.practic4;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {
   // Строка, которую мы выводим в список
    MyAdapter myAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    private static final String TAG = "MyApp";
    private String[] dikovinki = { "Кор Ляпсис", "Полуночный нефрит","Шелковица", "Лилия","Чили",
           "Колокольчики","Цин Синь","Ракушка", "Кристальный костный мозг","Цвет сакуры",
   "Трава наку","Морской гриб","Кровоцвет","Оникабуто" };
    private int[] imageList = {R.drawable.gen0, R.drawable.gen2, R.drawable.gen3, R.drawable.gen4,
            R.drawable.gen5, R.drawable.gen6, R.drawable.gen7, R.drawable.gen8,
            R.drawable.kostniimozg,R.drawable.sacura,R.drawable.naky,
            R.drawable.morskoigrib, R.drawable.crovocvet, R.drawable.bonicobuto};

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // получаем элемент ListView
        ListView listView = view.findViewById(R.id.listViev);
        for (int j = 0; j<17 ;j++){
            for (int i = 0; i<imageList.length; i++) {
                listData = new ListData(dikovinki[i],imageList[i]);
                dataArrayList.add(listData);
            }
        }
        // создаем адаптер
        myAdapter = new MyAdapter(this.getContext(),R.layout.frag_list, dataArrayList);

        // устанавливаем для списка адаптер
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Context context = getActivity().getApplicationContext();
                CharSequence text = "Эта диковинка живет только в 1 регионе";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Log.i(TAG, "Поздравляю, вы нашли диковину");


            }
        });

    }
}