package com.example.moonnguyen.reload;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Moon Nguyen on 6/1/2018.
 */

public class Sinhvien extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "qlsinhvien";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME ="sinhvien";
    private static final String KEY_ID="_id";
    private static final String KEY_MSSV="Mssv";
    private static final String KEY_NAME="Hotensv";
    private static final String KEY_DOB="Ngaysinh";
    private static final String KEY_CLASS="Lop";

    public Sinhvien(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sql = "create table " + TABLE_NAME+
                "("+KEY_ID+" integer primary key autoincrement, "
                +KEY_MSSV+" text, "+KEY_NAME+" text, "
                +KEY_DOB+" text, "
                +KEY_CLASS+" text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists " +TABLE_NAME);
        onCreate(db);
    }

    public void taosinhvien(String mssv,String ten,String dob,String lop){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues noidung = new ContentValues();
        noidung.put(KEY_MSSV,mssv);
        noidung.put(KEY_NAME,ten);
        noidung.put(KEY_DOB,dob);
        noidung.put(KEY_CLASS,lop);

        String nullColumnHack = null;
        db.insert(TABLE_NAME,nullColumnHack,noidung);
    }


    public Cursor getAllSv(){
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor con_tro = db.rawQuery("select * from " +TABLE_NAME,null);
        return con_tro;
    }

    public boolean xoasv(String mssv){
        SQLiteDatabase db = this.getWritableDatabase();
        return  db.delete(TABLE_NAME,KEY_MSSV+"="+"'"+mssv+"'", null)>0;
    }

    public boolean suasv(String mssv,String ten,String dob,String lop){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues noidung = new ContentValues();
        noidung.put(KEY_MSSV,mssv);
        noidung.put(KEY_NAME,ten);
        noidung.put(KEY_DOB,dob);
        noidung.put(KEY_CLASS,lop);

        return db.update(TABLE_NAME,noidung,KEY_MSSV+"="+"'"+mssv+"'", null)>0;
    }

}
