package com.test.pocobservables;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.test.pocobservables.model.enums.EnumStatesObservable;
import com.test.pocobservables.view.FirstFragment;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private final FirstFragment firstFragment = new FirstFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        subscribeEvents();
    }

    private void subscribeEvents() {
        firstFragment.getChangeStatus().observe(this, this::changeObserver);
    }

    public void changeObserver(EnumStatesObservable enumStatesObservable) {
        if (enumStatesObservable != null) {
            Log.e(TAG,"enum" + enumStatesObservable);
        } else {
            Log.e(TAG,"enum is null");
        }
    }
    public void initUI(){
          addFragment();
//        callTimeObserver();
    }

    private void callTimeObserver() {
        try {
            changeObserver(EnumStatesObservable.INITIAL_STATUS);
            Thread.sleep(10000);
            changeObserver(EnumStatesObservable.INTERMEDIATE_STATUS);
            Thread.sleep(8000);
            changeObserver(EnumStatesObservable.FINAL_STATUS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void addFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, FirstFragment.class, null)
                .setReorderingAllowed(true)
                .commit();
    }


}