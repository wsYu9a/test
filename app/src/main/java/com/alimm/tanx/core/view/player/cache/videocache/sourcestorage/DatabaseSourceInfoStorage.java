package com.alimm.tanx.core.view.player.cache.videocache.sourcestorage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.alimm.tanx.core.view.player.cache.videocache.Preconditions;
import com.alimm.tanx.core.view.player.cache.videocache.SourceInfo;

/* loaded from: classes.dex */
class DatabaseSourceInfoStorage extends SQLiteOpenHelper implements SourceInfoStorage {
    private static final String[] ALL_COLUMNS = {"_id", "url", "length", "mime"};
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_LENGTH = "length";
    private static final String COLUMN_MIME = "mime";
    private static final String COLUMN_URL = "url";
    private static final String CREATE_SQL = "CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);";
    private static final String TABLE = "SourceInfo";

    public DatabaseSourceInfoStorage(Context context) {
        super(context, "AndroidVideoCache.db", (SQLiteDatabase.CursorFactory) null, 1);
        Preconditions.checkNotNull(context);
    }

    private SourceInfo convert(Cursor cursor) {
        return new SourceInfo(cursor.getString(cursor.getColumnIndexOrThrow("url")), cursor.getLong(cursor.getColumnIndexOrThrow("length")), cursor.getString(cursor.getColumnIndexOrThrow("mime")));
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public SourceInfo get(String str) {
        Throwable th2;
        Cursor cursor;
        Preconditions.checkNotNull(str);
        SourceInfo sourceInfo = null;
        try {
            cursor = getReadableDatabase().query("SourceInfo", ALL_COLUMNS, "url=?", new String[]{str}, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        sourceInfo = convert(cursor);
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
            return sourceInfo;
        } catch (Throwable th4) {
            th2 = th4;
            cursor = null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Preconditions.checkNotNull(sQLiteDatabase);
        sQLiteDatabase.execSQL("CREATE TABLE SourceInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,url TEXT NOT NULL,mime TEXT,length INTEGER);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        throw new IllegalStateException("Should not be called. There is no any migration");
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void put(String str, SourceInfo sourceInfo) {
        Preconditions.checkAllNotNull(str, sourceInfo);
        boolean z10 = get(str) != null;
        ContentValues convert = convert(sourceInfo);
        if (z10) {
            getWritableDatabase().update("SourceInfo", convert, "url=?", new String[]{str});
        } else {
            getWritableDatabase().insert("SourceInfo", null, convert);
        }
    }

    @Override // com.alimm.tanx.core.view.player.cache.videocache.sourcestorage.SourceInfoStorage
    public void release() {
        close();
    }

    private ContentValues convert(SourceInfo sourceInfo) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("url", sourceInfo.url);
        contentValues.put("length", Long.valueOf(sourceInfo.length));
        contentValues.put("mime", sourceInfo.mime);
        return contentValues;
    }
}
