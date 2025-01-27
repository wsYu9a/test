package com.sigmob.sdk.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.sigmob.sdk.videocache.o;
import com.sigmob.sdk.videocache.v;

/* loaded from: classes4.dex */
public class a extends SQLiteOpenHelper implements c {

    /* renamed from: a */
    public static final String f20678a = "SourceInfo";

    /* renamed from: b */
    public static final String f20679b = "_id";

    /* renamed from: c */
    public static final String f20680c = "url";

    /* renamed from: d */
    public static final String f20681d = "length";

    /* renamed from: e */
    public static final String f20682e = "mime";

    /* renamed from: f */
    public static final String[] f20683f = {"_id", "url", f20681d, f20682e};

    /* renamed from: g */
    public static final String f20684g = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        o.a(context);
    }

    public final ContentValues a(v vVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", vVar.f20685a);
        contentValues.put(f20681d, Long.valueOf(vVar.f20686b));
        contentValues.put(f20682e, vVar.f20687c);
        return contentValues;
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public v get(String str) {
        Throwable th2;
        Cursor cursor;
        o.a(str);
        v vVar = null;
        try {
            cursor = getReadableDatabase().query(f20678a, f20683f, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        vVar = a(cursor);
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th2;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return vVar;
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        o.a(sQLiteDatabase);
        sQLiteDatabase.execSQL(f20684g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    public final v a(Cursor cursor) {
        return new v(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(f20681d)), cursor.getString(cursor.getColumnIndexOrThrow(f20682e)));
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a(String str, v vVar) {
        o.a(str, vVar);
        boolean z10 = get(str) != null;
        ContentValues a10 = a(vVar);
        if (z10) {
            getWritableDatabase().update(f20678a, a10, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(f20678a, null, a10);
        }
    }

    @Override // com.sigmob.sdk.videocache.sourcestorage.c
    public void a() {
        close();
    }
}
