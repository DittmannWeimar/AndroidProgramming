package com.example.threading2;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JokeService {
    @GET("jokes/random")
    Call<Joke> randomJoke();
}
