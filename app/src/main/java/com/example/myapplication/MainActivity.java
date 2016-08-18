package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.example.myapplication.MESSAGE";
    public static final List<String> Services = Arrays.asList("DIAG", "TMS", "TIME", "UTILS", "QDSS");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();

        if (message.matches("[a-zA-Z]+") && Services.contains(message)) {
            Log.i(message, "message ");
            message = Integer.toString(Integer.parseInt(String.valueOf(Services.indexOf(message)))+1) + message;
        } else if (message.matches("[0-9]+") && (Integer.parseInt(message) < Services.size())) {
            Log.i(message, "message ");
            message = message + Services.get(Integer.parseInt(message) - 1);
        } else
            message = "Invalid Input";

        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}
