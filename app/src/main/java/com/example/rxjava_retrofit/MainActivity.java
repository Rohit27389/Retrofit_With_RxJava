package com.example.rxjava_retrofit;

import android.os.Bundle;

import com.example.rxjava_retrofit.api.MyAPI;
import com.example.rxjava_retrofit.model.Post;
import com.example.rxjava_retrofit.model.PostsAdapter;
import com.example.rxjava_retrofit.model.RetrofitClient;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    MyAPI myAPI;
    RecyclerView recyclerView;
    CompositeDisposable compositeDisposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = RetrofitClient.getInstance();
        myAPI = retrofit.create(MyAPI.class);

        recyclerView = findViewById(R.id.recycler_posts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchData();
    }

    private void fetchData() {
        compositeDisposable.add(myAPI.getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Post>>() {
                    @Override
                    public void accept(List<Post> post) {
                        displayData(post);
                    }
                }));
    }

    private void displayData(List<Post> post) {
        PostsAdapter adapter = new PostsAdapter(this, post);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        compositeDisposable.clear();
    }
}