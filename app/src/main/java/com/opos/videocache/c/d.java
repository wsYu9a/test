package com.opos.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.opos.videocache.f;
import com.opos.videocache.j;

/* loaded from: classes4.dex */
class d extends SQLiteOpenHelper implements b {

    /* renamed from: a */
    private static final String[] f23810a = {"_id", "url", "length", "mime"};

    d(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        f.a(context);
    }

    private ContentValues a(j jVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", jVar.f23816a);
        contentValues.put("length", Long.valueOf(jVar.f23817b));
        contentValues.put("mime", jVar.f23818c);
        return contentValues;
    }

    private j a(Cursor cursor) {
        return new j(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.opos.videocache.c.b
    public j a(String str) {
        f.a(str);
        Cursor cursor = null;
        r0 = null;
        j a2 = null;
        try {
            Cursor query = getReadableDatabase().query("SourceInfo", f23810a, "url=?", new String[]{str}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        a2 = a(query);
                    }
                } catch (Throwable th) {
                    cursor = query;
                    th = th;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            return a2;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // com.opos.videocache.c.b
    public void a(String str, j jVar) {
        f.a(str, jVar);
        boolean z = a(str) != null;
        ContentValues a2 = a(jVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        f.a(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
