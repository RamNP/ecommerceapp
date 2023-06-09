package com.ram.e_commerceapp.features.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ram.e_commerceapp.R;
import com.ram.e_commerceapp.features.database.DatabaseHelper;
import com.ram.e_commerceapp.features.database.User;

import java.util.List;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SignupActivity extends AppCompatActivity  implements LoginContract.View{

    EditText userName;
    EditText userMobileNo;
    EditText userEmail;
    EditText userPassword;
    Button signupButton;
    DatabaseHelper database;
    List<User> userArrayList;

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        database = DatabaseHelper.getInstance(this);
        Button button = findViewById(R.id.signupButton);

        userName = findViewById(R.id.name);
        userMobileNo = findViewById(R.id.phoneNumber);
        userEmail = findViewById(R.id.tvEmail);
        userPassword = findViewById(R.id.tvPassword);

        button.setOnClickListener(v -> {
            insertUser()
                    .subscribeOn(Schedulers.io())
                    .subscribe(new CompletableObserver() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {
                            CompositeDisposable compositeDisposable = new CompositeDisposable();
                            compositeDisposable.add(d);
                        }

                        @Override
                        public void onComplete() {

                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }
                    });
        });
    }

    public Completable insertUser() {
        String name = userName.getText().toString().trim();
        long mobileNo = Long.parseLong(userMobileNo.getText().toString().trim());
        String email = userEmail.getText().toString().trim();
        String password = userPassword.getText().toString().trim();
        // check the empty values
        if (name.isEmpty() || mobileNo == 0 || email.isEmpty() || password.isEmpty()) {
            return null;
        } else {
            userArrayList.add(new User(name,mobileNo,email,password));
//            showSuccessfulMessage("Register is successfully");
            startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                  showSuccessfulMessage("Register is successfully");

            return database.userDao().insertAll(userArrayList);
        }
    }


    @Override
    public void showSuccessfulMessage(String SuccessMessage) {
        toastMessage(SuccessMessage);



    }

    @Override
    public void showInvalidMessage(String invalidMessage) {

    }
    public void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

}