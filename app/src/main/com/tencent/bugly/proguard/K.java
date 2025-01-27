package com.tencent.bugly.proguard;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.analytics.pro.bx;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class K extends SQLiteOpenHelper {

    /* renamed from: a */
    public static String f22624a = "bugly_db";

    /* renamed from: b */
    public static int f22625b = 15;

    /* renamed from: c */
    protected Context f22626c;

    /* renamed from: d */
    private List<com.tencent.bugly.a> f22627d;

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
            java.lang.String r1 = com.tencent.bugly.proguard.K.f22624a
            r0.append(r1)
            java.lang.String r1 = "_"
            r0.append(r1)
            com.tencent.bugly.crashreport.common.info.a r1 = com.tencent.bugly.crashreport.common.info.a.a(r4)
            r1.getClass()
            java.lang.String r1 = ""
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r1 = com.tencent.bugly.proguard.K.f22625b
            r2 = 0
            r3.<init>(r4, r0, r2, r1)
            r3.f22626c = r4
            r3.f22627d = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.K.<init>(android.content.Context, java.util.List):void");
    }

    public synchronized boolean a(SQLiteDatabase sQLiteDatabase) {
        try {
            String[] strArr = {"t_lr", "t_ui", "t_pf"};
            for (int i10 = 0; i10 < 3; i10++) {
                String str = strArr[i10];
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DROP TABLE IF EXISTS ");
                sb2.append(str);
                sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            }
        } catch (Throwable th2) {
            if (!X.a(th2)) {
                th2.printStackTrace();
            }
            return false;
        }
        return true;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getReadableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i10 = 0;
        while (sQLiteDatabase == null && i10 < 5) {
            i10++;
            try {
                sQLiteDatabase = super.getReadableDatabase();
            } catch (Throwable unused) {
                X.e("[Database] Try to get db(count: %d).", Integer.valueOf(i10));
                if (i10 == 5) {
                    X.b("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
                }
            }
        }
        return sQLiteDatabase;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized SQLiteDatabase getWritableDatabase() {
        SQLiteDatabase sQLiteDatabase;
        sQLiteDatabase = null;
        int i10 = 0;
        while (sQLiteDatabase == null && i10 < 5) {
            i10++;
            try {
                sQLiteDatabase = super.getWritableDatabase();
            } catch (Throwable unused) {
                X.e("[Database] Try to get db(count: %d).", Integer.valueOf(i10));
                if (i10 == 5) {
                    X.b("[Database] Failed to get db.", new Object[0]);
                }
                try {
                    Thread.sleep(200L);
                } catch (InterruptedException e10) {
                    e10.printStackTrace();
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
            StringBuilder sb2 = new StringBuilder();
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS ");
            sb2.append("t_ui");
            sb2.append(" ( ");
            sb2.append("_id");
            sb2.append(" ");
            sb2.append("INTEGER PRIMARY KEY");
            sb2.append(" , ");
            sb2.append("_tm");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_ut");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append(bx.f23687e);
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_dt");
            sb2.append(" ");
            sb2.append("blob");
            sb2.append(" , ");
            sb2.append("_pc");
            sb2.append(" ");
            sb2.append("text");
            sb2.append(" ) ");
            X.a(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS ");
            sb2.append("t_lr");
            sb2.append(" ( ");
            sb2.append("_id");
            sb2.append(" ");
            sb2.append("INTEGER PRIMARY KEY");
            sb2.append(" , ");
            sb2.append(bx.f23687e);
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_tm");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_pc");
            sb2.append(" ");
            sb2.append("text");
            sb2.append(" , ");
            sb2.append("_th");
            sb2.append(" ");
            sb2.append("text");
            sb2.append(" , ");
            sb2.append("_dt");
            sb2.append(" ");
            sb2.append("blob");
            sb2.append(" ) ");
            X.a(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS ");
            sb2.append("t_pf");
            sb2.append(" ( ");
            sb2.append("_id");
            sb2.append(" ");
            sb2.append(TypedValues.Custom.S_INT);
            sb2.append(" , ");
            sb2.append(bx.f23687e);
            sb2.append(" ");
            sb2.append("text");
            sb2.append(" , ");
            sb2.append("_tm");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_dt");
            sb2.append(" ");
            sb2.append("blob");
            sb2.append(",primary key(");
            sb2.append("_id");
            sb2.append(",");
            sb2.append(bx.f23687e);
            sb2.append(" )) ");
            X.a(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS ");
            sb2.append("t_cr");
            sb2.append(" ( ");
            sb2.append("_id");
            sb2.append(" ");
            sb2.append("INTEGER PRIMARY KEY");
            sb2.append(" , ");
            sb2.append("_tm");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_s1");
            sb2.append(" ");
            sb2.append("text");
            sb2.append(" , ");
            sb2.append("_up");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_me");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_uc");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_dt");
            sb2.append(" ");
            sb2.append("blob");
            sb2.append(" ) ");
            X.a(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS ");
            sb2.append("dl_1002");
            sb2.append(" (");
            sb2.append("_id");
            sb2.append(" integer primary key autoincrement, ");
            sb2.append("_dUrl");
            sb2.append(" varchar(100), ");
            sb2.append("_sFile");
            sb2.append(" varchar(100), ");
            sb2.append("_sLen");
            sb2.append(" INTEGER, ");
            sb2.append("_tLen");
            sb2.append(" INTEGER, ");
            sb2.append("_MD5");
            sb2.append(" varchar(100), ");
            sb2.append("_DLTIME");
            sb2.append(" INTEGER)");
            X.a(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append("CREATE TABLE IF NOT EXISTS ");
            sb2.append("ge_1002");
            sb2.append(" (");
            sb2.append("_id");
            sb2.append(" integer primary key autoincrement, ");
            sb2.append("_time");
            sb2.append(" INTEGER, ");
            sb2.append("_datas");
            sb2.append(" blob)");
            X.a(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
            sb2.setLength(0);
            sb2.append(" CREATE TABLE IF NOT EXISTS ");
            sb2.append("st_1002");
            sb2.append(" ( ");
            sb2.append("_id");
            sb2.append(" ");
            sb2.append(TypedValues.Custom.S_INT);
            sb2.append(" , ");
            sb2.append(bx.f23687e);
            sb2.append(" ");
            sb2.append("text");
            sb2.append(" , ");
            sb2.append("_tm");
            sb2.append(" ");
            sb2.append(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
            sb2.append(" , ");
            sb2.append("_dt");
            sb2.append(" ");
            sb2.append("blob");
            sb2.append(",primary key(");
            sb2.append("_id");
            sb2.append(",");
            sb2.append(bx.f23687e);
            sb2.append(" )) ");
            X.a(sb2.toString(), new Object[0]);
            sQLiteDatabase.execSQL(sb2.toString(), new String[0]);
        } catch (Throwable th2) {
            if (!X.a(th2)) {
                th2.printStackTrace();
            }
        }
        List<com.tencent.bugly.a> list = this.f22627d;
        if (list == null) {
            return;
        }
        Iterator<com.tencent.bugly.a> it = list.iterator();
        while (it.hasNext()) {
            try {
                it.next().onDbCreate(sQLiteDatabase);
            } catch (Throwable th3) {
                if (!X.a(th3)) {
                    th3.printStackTrace();
                }
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    @TargetApi(11)
    public synchronized void onDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            if (com.tencent.bugly.crashreport.common.info.b.c() >= 11) {
                X.e("[Database] Downgrade %d to %d drop tables.", Integer.valueOf(i10), Integer.valueOf(i11));
                List<com.tencent.bugly.a> list = this.f22627d;
                if (list != null) {
                    Iterator<com.tencent.bugly.a> it = list.iterator();
                    while (it.hasNext()) {
                        try {
                            it.next().onDbDowngrade(sQLiteDatabase, i10, i11);
                        } catch (Throwable th2) {
                            if (!X.a(th2)) {
                                th2.printStackTrace();
                            }
                        }
                    }
                }
                if (a(sQLiteDatabase)) {
                    onCreate(sQLiteDatabase);
                } else {
                    X.e("[Database] Failed to drop, delete db.", new Object[0]);
                    File databasePath = this.f22626c.getDatabasePath(f22624a);
                    if (databasePath != null && databasePath.canWrite()) {
                        databasePath.delete();
                    }
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public synchronized void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            X.e("[Database] Upgrade %d to %d , drop tables!", Integer.valueOf(i10), Integer.valueOf(i11));
            List<com.tencent.bugly.a> list = this.f22627d;
            if (list != null) {
                Iterator<com.tencent.bugly.a> it = list.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().onDbUpgrade(sQLiteDatabase, i10, i11);
                    } catch (Throwable th2) {
                        if (!X.a(th2)) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
            if (a(sQLiteDatabase)) {
                onCreate(sQLiteDatabase);
            } else {
                X.e("[Database] Failed to drop, delete db.", new Object[0]);
                File databasePath = this.f22626c.getDatabasePath(f22624a);
                if (databasePath != null && databasePath.canWrite()) {
                    databasePath.delete();
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
    }
}
