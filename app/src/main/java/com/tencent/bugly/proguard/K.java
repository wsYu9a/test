package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.analytics.pro.aq;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class K extends SQLiteOpenHelper {

    /* renamed from: a */
    public static String f24975a = "bugly_db";

    /* renamed from: b */
    public static int f24976b = 15;

    /* renamed from: c */
    protected Context f24977c;

    /* renamed from: d */
    private List<com.tencent.bugly.a> f24978d;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public K(android.content.Context r4, java.util.List<com.tencent.bugly.a> r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = com.tencent.bugly.proguard.K.f24975a
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            com.tencent.bugly.crashreport.common.info.a r1 = com.tencent.bugly.crashreport.common.info.a.a(r4)
            r1.getClass()
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r1 = com.tencent.bugly.proguard.K.f24976b
            r2 = 0
            r3.<init>(r4, r0, r2, r1)
            r3.f24977c = r4
            r3.f24978d = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.K.<init>(android.content.Context, java.util.List):void");
    }

    protected synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = new String[3];
            strArr[0] = "t_lr";
            strArr[1] = "t_ui";
            strArr[2] = "t_pf";
            for (int i2 = 0; i2 < 3; i2++) {
                String str = strArr[i2];
                StringBuilder sb = new StringBuilder();
                sb.append("DROP TABLE IF EXISTS ");
                sb.append(str);
                sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            }
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i2 = 0;
        while (sQLiteDatabase == null && i2 < 5) {
            i2++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                X.e("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    X.b("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i2 = 0;
        while (sQLiteDatabase == null && i2 < 5) {
            i2++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                X.e("[Database] Try to get db(count: %d).", Integer.valueOf(i2));
                if (i2 == 5) {
                    X.b("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (sQLiteDatabase == null) {
            X.e("[Database] db error delay error record 1min.", new Object[0]);
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_ui");
            sb.append(" ( ");
            sb.append("_id");
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_ut");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append(aq.f25697e);
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(" , ");
            sb.append("_pc");
            sb.append(" ");
            sb.append(com.baidu.mobads.sdk.internal.a.f5473b);
            sb.append(" ) ");
            X.a(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_lr");
            sb.append(" ( ");
            sb.append("_id");
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append(aq.f25697e);
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_pc");
            sb.append(" ");
            sb.append(com.baidu.mobads.sdk.internal.a.f5473b);
            sb.append(" , ");
            sb.append("_th");
            sb.append(" ");
            sb.append(com.baidu.mobads.sdk.internal.a.f5473b);
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(" ) ");
            X.a(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_pf");
            sb.append(" ( ");
            sb.append("_id");
            sb.append(" ");
            sb.append("integer");
            sb.append(" , ");
            sb.append(aq.f25697e);
            sb.append(" ");
            sb.append(com.baidu.mobads.sdk.internal.a.f5473b);
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(",primary key(");
            sb.append("_id");
            sb.append(",");
            sb.append(aq.f25697e);
            sb.append(" )) ");
            X.a(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("t_cr");
            sb.append(" ( ");
            sb.append("_id");
            sb.append(" ");
            sb.append("INTEGER PRIMARY KEY");
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_s1");
            sb.append(" ");
            sb.append(com.baidu.mobads.sdk.internal.a.f5473b);
            sb.append(" , ");
            sb.append("_up");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_me");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_uc");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(" ) ");
            X.a(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("dl_1002");
            sb.append(" (");
            sb.append("_id");
            sb.append(" integer primary key autoincrement, ");
            sb.append("_dUrl");
            sb.append(" varchar(100), ");
            sb.append("_sFile");
            sb.append(" varchar(100), ");
            sb.append("_sLen");
            sb.append(" INTEGER, ");
            sb.append("_tLen");
            sb.append(" INTEGER, ");
            sb.append("_MD5");
            sb.append(" varchar(100), ");
            sb.append("_DLTIME");
            sb.append(" INTEGER)");
            X.a(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append("CREATE TABLE IF NOT EXISTS ");
            sb.append("ge_1002");
            sb.append(" (");
            sb.append("_id");
            sb.append(" integer primary key autoincrement, ");
            sb.append("_time");
            sb.append(" INTEGER, ");
            sb.append("_datas");
            sb.append(" blob)");
            X.a(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
            sb.setLength(0);
            sb.append(" CREATE TABLE IF NOT EXISTS ");
            sb.append("st_1002");
            sb.append(" ( ");
            sb.append("_id");
            sb.append(" ");
            sb.append("integer");
            sb.append(" , ");
            sb.append(aq.f25697e);
            sb.append(" ");
            sb.append(com.baidu.mobads.sdk.internal.a.f5473b);
            sb.append(" , ");
            sb.append("_tm");
            sb.append(" ");
            sb.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb.append(" , ");
            sb.append("_dt");
            sb.append(" ");
            sb.append("blob");
            sb.append(",primary key(");
            sb.append("_id");
            sb.append(",");
            sb.append(aq.f25697e);
            sb.append(" )) ");
            X.a(sb.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb.toString(), new String[0]);
        } catch (Throwable th) {
            if (!X.a(th)) {
                th.printStackTrace();
            }
        }
        List<com.tencent.bugly.a> list = this.f24978d;
        if (list == null) {
            return;
        }
        Iterator<com.tencent.bugly.a> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th2) {
                if (!X.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (com.tencent.bugly.crashreport.common.info.b.c() >= 11) {
            X.e("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i2), Integer.valueOf(i3));
            List<com.tencent.bugly.a> list = this.f24978d;
            if (list != null) {
                Iterator<com.tencent.bugly.a> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbDowngrade(sQLiteDatabase, i2, i3);
                    } catch (Throwable th) {
                        if (!X.a(th)) {
                            th.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                X.e("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f24977c.getDatabasePath(f24975a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        X.e("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i2), Integer.valueOf(i3));
        List<com.tencent.bugly.a> list = this.f24978d;
        if (list != null) {
            Iterator<com.tencent.bugly.a> it = list.iterator();
            while (it.hasNext()) {
                try {
                    it.next().onDbUpgrade(sQLiteDatabase, i2, i3);
                } catch (Throwable th) {
                    if (!X.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
        }
        if (a(sQLiteDatabase)) {
            onCreate(sQLiteDatabase);
        } else {
            X.e("[Database] Failed to drop, delete db.", new Object[0]);
            File databasePath = this.f24977c.getDatabasePath(f24975a);
            if (databasePath != null && databasePath.canWrite()) {
                databasePath.delete();
            }
        }
    }
}
