package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.X;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: id */
    public int f22063id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z10, BuglyStrategy buglyStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DROP TABLE IF EXISTS ");
                sb2.append(str);
                sQLiteDatabase.execSQL(sb2.toString());
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th2) {
            if (X.a(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("DROP TABLE IF EXISTS ");
                sb2.append(str);
                sQLiteDatabase.execSQL(sb2.toString());
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th2) {
            if (X.a(th2)) {
                return;
            }
            th2.printStackTrace();
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }
}
