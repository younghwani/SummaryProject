package com.younghwani.summarize;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitAPI {

    @GET("/api/summary")
    Call<SummaryItem> get_summary(@Query("text") String text);
}
