package com.rameshracharla.data_mvvm.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.rameshracharla.data_mvvm.model.UserModel;
import com.rameshracharla.data_mvvm.api.ApiClient;
import com.rameshracharla.data_mvvm.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepo {
    private final String TAG = getClass().getSimpleName();


    public MutableLiveData<UserModel> requestUserData(String id) {
        final MutableLiveData<UserModel> liveData = new MutableLiveData<>();

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        apiService.getUserDetails(id).enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                liveData.setValue(response.body());
                Log.d(TAG, "onResponse: " + response.body().data.getFirst_name());
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {
                Log.d(TAG, "onResponse: " + call.toString());
            }
        });
        return liveData;
    }
}
