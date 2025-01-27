package com.wbl.ad.yzz.sensor;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.martian.mibook.application.MiConfigSingleton;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class DbAdapter {

    /* renamed from: d */
    public static final String f33776d;

    /* renamed from: e */
    public static final String f33777e;

    /* renamed from: a */
    public final Context f33778a;

    /* renamed from: b */
    public final String f33779b;

    /* renamed from: c */
    public a f33780c = null;

    public enum Table {
        EVENTS(com.umeng.analytics.pro.d.ar);

        private final String mTableName;

        Table(String str) {
            this.mTableName = str;
        }

        public static Table valueOf(String str) {
            return (Table) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10664, null, str);
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static Table[] valuesCustom() {
            return (Table[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10663, null, null);
        }

        public String getName() {
            return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10658, this, null);
        }
    }

    public static class a extends SQLiteOpenHelper {

        /* renamed from: a */
        public final File f33782a;

        public a(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
            this.f33782a = context.getDatabasePath(str);
        }

        public boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10657, this, null);
        }

        public void b() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10660, this, null);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10659, this, sQLiteDatabase);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10686, this, sQLiteDatabase, Integer.valueOf(i2), Integer.valueOf(i3));
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("CREATE TABLE ");
        Table table = Table.EVENTS;
        sb.append(table.getName());
        sb.append(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        sb.append(MiConfigSingleton.t0);
        sb.append(" STRING NOT NULL, ");
        sb.append("created_at");
        sb.append(" INTEGER NOT NULL);");
        f33776d = sb.toString();
        f33777e = "CREATE INDEX IF NOT EXISTS time_idx ON " + table.getName() + " (created_at);";
    }

    public DbAdapter(Context context, String str) {
        this.f33778a = context;
        this.f33779b = str;
        c();
    }

    public static /* synthetic */ String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10685, null, null);
    }

    public static /* synthetic */ String b() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10688, null, null);
    }

    public int a(String str, Table table) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10687, this, str, table);
    }

    public int a(JSONObject jSONObject, Table table) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10682, this, jSONObject, table);
    }

    public String[] a(Table table, int i2) {
        return (String[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10681, this, table, Integer.valueOf(i2));
    }

    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10684, this, null);
    }
}
