package com.opos.cmn.biz.requeststatistic.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.martian.mibook.application.MiConfigSingleton;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends SQLiteOpenHelper {

    /* renamed from: a */
    static final String f16783a = b.class.getSimpleName();

    public b(Context context) {
        super(context, "request_statistic.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    public final List<c> a(long j2, long j3) {
        LinkedList linkedList = new LinkedList();
        Cursor rawQuery = getWritableDatabase().rawQuery("select *\tfrom\trequest_statistic\twhere\tcreateTime\t>=?\tand\tcreateTime\t<=?\tlimit ?;", new String[]{String.valueOf(j2), String.valueOf(j3), "100"});
        if (rawQuery != null) {
            try {
                for (boolean moveToFirst = rawQuery.moveToFirst(); moveToFirst; moveToFirst = rawQuery.moveToNext()) {
                    linkedList.add(new c(rawQuery.getLong(rawQuery.getColumnIndex("id")), rawQuery.getString(rawQuery.getColumnIndex(MiConfigSingleton.t0)), rawQuery.getLong(rawQuery.getColumnIndex("createTime"))));
                }
            } finally {
                try {
                    rawQuery.close();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.b(f16783a, "cursor close fail", e2);
                }
            }
        }
        return linkedList;
    }

    public final void a(List<c> list) {
        if (list.isEmpty()) {
            return;
        }
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            for (c cVar : list) {
                ContentValues contentValues = new ContentValues();
                contentValues.put(MiConfigSingleton.t0, cVar.f16785b);
                contentValues.put("createTime", Long.valueOf(cVar.f16786c));
                cVar.f16784a = getWritableDatabase().insert("request_statistic", null, contentValues);
            }
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table\trequest_statistic\t(id\tinteger primary key,\tdata\ttext,\tcreateTime\tlong)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }
}
