package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.g;

/* loaded from: classes4.dex */
class h extends SQLiteOpenHelper {

    /* renamed from: b */
    private static Context f23986b;

    /* renamed from: a */
    private String f23987a;

    public static class a {

        /* renamed from: a */
        private static final h f23988a = new h(h.f23986b, j.b(h.f23986b), g.f23920b, null, 2);

        private a() {
        }
    }

    public /* synthetic */ h(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i10, AnonymousClass1 anonymousClass1) {
        this(context, str, str2, cursorFactory, i10);
    }

    public static h a(Context context) {
        if (f23986b == null) {
            f23986b = context.getApplicationContext();
        }
        return a.f23988a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23987a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23987a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!j.a(sQLiteDatabase, g.d.f23961a, "__av")) {
            j.a(sQLiteDatabase, g.d.f23961a, "__sp", "TEXT");
            j.a(sQLiteDatabase, g.d.f23961a, "__pp", "TEXT");
            j.a(sQLiteDatabase, g.d.f23961a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.d.f23961a, "__vc", "TEXT");
        }
        if (!j.a(sQLiteDatabase, g.b.f23935a, "__av")) {
            j.a(sQLiteDatabase, g.b.f23935a, "__av", "TEXT");
            j.a(sQLiteDatabase, g.b.f23935a, "__vc", "TEXT");
        }
        if (j.a(sQLiteDatabase, g.a.f23924a, "__av")) {
            return;
        }
        j.a(sQLiteDatabase, g.a.f23924a, "__av", "TEXT");
        j.a(sQLiteDatabase, g.a.f23924a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, g.d.f23961a);
        a(sQLiteDatabase, g.b.f23935a);
        a(sQLiteDatabase, g.a.f23924a);
        a();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                c(sQLiteDatabase);
                d(sQLiteDatabase);
                b(sQLiteDatabase);
                a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (SQLiteDatabaseCorruptException unused) {
                j.a(f23986b);
                if (sQLiteDatabase == null) {
                    return;
                }
            } catch (Throwable unused2) {
                if (sQLiteDatabase == null) {
                    return;
                }
            }
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused3) {
            }
        } catch (Throwable th2) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th2;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i10, int i11) {
        if (i11 <= i10 || i10 != 1) {
            return;
        }
        try {
            try {
                e(sQLiteDatabase);
            } catch (Exception unused) {
                e(sQLiteDatabase);
            }
        } catch (Exception unused2) {
            f(sQLiteDatabase);
        }
    }

    private h(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        this(new e(context, str), str2, cursorFactory, i10);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23987a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private h(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i10) {
        super(context, TextUtils.isEmpty(str) ? g.f23920b : str, cursorFactory, i10);
        this.f23987a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!j.a(g.d.f23961a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!j.a(g.c.f23948a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!j.a(g.b.f23935a, writableDatabase)) {
                b(writableDatabase);
            }
            if (j.a(g.a.f23924a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f23987a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        } catch (SQLException unused) {
        }
    }
}
