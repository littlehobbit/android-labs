package com.example.lab_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText emailField, passwordField;

    private String userEmail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailField = findViewById(R.id.email_field);
        passwordField = findViewById(R.id.password_field);

        userEmail = getString(R.string.email);
        userPassword = getString(R.string.password);

        loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(
                (View view) -> {
                    String email = emailField.getText().toString();
                    String password = passwordField.getText().toString();

                    Bundle userData = new Bundle();
                    userData.putString("password", password);
                    userData.putString("email", email);

                    Intent secondActivity = new Intent(this, NavigationActivity.class);
                    secondActivity.putExtra("data", userData);

//                    if (email.equals(userEmail) && password.equals(userPassword)) {
                        showToast(getString(R.string.successful_login), Toast.LENGTH_SHORT);
                        startActivity(secondActivity);
//                    } else {
//                        showToast(getString(R.string.login_error), Toast.LENGTH_SHORT);
//                    }

                }
        );

    }

    private void showToast(String msg, int duration) {
        Toast toast = Toast.makeText(this, msg, duration);
        toast.show();
    }
}