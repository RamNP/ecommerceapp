package com.ram.e_commerceapp.features.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.ram.e_commerceapp.MainActivity;
import com.ram.e_commerceapp.R;
import com.ram.e_commerceapp.features.database.DatabaseHelper;


public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    EditText username;
    EditText password;
    Button loginButton;
  LoginContract.Presenter presenter;
  DatabaseHelper database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = DatabaseHelper.getInstance(this);
        presenter = new LoginPresenter(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
           TextView textView = findViewById(R.id.signupText);
           textView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(LoginActivity.this,  SignupActivity.class);
                   startActivity(intent);
               }
           });

        loginButton.setOnClickListener(v -> {
            String UserName  = username.getText().toString().trim();
            String Password = password.getText().toString().trim();
//                presenter.LoginOnclick(UserName,Password);
//            if (!UserName.isEmpty() && !Password.isEmpty()) {
//                if(database.userDao().getUserByName(UserName, Password)){
//                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                    startActivity(intent);
//                } else {
//                    showInvalidMessage("Invalid username and password.");
//                }
//            } else {
//                showInvalidMessage("The fields is empty!");
//            }

            if (username.getText().toString().equals("ram pariyar") && password.getText().toString().equals("ram12")) {

                showSuccessfulMessage("Login Successful");
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                showInvalidMessage("Invalid userName and password");
            }


    });

}

    @Override
    public void showSuccessfulMessage(String SuccessMessage) {
        toastMessage(SuccessMessage);

    }

    @Override
    public void showInvalidMessage(String invalidMessage) {
        toastMessage(invalidMessage);

    }
    public void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}