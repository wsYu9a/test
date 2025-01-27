package com.opos.cmn.biz.web.a.b;

import android.text.TextUtils;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public final String f16853a;

    /* renamed from: b */
    public final String f16854b;

    /* renamed from: com.opos.cmn.biz.web.a.b.a$a */
    public static class C0383a {

        /* renamed from: a */
        private String f16855a;

        /* renamed from: b */
        private String f16856b;

        public C0383a a(String str) {
            this.f16855a = str;
            return this;
        }

        public a a() {
            if (TextUtils.isEmpty(this.f16855a)) {
                throw new Exception("url is null.");
            }
            return new a(this);
        }

        public C0383a b(String str) {
            this.f16856b = str;
            return this;
        }
    }

    private a(C0383a c0383a) {
        this.f16853a = c0383a.f16855a;
        this.f16854b = c0383a.f16856b;
    }

    /* synthetic */ a(C0383a c0383a, AnonymousClass1 anonymousClass1) {
        this(c0383a);
    }

    public String toString() {
        return "CacheResourceRequest{url=" + this.f16853a + ", md5=" + this.f16854b + '}';
    }
}
