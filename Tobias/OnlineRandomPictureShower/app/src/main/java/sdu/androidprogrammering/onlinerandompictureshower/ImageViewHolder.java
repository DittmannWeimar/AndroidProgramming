package sdu.androidprogrammering.onlinerandompictureshower;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ImageViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;

    public ImageViewHolder(@NonNull ConstraintLayout constraintFrame, ImageView imageView) {
        super(constraintFrame);
        this.imageView = imageView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
