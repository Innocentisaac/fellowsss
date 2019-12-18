package com.example.fellows.models;

public class ContactModel {
    public static String TABLE_NAME = "contact";
    public static String COLUMN_ID = "id";
    public static String COLUMN_FULLNAME = "fullname";
    public static String COLUMN_EMAIL = "email";
    public static String COLUMN_PHONE = "phone";
    public static String COLUMN_GENDER = "gender";
    public static String COLUMN_STATE = "state";
    public static String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String fullname;
    private String email;
    private String phone;
    private String gender;
    private String state;
    private String timestamp;


    public ContactModel(){}
    public ContactModel(int id, String fullname, String email, String phone, String gender,
                        String state, String timestamp) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.state = state;
        this.timestamp = timestamp;
    }

    //Creating SQL Table Query

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME  + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + COLUMN_FULLNAME + " TEXT, "
                    + COLUMN_EMAIL + " TEXT, "
                    + COLUMN_PHONE + " TEXT, "
                    + COLUMN_GENDER + " TEXT, "
                    + COLUMN_STATE + " TEXT, "
                    + COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                    + ")";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }





    }



