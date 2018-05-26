package com.developer.retro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.developer.retro.adapters.RVAdapter;
import com.developer.retro.controller.RetroController;
import com.developer.retro.interfaces.RVListener;
import com.developer.retro.models.ChangeItem;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RVAdapter rvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetroController retroController = new RetroController();
        retroController.start();

        RetroController.setOnRVListener(new RVListener() {
            @Override
            public void onDataFetch(List<ChangeItem> listChangeItems) {
                recyclerView = (RecyclerView) findViewById(R.id.rv_data);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));

                rvAdapter = new RVAdapter(listChangeItems);
                recyclerView.setAdapter(rvAdapter);
            }
        });
    }
}
