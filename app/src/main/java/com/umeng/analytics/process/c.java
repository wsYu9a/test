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
    private static c f26068a;

    /* renamed from: b */
    private ConcurrentHashMap<String, a> f26069b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private Context f26070c;

    private c() {
    }

    static c a(Context context) {
        if (f26068a == null) {
            synchronized (c.class) {
                if (f26068a == null) {
                    f26068a = new c();
                }
            }
        }
        c cVar = f26068a;
        cVar.f26070c = context;
        return cVar;
    }

    private a c(String str) {
        if (this.f26069b.get(str) != null) {
            return this.f26069b.get(str);
        }
        a a2 = a.a(this.f26070c, str);
        this.f26069b.put(str, a2);
        return a2;
    }

    synchronized void b(String str) {
        c(str).b();
    }

    static class a {

        /* renamed from: a */
        private AtomicInteger f26071a = new AtomicInteger();

        /* renamed from: b */
        private SQLiteOpenHelper f26072b;

        /* renamed from: c */
        private SQLiteDatabase f26073c;

        private a() {
        }

        static a a(Context context, String str) {
            Context appContext = UMGlobalContext.getAppContext(context);
            a aVar = new a();
            aVar.f26072b = b.a(appContext, str);
            return aVar;
        }

        synchronized void b() {
            try {
                if (this.f26071a.decrementAndGet() == 0) {
                    this.f26073c.close();
                }
            } catch (Throwable unused) {
            }
        }

        synchronized SQLiteDatabase a() {
            if (this.f26071a.incrementAndGet() == 1) {
                this.f26073c = this.f26072b.getWritableDatabase();
            }
            return this.f26073c;
        }
    }

    synchronized SQLiteDatabase a(String str) {
        return c(str).a();
    }
}
