package com.example.loginpage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void click(View view) {
        EditText userName=findViewById(R.id.et1);
        EditText password=findViewById(R.id.password);
        String inputUsername = userName.getText().toString();
        String inputPassword = password.getText().toString();
        String user="Admin";
        String pass="Admin";
        if(inputUsername.isEmpty() || inputPassword.isEmpty()) {
            Toast.makeText(this, "Please fill the feilds", Toast.LENGTH_SHORT).show();
        }
        else if(inputPassword.equals(pass)&& inputUsername.equals(user)){
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MainPage.class);
            startActivity(intent);

        }
        else {
            Toast.makeText(this, "Login Failed...!!!", Toast.LENGTH_SHORT).show();
        }

    }
    }


