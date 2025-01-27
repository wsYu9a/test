package com.opos.cmn.an.g;

import java.util.Arrays;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    public final int f16493a;

    /* renamed from: b */
    public final String f16494b;

    /* renamed from: c */
    public final String f16495c;

    /* renamed from: d */
    public final Map<String, String> f16496d;

    /* renamed from: e */
    public final int f16497e;

    /* renamed from: f */
    public final int f16498f;

    /* renamed from: g */
    public final byte[] f16499g;

    /* renamed from: h */
    public final SSLSocketFactory f16500h;

    /* renamed from: i */
    public final HostnameVerifier f16501i;

    public static class a {

        /* renamed from: b */
        private String f16503b;

        /* renamed from: c */
        private String f16504c;

        /* renamed from: d */
        private Map<String, String> f16505d;

        /* renamed from: g */
        private byte[] f16508g;

        /* renamed from: h */
        private SSLSocketFactory f16509h;

        /* renamed from: i */
        private HostnameVerifier f16510i;

        /* renamed from: a */
        private int f16502a = 0;

        /* renamed from: e */
        private int f16506e = 30000;

        /* renamed from: f */
        private int f16507f = 30000;

        private void b() {
        }

        private boolean d(int i2) {
            return i2 == 0 || 1 == i2 || 2 == i2 || 3 == i2;
        }

        public a a(int i2) {
            this.f16502a = i2;
            return this;
        }

        public a a(String str) {
            this.f16503b = str;
            return this;
        }

        public a a(Map<String, String> map) {
            this.f16505d = map;
            return this;
        }

        public a a(HostnameVerifier hostnameVerifier) {
            this.f16510i = hostnameVerifier;
            return this;
        }

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.f16509h = sSLSocketFactory;
            return this;
        }

        public a a(byte[] bArr) {
            this.f16508g = bArr;
            return this;
        }

        public f a() throws Exception {
            if (com.opos.cmn.an.c.a.a(this.f16503b) || com.opos.cmn.an.c.a.a(this.f16504c)) {
                throw new NullPointerException("httpMethod or url is null.");
            }
            if (!d(this.f16502a)) {
                throw new Exception("protocol should be NET_PROTOCOL_HTTP or NET_PROTOCOL_HTTPS or NET_PROTOCOL_HTTP2 or NET_PROTOCOL_SPDY");
            }
            b();
            return new f(this);
        }

        public a b(int i2) {
            this.f16506e = i2;
            return this;
        }

        public a b(String str) {
            this.f16504c = str;
            return this;
        }

        public a c(int i2) {
            this.f16507f = i2;
            return this;
        }
    }

    public f(a aVar) {
        this.f16493a = aVar.f16502a;
        this.f16494b = aVar.f16503b;
        this.f16495c = aVar.f16504c;
        this.f16496d = aVar.f16505d;
        this.f16497e = aVar.f16506e;
        this.f16498f = aVar.f16507f;
        this.f16499g = aVar.f16508g;
        this.f16500h = aVar.f16509h;
        this.f16501i = aVar.f16510i;
    }

    public String toString() {
        return "NetRequest{protocol=" + this.f16493a + ", httpMethod='" + this.f16494b + "', url='" + this.f16495c + "', headerMap=" + this.f16496d + ", connectTimeout=" + this.f16497e + ", readTimeout=" + this.f16498f + ", data=" + Arrays.toString(this.f16499g) + ", sslSocketFactory=" + this.f16500h + ", hostnameVerifier=" + this.f16501i + '}';
    }
}
