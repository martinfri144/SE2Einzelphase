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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void buttonCheckSum(View v) {
        mtn = findViewById(R.id.editTextNumberMtn);
        showResultQuersumme = findViewById(R.id.textViewQuersumme);
        String mtnString = mtn.getText().toString();
        int mtnNumber = Integer.parseInt(mtnString);
        int even = 0;
        int odd = 0;
        int length = mtn.length();

         for (int i = length; i > 0; i--) {

             if (i % 2 == 0) {
                    even = even + mtnNumber % 10;
             } else {
                 odd = odd + mtnNumber % 10;
             }
             mtnNumber = mtnNumber / 10;
             length--;
         }

         int result = odd - even;
         length--;
         showResultQuersumme.setText(Integer.toString(result));
    }
}
