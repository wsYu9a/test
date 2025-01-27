package com.oplus.quickgame.sdk.engine.b;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private String f16178a;

    /* renamed from: b */
    private String f16179b;

    /* renamed from: c */
    private Map<String, String> f16180c;

    /* renamed from: com.oplus.quickgame.sdk.engine.b.b$b */
    public static class C0365b {

        /* renamed from: d */
        static final /* synthetic */ boolean f16181d = true;

        /* renamed from: a */
        private String f16182a;

        /* renamed from: b */
        private String f16183b;

        /* renamed from: c */
        private Map<String, String> f16184c;

        private C0365b() {
        }

        /* synthetic */ C0365b(a aVar) {
            this();
        }

        public C0365b a(String str) {
            this.f16183b = str.toLowerCase();
            return this;
        }

        public C0365b a(String str, String str2) {
            if (this.f16184c == null) {
                this.f16184c = new HashMap();
            }
            this.f16184c.put(str, str2);
            return this;
        }

        public b a() {
            if (f16181d || TextUtils.isEmpty(this.f16182a) || TextUtils.isEmpty(this.f16183b)) {
                return new b(this);
            }
            throw new AssertionError();
        }

        public C0365b b(String str) {
            this.f16182a = str;
            return this;
        }
    }

    private b(C0365b c0365b) {
        this.f16180c = c0365b.f16184c;
        this.f16178a = c0365b.f16182a;
        this.f16179b = c0365b.f16183b;
    }

    /* synthetic */ b(C0365b c0365b, a aVar) {
        this(c0365b);
    }

    public static C0365b d() {
        return new C0365b();
    }

    public Map<String, String> a() {
        return this.f16180c;
    }

    public String b() {
        return this.f16179b.toUpperCase();
    }

    public String c() {
        return this.f16178a;
    }
}
