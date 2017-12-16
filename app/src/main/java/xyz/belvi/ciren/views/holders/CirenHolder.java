package xyz.belvi.ciren.views.holders;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import xyz.belvi.ciren.R;

/**
 * Created by zone2 on 6/27/17.
 */

public class CirenHolder extends RecyclerView.ViewHolder {
    private AppCompatImageView cirenImg;
    private AppCompatTextView cirenTitle;
    private Context context;

    public CirenHolder(View itemView) {
        super(itemView);
        context = itemView.getContext();
        cirenImg = (AppCompatImageView) itemView.findViewById(R.id.ciren_img);
        cirenTitle = (AppCompatTextView) itemView.findViewById(R.id.ciren_title);
    }

    public AppCompatImageView getCirenImg() {
        return this.cirenImg;
    }

    public AppCompatTextView getCirenTitle() {
        return this.cirenTitle;
    }

    public Context getContext() {
        return this.context;
    }
}
