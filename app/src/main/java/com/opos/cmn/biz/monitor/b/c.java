package com.opos.cmn.biz.monitor.b;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private int f16728a;

    /* renamed from: b */
    private Map<String, String> f16729b;

    /* renamed from: c */
    private byte[] f16730c;

    public static class a {

        /* renamed from: a */
        private int f16731a;

        /* renamed from: b */
        private Map<String, String> f16732b = new HashMap();

        /* renamed from: c */
        private byte[] f16733c = null;

        public a(int i2) {
            this.f16731a = i2;
        }

        public a a(Map<String, String> map) {
            if (map != null) {
                this.f16732b = map;
            }
            return this;
        }

        public a a(byte[] bArr) {
            this.f16733c = bArr;
            return this;
        }

        public c a() {
            return new c(this.f16731a, this.f16732b, this.f16733c);
        }
    }

    private c(int i2, Map<String, String> map, byte[] bArr) {
        this.f16728a = i2;
        this.f16729b = map;
        this.f16730c = bArr;
    }

    /* synthetic */ c(int i2, Map map, byte[] bArr, AnonymousClass1 anonymousClass1) {
        this(i2, map, bArr);
    }

    public int a() {
        return this.f16728a;
    }

    public Map<String, String> b() {
        return this.f16729b;
    }

    public byte[] c() {
        return this.f16730c;
    }
}
