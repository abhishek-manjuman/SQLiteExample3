package com.swipcom.sqliteexample;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) !=null){

            if (savedInstanceState !=null){
                return;
            }

            HomeFragment homeFragment=new HomeFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homeFragment,null).commit();

        }
    }

}
