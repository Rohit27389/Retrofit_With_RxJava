package com.example.rxjava_retrofit.model;

import android.view.View;
import android.widget.TextView;

import com.example.rxjava_retrofit.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostViewHolder extends RecyclerView.ViewHolder {
    TextView txtTitle, txtContent, txtAuthor;

    public PostViewHolder(@NonNull View itemView) {
        super(itemView);

        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtContent = itemView.findViewById(R.id.txtContent);
        txtAuthor = itemView.findViewById(R.id.txtAuthor);
    }
}
