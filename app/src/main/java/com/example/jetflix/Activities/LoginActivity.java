package com.example.jetflix.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.jetflix.R;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUser, edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        initView();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        }

    private void initView() {
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(view -> {
            if (edtUser.getText().toString().isEmpty() || edtPassword.getText().toString().isEmpty()) {
                Toast.makeText(LoginActivity.this, "Please fill your username and password.", Toast.LENGTH_SHORT).show();

            } else if (edtUser.getText().toString().equals("usertest") && edtPassword.getText().toString().equals("userpass")) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            } else {
                Toast.makeText(LoginActivity.this, "Invalid username and password.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}