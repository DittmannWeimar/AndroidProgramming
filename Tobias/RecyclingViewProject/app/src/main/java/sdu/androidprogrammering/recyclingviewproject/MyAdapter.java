package sdu.androidprogrammering.recyclingviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private ArrayList<Integer> intArray;

    public MyAdapter(ArrayList<Integer> dataSet){
        intArray = dataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FrameLayout frame = (FrameLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlayout, parent, false);
        TextView textView = frame.findViewById(R.id.my_textView);
        MyViewHolder vh = new MyViewHolder(frame, textView);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.setTextView(intArray.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return intArray.size();
    }

    public void deleteItem(final int position, View view){
        String message = "Removed item " + intArray.get(position) + " at position " + position;
        final int deletedValue = intArray.get(position);
        Snackbar snack = Snackbar.make(view, message, Snackbar.LENGTH_LONG);
        snack.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intArray.add(position, deletedValue);
                notifyDataSetChanged();
            }
        });
        snack.show();
        intArray.remove(position);
        notifyDataSetChanged();
    }
}
