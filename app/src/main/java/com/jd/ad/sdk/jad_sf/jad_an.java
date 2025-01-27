package com.jd.ad.sdk.jad_sf;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes2.dex */
public class jad_an extends SQLiteOpenHelper {
    public SQLiteDatabase jad_an;

    public jad_an(Context context, String str, int i10) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i10);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        if (jad_bo()) {
            this.jad_an.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase readableDatabase = super.getReadableDatabase();
        this.jad_an = readableDatabase;
        return readableDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase writableDatabase = super.getWritableDatabase();
        this.jad_an = writableDatabase;
        return writableDatabase;
    }

    public boolean jad_bo() {
        SQLiteDatabase sQLiteDatabase = this.jad_an;
        return sQLiteDatabase != null && sQLiteDatabase.isOpen();
    }
}
