package com.example.projectewhatsapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class ChatMessageAdapter extends ArrayAdapter<ChatMessage> {
    private static final int MY_MESSAGE = 0, OTHER_MESSAGE = 1;

    public ChatMessageAdapter(Context context, List<ChatMessage> data) {
        super(context, R.layout.item_mine_message, data);
    }

    @Override
    public int getItemViewType(int position) {
        ChatMessage item = getItem(position);

        if (item.isMine()) return MY_MESSAGE;
        else return OTHER_MESSAGE;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        int viewType = getItemViewType(position);

        if (viewType == MY_MESSAGE) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mine_message, parent, false);

            TextView textView = convertView.findViewById(R.id.text);
            ImageView imageView = convertView.findViewById(R.id.imatge);
            textView.setText(getItem(position).getContent());

            if (getItem(position).getImageUri() != null){
                imageView.setImageURI(getItem(position).getImageUri());
            }

        } else if (viewType == OTHER_MESSAGE) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_other_message, parent, false);

            TextView textView = convertView.findViewById(R.id.text);
            ImageView imageView = convertView.findViewById(R.id.imatge);
            textView.setText(getItem(position).getContent());
            imageView.setImageResource(getItem(position).getPicture());

        }

        return convertView;
    }
}
