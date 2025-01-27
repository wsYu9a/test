package com.vivo.mobilead.b;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.vivo.mobilead.util.x0;

/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper {
    public a(Context context) {
        this(context.getApplicationContext(), "vivoopenadsdk.db");
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(a("vivo_report_url"));
        } catch (Exception e2) {
            x0.b("DBHelper", "create table failed: " + e2.getMessage());
        }
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            sQLiteDatabase.execSQL(b("vivo_report_url"));
        } catch (Exception e2) {
            x0.b("DBHelper", "drop table failed: " + e2.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            a(sQLiteDatabase);
        } catch (Exception e2) {
            x0.b("DBHelper", "onCreate Exception..." + e2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 < i2) {
            b(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 > i2) {
            b(sQLiteDatabase);
            onCreate(sQLiteDatabase);
        }
    }

    public a(Context context, String str) {
        this(context, str, 4);
    }

    public a(Context context, String str, int i2) {
        this(context, str, null, i2);
    }

    private String a(String str) {
        return "CREATE TABLE IF NOT EXISTS " + str + " (id INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT,coop varchar[20],create_time LONG,reqId TEXT,posId TEXT,level int,third_report int,reason TEXT,report_flag varchar[1],retry_time INTEGER);";
    }

    private String b(String str) {
        return "DROP TABLE IF EXISTS " + str;
    }

    public a(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, str, cursorFactory, i2);
    }
}
