package com.test.pocobservables.view;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.pocobservables.databinding.FragmentFirstBinding;
import com.test.pocobservables.model.callback.CustomCallback;
import com.test.pocobservables.model.enums.EnumStatesObservable;
import com.test.pocobservables.util.SingleLiveEvent;
import com.test.pocobservables.viewmodel.FirstViewModel;


public class FirstFragment extends Fragment {
    private String TAG = FirstFragment.class.getSimpleName();

    private FragmentFirstBinding binding;
    private FirstViewModel mViewModel;
    public CustomCallback callback;

    /**
     * observable
     */
    private MutableLiveData<String> changeStatus = new MutableLiveData<>();

    public LiveData<String> getChangeStatus() {
        Log.e(TAG, "Entre aqui a getChangeStatus");
        if (changeStatus != null) {
            changeStatus = new MutableLiveData<>();
        }
        return changeStatus;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FirstViewModel.class);
        if (binding != null) {
            listeners();
        }
    }

    private void getChangeStatus(EnumStatesObservable enumStatesObservable) {
        Log.e(TAG, "enum:  " + enumStatesObservable);
        changeStatus.postValue(enumStatesObservable.toString());
    }

    private void listeners() {
        binding.firstButton.setOnClickListener(view -> {
            Log.e(TAG,"CLICK 1");
            changeStatus.postValue(EnumStatesObservable.INITIAL_STATUS.toString());
        });

        binding.secondButton.setOnClickListener(view -> {
            Log.e(TAG,"CLICK 2");
            changeStatus.postValue(EnumStatesObservable.INTERMEDIATE_STATUS.toString());
        });

        binding.thirdButton.setOnClickListener(view -> {
            Log.e(TAG,"CLICK 3");
            changeStatus.postValue(EnumStatesObservable.FINAL_STATUS.toString());
        });
    }

}
