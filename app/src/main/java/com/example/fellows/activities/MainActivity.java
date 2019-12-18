package com.example.fellows.activities;
import androidx.appcompat.app.AppCompatActivity;

import android.net.nsd.NsdManager;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import com.example.fellows.R;

public class MainActivity extends AppCompatActivity {
    private TextView tVnotregistered;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            tVnotregistered = findViewById(R.id.tvnotregisterd);
            tVnotregistered.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(MainActivity.this,
                            RegisterActivity.class);

                    startActivity(intent);
                }
            });


        }
}
