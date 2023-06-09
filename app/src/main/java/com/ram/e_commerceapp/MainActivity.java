package com.ram.e_commerceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.ram.e_commerceapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    ContractFragment contractFragment = new ContractFragment();
    CategoriesFragment categoriesFragment = new CategoriesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
            /*
            This Java code retrieves the FCM registration token from the device and logs it using the Android Log class.
            It uses an asynchronous task with a completion listener to handle the token retrieval and error logging.
            */
        FirebaseMessaging.getInstance().getToken()
                        .addOnCompleteListener(new OnCompleteListener<String>() {
                            @Override
                            public void onComplete(@NonNull Task<String> task) {
                                if (!task.isSuccessful()) {
                                    Log.e("Error Message", task.getException().getLocalizedMessage());
                                }
                                // get new FCM registration token
                                String token = task.getResult();
                        //      String message = getString(R.string.notification, token);
                                Log.d("Token", token);
                            }
                        });
        /*
         * This code sets up a listener for the BottomNavigationView and handles the item selection event.
         * When an item is selected, it replaces the current fragment with a new fragment, depending on the
         * selected item. The fragment is displayed in the container view with the specified ID.
         */
         bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
             @SuppressLint("NonConstantResourceId")
             @Override
             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                 switch (item.getItemId()){
                     case R.id.home:
                         getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                     case R.id.Profile:
                         getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
                         return true;

                     case R.id.categories:
                         getSupportFragmentManager().beginTransaction().replace(R.id.container,categoriesFragment).commit();
                         return true;

                     case R.id.contract:
                         getSupportFragmentManager().beginTransaction().replace(R.id.container,contractFragment).commit();
                         return true;

                 }
                 return false;
             }
         });

    }
}