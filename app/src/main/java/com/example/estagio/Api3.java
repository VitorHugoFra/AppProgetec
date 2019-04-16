package com.example.estagio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api3 {

    /* Pega todos os posts do json*/
    @GET ("posts")
    Call<List<Post>> getPosts();

    /* Pega todos os posts do json com Id correto*/
    @GET ("posts")
    Call<List<Post>> getOne(
            @Query("userId") int userId,
            @Query("_order") String order
    );

    /* Envia todos os posts do json*/
    @POST("posts")
    Call<Post>createPost(@Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
