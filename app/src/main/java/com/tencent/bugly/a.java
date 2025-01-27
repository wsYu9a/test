package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.X;

/* loaded from: classes.dex */
public abstract class a {
    public int id;
    public String moduleName;
    public String version;
    public String versionKey;

    public abstract String[] getTables();

    public abstract void init(Context context, boolean z, BuglyStrategy buglyStrategy);

    public void onDbCreate(SQLiteDatabase sQLiteDatabase) {
    }

    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                StringBuilder sb = new StringBuilder();
                sb.append("DROP TABLE IF EXISTS ");
                sb.append(str);
                sQLiteDatabase.execSQL(sb.toString());
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th) {
            if (X.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        try {
            if (getTables() == null) {
                return;
            }
            for (String str : getTables()) {
                StringBuilder sb = new StringBuilder();
                sb.append("DROP TABLE IF EXISTS ");
                sb.append(str);
                sQLiteDatabase.execSQL(sb.toString());
            }
            onDbCreate(sQLiteDatabase);
        } catch (Throwable th) {
            if (X.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public void onServerStrategyChanged(StrategyBean strategyBean) {
    }
}
