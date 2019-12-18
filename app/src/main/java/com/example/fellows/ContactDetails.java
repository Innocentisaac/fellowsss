package com.example.fellows;

import androidx.appcompat.app.AppCompatActivity;
import com.example.fellows.R;
import com.example.fellows.adapter.ContactHelper;

import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactDetails extends AppCompatActivity {
    ContactHelper helper;
    ListView list;
    ListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);

        helper = new ContactHelper(getApplicationContext());
        ArrayList<HashMap<String, String >> userList = helper.getUser();
        list = findViewById(R.id.listView);
        adapter = new SimpleAdapter(ContactDetails.this, userList, R.layout.contacts_layouts,
                new String[] {"fullname", "email", "phone", "gender", "state"},
                new int[] {R.id.tvname, R.id.tvemail, R.id.tvphone, R.id.tvgender, R.id.tvstate} );
        list.setAdapter(adapter);



    }
}
