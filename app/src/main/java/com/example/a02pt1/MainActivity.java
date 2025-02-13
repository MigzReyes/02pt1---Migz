package com.example.a02pt1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE="com.example.a02pt1";

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
    
    public void sendMessage (View view) {

        EditText textField = findViewById(R.id.textField);
        EditText textField2 = findViewById(R.id.textField2);

        String text = textField.getText().toString().trim();
        String text2 = textField2.getText().toString().trim();

        Intent intent = new Intent(this, DisplayMessageActivity01.class);
        String message;
        if (text.equalsIgnoreCase(text2)) {
            message = "Both text field are the same";
        } else {
            message = "Both text field are not the same";
        }
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}