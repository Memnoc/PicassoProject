package com.smartdroidesign.picassoproject.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.picassoproject.R;

/**
 * Created by memnoc on 10/02/2018.
 */

public class ImagesHolder extends RecyclerView.ViewHolder {

    public ImageView mImageView;
    public TextView mTextViewCreator;
    public TextView mTextViewLikes;


    public ImagesHolder(View itemView) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.card_image_view);
        mTextViewCreator = itemView.findViewById(R.id.card_creator_text);
        mTextViewLikes = itemView.findViewById(R.id.card_likes_text);
    }
}
