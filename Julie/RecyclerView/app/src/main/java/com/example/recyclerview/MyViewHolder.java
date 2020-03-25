package com.example.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private TextView textView;

    public MyViewHolder(@NonNull View itemView, TextView textview) {
        super(itemView);
        this.textView = textview;
    }

    public void setString(String string){
        textView.setText(string);
    }
}
