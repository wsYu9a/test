package com.sigmob.sdk.downloader.core.breakpoint;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.SparseArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends SQLiteOpenHelper {

    /* renamed from: a */
    public static final String f19021a = "sig_breakpoint.db";

    /* renamed from: b */
    public static final int f19022b = 3;

    /* renamed from: c */
    public static final String f19023c = "FileDownloadResponseFilename";

    /* renamed from: d */
    public static final String f19024d = "breakpoint";

    /* renamed from: e */
    public static final String f19025e = "block";

    /* renamed from: f */
    public static final String f19026f = "taskFileDirty";

    public interface a {

        /* renamed from: a */
        public static final String f19027a = "CREATE TABLE IF NOT EXISTS breakpoint( id INTEGER PRIMARY KEY, url VARCHAR NOT NULL, etag VARCHAR, parent_path VARCHAR NOT NULL, filename VARCHAR, task_only_parent_path TINYINT(1) DEFAULT 0, chunked TINYINT(1) DEFAULT 0)";

        /* renamed from: b */
        public static final String f19028b = "CREATE TABLE IF NOT EXISTS block( id INTEGER PRIMARY KEY AUTOINCREMENT, breakpoint_id INTEGER, block_index INTEGER, start_offset INTEGER, content_length INTEGER, current_offset INTEGER)";

        /* renamed from: c */
        public static final String f19029c = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";

        /* renamed from: d */
        public static final String f19030d = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    public interface b {

        /* renamed from: a */
        public static final String f19031a = "CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)";

        /* renamed from: b */
        public static final String f19032b = "CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)";
    }

    public interface c {

        /* renamed from: a */
        public static final String f19033a = "SELECT * FROM taskFileDirty";

        /* renamed from: b */
        public static final String f19034b = "SELECT * FROM breakpoint";

        /* renamed from: c */
        public static final String f19035c = "SELECT * FROM block";

        /* renamed from: d */
        public static final String f19036d = "SELECT * FROM FileDownloadResponseFilename";

        /* renamed from: e */
        public static final String f19037e = "SELECT filename FROM FileDownloadResponseFilename WHERE url = ?";

        /* renamed from: f */
        public static final String f19038f = "SELECT id FROM breakpoint WHERE id = ? LIMIT 1";
    }

    public e(Context context) {
        super(context, f19021a, (SQLiteDatabase.CursorFactory) null, 3);
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar) throws IOException {
        int b10 = cVar.b();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        for (int i10 = 0; i10 < b10; i10++) {
            com.sigmob.sdk.downloader.core.breakpoint.a b11 = cVar.b(i10);
            if (writableDatabase.insert(f19025e, null, a(cVar.f19005a, i10, b11)) == -1) {
                throw new com.sigmob.sdk.downloader.core.exception.h("insert block " + b11 + " failed!");
            }
        }
        if (writableDatabase.insert(f19024d, null, b(cVar)) != -1) {
            return;
        }
        throw new com.sigmob.sdk.downloader.core.exception.h("insert info " + cVar + " failed!");
    }

    public HashMap<String, String> b() {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        HashMap<String, String> hashMap = new HashMap<>();
        Cursor cursor = null;
        try {
            cursor = writableDatabase.rawQuery(c.f19036d, null);
            while (cursor.moveToNext()) {
                int columnIndex = cursor.getColumnIndex("url");
                String str = "";
                String string = columnIndex >= 0 ? cursor.getString(columnIndex) : "";
                int columnIndex2 = cursor.getColumnIndex(f.f19043e);
                if (columnIndex2 >= 0) {
                    str = cursor.getString(columnIndex2);
                }
                hashMap.put(string, str);
            }
            cursor.close();
            return hashMap;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> c() {
        Cursor cursor;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor cursor2 = null;
        try {
            Cursor rawQuery = writableDatabase.rawQuery(c.f19034b, null);
            while (rawQuery.moveToNext()) {
                try {
                    arrayList.add(new d(rawQuery));
                } catch (Throwable th2) {
                    th = th2;
                    cursor = cursor2;
                    cursor2 = rawQuery;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            cursor2 = writableDatabase.rawQuery(c.f19035c, null);
            while (cursor2.moveToNext()) {
                arrayList2.add(new com.sigmob.sdk.downloader.core.breakpoint.b(cursor2));
            }
            rawQuery.close();
            cursor2.close();
            SparseArray<com.sigmob.sdk.downloader.core.breakpoint.c> sparseArray = new SparseArray<>();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.sigmob.sdk.downloader.core.breakpoint.c h10 = ((d) it.next()).h();
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    com.sigmob.sdk.downloader.core.breakpoint.b bVar = (com.sigmob.sdk.downloader.core.breakpoint.b) it2.next();
                    if (bVar.a() == h10.f19005a) {
                        h10.a(bVar.e());
                        it2.remove();
                    }
                }
                sparseArray.put(h10.f19005a, h10);
            }
            return sparseArray;
        } catch (Throwable th3) {
            th = th3;
            cursor = null;
        }
    }

    public void d(int i10) {
        getWritableDatabase().delete(f19024d, "id = ?", new String[]{String.valueOf(i10)});
        c(i10);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(a.f19027a);
        sQLiteDatabase.execSQL(a.f19028b);
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        setWriteAheadLoggingEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i10 == 1 && i11 == 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS FileDownloadResponseFilename( url VARCHAR NOT NULL PRIMARY KEY, filename VARCHAR NOT NULL)");
        }
        if (i10 <= 2) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS taskFileDirty( id INTEGER PRIMARY KEY)");
        }
    }

    public List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(c.f19033a, null);
            while (cursor.moveToNext()) {
                arrayList.add(Integer.valueOf(cursor.getInt(cursor.getColumnIndex("id"))));
            }
            cursor.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public void b(int i10) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("id", Integer.valueOf(i10));
        writableDatabase.insert(f19026f, null, contentValues);
    }

    public void c(int i10) {
        getWritableDatabase().delete(f19025e, "breakpoint_id = ?", new String[]{String.valueOf(i10)});
    }

    public static ContentValues b(com.sigmob.sdk.downloader.core.breakpoint.c cVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", Integer.valueOf(cVar.f19005a));
        contentValues.put("url", cVar.k());
        contentValues.put(f.f19041c, cVar.c());
        contentValues.put(f.f19042d, cVar.f19008d.getAbsolutePath());
        contentValues.put(f.f19043e, cVar.e());
        contentValues.put(f.f19044f, Integer.valueOf(cVar.n() ? 1 : 0));
        contentValues.put("chunked", Integer.valueOf(cVar.l() ? 1 : 0));
        return contentValues;
    }

    public void a(int i10) {
        getWritableDatabase().delete(f19026f, "id = ?", new String[]{String.valueOf(i10)});
    }

    public void c(com.sigmob.sdk.downloader.core.breakpoint.c cVar) throws IOException {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(c.f19038f, new String[]{Integer.toString(cVar.f19005a)});
            if (cursor.moveToNext()) {
                d(cVar.f19005a);
                a(cVar);
                writableDatabase.setTransactionSuccessful();
            }
            cursor.close();
            writableDatabase.endTransaction();
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            writableDatabase.endTransaction();
            throw th2;
        }
    }

    public static ContentValues a(int i10, int i11, com.sigmob.sdk.downloader.core.breakpoint.a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.f19046h, Integer.valueOf(i10));
        contentValues.put(f.f19047i, Integer.valueOf(i11));
        contentValues.put(f.f19048j, Long.valueOf(aVar.f()));
        contentValues.put(f.f19049k, Long.valueOf(aVar.b()));
        contentValues.put(f.f19050l, Long.valueOf(aVar.c()));
        return contentValues;
    }

    public void a(com.sigmob.sdk.downloader.core.breakpoint.c cVar, int i10, long j10) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(f.f19050l, Long.valueOf(j10));
        getWritableDatabase().update(f19025e, contentValues, "breakpoint_id = ? AND block_index = ?", new String[]{Integer.toString(cVar.f19005a), Integer.toString(i10)});
    }

    public void a(String str, String str2) {
        Cursor rawQuery;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("url", str);
        contentValues.put(f.f19043e, str2);
        synchronized (str.intern()) {
            Cursor cursor = null;
            try {
                try {
                    rawQuery = writableDatabase.rawQuery(c.f19037e, new String[]{str});
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    if (!rawQuery.moveToFirst()) {
                        writableDatabase.insert(f19023c, null, contentValues);
                    } else if (!str2.equals(rawQuery.getString(rawQuery.getColumnIndex(f.f19043e)))) {
                        writableDatabase.replace(f19023c, null, contentValues);
                    }
                    rawQuery.close();
                } catch (Throwable th3) {
                    th = th3;
                    cursor = rawQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            } finally {
            }
        }
    }
}
