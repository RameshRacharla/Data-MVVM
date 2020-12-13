package com.rameshracharla.data_mvvm.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.rameshracharla.data_mvvm.model.DataModel;
import com.rameshracharla.data_mvvm.repository.DataRepo;

public class MainViewModel extends ViewModel {

    private DataRepo dataRepo;
    private MutableLiveData<DataModel> mutableLiveData;

    public MainViewModel() {
        dataRepo = new DataRepo();
    }

    public LiveData<DataModel> getData() {
        if (mutableLiveData == null) {
            mutableLiveData = dataRepo.requestData();
        }
        return mutableLiveData;
    }
}
