package com.github.ricardosbarbosa.habittracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.format.Time;

/**
 * Created by ricardobarbosa on 31/01/17.
 */
public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "habittracker.db";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        final String SQL_CREATE_HABIT_TABLE = "CREATE TABLE " + Contract.HabitEntry.TABLE_NAME + " (" +
                Contract.HabitEntry._ID + " INTEGER PRIMARY KEY," +
                Contract.HabitEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                Contract.HabitEntry.COLUMN_DATE + " DATE NOT NULL, " +
                Contract.HabitEntry.COLUMN_TIME + " TEXT NOT NULL " +
                " );";

        sqLiteDatabase.execSQL(SQL_CREATE_HABIT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Contract.HabitEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}