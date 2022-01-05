package com.mehmetberkan.theworldofmybooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mehmetberkan.theworldofmybooks.entity.Book;

import java.util.ArrayList;
import java.util.List;

public class Db_Manager_Book {
    SQLiteDatabase db;
    Database dbm;

    public Db_Manager_Book(Context context) {
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
            ContentValues val = new ContentValues();
            val.put("name", name);
            val.put("author", author);
            val.put("numberofsize", numberofsize);
            val.put("category", category);
            val.put("owned", owned);
            val.put("read", read);
            db.insert("books", null, val);
            return "Başarıyla " + name + " eklendi";
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    public String update_book(int id,String name, String author, int numberofsize, String category, Boolean owned, Boolean read) {
        try{
            ContentValues val = new ContentValues();
            val.put("name", name);
            val.put("author", author);
            val.put("numberofsize", numberofsize);
            val.put("category", category);
            val.put("owned", owned);
            val.put("read", read);
            db.update("books",val,"id="+id,null);
            return "Başarıyla No : " + id + " güncellendi";
        }catch (Exception e) {
            return e.getMessage();
        }
    }

    public String delete_book(int bookId) {
        try {
            db.delete("books", "id=" + bookId, null);
            return "Başarıyla Silindi";
        } catch (Exception e) {
            return e.getMessage().toString();
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
                Book book = new Book(id, name, author, numberofsize, category, owned, read);
                bookList.add(book.toString());
                c.moveToNext();
            }
            return bookList;
        }
        return null;
    }

    public Book getByBookId(int bookId) {
        Cursor c = db.rawQuery("select * from books where id = "+bookId,null);
        if(c.moveToFirst()) {
            int id = c.getInt(0);
            String name = c.getString(1);
            String author = c.getString(2);
            int numberofsize = c.getInt(3);
            String category = c.getString(4);
            Boolean owned = c.getInt(5) > 0;
            Boolean read = c.getInt(6) > 0;
            Book book = new Book(id, name, author, numberofsize, category, owned, read);
            return book;
        }
        return null;
    }
}
