package com.shu.priory.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.shu.priory.config.SDKConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class c extends SQLiteOpenHelper {

    /* renamed from: a */
    private static volatile c f17304a;

    private c(Context context) {
        super(context.getApplicationContext(), "iflyads_cache.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public static c a(Context context) {
        if (f17304a == null) {
            synchronized (c.class) {
                try {
                    if (f17304a == null) {
                        f17304a = new c(context);
                    }
                } finally {
                }
            }
        }
        return f17304a;
    }

    public synchronized String b(String str) {
        String str2;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        str2 = null;
        try {
            try {
                Cursor query = readableDatabase.query("ad_cache", null, "ad_unit_id=? and type=?", new String[]{str, "0"}, null, null, "ts", null);
                if (query.getCount() > 0 && query.moveToFirst()) {
                    long currentTimeMillis = System.currentTimeMillis();
                    while (true) {
                        if (currentTimeMillis - query.getLong(query.getColumnIndex("ts")) <= query.getInt(query.getColumnIndex("valid_time"))) {
                            h.a(SDKConstants.TAG, "find valid cache");
                            str2 = query.getString(query.getColumnIndex("content"));
                            break;
                        }
                        if (!query.moveToNext()) {
                            break;
                        }
                    }
                }
                query.close();
            } catch (Exception e10) {
                h.a(SDKConstants.TAG, "query cache error " + e10);
            }
            readableDatabase.close();
        } catch (Throwable th2) {
            readableDatabase.close();
            throw th2;
        }
        return str2;
    }

    public synchronized String c(String str) {
        String str2;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        str2 = null;
        try {
            try {
                Cursor query = readableDatabase.query("ad_cache", null, "ad_unit_id=? and type=?", new String[]{str, "1"}, null, null, "ts DESC", null);
                if (query.getCount() > 0 && query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndex("content"));
                }
                query.close();
            } catch (Exception e10) {
                h.a(SDKConstants.TAG, "query default cache error" + e10);
            }
            readableDatabase.close();
        } catch (Throwable th2) {
            readableDatabase.close();
            throw th2;
        }
        return str2;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        h.a(SDKConstants.TAG, "CacheManager onCreate");
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ad_cache(\n\t_id INTEGER PRIMARY KEY AUTOINCREMENT,\n\tad_unit_id VARCHAR(128) ,\n\tsid VARCHAR(128) ,\n\tcontent TEXT ,\n\ttype INTEGER,\n\tts INTEGER,\n\tvalid_time INTEGER \n)");
        } catch (Exception e10) {
            h.a(SDKConstants.TAG, "create table error: " + e10.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
    }

    public synchronized void a(String str) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            try {
                h.a(SDKConstants.TAG, "delete cache for " + str);
                writableDatabase.delete("ad_cache", "sid=? and type=?", new String[]{str, "0"});
            } catch (Exception e10) {
                h.a(SDKConstants.TAG, "delete cache error " + e10);
            }
        } finally {
            writableDatabase.close();
        }
    }

    public synchronized void a(String str, String str2, String str3, int i10, boolean z10) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            try {
                if (z10) {
                    h.a(SDKConstants.TAG, "delete default cache for " + str);
                    writableDatabase.delete("ad_cache", "ad_unit_id=? and type=?", new String[]{str, "1"});
                } else {
                    h.a(SDKConstants.TAG, "updateCache " + str3);
                    long currentTimeMillis = System.currentTimeMillis();
                    Cursor query = writableDatabase.query("ad_cache", null, "ad_unit_id=? and type=?", new String[]{str, "0"}, null, null, "ts", null);
                    ArrayList arrayList = new ArrayList();
                    if (query.getCount() > 0 && query.moveToFirst()) {
                        do {
                            if (currentTimeMillis - query.getLong(query.getColumnIndex("ts")) > query.getInt(query.getColumnIndex("valid_time"))) {
                                arrayList.add(Long.valueOf(query.getLong(query.getColumnIndex("_id"))));
                            }
                        } while (query.moveToNext());
                    }
                    query.close();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        writableDatabase.delete("ad_cache", "_id=?", new String[]{String.valueOf(((Long) it.next()).longValue())});
                    }
                    Cursor query2 = writableDatabase.query("ad_cache", null, "ad_unit_id=? and type=?", new String[]{str, "0"}, null, null, "ts", null);
                    long j10 = (query2.getCount() < 5 || !query2.moveToPosition(query2.getCount() - 5)) ? -1L : query2.getLong(query2.getColumnIndex("ts"));
                    query2.close();
                    if (j10 > 0) {
                        writableDatabase.delete("ad_cache", "ad_unit_id=? and ts<=?", new String[]{str, String.valueOf(j10)});
                    }
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("ad_unit_id", str);
                contentValues.put("content", str2);
                contentValues.put("valid_time", Integer.valueOf(i10));
                contentValues.put("sid", str3);
                contentValues.put("type", Integer.valueOf(z10 ? 1 : 0));
                contentValues.put("ts", Long.valueOf(System.currentTimeMillis()));
                writableDatabase.insert("ad_cache", null, contentValues);
            } catch (Exception e10) {
                e10.printStackTrace();
                h.a(SDKConstants.TAG, "update db error " + e10);
            }
            writableDatabase.close();
        } catch (Throwable th2) {
            writableDatabase.close();
            throw th2;
        }
    }
}
