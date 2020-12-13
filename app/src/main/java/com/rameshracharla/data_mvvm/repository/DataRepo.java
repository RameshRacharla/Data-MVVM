package com.rameshracharla.data_mvvm.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.rameshracharla.data_mvvm.model.DataModel;
import com.rameshracharla.data_mvvm.api.ApiClient;
import com.rameshracharla.data_mvvm.api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DataRepo {
    private final String TAG = getClass().getSimpleName();


    public MutableLiveData<DataModel> requestData() {
        final MutableLiveData<DataModel> mutableLiveData = new MutableLiveData<>();

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        apiService.getUsers().enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                Log.d(TAG, "onResponse: " + response.body().getTotal());
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.d(TAG, "onResponse: " + call.toString());
            }
        });
        return mutableLiveData;
    }
}
