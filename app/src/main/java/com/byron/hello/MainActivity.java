package com.byron.hello;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView messageText;
    private Button helloButton;
    private int tapCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageText = findViewById(R.id.messageText);
        helloButton = findViewById(R.id.helloButton);

        helloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tapCount++;
                String message = "你好，安卓！👋\n\n你已经点了 " + tapCount + " 次";
                messageText.setText(message);
            }
        });
    }
}
