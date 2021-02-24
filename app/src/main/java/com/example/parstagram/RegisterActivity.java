package com.example.parstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class RegisterActivity extends AppCompatActivity {
    public static final String TAG = "RegisterActivity";

    EditText etUsername;
    EditText etEmail;
    EditText etPassword;
    Button btnRegister;

    // Create the ParseUser
    ParseUser user = new ParseUser();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername = findViewById(R.id.etUsername);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String email = etEmail.getText().toString();

                if(username.isEmpty() || password.isEmpty() || email.isEmpty() )
                {
                    Toast.makeText(RegisterActivity.this, "No fields can be empty.", Toast.LENGTH_LONG).show();
                    return;
                }
                signUpUser(username, password, email);
                goLoginActivity();
            }
        });
    }

    private void signUpUser(String username, String password, String email) {
        ParseUser user = new ParseUser();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.put("user", username);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null) {
                    Log.e(TAG, "Error Signing Up", e);
                    return;
                }
                else
                    Toast.makeText(RegisterActivity.this, "Sign-up Successful!", Toast.LENGTH_LONG).show();
                goLoginActivity();
            }
        });
    }

    private void goLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}