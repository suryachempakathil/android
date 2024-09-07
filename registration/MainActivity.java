package com.example.register2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private Button registerButton;
    private RadioGroup radioGroup;
    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private EditText dateOfBirthEditText;
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
        firstNameEditText = findViewById(R.id.e1);
        lastNameEditText = findViewById(R.id.e2);
        registerButton = findViewById(R.id.b1);
        radioGroup = findViewById(R.id.radioGroup);
        emailEditText = findViewById(R.id.e4);
        phoneNumberEditText = findViewById(R.id.e5);
        passwordEditText = findViewById(R.id.e6);
        dateOfBirthEditText = findViewById(R.id.e7);
    }

    public void register(View view) {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phoneNumber = phoneNumberEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String dateOfBirth = dateOfBirthEditText.getText().toString();

        if (firstName.isEmpty()) {
            showToast("First Name is required");
            return;
        }
        if (lastName.isEmpty()) {
            showToast("Last Name is required");
            return;
        }

        // Check if a gender is selected
        int selectedId = radioGroup.getCheckedRadioButtonId();
        if (selectedId == -1) {
            showToast("Gender is required");
            return;
        }
        RadioButton selectedRadioButton = findViewById(selectedId);
        String selectedOption = selectedRadioButton.getText().toString();

        // Validate email
        if (email.isEmpty()) {
            showToast("Email is required");
            return;
        }
        if (!email.contains("@")) {
            showToast("Email must contain '@'");
            return;
        }

        // Validate phone number
        if (phoneNumber.isEmpty()) {
            showToast("Phone Number is required");
            return;
        }
        if (!phoneNumber.matches("\\d+")) { // Check if phone number contains only digits
            showToast("Phone Number must contain only digits");
            return;
        }

        // Validate password
        if (password.isEmpty()) {
            showToast("Password is required");
            return;
        }

        // Validate date of birth (assuming format YYYY)
        if (dateOfBirth.isEmpty()) {
            showToast("Date of Birth is required");
            return;
        }



        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
        intent.putExtra("FIRST_NAME", firstName);
        intent.putExtra("LAST_NAME", lastName);
        intent.putExtra("SELECTED_OPTION", selectedOption);
        intent.putExtra("EMAIL", email);
        intent.putExtra("PHONE_NUMBER", phoneNumber);
        intent.putExtra("PASSWORD", password);
        intent.putExtra("DATE_OF_BIRTH", dateOfBirth);
        startActivity(intent);
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
