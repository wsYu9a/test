package com.opos.acs.st.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes4.dex */
public final class a extends SQLiteOpenHelper {

    /* renamed from: a */
    private static SQLiteDatabase f16278a;

    private a(Context context) {
        super(context, "acs_st.db", (SQLiteDatabase.CursorFactory) null, 8);
    }

    public static SQLiteDatabase a(Context context) {
        String str;
        String str2;
        synchronized (a.class) {
            try {
                SQLiteDatabase sQLiteDatabase = f16278a;
                if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                    try {
                        f16278a = new a(context).getWritableDatabase();
                    } catch (SQLiteException e2) {
                        e = e2;
                        str = "SQLiteHelper";
                        str2 = "getInstance SQLiteException";
                        com.opos.cmn.an.f.a.d(str, str2, e);
                        return f16278a;
                    } catch (Exception e3) {
                        e = e3;
                        str = "SQLiteHelper";
                        str2 = "getInstance Exception";
                        com.opos.cmn.an.f.a.d(str, str2, e);
                        return f16278a;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f16278a;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            com.opos.cmn.an.f.a.b("SQLiteHelper", "create table:");
            if (sQLiteDatabase != null) {
                sQLiteDatabase.beginTransaction();
                try {
                    try {
                        com.opos.cmn.an.f.a.b("SQLiteHelper", "create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                        sQLiteDatabase.execSQL("create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                        com.opos.cmn.an.f.a.b("SQLiteHelper", "create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                        sQLiteDatabase.execSQL("create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                        com.opos.cmn.an.f.a.b("SQLiteHelper", "create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                        sQLiteDatabase.execSQL("create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
                        sQLiteDatabase.setTransactionSuccessful();
                        com.opos.cmn.an.f.a.c("SQLiteHelper", "setTransactionSuccessful");
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("SQLiteHelper", e2.getMessage(), (Throwable) e2);
                    }
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    sQLiteDatabase.endTransaction();
                    throw th;
                }
            }
        } catch (Exception e3) {
            com.opos.cmn.an.f.a.a("SQLiteHelper", e3.getMessage());
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        com.opos.cmn.an.f.a.a("SQLiteHelper", "onDowngrade db old version code=" + i2 + "\tnew version code=" + i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        com.opos.cmn.an.f.a.a("SQLiteHelper", "upgrade db old version code=" + i2 + "\tnew version code=" + i3);
        if (i3 <= i2 || sQLiteDatabase == null) {
            return;
        }
        sQLiteDatabase.beginTransaction();
        if (i2 < 6) {
            try {
                try {
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_acs_st_db_cache");
                    sQLiteDatabase.execSQL("create table\tt_acs_st_db_cache\t(ID\tinteger primary key autoincrement,EVENT_ID\ttext,ACS_ID\ttext,URL\ttext,HEAD_JSON_STRING\ttext,BODY_JSON_STRING\ttext,EVENT_JSON_STRING\ttext,BATCH_ID\ttext,EVENT_TIME\tlong,UPLOAD_TYPE\tinteger);");
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS t_stat_batch_entity");
                    sQLiteDatabase.execSQL("create table\tt_stat_batch_entity\t(ID\tinteger primary key autoincrement,BATCH_ID\ttext,ACS_POS_IDS\ttext,EFFECTIVE_TAG\tinteger);");
                    i2 = 6;
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.a("SQLiteHelper", e2.getMessage(), (Throwable) e2);
                }
            } catch (Throwable th) {
                sQLiteDatabase.endTransaction();
                throw th;
            }
        }
        if (i2 < 7) {
            sQLiteDatabase.execSQL("create table\tt_biz_entity\t(ID\tinteger primary key autoincrement,BIZ_DATA\ttext,EVENT_TIME\tlong,UPDATE_TIME\tlong);");
            i2 = 7;
        }
        if (i2 < 8) {
            sQLiteDatabase.execSQL("ALTER TABLE t_acs_st_db_cache ADD COLUMN UPLOAD_TYPE integer");
        }
        sQLiteDatabase.setTransactionSuccessful();
        com.opos.cmn.an.f.a.c("SQLiteHelper", "setTransactionSuccessful");
        sQLiteDatabase.endTransaction();
    }
}
