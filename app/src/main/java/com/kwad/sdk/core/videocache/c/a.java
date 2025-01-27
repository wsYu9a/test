package com.kwad.sdk.core.videocache.c;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.m;
import com.kwad.sdk.utils.ao;

/* loaded from: classes2.dex */
final class a extends SQLiteOpenHelper implements b {
    private static final String[] aon = {"_id", "url", "length", "mime"};

    a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        ao.checkNotNull(context);
    }

    private static ContentValues a(m mVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", mVar.url);
        contentValues.put("length", Long.valueOf(mVar.aoh));
        contentValues.put("mime", mVar.aoi);
        return contentValues;
    }

    private static m g(Cursor cursor) {
        return new m(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final void a(String str, m mVar) {
        ao.e(str, mVar);
        boolean z = db(str) != null;
        ContentValues a2 = a(mVar);
        if (z) {
            getWritableDatabase().update("SourceInfo", a2, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, a2);
        }
    }

    @Override // com.kwad.sdk.core.videocache.c.b
    public final m db(String str) {
        Throwable th;
        Cursor cursor;
        ao.eK(str);
        m mVar = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", aon, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        mVar = g(cursor);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return mVar;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        ao.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }
}
