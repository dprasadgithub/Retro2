package com.developer.retro.controller;

import com.developer.retro.interfaces.RVListener;
import com.developer.retro.models.ChangeItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.developer.retro.interfaces.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CH-E01393 on 10-04-2017.
 */
public class RetroController implements Callback<List<ChangeItem>> {

    private static RVListener rvListener;

    static final String BASE_URL = "https://git.eclipse.org/r/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<List<ChangeItem>> call = apiInterface.loadChanges("status:open");
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<ChangeItem>> call, Response<List<ChangeItem>> response) {
        if (response.isSuccessful()) {
            List<ChangeItem> changesList = response.body();

            if (changesList != null && !changesList.isEmpty() && changesList.size() > 0) {
                if (rvListener != null) {
                    rvListener.onDataFetch(changesList);
                }
            }

            /*for(ChangeItem changeItem : changesList){
                System.out.println("ChangeItem info ::::::::: " + changeItem.getSubject());
                System.out.println("Update Date::::::::: " + changeItem.getUpdated());
            }*/

        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<ChangeItem>> call, Throwable t) {
        t.printStackTrace();
    }

    public static void setOnRVListener(RVListener listener) {
        rvListener = listener;
    }

}
