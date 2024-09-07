package com.example.register2;

import android.os.Bundle;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView displayNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        displayNameTextView = findViewById(R.id.l1);

        String firstName = getIntent().getStringExtra("FIRST_NAME");
        String lastName = getIntent().getStringExtra("LAST_NAME");
        String selectedOption = getIntent().getStringExtra("SELECTED_OPTION");
        String email = getIntent().getStringExtra("EMAIL");
        String phoneNumber = getIntent().getStringExtra("PHONE_NUMBER");
        String password = getIntent().getStringExtra("PASSWORD");
        String dateOfBirth = getIntent().getStringExtra("DATE_OF_BIRTH");

        displayNameTextView.setText("First Name: " +firstName + "\n"+"Last Name: " +  lastName + "\n"+"Gender: " +selectedOption+ "\n" + "Email: " + email+ "\n" + "Phone Number: " + phoneNumber+ "\n" + "Password: " + password+ "\n" + "Date of Birth: " + dateOfBirth);
    }
}