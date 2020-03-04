package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Integer> data;

    public MyAdapter(ArrayList<Integer> data){
        this.data = data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FrameLayout frame = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout, parent, false);
        TextView textView = frame.findViewById(R.id.textView);
        MyViewHolder mvh = new MyViewHolder(frame, textView);
        return mvh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setString(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
