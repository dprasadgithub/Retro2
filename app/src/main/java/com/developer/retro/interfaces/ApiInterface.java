package com.developer.retro.interfaces;

import com.developer.retro.models.ChangeItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CH-E01393 on 10-04-2017.
 */
public interface ApiInterface {

    @GET("changes/")
    Call<List<ChangeItem>> loadChanges(@Query("q") String status);

}
