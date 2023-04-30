package com.ram.e_commerceapp.features.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerceapp.R;
import com.ram.e_commerceapp.features.ProfileActivity;
import com.ram.e_commerceapp.features.post.CategoriesActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    EditText username;
    EditText password;
    Button loginButton;
  LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
           TextView textView = findViewById(R.id.signupText);
           textView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                   startActivity(intent);
               }
           });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String UserName  = username.getText().toString().trim();
                String Password = password.getText().toString().trim();
                presenter.LoginOnclick(UserName,Password);

               Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
               startActivity(intent);

                if (username.getText().toString().equals("") && password.getText().toString().equals("")) {
                    Toast.makeText(LoginActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(LoginActivity.this, PostActivity.class);
//                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Login Failed!", Toast.LENGTH_SHORT).show();
                }




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