package com.rameshracharla.data_mvvm.view.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import com.rameshracharla.data_mvvm.R;
import com.rameshracharla.data_mvvm.databinding.ActivityUserdataBinding;
import com.rameshracharla.data_mvvm.model.UserModel;
import com.rameshracharla.data_mvvm.utils.MyApplication;
import com.rameshracharla.data_mvvm.viewmodel.UserDataViewModel;

public class UserDataActivity extends AppCompatActivity {
    ActivityUserdataBinding binding;
    String userid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_userdata);
        userid = getIntent().getStringExtra("userData");
        getUserDetails();
    }

    private void getUserDetails() {
        if (MyApplication.getInstance().isNetworkAvailable()) {
            binding.progressBar.setVisibility(View.VISIBLE);
            UserDataViewModel viewModel = new UserDataViewModel();
            viewModel.getUserData(userid).observe(this, new Observer<UserModel>() {
                @Override
                public void onChanged(UserModel userModel) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.setUserdata(userModel.data);
                }
            });

        } else {
            MyApplication.getInstance().noInternetConnectionDialog();
        }
    }
}
