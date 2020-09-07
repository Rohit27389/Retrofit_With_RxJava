package com.example.rxjava_retrofit.api;



import com.example.rxjava_retrofit.model.Post;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MyAPI {
    @GET("posts")
    Observable<List<Post>> getPosts();
}
