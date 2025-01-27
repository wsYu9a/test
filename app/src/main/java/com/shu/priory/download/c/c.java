package com.shu.priory.download.c;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes3.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17009a = String.format("CREATE TABLE %s (_id integer PRIMARY KEY NOT NULL,uri varchar(255) NOT NULL,path varchar(255) NOT NULL);", "download_info");

    public c(Context context) {
        super(context, "ifly_ad.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(f17009a);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }
}
