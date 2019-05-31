package com.example.projectewhatsapp;

import android.net.Uri;

public class ChatMessage {
    private boolean isMine;
    private String content;
    int picture;
    Uri imageUri;

    public ChatMessage(String message, int picture, boolean mine, Uri imageUri) {
        content = message;
        this.picture = picture;
        isMine = mine;
        this.imageUri = imageUri;
}

    public String getContent() {
        return content;
    }

    public int getPicture() {
        return picture;
    }

    public boolean isMine() {
        return isMine;
    }

    public Uri getImageUri() {
        return imageUri;
    }
}
