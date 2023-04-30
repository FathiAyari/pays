package com.cyrine.pays;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.cyrine.pays.UserContract;
import com.cyrine.pays.UserDbHelper;

public class UserManager {
    private UserDbHelper dbHelper;

    public UserManager(Context context) {
        dbHelper = new UserDbHelper(context);
    }

    public boolean login(String username, String password) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] projection = {
                UserContract.UserEntry._ID,
                UserContract.UserEntry.COLUMN_USERNAME,
                UserContract.UserEntry.COLUMN_PASSWORD
        };

        String selection = UserContract.UserEntry.COLUMN_USERNAME + " = ?";
        String[] selectionArgs = { username };

        Cursor cursor = db.query(
                UserContract.UserEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        boolean success = false;

        if (cursor.moveToFirst()) {
            String storedPassword = cursor.getString(cursor.getColumnIndex(UserContract.UserEntry.COLUMN_PASSWORD));
            if (password.equals(storedPassword)) {
                // Authentication successful
                success = true;
            }
        }

        cursor.close();

        return success;
    }
}
