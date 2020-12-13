package com.rameshracharla.data_mvvm.view.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.rameshracharla.data_mvvm.R;
import com.rameshracharla.data_mvvm.databinding.ActivityMainBinding;
import com.rameshracharla.data_mvvm.model.DataModel;
import com.rameshracharla.data_mvvm.utils.MyApplication;
import com.rameshracharla.data_mvvm.view.adapter.MainActivityAdapter;
import com.rameshracharla.data_mvvm.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    final String TAG = getClass().getSimpleName();
    ActivityMainBinding binding;
    MainActivityAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerview.setHasFixedSize(true);
        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainActivityAdapter(this);
        binding.recyclerview.setAdapter(adapter);
        getData();
    }

    private void getData() {
        if (MyApplication.getInstance().isNetworkAvailable()) {
            binding.progressBar.setVisibility(View.VISIBLE);
            MainViewModel viewModel = new MainViewModel();
            viewModel.getData().observe(this, new Observer<DataModel>() {
                @Override
                public void onChanged(DataModel dataModel) {
                    binding.progressBar.setVisibility(View.GONE);
                    adapter.addDataList(dataModel.getData());
                    adapter.notifyDataSetChanged();
                    Log.d(TAG, "onChanged: Success");
                }
            });

        } else {
            MyApplication.getInstance().noInternetConnectionDialog();
        }
    }
}
