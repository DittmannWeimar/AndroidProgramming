package sdu.androidprogrammering.recyclingviewproject;

import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public class MyViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    private FrameLayout frame;
    private TextView textView;

    public MyViewHolder(FrameLayout frame, TextView textView) {
        super(frame);
        this.textView = textView;
    }

    public FrameLayout getFrame() {
        return frame;
    }

    public void setFrame(FrameLayout frame) {
        this.frame = frame;
    }

    public TextView getTextView() {
        return textView;
    }

    public void setTextView(String text) {
        this.textView.setText(text);
    }
}
