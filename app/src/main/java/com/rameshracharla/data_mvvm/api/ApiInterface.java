package com.rameshracharla.data_mvvm.api;

import com.rameshracharla.data_mvvm.model.DataModel;
import com.rameshracharla.data_mvvm.model.UserModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ramesh Racharla on 11/12/2020.
 */
public interface ApiInterface {


    @GET("users")
    Call<DataModel> getUsers();

    @GET("users")
    Call<UserModel> getUserDetails(@Query("id") String id);

}
