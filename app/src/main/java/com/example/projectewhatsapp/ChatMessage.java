package com.example.projectewhatsapp;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class ChatMessage {
    private boolean isImage, isMine;
    private String content;
    int picture;
    Uri imageUri;

    public ChatMessage(String message, int picture, boolean mine, boolean image, Uri imageUri) {
        content = message;
        this.picture = picture;
        isMine = mine;
        isImage = image;
        this.imageUri = imageUri;
}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setIsImage(boolean isImage) {
        this.isImage = isImage;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}
