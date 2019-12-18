package com.example.fellows.adapter;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.fellows.models.ContactModel;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "contact_db";

    public ContactHelper(Context context) {
        super(context,
                DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(ContactModel.CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void insertUserDetails (String fullname, String email, String phone, String gender,
                                   String state){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ContactModel.COLUMN_FULLNAME, fullname);
        values.put(ContactModel.COLUMN_EMAIL, email);
        values.put(ContactModel.COLUMN_PHONE, email);
        values.put(ContactModel.COLUMN_GENDER, gender);
        values.put(ContactModel.COLUMN_STATE, state);
        long newData = db.insert(ContactModel.TABLE_NAME, null, values);
        db.close();

    }

    //get user details
    public ArrayList<HashMap<String, String >> getUser() {
        SQLiteDatabase db = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String query = "SELECT fullname, email, phone, gender, state FROM " + ContactModel.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,  null);
        while (cursor.moveToNext()) {
            HashMap<String, String> user = new HashMap<>();
            user.put("fullname", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_FULLNAME)));
            user.put("email", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_EMAIL)));
            user.put("phone", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_PHONE)));
            user.put("gender", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_GENDER)));
            user.put("state", cursor.getString(cursor.getColumnIndex(ContactModel.COLUMN_STATE)));

            userList.add(user);

        }
        return userList;
    }

}

