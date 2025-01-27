package com.kwad.sdk.core.videocache.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kwad.sdk.core.videocache.n;
import com.kwad.sdk.utils.au;

/* loaded from: classes3.dex */
final class a extends SQLiteOpenHelper implements c {
    private static final String[] aGW = {"_id", "url", com.sigmob.sdk.videocache.sourcestorage.a.f20681d, com.sigmob.sdk.videocache.sourcestorage.a.f20682e};

    public a(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        au.checkNotNull(context);
    }

    private static n i(Cursor cursor) {
        return new n(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow(com.sigmob.sdk.videocache.sourcestorage.a.f20681d)), cursor.getString(cursor.getColumnIndexOrThrow(com.sigmob.sdk.videocache.sourcestorage.a.f20682e)));
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final void a(String str, n nVar) {
        au.f(str, nVar);
        boolean z10 = eV(str) != null;
        ContentValues a10 = a(nVar);
        if (z10) {
            getWritableDatabase().update(com.sigmob.sdk.videocache.sourcestorage.a.f20678a, a10, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert(com.sigmob.sdk.videocache.sourcestorage.a.f20678a, null, a10);
        }
    }

    @Override // com.kwad.sdk.core.videocache.d.c
    public final n eV(String str) {
        Throwable th2;
        Cursor cursor;
        au.gV(str);
        n nVar = null;
        try {
            cursor = getReadableDatabase().query(com.sigmob.sdk.videocache.sourcestorage.a.f20678a, aGW, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        nVar = i(cursor);
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
                    throw th2;
                }
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(cursor);
            return nVar;
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        au.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL(com.sigmob.sdk.videocache.sourcestorage.a.f20684g);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    private static ContentValues a(n nVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", nVar.url);
        contentValues.put(com.sigmob.sdk.videocache.sourcestorage.a.f20681d, Long.valueOf(nVar.aGQ));
        contentValues.put(com.sigmob.sdk.videocache.sourcestorage.a.f20682e, nVar.aGR);
        return contentValues;
    }
}
