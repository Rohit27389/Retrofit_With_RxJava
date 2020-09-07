package com.example.rxjava_retrofit.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjava_retrofit.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PostsAdapter extends RecyclerView.Adapter<PostViewHolder> {
    Context mContext;
    List<Post> postList;

    public PostsAdapter(Context mContext, List<Post> postList) {
        this.mContext = mContext;
        this.postList = postList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.txtAuthor.setText(String.valueOf(postList.get(position).getUserId()));
        holder.txtContent.setText(postList.get(position).getTitle());
        holder.txtContent.setText(new StringBuilder(postList.get(position).getBody().substring(0, 20))
                .append("...").toString());
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }
}
