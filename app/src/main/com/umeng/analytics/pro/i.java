package com.umeng.analytics.pro;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
class i {

    /* renamed from: b */
    private static SQLiteOpenHelper f23989b;

    /* renamed from: d */
    private static Context f23990d;

    /* renamed from: a */
    private AtomicInteger f23991a;

    /* renamed from: c */
    private SQLiteDatabase f23992c;

    public static class a {

        /* renamed from: a */
        private static final i f23993a = new i();

        private a() {
        }
    }

    public /* synthetic */ i(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static i a(Context context) {
        if (f23990d == null && context != null) {
            Context applicationContext = context.getApplicationContext();
            f23990d = applicationContext;
            f23989b = h.a(applicationContext);
        }
        return a.f23993a;
    }

    public synchronized void b() {
        try {
            if (this.f23991a.decrementAndGet() == 0) {
                this.f23992c.close();
            }
        } catch (Throwable unused) {
        }
    }

    private i() {
        this.f23991a = new AtomicInteger();
    }

    public synchronized SQLiteDatabase a() {
        try {
            if (this.f23991a.incrementAndGet() == 1) {
                this.f23992c = f23989b.getWritableDatabase();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f23992c;
    }
}
