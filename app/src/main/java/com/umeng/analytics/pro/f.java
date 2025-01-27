package com.umeng.analytics.pro;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import com.umeng.analytics.pro.e;

/* loaded from: classes4.dex */
class f extends SQLiteOpenHelper {

    /* renamed from: b */
    private static Context f25904b;

    /* renamed from: a */
    private String f25905a;

    private static class a {

        /* renamed from: a */
        private static final f f25906a = new f(f.f25904b, h.b(f.f25904b), e.f25842b, null, 2);

        private a() {
        }
    }

    /* synthetic */ f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i2, AnonymousClass1 anonymousClass1) {
        this(context, str, str2, cursorFactory, i2);
    }

    public static f a(Context context) {
        if (f25904b == null) {
            f25904b = context.getApplicationContext();
        }
        return a.f25906a;
    }

    private void c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25905a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void d(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25905a = "create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __is(id INTEGER primary key autoincrement, __ii TEXT unique, __e TEXT, __sp TEXT, __pp TEXT, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private void e(SQLiteDatabase sQLiteDatabase) {
        if (!h.a(sQLiteDatabase, e.d.f25883a, "__av")) {
            h.a(sQLiteDatabase, e.d.f25883a, "__sp", "TEXT");
            h.a(sQLiteDatabase, e.d.f25883a, "__pp", "TEXT");
            h.a(sQLiteDatabase, e.d.f25883a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.d.f25883a, "__vc", "TEXT");
        }
        if (!h.a(sQLiteDatabase, e.b.f25857a, "__av")) {
            h.a(sQLiteDatabase, e.b.f25857a, "__av", "TEXT");
            h.a(sQLiteDatabase, e.b.f25857a, "__vc", "TEXT");
        }
        if (h.a(sQLiteDatabase, e.a.f25846a, "__av")) {
            return;
        }
        h.a(sQLiteDatabase, e.a.f25846a, "__av", "TEXT");
        h.a(sQLiteDatabase, e.a.f25846a, "__vc", "TEXT");
    }

    private void f(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase, e.d.f25883a);
        a(sQLiteDatabase, e.b.f25857a);
        a(sQLiteDatabase, e.a.f25846a);
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
                h.a(f25904b);
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
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable unused4) {
                }
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        if (i3 <= i2 || i2 != 1) {
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

    private f(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        this(new c(context, str), str2, cursorFactory, i2);
    }

    private void b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25905a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
            sQLiteDatabase.execSQL("create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER, __av TEXT, __vc TEXT)");
        } catch (SQLException unused) {
        }
    }

    private f(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i2) {
        super(context, TextUtils.isEmpty(str) ? e.f25842b : str, cursorFactory, i2);
        this.f25905a = null;
        a();
    }

    public void a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!h.a(e.d.f25883a, writableDatabase)) {
                c(writableDatabase);
            }
            if (!h.a(e.c.f25870a, writableDatabase)) {
                d(writableDatabase);
            }
            if (!h.a(e.b.f25857a, writableDatabase)) {
                b(writableDatabase);
            }
            if (h.a(e.a.f25846a, writableDatabase)) {
                return;
            }
            a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    private void a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f25905a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER, __av TEXT, __vc TEXT)";
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
