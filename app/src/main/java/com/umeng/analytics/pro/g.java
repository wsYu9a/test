package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
class g {

    /* renamed from: b */
    private static SQLiteOpenHelper f25907b;

    /* renamed from: d */
    private static Context f25908d;

    /* renamed from: a */
    private AtomicInteger f25909a;

    /* renamed from: c */
    private SQLiteDatabase f25910c;

    private static class a {

        /* renamed from: a */
        private static final g f25911a = new g();

        private a() {
        }
    }

    /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a(Context context) {
        if (f25908d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f25908d = applicationContext;
            f25907b = f.a(applicationContext);
        }
        return a.f25911a;
    }

    public synchronized void b() {
        try {
            if (this.f25909a.decrementAndGet() == 0) {
                this.f25910c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private g() {
        this.f25909a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        if (this.f25909a.incrementAndGet() == 1) {
            this.f25910c = f25907b.getWritableDatabase();
        }
        return this.f25910c;
    }
}
