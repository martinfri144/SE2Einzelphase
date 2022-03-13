package com.example.se2einzelphasefritz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {

    EditText mtn;
    TextView showReplyServer;
    TextView showResultQuersumme;

    Button btnTestServer;
    Button btnCalculateQuersumme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showResultQuersumme = findViewById(R.id.textViewQuersumme);

        btnTestServer = findViewById(R.id.btnTestServer);
        btnCalculateQuersumme = findViewById(R.id.btnSumCheck);


        btnCalculateQuersumme.setOnClickListener(view -> {
            String mtnNumber = mtn.getText().toString();
            int mtnNum = Integer.parseInt(mtnNumber);
            int testnum = 0;

            for (int i = 0; i <= mtnNumber.length(); i++) {

                testnum = i;

            }

            String test = String.valueOf(testnum);
            showResultQuersumme.setText(test);
        });

    }

    public void buttonSRVClick(View v) {
        mtn = findViewById(R.id.editTextNumberMtn);
        showReplyServer = findViewById(R.id.textViewReplyServer);

        String mtnToSrv = mtn.getText().toString();
        ConnectionThread c = new ConnectionThread(mtnToSrv);
        c.start();
        try {
            c.join();
        }
        catch (InterruptedException ie) {
            showReplyServer.setText("fehler");
        }

        showReplyServer.setText(c.returnMtn());
    }
}
