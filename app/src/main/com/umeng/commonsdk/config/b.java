package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements f {

    /* renamed from: a */
    private static Map<String, Boolean> f24339a = new HashMap();

    /* renamed from: b */
    private static Object f24340b = new Object();

    public static class a {

        /* renamed from: a */
        private static final b f24341a = new b();

        private a() {
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b b() {
        return a.f24341a;
    }

    public void a() {
        synchronized (f24340b) {
            f24339a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f24340b) {
            try {
                if (!f24339a.containsKey(str)) {
                    return true;
                }
                return f24339a.get(str).booleanValue();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f24340b) {
                try {
                    Map<String, Boolean> map = f24339a;
                    if (map != null) {
                        map.put(str, bool);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
