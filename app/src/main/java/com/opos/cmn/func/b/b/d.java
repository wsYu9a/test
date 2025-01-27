package com.opos.cmn.func.b.b;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public final String f17153a;

    /* renamed from: b */
    public final String f17154b;

    /* renamed from: c */
    public final Map<String, String> f17155c;

    /* renamed from: d */
    public final byte[] f17156d;

    /* renamed from: e */
    public final long f17157e;

    /* renamed from: f */
    public final boolean f17158f;

    /* renamed from: g */
    public final boolean f17159g;

    public static class a {

        /* renamed from: e */
        private static AtomicLong f17160e = new AtomicLong(0);

        /* renamed from: a */
        private String f17161a;

        /* renamed from: b */
        private String f17162b;

        /* renamed from: c */
        private Map<String, String> f17163c;

        /* renamed from: d */
        private byte[] f17164d;

        /* renamed from: f */
        private long f17165f;

        /* renamed from: g */
        private boolean f17166g = false;

        /* renamed from: h */
        private boolean f17167h = false;

        private static long b() {
            return f17160e.getAndIncrement();
        }

        public a a(d dVar) {
            a aVar = new a();
            if (dVar != null) {
                aVar.a(dVar.f17153a);
                aVar.b(dVar.f17154b);
                aVar.a(dVar.f17155c);
                aVar.a(dVar.f17156d);
                aVar.a(dVar.f17158f);
                aVar.b(dVar.f17159g);
            }
            return aVar;
        }

        public a a(String str) {
            this.f17161a = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.f17163c = map;
            return this;
        }

        public a a(boolean z) {
            this.f17166g = z;
            return this;
        }

        public a a(byte[] bArr) {
            this.f17164d = bArr;
            return this;
        }

        public d a() {
            if (TextUtils.isEmpty(this.f17161a) || TextUtils.isEmpty(this.f17162b)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            this.f17165f = b();
            if (this.f17163c == null) {
                this.f17163c = new HashMap();
            }
            return new d(this);
        }

        public a b(String str) {
            this.f17162b = str;
            return this;
        }

        public a b(boolean z) {
            this.f17167h = z;
            return this;
        }
    }

    public d(a aVar) {
        this.f17153a = aVar.f17161a;
        this.f17154b = aVar.f17162b;
        this.f17155c = aVar.f17163c;
        this.f17156d = aVar.f17164d;
        this.f17157e = aVar.f17165f;
        this.f17158f = aVar.f17166g;
        this.f17159g = aVar.f17167h;
    }

    public String toString() {
        return "NetRequest{, httpMethod='" + this.f17153a + "', url='" + this.f17154b + "', headerMap=" + this.f17155c + ", data=" + Arrays.toString(this.f17156d) + ", requestId=" + this.f17157e + ", needEnCrypt=" + this.f17158f + ", supportGzipCompress=" + this.f17159g + '}';
    }
}
