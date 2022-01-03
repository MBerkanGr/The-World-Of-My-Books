package com.mehmetberkan.theworldofmybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mehmetberkan.theworldofmybooks.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class Db_Manager {
    SQLiteDatabase db;
    Database dbm;

    public Db_Manager(Context context) {
        dbm = new Database(context);
    }

    public void open() {
        db = dbm.getWritableDatabase();
    }

    public void close() {
        dbm.close();
    }

    public String add_book(String name, String author, int numberofsize, String category, Boolean owned, Boolean read) {
        try {
            Book book = new Book(name, author, numberofsize, category, owned, read);
            ContentValues val = new ContentValues();
            val.put("name", book.getName());
            val.put("author", book.getAuthor());
            val.put("numberofsize", book.getNumberofsize());
            val.put("category", book.getCategory());
            val.put("owned", book.isOwned());
            val.put("read", book.isRead());
            db.insert("Books", null, val);
            return "Başarıyla " + book.getName() + " eklendi";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String delete_book(int bookId) {
        try {
            db.delete("books", "id=" + bookId, null);
            return "Başarıyla Silindi";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<String> getListBooks() {
        List<String> bookList = new ArrayList<>();
        String columns[] = {"id", "name", "author", "numberofsize", "category", "owned", "read"};

        Cursor c = db.rawQuery("select * from books where owned = 1",null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                int id = c.getInt(0);
                String name = c.getString(1);
                String author = c.getString(2);
                int numberofsize = c.getInt(3);
                String category = c.getString(4);
                Boolean owned = c.getInt(5) > 0;
                Boolean read = c.getInt(6) > 0;
                System.out.println(read);
                Book book = new Book(id, name, author, numberofsize, category, owned, read);
                bookList.add(book.toString());
                c.moveToNext();
            }
            return bookList;
        }
        return null;
    }

    public List<String> getListTargetBooks() {
        List<String> bookList = new ArrayList<>();
        String columns[] = {"id", "name", "author", "numberofsize", "category", "owned", "read"};

        Cursor c = db.rawQuery("select * from books where owned = 0",null);
        if (c.moveToFirst()) {
            while (!c.isAfterLast()) {
                int id = c.getInt(0);
                String name = c.getString(1);
                String author = c.getString(2);
                int numberofsize = c.getInt(3);
                String category = c.getString(4);
                Boolean owned = c.getInt(5) > 0;
                Boolean read = c.getInt(6) > 0;
                System.out.println(read);
                Book book = new Book(id, name, author, numberofsize, category, owned, read);
                bookList.add(book.toString());
                c.moveToNext();
            }
            return bookList;
        }
        return null;
    }
}
