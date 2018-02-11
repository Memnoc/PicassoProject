package com.smartdroidesign.picassoproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartdroidesign.picassoproject.R;
import com.smartdroidesign.picassoproject.holder.ImagesHolder;
import com.smartdroidesign.picassoproject.model.ImagesInformation;
import com.smartdroidesign.picassoproject.service.OnItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by memnoc on 10/02/2018.
 */

public class ImagesAdapter extends RecyclerView.Adapter<ImagesHolder> {

    private Context mContext;
    private ArrayList<ImagesInformation> mImagesList;
    private OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }


    public ImagesAdapter(Context context, ArrayList<ImagesInformation> imagesList) {
        this.mContext = context;
        this.mImagesList = imagesList;
    }

    @Override
    public ImagesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.card_item, parent, false);
        return new ImagesHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(ImagesHolder holder, int position) {
        ImagesInformation currentItem = mImagesList.get(position);

        String imageUrl = currentItem.getmImageUrl();
        String creatorName = currentItem.getmCreator();
        int likeCount = currentItem.getmLikes();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: " + likeCount);
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mImagesList.size();
    }
}
