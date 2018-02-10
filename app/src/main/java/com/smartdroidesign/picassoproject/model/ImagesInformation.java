package com.smartdroidesign.picassoproject.model;

/**
 * Created by memnoc on 10/02/2018.
 */

public class ImagesInformation {

    private String mImageUrl;
    private String mCreator;
    private int mLikes;

    public ImagesInformation(String imageUrl, String creator, int likes) {
        this.mImageUrl = imageUrl;
        this.mCreator = creator;
        this.mLikes = likes;
    }

    public String getmImageUrl() {
        return mImageUrl;
    }

    public String getmCreator() {
        return mCreator;
    }

    public int getmLikes() {
        return mLikes;
    }
}
