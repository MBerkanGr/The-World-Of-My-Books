package com.mehmetberkan.theworldofmybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mehmetberkan.theworldofmybooks.entity.Book;
import com.mehmetberkan.theworldofmybooks.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Db_Manager_User {
    SQLiteDatabase db;
    Database dbm;

    public Db_Manager_User(Context context) {
        dbm = new Database(context);
    }

    public void open() {
        db = dbm.getWritableDatabase();
    }

    public void close() {
        dbm.close();
    }

    public String add_user(String nameSurname, String userName, String password) {
        try{
            ContentValues val = new ContentValues();
            val.put("namesurname", nameSurname);
            val.put("username", userName);
            val.put("password", password);
            db.insert("users",null,val);
            return "Hoş geldin "+nameSurname;
        }catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String columns[] = {"id", "namesurname", "username", "password"};

        Cursor c = db.rawQuery("select * from users",null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                int id = c.getInt(0);
                String namesurname = c.getString(1);
                String username = c.getString(2);
                String password = c.getString(3);

                User user = new User(id,namesurname,username,password);
                userList.add(user);
                c.moveToNext();
            }
            return userList;
        }
        return null;
    }

    public Boolean login(String userName, String password) {
        try{
            Cursor c = db.rawQuery("select * from users",null);
            if(c.moveToFirst()) {
                while (!c.isAfterLast()) {
                    int id = c.getInt(0);
                    String nameSurnameC = c.getString(1);
                    String userNameC = c.getString(2);
                    String passwordC = c.getString(3);
                    System.out.println(nameSurnameC+" "+passwordC);
                    if(userName.equals(userNameC) && password.equals(passwordC)) {
                        return true;
                    }
                    c.moveToNext();
                }
            }
            return false;
        }catch(Exception e) {
            return false;
        }
    }
}
