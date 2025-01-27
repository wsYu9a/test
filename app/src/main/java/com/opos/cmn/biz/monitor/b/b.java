package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private String f16720a;

    /* renamed from: b */
    private String f16721b;

    /* renamed from: c */
    private Map<String, String> f16722c;

    /* renamed from: d */
    private byte[] f16723d;

    public static class a {

        /* renamed from: a */
        private String f16724a;

        /* renamed from: b */
        private String f16725b = "GET";

        /* renamed from: c */
        private Map<String, String> f16726c = new HashMap();

        /* renamed from: d */
        private byte[] f16727d = null;

        public a(String str) {
            this.f16724a = str;
        }

        public a a(Map<String, String> map) {
            this.f16726c = map;
            return this;
        }

        public b a() {
            return new b(this.f16724a, this.f16725b, this.f16726c, this.f16727d);
        }
    }

    private b(String str, String str2, Map<String, String> map, byte[] bArr) {
        this.f16720a = str;
        this.f16721b = str2;
        this.f16722c = map;
        this.f16723d = bArr;
    }

    /* synthetic */ b(String str, String str2, Map map, byte[] bArr, AnonymousClass1 anonymousClass1) {
        this(str, str2, map, bArr);
    }

    public String a() {
        return this.f16720a;
    }

    public String b() {
        return this.f16721b;
    }

    public Map<String, String> c() {
        return this.f16722c;
    }

    public byte[] d() {
        return this.f16723d;
    }
}
