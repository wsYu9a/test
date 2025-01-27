package com.opos.cmn.func.b.b.a;

import com.opos.cmn.func.b.b.a.d;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    public final int f17139a;

    /* renamed from: b */
    public final int f17140b;

    /* renamed from: c */
    public final SSLSocketFactory f17141c;

    /* renamed from: d */
    public final HostnameVerifier f17142d;

    /* renamed from: e */
    public final X509TrustManager f17143e;

    /* renamed from: f */
    public final d f17144f;

    public static class a {

        /* renamed from: a */
        private int f17145a = 30000;

        /* renamed from: b */
        private int f17146b = 30000;

        /* renamed from: c */
        private SSLSocketFactory f17147c;

        /* renamed from: d */
        private HostnameVerifier f17148d;

        /* renamed from: e */
        private d f17149e;

        /* renamed from: f */
        private X509TrustManager f17150f;

        public a a(SSLSocketFactory sSLSocketFactory) {
            this.f17147c = sSLSocketFactory;
            return this;
        }

        public g a() {
            if (this.f17149e == null) {
                this.f17149e = new d.a().a();
            }
            return new g(this);
        }
    }

    private g(a aVar) {
        this.f17139a = aVar.f17145a;
        this.f17140b = aVar.f17146b;
        this.f17141c = aVar.f17147c;
        this.f17142d = aVar.f17148d;
        this.f17143e = aVar.f17150f;
        this.f17144f = aVar.f17149e;
    }

    /* synthetic */ g(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public String toString() {
        return "InitParameter{, connectTimeout=" + this.f17139a + ", readTimeout=" + this.f17140b + ", sslSocketFactory=" + this.f17141c + ", hostnameVerifier=" + this.f17142d + ", x509TrustManager=" + this.f17143e + ", httpExtConfig=" + this.f17144f + '}';
    }
}
