package com.github.ricardosbarbosa.habittracker;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

public class Contract {

    static final String CONTENT_AUTHORITY = "com.github.ricardosbarbosa.habittracker";

    private static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    static final String PATH_HABIT = "habit";

    /* Inner class that defines the table contents of the habit table */
    public static final class HabitEntry implements BaseColumns {

        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_HABIT).build();

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HABIT;
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_HABIT;

        public static final String TABLE_NAME = "habit";

        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_TIME = "time";
        public static final String COLUMN_DATE = "date";

        public static Uri buildHabitUri(long id) {
            return ContentUris.withAppendedId(CONTENT_URI, id);
        }

        public static Integer getHabitIdFromUri(Uri uri) {
            return Integer.parseInt((uri.getPathSegments().get(1)));
        }
    }

}