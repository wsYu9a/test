package com.opos.cmn.an.g;

import java.io.InputStream;
import java.util.Map;

/* loaded from: classes4.dex */
public final class g {

    /* renamed from: a */
    public final int f16511a;

    /* renamed from: b */
    public final String f16512b;

    /* renamed from: c */
    public final InputStream f16513c;

    /* renamed from: d */
    public final long f16514d;

    /* renamed from: e */
    public final Map<String, String> f16515e;

    public static class a {

        /* renamed from: b */
        private String f16517b;

        /* renamed from: c */
        private InputStream f16518c;

        /* renamed from: e */
        private Map<String, String> f16520e;

        /* renamed from: a */
        private int f16516a = -1;

        /* renamed from: d */
        private long f16519d = -1;

        public a a(int i2) {
            this.f16516a = i2;
            return this;
        }

        public a a(long j2) {
            this.f16519d = j2;
            return this;
        }

        public a a(InputStream inputStream) {
            this.f16518c = inputStream;
            return this;
        }

        public a a(String str) {
            this.f16517b = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.f16520e = map;
            return this;
        }

        public g a() {
            return new g(this);
        }
    }

    public g(a aVar) {
        this.f16511a = aVar.f16516a;
        this.f16512b = aVar.f16517b;
        this.f16513c = aVar.f16518c;
        this.f16514d = aVar.f16519d;
        this.f16515e = aVar.f16520e;
    }

    public String toString() {
        return "NetResponse{code=" + this.f16511a + ", errMsg='" + this.f16512b + "', inputStream=" + this.f16513c + ", contentLength=" + this.f16514d + ", headerMap=" + this.f16515e + '}';
    }
}
