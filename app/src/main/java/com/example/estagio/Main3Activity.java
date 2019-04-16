package com.example.estagio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Main3Activity extends AppCompatActivity {
    private TextView Text;
    private Api3 api3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Text =findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api3 = (Api3) retrofit.create(Api3.class);

        //getPosts();
        //getOne();
        //createPost();
        Update();
        //deletePost();
    }
    //Exclui Post
    private void deletePost() {
        Call<Void> call = api3.deletePost(3);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Text.setText("Code: " +response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Text.setText(t.getMessage());
            }
        });

    }
    //Atualiza Post
    private void Update() {
        int d =5;
        Post post = new Post(12,"Title","Eai guys");
        Call<Post> call = api3.patchPost(d, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    Text.setText("code:" + response.code());
                    return;
                }
                Post posts = response.body();


                String content = "";
                Text.setText("Code: " +response.code());
                content += "ID: " + posts.getId() + "\n";
                content += "User ID: " + posts.getUserId() + "\n";
                content += "Title: " + posts.getTitle() + "\n";
                content += "Text: " + posts.getText() + "\n\n";
                Text.append(content);

            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Text.setText(t.getMessage());

            }
        });

    }

    //Recebe JSON e transforma em uma Lista
    private void getPosts() {
        Call<List<Post>> call = api3.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Text.setText("code:" + response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    Text.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Text.setText(t.getMessage());
            }
        });
    }
    // Recebe posts só de um Id
    private void getOne() {
        Call<List<Post>> call = api3.getOne(4, "crec");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    Text.setText("code:" + response.code());
                    return;
                }
                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID: " + post.getId() + "\n";
                    content += "User ID: " + post.getUserId() + "\n";
                    content += "Title: " + post.getTitle() + "\n";
                    content += "Text: " + post.getText() + "\n\n";

                    Text.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Text.setText(t.getMessage()+"nzxdcfvgb");
            }
        });

    }


    //Tranforma variaveis em JSON e envia para API
    private void createPost() {
        Post post = new Post(22,"nigga", "Nifsdflasdf");
        Call<Post> call = api3.createPost(post);
        call.enqueue(new Callback<Post>() {
             @Override
             public void onResponse(Call<Post> call, Response<Post> response) {
                 if (!response.isSuccessful()) {
                     Text.setText("code:" + response.code());
                     return;
                 }
                 Post postResponse = response.body();
                 String content = "";
                 content += "Code: " + response.code() + "\n";
                 content += "ID: " + postResponse.getId() + "\n";
                 content += "User ID: " + postResponse.getUserId() + "\n";
                 content += "Title: " + postResponse.getTitle() + "\n";
                 content += "Text: " + postResponse.getText() + "\n\n";

                 Text.setText(content);
             }

             @Override
             public void onFailure(Call<Post> call, Throwable t) {
                 Text.setText(t.getMessage());

             }
         });

    }
}
