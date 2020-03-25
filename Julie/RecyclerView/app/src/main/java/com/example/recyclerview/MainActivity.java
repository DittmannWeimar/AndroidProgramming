package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Integer> data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        recyclerView.setHasFixedSize(true);

        layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);

        data = createData(200);

        mAdapter = new MyAdapter(data);
        recyclerView.setAdapter(mAdapter);

    }

    private ArrayList<Integer> createData(int amount){
        Random random =  new Random();
        ArrayList<Integer> array = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            array.add(random.nextInt(10000));
        }
        return array;
    }
}
