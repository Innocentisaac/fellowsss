package com.example.fellows.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.fellows.ContactDetails;
import com.example.fellows.R;
import com.example.fellows.adapter.ContactHelper;

public class RegisterActivity extends AppCompatActivity {
    private  EditText etfname, etlname, etemail, etphone;
    private Spinner spstates, spgender;
    //private RadioButton rmale, rfemale;
    private Button bregister;
    private String fname, email, state, gender,phone, lname;
  //  private Boolean male, female;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //instantiating widgets
        etfname = (EditText) findViewById(R.id.etfname);
        etlname = findViewById(R.id.etlname);
        etemail = findViewById(R.id.etemail);
        etphone = findViewById(R.id.etphone);
        spstates = findViewById(R.id.spstates);
        spgender = findViewById(R.id.spgender);
       // rmale = findViewById(R.id.rmale);
      //  rfemale = findViewById(R.id.rfemale);
        bregister = findViewById(R.id.bregister);
        bregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process();
            }
        });
    }
    private void process() {
        //type casting
        fname = etfname.getText().toString().trim();
        lname = etlname.getText().toString().trim();
        fname =  fname + " " + lname;
        email= etemail.getText().toString().trim();
        phone = etphone.getText().toString().trim();
        gender = spgender.getSelectedItem().toString();
        state = spstates.getSelectedItem().toString();

        //rfemale.setChecked(false);
        //validating input fields
        if (fname.isEmpty()) {
            etfname.setError("Please enter your first name");
            Toast.makeText(getApplicationContext(), "please enter your first name",
                    Toast.LENGTH_LONG).show();
        }   else if (TextUtils.isEmpty(lname)) {
            etlname.setError("Please enter your last name");
        }   else if  (TextUtils.isEmpty(phone) || !phone.startsWith("0") || phone.length() <11)
            etphone.setError("Please enter a valid phone number");
        else if (gender.equalsIgnoreCase( "Select gender")) {
            Toast.makeText(getApplicationContext(), "Please select your gender",
                    Toast.LENGTH_LONG).show();
        }  else if(state.equalsIgnoreCase("Select state")) {
                Toast.makeText(getApplicationContext(), "Please select your state",
                        Toast.LENGTH_LONG).show();

        }
     //   else if(!rfemale.isChecked() && !rmale.isChecked()) {
         //   Toast.makeText(getApplicationContext(), "Please select your gender",
           //         Toast.LENGTH_LONG).show();

        else {
            ContactHelper helper = new ContactHelper(RegisterActivity.this);
            helper.insertUserDetails(fname, phone, email, gender, state);
            Toast.makeText(getApplicationContext(), "data entered succesfully",
                    Toast.LENGTH_LONG).show();
            Intent intent = new Intent(RegisterActivity.this, ContactDetails.class);
            startActivity(intent);
        }
    }
}
