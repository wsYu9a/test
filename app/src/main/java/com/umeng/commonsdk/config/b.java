package com.umeng.commonsdk.config;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b implements f {

    /* renamed from: a */
    private static Map<String, Boolean> f26114a = new HashMap();

    /* renamed from: b */
    private static Object f26115b = new Object();

    private static class a {

        /* renamed from: a */
        private static final b f26116a = new b();

        private a() {
        }
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b b() {
        return a.f26116a;
    }

    public void a() {
        synchronized (f26115b) {
            f26114a.clear();
        }
    }

    private b() {
    }

    public static boolean a(String str) {
        if (!d.a(str)) {
            return false;
        }
        synchronized (f26115b) {
            if (!f26114a.containsKey(str)) {
                return true;
            }
            return f26114a.get(str).booleanValue();
        }
    }

    @Override // com.umeng.commonsdk.config.f
    public void a(String str, Boolean bool) {
        if (d.a(str)) {
            synchronized (f26115b) {
                Map<String, Boolean> map = f26114a;
                if (map != null) {
                    map.put(str, bool);
                }
            }
        }
    }
}
