package x2;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import p3.g;

/* loaded from: classes.dex */
public class a {

    /* renamed from: x2.a$a */
    public static final class C0803a {

        /* renamed from: a */
        public static final String f31770a = "RecordPref";

        /* renamed from: b */
        public static final String f31771b = "alipay_cashier_statistic_record";

        public static synchronized int a(Context context, String str) {
            synchronized (C0803a.class) {
                p3.d.g(f31770a, "stat remove " + str);
                if (context != null && !TextUtils.isEmpty(str)) {
                    C0804a c10 = c(context);
                    if (c10.f31772a.isEmpty()) {
                        return 0;
                    }
                    try {
                        ArrayList arrayList = new ArrayList();
                        for (Map.Entry<String, String> entry : c10.f31772a.entrySet()) {
                            if (str.equals(entry.getValue())) {
                                arrayList.add(entry.getKey());
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            c10.f31772a.remove((String) it.next());
                        }
                        d(context, c10);
                        return arrayList.size();
                    } catch (Throwable th2) {
                        p3.d.e(th2);
                        int size = c10.f31772a.size();
                        d(context, new C0804a());
                        return size;
                    }
                }
                return 0;
            }
        }

        public static synchronized String b(Context context, String str, String str2) {
            synchronized (C0803a.class) {
                try {
                    p3.d.g(f31770a, "stat append " + str2 + " , " + str);
                    if (context != null && !TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str2)) {
                            str2 = UUID.randomUUID().toString();
                        }
                        C0804a c10 = c(context);
                        if (c10.f31772a.size() > 20) {
                            c10.f31772a.clear();
                        }
                        c10.f31772a.put(str2, str);
                        d(context, c10);
                        return str2;
                    }
                    return null;
                } finally {
                }
            }
        }

        public static synchronized C0804a c(Context context) {
            synchronized (C0803a.class) {
                try {
                    String b10 = g.b(null, context, f31771b, null);
                    if (TextUtils.isEmpty(b10)) {
                        return new C0804a();
                    }
                    return new C0804a(b10);
                } catch (Throwable th2) {
                    p3.d.e(th2);
                    return new C0804a();
                }
            }
        }

        public static synchronized void d(Context context, C0804a c0804a) {
            synchronized (C0803a.class) {
                if (c0804a == null) {
                    try {
                        c0804a = new C0804a();
                    } finally {
                    }
                }
                g.e(null, context, f31771b, c0804a.a());
            }
        }

        public static synchronized String e(Context context) {
            synchronized (C0803a.class) {
                p3.d.g(f31770a, "stat peek");
                if (context == null) {
                    return null;
                }
                C0804a c10 = c(context);
                if (c10.f31772a.isEmpty()) {
                    return null;
                }
                try {
                    return c10.f31772a.entrySet().iterator().next().getValue();
                } catch (Throwable th2) {
                    p3.d.e(th2);
                    return null;
                }
            }
        }

        /* renamed from: x2.a$a$a */
        public static final class C0804a {

            /* renamed from: a */
            public final LinkedHashMap<String, String> f31772a = new LinkedHashMap<>();

            public C0804a() {
            }

            public String a() {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry<String, String> entry : this.f31772a.entrySet()) {
                        JSONArray jSONArray2 = new JSONArray();
                        jSONArray2.put(entry.getKey()).put(entry.getValue());
                        jSONArray.put(jSONArray2);
                    }
                    return jSONArray.toString();
                } catch (Throwable th2) {
                    p3.d.e(th2);
                    return new JSONArray().toString();
                }
            }

            public C0804a(String str) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONArray jSONArray2 = jSONArray.getJSONArray(i10);
                        this.f31772a.put(jSONArray2.getString(0), jSONArray2.getString(1));
                    }
                } catch (Throwable th2) {
                    p3.d.e(th2);
                }
            }
        }
    }

    public static final class b {

        /* renamed from: x2.a$b$a */
        public static class RunnableC0805a implements Runnable {

            /* renamed from: b */
            public final /* synthetic */ String f31773b;

            /* renamed from: c */
            public final /* synthetic */ Context f31774c;

            public RunnableC0805a(String str, Context context) {
                this.f31773b = str;
                this.f31774c = context;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.isEmpty(this.f31773b) || b.e(this.f31774c, this.f31773b)) {
                    for (int i10 = 0; i10 < 4; i10++) {
                        String e10 = C0803a.e(this.f31774c);
                        if (TextUtils.isEmpty(e10) || !b.e(this.f31774c, e10)) {
                            return;
                        }
                    }
                }
            }
        }

        public static synchronized void a(Context context) {
            synchronized (b.class) {
                b(context, null, null);
            }
        }

        public static synchronized void b(Context context, String str, String str2) {
            synchronized (b.class) {
                if (context == null) {
                    return;
                }
                try {
                    if (!TextUtils.isEmpty(str)) {
                        C0803a.b(context, str, str2);
                    }
                    new Thread(new RunnableC0805a(str, context)).start();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public static synchronized void c(Context context, x2.b bVar, String str, String str2) {
            synchronized (b.class) {
                if (context == null || bVar == null || str == null) {
                    return;
                }
                b(context, bVar.e(str), str2);
            }
        }

        public static synchronized boolean e(Context context, String str) {
            synchronized (b.class) {
                try {
                    p3.d.g(z2.a.A, "stat sub " + str);
                    try {
                        if ((b3.a.J().o() ? new j3.d() : new j3.e()).b(null, context, str) == null) {
                            return false;
                        }
                        C0803a.a(context, str);
                        return true;
                    } catch (Throwable th2) {
                        p3.d.e(th2);
                        return false;
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    public static final class c {

        /* renamed from: a */
        public static final String f31775a = "alipay_cashier_ap_seq_v";

        public static synchronized long a(Context context) {
            long a10;
            synchronized (c.class) {
                a10 = d.a(context, f31775a);
            }
            return a10;
        }
    }

    public static final class d {
        /* JADX WARN: Can't wrap try/catch for region: R(8:3|(2:4|5)|(5:7|8|9|10|11)|17|8|9|10|11) */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static synchronized long a(android.content.Context r6, java.lang.String r7) {
            /*
                java.lang.Class<x2.a$d> r0 = x2.a.d.class
                monitor-enter(r0)
                r1 = 0
                java.lang.String r2 = p3.g.b(r1, r6, r7, r1)     // Catch: java.lang.Throwable -> L13
                boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L13
                if (r3 != 0) goto L13
                long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L13
                goto L15
            L13:
                r2 = 0
            L15:
                r4 = 1
                long r2 = r2 + r4
                java.lang.String r4 = java.lang.Long.toString(r2)     // Catch: java.lang.Throwable -> L1f
                p3.g.e(r1, r6, r7, r4)     // Catch: java.lang.Throwable -> L1f
            L1f:
                monitor-exit(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: x2.a.d.a(android.content.Context, java.lang.String):long");
        }
    }

    public static final class e {

        /* renamed from: a */
        public static final String f31776a = "alipay_cashier_statistic_v";

        public static synchronized long a(Context context) {
            long a10;
            synchronized (e.class) {
                a10 = d.a(context, f31776a);
            }
            return a10;
        }
    }

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            b.a(context);
        }
    }

    public static synchronized void b(Context context, n3.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            try {
                C0803a.b(context, aVar.f28772l.e(str), str2);
            } finally {
            }
        }
    }

    public static void c(n3.a aVar, String str, String str2) {
        if (aVar == null) {
            return;
        }
        aVar.f28772l.g(str, str2);
    }

    public static void d(n3.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.f28772l.h(str, str2, str3);
    }

    public static void e(n3.a aVar, String str, String str2, Throwable th2) {
        if (aVar == null) {
            return;
        }
        aVar.f28772l.i(str, str2, th2);
    }

    public static void f(n3.a aVar, String str, String str2, Throwable th2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.f28772l.j(str, str2, th2, str3);
    }

    public static void g(n3.a aVar, String str, Throwable th2) {
        if (aVar == null || th2 == null) {
            return;
        }
        aVar.f28772l.i(str, th2.getClass().getSimpleName(), th2);
    }

    public static synchronized void h(Context context, n3.a aVar, String str, String str2) {
        synchronized (a.class) {
            if (context == null || aVar == null) {
                return;
            }
            b.c(context, aVar.f28772l, str, str2);
        }
    }

    public static void i(n3.a aVar, String str, String str2, String str3) {
        if (aVar == null) {
            return;
        }
        aVar.f28772l.n(str, str2, str3);
    }
}
