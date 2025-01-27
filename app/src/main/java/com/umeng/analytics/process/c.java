package com.umeng.analytics.process;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
class c {

    /* renamed from: a */
    private static c f24215a;

    /* renamed from: b */
    private ConcurrentHashMap<String, a> f24216b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private Context f24217c;

    private c() {
    }

    public static c a(Context context) {
        if (f24215a == null) {
            synchronized (c.class) {
                try {
                    if (f24215a == null) {
                        f24215a = new c();
                    }
                } finally {
                }
            }
        }
        c cVar = f24215a;
        cVar.f24217c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f24216b.get(str) != null) {
            return this.f24216b.get(str);
        }
        a a10 = a.a(this.f24217c, str);
        this.f24216b.put(str, a10);
        return a10;
    }

    public synchronized void b(String str) {
        c(str).b();
    }

    public static class a {

        /* renamed from: a */
        private AtomicInteger f24218a = new AtomicInteger();

        /* renamed from: b */
        private SQLiteOpenHelper f24219b;

        /* renamed from: c */
        private SQLiteDatabase f24220c;

        private a() {
        }

        public static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f24219b = b.a(appContext, str);
            return aVar;
        }

        public synchronized void b() {
            try {
                if (this.f24218a.decrementAndGet() == 0) {
                    this.f24220c.close();
                }
            } catch (Throwable unused) {
            }
        }

        public synchronized SQLiteDatabase a() {
            try {
                if (this.f24218a.incrementAndGet() == 1) {
                    this.f24220c = this.f24219b.getWritableDatabase();
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return this.f24220c;
        }
    }

    public synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
