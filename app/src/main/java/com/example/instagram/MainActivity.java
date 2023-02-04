package com.example.instagram;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;

import com.example.instagram.databinding.ActivityMainBinding;
import com.example.instagram.fragment.Home;
import com.example.instagram.fragment.Notification;
import com.example.instagram.fragment.Post;
import com.example.instagram.fragment.Profile;
import com.example.instagram.fragment.Search;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        replaceFragment(new Home());


        binding.bottomNavigation.setOnItemReselectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.itemHome:

                    replaceFragment(new Home());
                    break;
                case R.id.itemSearch:

                    replaceFragment(new Search());
                    break;
                case R.id.itemAddPost:

                    replaceFragment(new Post());
                    break;
                case R.id.itemNotification:

                    replaceFragment(new Notification());
                    break;
                case R.id.itemProfile:

                    replaceFragment(new Profile());
                    break;

            }


        });


    }
    public void replaceFragment(Fragment fragment) {
        Log.e(TAG, "replaceFragment:fragmentChange");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.commit();
    }


}