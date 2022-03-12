package com.example.se2einzelphasefritz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText mtn = findViewById(R.id.editTextNumberMtn);

        Button btnTestServer = findViewById(R.id.btnTestServer);
        Button btnCalculateQuersumme = findViewById(R.id.btnSumCheck);

        TextView showReplySRV = findViewById(R.id.textViewReplyServer);
        TextView showResultQuersumme = findViewById(R.id.textViewQuersumme);

        btnTestServer.setOnClickListener(view -> {
           showReplySRV.setText("Test");
        });

        btnCalculateQuersumme.setOnClickListener(view -> {
            String mtnNumber = mtn.getText().toString();
            int test = Integer.parseInt(mtnNumber);
            test = test + 1;
            mtnNumber = String.valueOf(test);
            showResultQuersumme.setText(mtnNumber);
        });

    }
}