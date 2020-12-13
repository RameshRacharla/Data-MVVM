package com.rameshracharla.data_mvvm.view.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.rameshracharla.data_mvvm.R;
import com.rameshracharla.data_mvvm.databinding.ItemDataBinding;
import com.rameshracharla.data_mvvm.model.DataList;
import com.rameshracharla.data_mvvm.view.activity.MainActivity;
import com.rameshracharla.data_mvvm.view.activity.UserDataActivity;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MyViewHolder> {

    ArrayList<DataList> datalist;
    Context context;

    public MainActivityAdapter(MainActivity mainActivity) {
        datalist = new ArrayList<>();
        context = mainActivity;
    }

    public void addDataList(ArrayList<DataList> data) {
        this.datalist = data;
    }


    @Override
    public int getItemCount() {
        return datalist != null ? datalist.size() : 0;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemDataBinding binding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_data, parent, false);

        return new MyViewHolder(binding);
    }


    static class MyViewHolder extends RecyclerView.ViewHolder {
        private ItemDataBinding binding;

        MyViewHolder(ItemDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.binding.setModel(datalist.get(position));
        holder.binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UserDataActivity.class);
                intent.putExtra("userData", datalist.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

}
