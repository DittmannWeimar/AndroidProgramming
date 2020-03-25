package sdu.androidprogrammering.onlinerandompictureshower;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class ImageAdapter extends RecyclerView.Adapter<ImageViewHolder> {

    Context context;

    public ImageAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ConstraintLayout constraintLayout = (ConstraintLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.imagelayout, parent, false);
        ImageView imageView = constraintLayout.findViewById(R.id.imageView);
        ImageViewHolder imageViewHolder = new ImageViewHolder(constraintLayout, imageView);
        return imageViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        Glide.with(context).load("https://picsum.photos/500/500?image="+position).into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return 50;
    }
}
