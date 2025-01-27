package com.opos.cmn.biz.monitor.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: a */
    private SQLiteDatabase f16686a;

    public b(Context context) {
        super(context, "monitor_cache.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    private SQLiteDatabase a() {
        SQLiteDatabase sQLiteDatabase = this.f16686a;
        if (sQLiteDatabase != null) {
            return sQLiteDatabase;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        this.f16686a = writableDatabase;
        return writableDatabase;
    }

    private d a(Cursor cursor) {
        return new d(cursor.getString(cursor.getColumnIndex("id")), cursor.getString(cursor.getColumnIndex("monitorUrl")), cursor.getLong(cursor.getColumnIndex("createTime")));
    }

    public int a(long j2) {
        return a().delete("monitor_cache", "createTime<=?", new String[]{String.valueOf(j2)});
    }

    public int a(d dVar) {
        return TextUtils.isEmpty(dVar.f16711a) ? a().delete("monitor_cache", "monitorUrl=? and createTime=?", new String[]{dVar.f16713c, String.valueOf(dVar.f16712b)}) : a().delete("monitor_cache", "id=?", new String[]{dVar.f16711a});
    }

    public List<d> a(long j2, long j3, int i2) {
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = a().rawQuery("select *\tfrom\tmonitor_cache\twhere\tcreateTime\t>=?\tand\tcreateTime\t<=?\torder by random() limit ?;", new String[]{String.valueOf(j2), String.valueOf(j3), String.valueOf(i2)});
        if (rawQuery != null) {
            try {
                for (boolean moveToFirst = rawQuery.moveToFirst(); moveToFirst; moveToFirst = rawQuery.moveToNext()) {
                    linkedList.add(a(rawQuery));
                }
            } finally {
                try {
                    rawQuery.close();
                } catch (Exception unused) {
                }
            }
        }
        return linkedList;
    }

    public void a(List<d> list) {
        SQLiteDatabase a2 = a();
        a2.beginTransaction();
        try {
            for (d dVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("monitorUrl", dVar.f16713c);
                contentValues.put("createTime", Long.valueOf(dVar.f16712b));
                a2.insert("monitor_cache", null, contentValues);
            }
            a2.setTransactionSuccessful();
        } finally {
            a2.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public void close() {
        SQLiteDatabase sQLiteDatabase = this.f16686a;
        if (sQLiteDatabase != null) {
            sQLiteDatabase.close();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table\tmonitor_cache\t(id\tinteger primary key autoincrement,monitorUrl\ttext,createTime\tlong)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        com.opos.cmn.an.f.a.a("CacheDBHelper", "onDowngrade db old version code=" + i2 + "\tnew version code=" + i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
