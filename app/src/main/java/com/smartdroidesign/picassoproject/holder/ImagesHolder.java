package com.smartdroidesign.picassoproject.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartdroidesign.picassoproject.R;
import com.smartdroidesign.picassoproject.adapter.ImagesAdapter;
import com.smartdroidesign.picassoproject.service.OnItemClickListener;

/**
 * Created by memnoc on 10/02/2018.
 */

public class ImagesHolder extends RecyclerView.ViewHolder {


    public ImageView mImageView;
    public TextView mTextViewCreator;
    public TextView mTextViewLikes;




    public ImagesHolder(View itemView, final OnItemClickListener mListener) {
        super(itemView);
        mImageView = itemView.findViewById(R.id.card_image_view);
        mTextViewCreator = itemView.findViewById(R.id.card_creator_text);
        mTextViewLikes = itemView.findViewById(R.id.card_likes_text);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    int position = getAdapterPosition();

                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(position);
                    }
                }
            }
        });

    }
}
