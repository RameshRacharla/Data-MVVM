package com.rameshracharla.data_mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rameshracharla.data_mvvm.model.UserModel;
import com.rameshracharla.data_mvvm.repository.UserRepo;

public class UserDataViewModel extends ViewModel {

    private UserRepo userRepo;
    private MutableLiveData<UserModel> mutableLiveData;

    public UserDataViewModel() {
        userRepo = new UserRepo();
    }

    public LiveData<UserModel> getUserData(String id) {
        if (mutableLiveData == null) {
            mutableLiveData = userRepo.requestUserData(id);
        }
        return mutableLiveData;
    }
}
