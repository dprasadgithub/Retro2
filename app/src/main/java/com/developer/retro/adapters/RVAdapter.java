package com.developer.retro.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.developer.retro.R;
import com.developer.retro.models.ChangeItem;

import java.util.List;


/**
 * Created by SDL on 5/25/2018.
 */

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.CustomViewHolder> {

    private List<ChangeItem> listChangeItems;

    public RVAdapter(List<ChangeItem> listChangeItems){
        this.listChangeItems = listChangeItems;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);

        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {

        holder.tv1.setText(listChangeItems.get(position).getSubject());
        holder.tv2.setText(listChangeItems.get(position).getUpdated());
    }

    @Override
    public int getItemCount() {
        return listChangeItems.size();
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder{

        private TextView tv1, tv2;
        public CustomViewHolder(View itemView) {
            super(itemView);

            tv1 = (TextView) itemView.findViewById(R.id.firstLine);
            tv2 = (TextView) itemView.findViewById(R.id.secondLine);
        }
    }
}
